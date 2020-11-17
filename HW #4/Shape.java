import java.awt.Color;

public abstract class Shape implements Comparable<Shape> {
    /**
     * @variable initialized the variable id which is final and protected.
     * @variable initialized the variable name which is final and protected.
     * @variable initialized the variable description which is final and protected.
     * @variable initialized the variable color which is protected subjected to change.
     */
    protected final Integer id;
    protected final String name;
    protected final String description;
    protected Color color;
    /**
     * non - default constructor that takes in the below params.
     * @param id, name, description, color.
     * sets the id, name, description, color to respective params.
     */
    public Shape(int id , String name, String description, Color color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
    }
    /**
     * @method  abstract method used for area determined by child classes
     * declared without an implementation
     */
    public abstract double area();
    /**
     * @method  abstract method used for perimeter determined by child classes
     * declared without an implementation
     */
    public abstract double perimeter();
    /**
     * @param shape
     * compares two objects of type Shape.
     * @return A 0 if two objects have the same name and color.
     * @return the results of the first mismatch comparison between name then color.
     * @Override an element declared in a superclass.
     */
    @Override
    public int compareTo(Shape shape) {
        if (this.name.equals(shape.name)  && this.color.equals(shape.color)) return 0;
        int val = this.name.compareTo(shape.name);
        if (val == 0) {
            val = ((this.getColorName())).compareTo((shape. getColorName()));
        }
        return val;
    }

    /**
     * @return the string format version with id, name, color, and description.
     */
    public String toString() {
        return String.format( "%d%s%s%s%s%s%s", id," ",name, " ", color, " ", description);
    }

    /**
     * @return the name of the Color as a String.
     */
    public String  getColorName() {

        if (Color.BLACK.equals(color)) {
            return "Black";
        }
        else if (Color.BLUE.equals(color)) {
            return "Blue";
        }
        else if (Color.GREEN.equals(color)) {
            return "Green";
        }
        else if (Color.RED.equals(color)) {
            return "Red";
        }
        else if (Color.WHITE.equals(color)) {
            return "White";
        }
        else if (Color.CYAN.equals(color)) {
            return "Cyan";
        }
        else if (Color.YELLOW.equals(color)) {
            return "Yellow";
        }
        else return null;
    }
}
