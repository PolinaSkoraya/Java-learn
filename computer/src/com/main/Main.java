package com.main;

import com.computer.Computer;

public class Main {

    public static void main(String[] args) {
        Computer.OperatingSystem operatingSystem = new Computer.OperatingSystem ("Windows");
        Computer comp = new Computer ("Asus", "intel core i5", 8, operatingSystem);

        Computer anon = new Computer ("Asus", "intel", 8, operatingSystem) {
            @Override
            public String toString() {
                return "computer from anonymous class";
            }
        };

        System.out.println (comp);
        System.out.println (anon);
    }
}
