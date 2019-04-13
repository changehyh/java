package com.bit.src;

public class MsFactory implements ComputerFactory {

    @Override
    public Computer createComputer() {
        return new SurfaceBookComputer();
    }

    @Override
    public OperatingSystem createSystem() {
        return new Windows10System();
    }
}
