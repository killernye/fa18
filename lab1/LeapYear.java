/** Class that determines whether or not a year is a leap year.
 *  @author YOUR NAME HERE
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    /** Check if the given year is a leap year.
    *   How should I do this?
    *   First I got to know what a leap year is.
    *       A leap year is a year which is either diviible by 400 or
    *       divisible by 4 not by 100
    *   Then I should figure out some mechnical steps to realize those 
    *   definition or abstraction!
    *       1. Thinking! 
    *       There are two options which are exclusive to each other, so
    *       What we should do is check the input and see if it satisfy the
    *       criteria!
    *       The simple way to do this is to check the first one and then
    *       the second one. If either of the two is true then return a positive
    *       answer, otherwise, a negative answer!
    *       2. Let's think a little harder. 
    *       A group of numbers divisble to four contains all the numbers divisible
    *       to 100. And a group of numbers divisble to 100 contains all the numbers
    *       divisible to 400.
    *       So we should first check if the number is divisible to 4. 
    *       If not, then return false.
    *       If divisble to 4, we should check if divisible to 100.
    *       If not, then return true.
    *       If divisble to 100, then we should check if divisible to 400.
    *       If not, then return false.
    *       If divisble to 400, then return true!
    *       Let's do it!
    *
    *   @param year to be analyzed
    *   @return true if the year is a leap year, otherwise, false.
    */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } 
        if (year % 100 != 0) {
            return true;
        }
        if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }

    }


    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}

