package com.example.SpringRedis_pet10.Model.Flower;

public enum FlowerType {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    ORANGE,
    PURPLE,
    PINK,
    BLACK,
    WHITE,
    GRAY,
    BROWN,
    CYAN,
    MAGENTA,
    LIGHT_BLUE,
    DARK_GREEN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}