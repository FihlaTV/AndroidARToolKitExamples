# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

set (MY_LOCAL_PATH "/Users/herbert/AndroidProjects/AndroidARToolKitExamples/ARSimpleNativeCars/app")
set (LOCAL_PATH ${CMAKE_CURRENT_LIST_DIR})
message("Current dir --> " ${LOCAL_PATH})

add_library( ARWrapperNativeCarsExample SHARED src/main/cpp/ARWrapperNativeCarsExample.cpp )
add_library( ARWrapper SHARED IMPORTED )
add_library( c++_shared SHARED IMPORTED )
add_library( eden STATIC IMPORTED )

set_target_properties( ARWrapper PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/libs/${ANDROID_ABI}/libARWrapper.so )

set_target_properties( c++_shared PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/libs/${ANDROID_ABI}/libc++_shared.so )

set_target_properties( eden PROPERTIES IMPORTED_LOCATION ${LOCAL_PATH}/obj/local/${ANDROID_ABI}/libeden.a )

include_directories(include/)


find_library( log-lib log )
find_library(glesv1 GLESv1_CM)

target_link_libraries( ARWrapperNativeCarsExample c++_shared  ${log-lib} ${glesv1} eden ARWrapper  )