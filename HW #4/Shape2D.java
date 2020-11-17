import java.awt.Color;

public abstract class Shape2D extends Shape {
    /**
     * @variable initialized the variable height.
     * @variable initialized the variable width.
     */
    public  final double height;
    public  final double width;

    /**
     * non - default constructor that takes in the below params.
     * @param id, name, description, color, height, width, length.
     * @super refers immediate parent class object.
     * sets the height and width to respective params.
     */
    public Shape2D(int id, String name, String description, Color color , double height, double width) {
        super(id, name, description, color);
        this.height = height;
        this.width = width;
    }

    /**
     * @return returns the same value described in the parent class.
     * reuses the parent class toString implementation.
     */
    public String toString() { return super.toString();}

    /**
     * @return the dimensions for width, height.
     */
    public String getDimensions() {
        return String.format("%.2f%s%.2f",width," x ", height);
    }

    /**
     * @param shape
     * compares the two objects of type Shape2D.
     * reuses the compareTo method from Shape class.
     * @return A 0 if two objects are deemed equivalent.
     * @return A negative number if the left object is smaller than the right object.
     * @return A positive number if the left object is greater than the right object.
     */
    public int compareTo(Shape shape) {
        Shape2D s = ((Shape2D)shape);
        int val = super.compareTo(shape);
		if(shape instanceof Shape2D && val ==0) {
				 val = Double.compare(this.height, s.height);
				    if (val == 0) {
				        val = Double.compare(this.width, s.width);
                    }
            return val;
        }
		return super.compareTo(shape);
	}
}
