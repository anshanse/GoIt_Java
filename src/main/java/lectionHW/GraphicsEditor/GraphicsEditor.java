package lectionHW.GraphicsEditor;

public class GraphicsEditor {
    public static void main(String[] args) {
        System.out.println(new Shapes().shapeName(new Circle()));
        System.out.println(new Shapes().shapeName(new Rectangle()));
        System.out.println(new Shapes().shapeName(new Rhombus()));
        System.out.println(new Shapes().shapeName(new Triangle()));
        System.out.println(new Shapes().shapeName(new Quad()));
    }
}
