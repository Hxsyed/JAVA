import java.awt.Color;

public abstract class Shape3D extends Shape2D {
    /**
     * @variable initialized the variable length.
     */
    public final double length;

    /**
     * non - default constructor that takes in the below params.
     * @param id, name, description, color, height, width, length.
     * @super refers immediate parent class object.
     * sets length to the respective length param.
     */
    public Shape3D(int id, String name , String description, Color color, double height, double width, double length){
        super(id, name, description, color,height,width);
        this.length = length;
    }
    /**
     * @return returns the same value described in the parent class.
     * reuses the parent class toString implementation.
     */
    public String toString() {
        return super.toString() + " " + this.length;
    }
    /**
     * @return the dimensions for length, width, height.
     * @Override an element declared in a superclass.
     */
    public String getDimensions() {
        return String.format("%.2f%s%.2f%s%.2f",width," X ", height, " X ", length);
    }

    /**
     * @param shape
     * compares the two objects of type Shape3D.
     * reuses the compareTo method from Shape2D class.
     * @return A 0 if two objects are deemed equivalent.
     * @return A negative number if the left object is smaller than the right object.
     * @return A positive number if the left object is greater than the right object.
     */
    public int compareTo(Shape shape) {
        int val = super.compareTo(shape);
        if((shape instanceof Shape3D) && val==0){
            Shape3D s = ((Shape3D)shape);
            if(length != s.length){
                return (int)(length-s.length);
            }
            else return 0;
        }
        else return val;
    }
}
