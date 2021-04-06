package lectionHW.GraphicsEditor;

public class GraphicsEditor {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[5];
        shapes[0] = new Circle();
        shapes[1] = new Quad();
        shapes[2] = new Rectangle();
        shapes[3] = new Rhombus();
        shapes[4] = new Triangle();

        for (Shape sh: shapes) {
            System.out.println(sh.getName());
        }
    }
}
