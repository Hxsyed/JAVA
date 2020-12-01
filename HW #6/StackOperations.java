import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A set of tools which operate on a Stack
 */
public class StackOperations {

    /**
     * Uses Java's streams to generate a Queue object from an existing Stack object in the same order.
     * Use the LinkedLists class since it implements the Queue interface
     *
     * @param stackOriginal the stack to be converted to a Queue
     * @return a queue containing all the elements of the original Stack in the same order
     */
    public static Queue<Character> toQueue(Stack<Character> stackOriginal) {
        Queue<Character> inorder = new LinkedList<Character>();
        stackOriginal.stream()
                // For-each is another array traversing technique like for loop, while loop, do-while loop
                // add method of Set in Java is used to add a specific element into a Set collection
                .forEach(inorder::add);
        return inorder;
    }

    /**
     * Uses Java's streams to generate a new Stack object from an existing Stack object but in reversed order.
     * The original stack's becomes empty after copied over
     *
     * @param stackOriginal the stack to be reversed
     * @return a new stack containing the same items from the original Stack
     */
    public static Stack<Character> reverseStack(Stack<Character> stackOriginal) {
        Stack<Character> reverseorder = stackOriginal.stream()
                // sorted returns a stream consisting of the elements of this stream, sorted according to reverse order
                // collect allows us to perform mutable fold operations
                .sorted(Comparator.comparing(Character::charValue).reversed())
                .collect(Collectors.toCollection(Stack::new));
        stackOriginal.clear();
        return reverseorder;
    }

    /**
     * Uses Java's streams to sum all items between the star and end positions inclusive.
     * Account for invalid ranges such as endPosition < startPosition or large ranges
     *
     * @param stackOriginal the stack with the items to sum
     * @param startPosition the position of the starting element in the sum (included)
     * @param endPosition   the position of the end element in the sum (included)
     * @return the sum of all items between the star and end positions inclusive. The method returns -1 if the sum range is invalid
     */
    public static int sumBetween(Stack<Integer> stackOriginal, int startPosition, int endPosition) {
        if (endPosition < startPosition || endPosition > stackOriginal.size()){
            return -1;
            // range returns a sequential ordered IntStream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1
            // sum adds up all elements
        } else return IntStream.range(startPosition-1, endPosition).map(stackOriginal::elementAt).sum();
    }

    /**
     * Uses Java's streams to read the characters from InputFile.txt one character at a time.
     * If the character read is a number, it is added to a Stack. Otherwise, the character is simply discarded.
     * In case of an Exception, simply print the stack trace which will cause the method to stop the read process and return.
     * <p>
     * Here is an example which filters the characters from a String
     *
     * <pre>   {@code
     *
     * String line = "abc0123!@#$";
     *   line.chars()
     *       .mapToObj(i -> (char) i)
     *       .forEach(c -> System.out.println(c));
     *
     * }</pre> </p>
     *
     * @param filePath the input file containing alpha-numeric characters
     * @return a stack containing numeric characters only
     */
    public static Stack<Character> readNumericFromFile(final String filePath) {
        Stack<Character> readnum = new Stack<>();
        try {
            Files.lines(Paths.get(filePath)).forEach(line -> {
                line.chars()
                        // returns a stream consisting of the elements of this stream that match the given predicate.
                        // For-each is another array traversing technique like for loop, while loop, do-while loop
                        .filter(character -> character <= '9' && character >= '0')
                        .forEach(character -> readnum.push((char) character));
            });
        } catch (IOException ex) {
            System.err.println("ERROR FILE NOT FOUND");
            ex.printStackTrace();
        }
        return readnum;
    }
}
