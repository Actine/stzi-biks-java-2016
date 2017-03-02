package ua.edu.uzhnu.biks.training.lecture3.oop;

/**
 * Коробка має об'єм і видає звук, коли плюхається об землю
 */
public class Box implements HasVolume, MakesSound {

    private int width;
    private int height;
    private int depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public int getVolume() {
        return width * height * depth;
    }

    @Override
    public String getSound() {
        return "Thump";
    }
}
