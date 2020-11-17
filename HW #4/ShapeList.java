import java.util.TreeSet;

public class ShapeList extends TreeSet<Shape> {

    /**
     * default constructor.
     */
    public ShapeList() {}

    /**
     * @return returns a boolean value.
     * returns true is the shape was added.
     * returns false if the shape was already contained.
     * checks if a similar shape has been added already.
     */
    public boolean add(Shape shape) {
        if (contains(shape))
            return false;
        else {
            super.add(shape);
        }
        return true;
    }

    /**
     * @return a new set of supertype Shape2D only.
     * checks if a similar  2D shape has been added already.
     */
    public ShapeList get2DShapes() {
        ShapeList list = new ShapeList();
        for(Shape shape : this) {
            if (shape instanceof Quadrilateral) {
                list.add(shape);
            }
        }
        return list;
    }

    /**
     * @return a new set of supertype Shape3D only.
     * checks if a similar 3D shape has been added already.
     */
    public ShapeList get3DShapes() {
        ShapeList list = new ShapeList();
        for(Shape shape : this) {
            if (shape instanceof Quadrilateral3D) {
                list.add(shape);
            }
        }
        return list;
    }

    /**
     * @return a new set of supertype Shape3D only.
     */
    public int getSize() {
        return super.size();
    }

    /**
     * @Print prints a sorted and formatted table.
     * Displays the ID, NAME, COLOR, DIMENSIONS, DESCRIPTION.
     * The list is sorted by the compareTo method utilized by the Treeset.
     */
    public void printFormatted() {
        String linedash = "+--------+-------------+---------+-------------------------+----------------------+";
        System.out.printf("%s%n| %-7s| %-12s| %-8s| %-24s| %-21s|%n",linedash,"ID","Name","Color","Dimension","Description");

        for(Shape shape : this) {
            System.out.printf("%s%n| %-7s| %-12s| %-8s| %-24s| %-21s|%n",linedash,shape.id,shape.name,
                    shape.getColorName(),((Shape2D) shape).getDimensions(),shape.description);
        }
        System.out.print(linedash);
    }
}

