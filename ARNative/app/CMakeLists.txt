# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

set (MY_LOCAL_PATH "/Users/herbert/AndroidProjects/AndroidARToolKitExamples/ARNative/app")
#set (LOCAL_PATH ${CMAKE_CURRENT_LIST_DIR})
set (LOCAL_PATH "/Users/herbert/AndroidProjects/AndroidARToolKitExamples/ExternalLibs/")
message("Current dir --> " ${LOCAL_PATH})

add_library( ARNative SHARED src/main/cpp/ARNative.cpp src/main/cpp/ARMarkerSquare.c)
add_library( eden STATIC IMPORTED )
add_library( argsub_es2 STATIC IMPORTED )
add_library( armulti STATIC IMPORTED )
add_library( ar STATIC IMPORTED )
add_library( aricp STATIC IMPORTED )
add_library( arvideo STATIC IMPORTED )
add_library( util STATIC IMPORTED )
add_library( cpufeatures STATIC IMPORTED )


set_target_properties( eden PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libeden.a )
set_target_properties( argsub_es2 PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libargsub_es2.a )
set_target_properties( armulti PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libarmulti.a )
set_target_properties( ar PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libar.a )
set_target_properties( aricp PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libaricp.a )
set_target_properties( arvideo PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libarvideo.a )
set_target_properties( util PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libutil.a )
set_target_properties( cpufeatures PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libcpufeatures.a )

include_directories(${LOCAL_PATH}/include/)

add_library( curl STATIC IMPORTED )
set_target_properties( curl PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/curl/libs/${ANDROID_ABI}/libcurl.a )
include_directories(${LOCAL_PATH}/curl/include/)


find_library( log-lib log )
find_library(glesv2 GLESv2)
find_library(lz z)

target_link_libraries( ARNative ${log-lib} ${glesv2} ${lz}
                        -Wl,--whole-archive ar -Wl,--no-whole-archive
                        eden armulti aricp cpufeatures arvideo util curl argsub_es2)