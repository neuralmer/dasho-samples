#-dontoptimize
-keepnames class com.dasho.android.debug.other.ApplicationLogic {
    com.dasho.android.debug.other.SomeInterface someMethod(com.dasho.android.debug.other.SomeClass);
}
