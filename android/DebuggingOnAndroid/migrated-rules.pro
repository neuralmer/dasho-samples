#-dontshrink
#-dontobfuscate
#-dontoptimize
#-keep class com.dasho.android.debug.other.ApplicationLogic { <in*>(...); }
-keepnames class com.dasho.android.debug.other.ApplicationLogic {
    com.dasho.android.debug.other.SomeInterface couldBeGood(com.dasho.android.debug.other.SomeClass);
#    *** couldBeGood(...);
#    *** herb;
}
#-whyareyoukeeping class com.dasho.android.debug.other.ApplicationLogic { <methods>; }
