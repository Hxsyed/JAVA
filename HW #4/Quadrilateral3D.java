import java.awt.Color;

public class Quadrilateral3D extends Shape3D{

    /**
     * non - default constructor that takes in the below params.
     * @param id, name, description, color, height, width, length.
     * @super refers immediate parent class object.
     */
    public Quadrilateral3D(int id, String name, String description, Color color, double height, double width,
                           double length) {
        super(id, name, description, color, height, width, length);
    }

    /**
     * @return the area for the 3d object.
     * @Override an element declared in a superclass.
     */
    @Override
    public double area() {
        return 2*((width*height)+(width*length)+(height*length));
    }

    /**
     * @return the perimeter for the 3d object.
     * @Override an element declared in a superclass.
     */
    @Override
    public double perimeter() {
        return 4*(width+height+length);
    }
}
