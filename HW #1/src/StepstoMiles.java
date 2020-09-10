import java.util.GregorianCalendar;
import java.util.Calendar;

public class StepstoMiles {
    // INSTANCE INITALIZATION
    private String name;
    private double feet;
    private double inches;

    // NON-DEFAULT CONSTRUCTOR THAT WILL HELP ME ASSIGN DATA TO VARIBALES LATER

    public StepstoMiles(String name, double feet, double inches) {
        this.name = name;
        this.feet = feet;
        this.inches = inches;
    }

    // DEFAULT CONSTRUCTOR

    public StepstoMiles() {
        name = "John Doe";
        feet = 5;
        inches = 4.5;
    }

    // METHOD TO SET THE NAME IN THE OBJECT
    public void setName(String name) {
        this.name = name; // STORE THE NAME
    }

    // METHOD TO RETRIVE THE NAME FROM THE OBJECT
    public String getName() {
        return name; // RETURN VALUE OF NAME TO CALLER
    }

    // METHOD TO SET THE FEET IN THE OBJECT
    public void setFeet(double feet) {
        this.feet = feet; // STORE THE FEET
    }

    // METHOD TO RETRIVE THE FEET FROM THE OBJECT
    public double getFeet() {
        return feet; // RETURN VALUE OF FEET TO CALLER
    }

    // METHOD TO SET THE INCHES IN THE OBJECT
    public void setInches(double inches) {
        this.inches = inches; // STORE THE INCHES
    }

    // METHOD TO RETRIVE THE INCHES FROM THE OBJECT
    public double getInches() {
        return inches; // RETURN VALUE OF INCHES TO CALLER
    }

    // THIS METHOD PRINTS CURRENT DATE USING CALENDAR AND GREGORIAN CALENDAR
    public String currDate() {
        int year, month, date; // VARIBALE DECLRATION
        String year1, month1, date1;
        Calendar c1 = new GregorianCalendar(); // CREATED AN INSTANCE OF CALENDAR
        year = c1.get(Calendar.YEAR); // GET THE CURRENT YEAR
        month = c1.get(Calendar.MONTH); // GET THE CURRENT MONTH, BUT SINCE MONTH STARTS FROM 0 IN GREGORIAN I
                                        // INCREMENTED THE MONTH
        month++;
        date = c1.get(Calendar.DAY_OF_MONTH); // GET THE CURRENT DATE
        year1 = Integer.toString(year); // CONV TO STRINGS
        month1 = Integer.toString(month);
        date1 = Integer.toString(date);
        return month1 + "/" + date1 + "/" + year1; // RETURNS THE DATE
    }

    // THIS METHOD TURNS YOUR INT INTO A STRING
    public String formatAsString(int a) {
        String steps = String.format("%,d", a); // FORMATS THE STEPS
        return steps; // RETURNS STEPS
    }

    // // RETURNS THE HEIGHT IN INCHES
    public double height_inches() {
        double feet_inches = 12 * this.feet; // 1FT==12IN, SO WE TAKE THE FFET AND MULTIPLY IT BY 12
        feet_inches += this.inches; // ADD THE ADDITIONAL INCHES
        return feet_inches; // RETURN HEIGHT IN INCHES
    }

    // // THIS METHOD RETURNS THE LENGTH OF A PERSON'S STRIDE
    public double strideLength_inches() {
        double getinches = height_inches(); // OBTAINS THE RETURN OF HEIGHT_INCHES() FUNCTION
        return getinches * 0.413; // USING THE FORMULA PROVIDED I RETURNED THE OBTAINED VALUE * 0.413
    }

    // // THIS METHOD RETURNS THE NUMBER OF MILES TO WALK GIVEN THE NUMBER OF STEPS
    public double miles(int a) {
        double getstride = strideLength_inches(); // OBTAINS THE RETURN OF strideLength_inches()
        double miles = (getstride * a) / (12 * 5280); // USING THE FORMULA PROVIDED I OBTAINED THE MILES
        return miles; // RETURN MILES
    }

}