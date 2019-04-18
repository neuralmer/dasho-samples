package com.dasho.android.debug.other;

public class SomeClass implements AnotherInterface {
    
    @Override
    public byte takeAByteOutOfAnInterface() {
        return 0x42;
    }

    @Override
    public byte takeAnotherByteOutOfAnInterface() {
        return 0x2A;
    }
}
