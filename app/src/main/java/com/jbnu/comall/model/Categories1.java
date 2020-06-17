package com.jbnu.comall.model;

import java.util.Arrays;
import java.util.List;

public enum Categories1 {

    CPU, MAINBOARD, MEMORY, HDD, VGA;

    @Override public String toString() {
        switch (this) {
            case CPU:
                return "cpu";
            case MAINBOARD:
                return "main_board";
            case MEMORY:
                return "memory";
            case HDD:
                return "hdd";
            case VGA:
                return "vga";
            default:
                return null;
        }
    }

    public static List<String> getAll() {
        return Arrays.asList(CPU.toString(),
                MAINBOARD.toString(),
                MEMORY.toString(),
                HDD.toString(),
                VGA.toString());
    }

    public static Categories1 toEnum(String name) {
        switch (name) {
            case "CPU":
                return CPU;
            case "메인보드":
                return MAINBOARD;
            case "메모리":
                return MEMORY;
            case "HDD":
                return HDD;
            case "VGA":
                return VGA;
            default:
                return null;
        }
    }
}
