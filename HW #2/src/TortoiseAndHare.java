import java.security.SecureRandom;

public class TortoiseAndHare {
    public final static int MAX_MOVES = 100;
    public final static int MAX_ITERATIONS = 200;
    public static int HarePosition = 1;
    public static int TortoisePosition = 1;
    public static int iteration = 0;
    public static int time = 0;

    public static void main(String[] args) {
        TortoiseAndHare inst = new TortoiseAndHare();
        // STARTING THE RACE
        System.out.println("ON YOUR MARK, GET SET");
        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");

        while (MAX_ITERATIONS >= iteration) {
            inst.printPositions(); // prints the positions
            inst.simulateHareMove(); // moving the Hare
            inst.simulateTortoiseMove(); // moving the Tortoise
            // check to see who won
            if (HarePosition >= 100 && TortoisePosition >= 100) {
                System.out.println("It's a tie");
                break;
            } else if (HarePosition > 100) {
                System.out.println("Hare wins. Yuch!");
                break;
            } else if (TortoisePosition > 100) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
                break;
            }
        }
        // hceck to see who won if time-out
        System.out.println("Time Out!");
        if (HarePosition > TortoisePosition) {
            System.out.println("Hare wins. Yuch!");
        } else {
            System.out.println("TORTOISE WINS!!! YAY!!!");
        }

    }

    public void printPositions() {
        System.out.println("Iteration: " + iteration);
        for (int i = 1; i <= MAX_MOVES; i++) {
            if (i == HarePosition && i == TortoisePosition) {
                System.out.print("B");
            } else if (i == TortoisePosition) {
                System.out.print("T");
            } else if (i == HarePosition) {
                System.out.print("H");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
        for (int i = 1; i <= 100; i++) {
            System.out.print("-");
        }
        System.out.println("");
        iteration++;
    }

    public int randomBetween(int a, int b) {
        SecureRandom between = new SecureRandom();
        return between.nextInt(b) + a; // returns a number between a-b
    }

    public void simulateTortoiseMove() {
        SecureRandom randTort = new SecureRandom();
        int value = 1 + randTort.nextInt(10);
        // Sleep 10% of the time
        if (value == 1) {
            // Tortoise sleeps no change in position
        } else if (value >= 2 && value <= 5) {
            // Tortoise Jumps 40% of the time
            int square = randomBetween(1, 3);
            TortoisePosition += square;
        } else if (value >= 6 && value <= 8) {
            // Tortoise Slips 30% of the time
            int square = randomBetween(1, 6);
            TortoisePosition -= square;
            // if the Tortiose slips before square 1, then we adjust the postion to 1
            if (TortoisePosition < 1) {
                TortoisePosition = 1;
            }
        } else {
            // Tortoise Walks 20% of the time
            int square = randomBetween(0, 1);
            TortoisePosition += square;
        }
    }

    public void simulateHareMove() {
        SecureRandom randHare = new SecureRandom();
        int value = 1 + randHare.nextInt(10);
        // Sleep 10% of the time
        if (value == 1) {
            // Hare sleeps no change in position
        } else if (value >= 2 && value <= 4) {
            // Hare Jumps 30% of the time
            int square = randomBetween(1, 5);
            HarePosition += square;
        } else if (value >= 5 && value <= 6) {
            // Hare Small Slips 20% of the time
            int square = randomBetween(1, 2);
            HarePosition -= square;
            // if the Tortiose slips before square 1, then we adjust the postion to 1
            if (HarePosition < 1) {
                HarePosition = 1;
            }
        } else if (value == 7) {
            // Hare Big Slips 10% of the time
            int square = randomBetween(1, 7);
            HarePosition -= square;
            // if the Tortiose slips before square 1, then we adjust the postion to 1
            if (HarePosition < 1) {
                HarePosition = 1;
            }
        } else {
            // Hare Walks 30% of the time
            int square = randomBetween(0, 1);
            HarePosition += square;
        }

    }

}
