package Program;

import CustomExceptions.BlankInputException;
import CustomExceptions.IncorrectInputTypeException;

public class Utilities {
    
    public static void parseInvalidSelection(String selection, String errorMessage) throws BlankInputException, IncorrectInputTypeException {
        if (selection.isEmpty() || selection.equals(""))
            throw new BlankInputException("Please enter a selection value");
        throw new IncorrectInputTypeException(errorMessage);
    }
    
    public static String readString(String prompt) {
        System.out.print(prompt);
        return In.nextLine().trim();
    }
    
    public static int parseInt(String input, String invalidMessage) throws IncorrectInputTypeException, BlankInputException {
        if (input.isEmpty() || input.equals(""))
            throw new BlankInputException("Please enter a value");
        if (!isInt(input))
            throw new IncorrectInputTypeException(invalidMessage);
         return Integer.parseInt(input);
    }
    
    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isConfirmed(String action) {
        String selection;
        while (!(selection = Utilities.readString("Are you sure you want to " + action + "?(y/n): ")).equals("n")) {
            switch (selection) {
                case "y": return true;
                default:
                try {
                    parseInvalidSelection(selection, "\"" + selection + "\" is not a valid selection");
                } catch (IncorrectInputTypeException | BlankInputException e) {
                    System.out.println(e.getMessage());
                    }
                }
            }
        return false;
    }
}
