import java.awt.Color;

public class Quadrilateral extends Shape2D {

    /**
     * non - default constructor that takes in the below params.
     * @param id, name, description, color, height, width.
     * @super refers immediate parent class object.
     */
    public Quadrilateral(int id, String name, String description, Color color, double height, double width) {
        super(id, name, description, color, height, width);
    }

    /**
     * @return the area for the 2d object.
     */
    public double area() {
        return (width*height);
    }

    /**
     * @return the perimeter for the 2d object.
     */
    public double perimeter() {
        return 2*(width+height);
    }
}
