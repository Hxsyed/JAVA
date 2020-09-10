import java.util.Scanner;

public class TestStepsToMiles {

    public static void main(String[] args) {

        // CREATS AN INSTANCE OF A CLASS
        StepstoMiles p1 = new StepstoMiles(); // THIS ONE IS FOR THE CONSTRUCTOR VALUES
        StepstoMiles p2 = new StepstoMiles(); // THIS ONE IS FOR THE USER INPUT
        // DECLARED THE SCANNER OBJECT TO GET USER INPUTS
        Scanner input = new Scanner(System.in);
        System.out.printf("%26s", "Enter Name: "); // OBTAINING THE USER INPUT
        p2.setName(input.nextLine()); // SETS THE USER NAME INPUT USING SETTER METHOD
        System.out.printf("%26s", "Enter Height (ft and in): "); // OBTAINING THE HEIGH IN FT AND INCHES
        p2.setFeet(input.nextDouble()); // SETS THE FEET INPUT USING SETTER METHOD
        p2.setInches(input.nextDouble()); // SETS THE INCHES INPUT USING SETTER METHOD
        input.close(); // CLOSED THE SCANNER OBJECT
        System.out.printf("\n");

        // PRINTS OUT TODAYS DATE
        System.out.printf("%14s%s\n\n", "Today's Date: ", p1.currDate());

        // PRINTS OUT THE DEFAULT CONSTRUCTOR VALUES
        // (I.E-NAME,HEIGHT,STRIDE,STEPS,WALKING MILES)
        System.out.printf("%14s%s\n", "Name: ", p1.getName());
        System.out.printf("%14s%.2f' %.2f\"\n", "Height: ", p1.getFeet(), p1.getInches());
        System.out.printf("%14s%.2f\n", "Stride: ", p1.strideLength_inches());
        System.out.printf("%14s%s\n", "Steps: ", p1.formatAsString(12345));
        System.out.printf("%14s%.2f miles\n\n", "Walk: ", p1.miles(12345));

        // // PRINTS OUT THE NON-DEFAULT CONSTRUCTOR VALUES
        // (I.E-NAME,HEIGHT,STRIDE,STEPS,WALKING MILES)
        System.out.printf("%14s%s\n", "Name: ", p2.getName());
        System.out.printf("%14s%.2f' %.2f\"\n", "Height: ", p2.getFeet(), p2.getInches());
        System.out.printf("%14s%.2f\n", "Stride: ", p2.strideLength_inches());
        System.out.printf("%14s%s\n", "Steps: ", p2.formatAsString(1000));
        System.out.printf("%14s%.2f miles", "Walk: ", p2.miles(1000));
    }
}
