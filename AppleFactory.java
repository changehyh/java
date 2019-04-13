package com.bit.src;

public class AppleFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new MacBookComputer();
    }

    @Override
    public OperatingSystem createSystem() {
        return new MacSystem();
    }
}
