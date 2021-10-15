#include "jni.h"
#include "Hello.h"
//#include other headers
JNIEXPORT void JNICALL Java_com_example_test_jni_HelloWorld(JNIEnv *env, jobject obj){
    printf("Hello world!\n");
return;
}