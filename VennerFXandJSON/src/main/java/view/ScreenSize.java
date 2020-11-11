package view;

import javafx.scene.Scene;

class ScreenSize {

    private static double width = 800;
    private static double height = 600;

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }

    public static void setSize(Scene scene) {
        width = scene.getWidth();
        height = scene.getHeight();
    }
}
