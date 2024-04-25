package edu.sjsu;

public class NameChecker {
    /**
     * Checks if a given string is a valid name following these rules:
     * - Between 2 to 40 characters
     * - Contains only alphabetic characters, non-consecutive hyphens, or a single quote
     * - Cannot start with a hyphen or single quote
     * 
     * @param input Name to check
     * @return True if input is a valid name, else false
     */
    public static boolean check(String input) {
        boolean prevHypen = false;

        if(input == null || input.length()<2 || input.length()>40){
            return false;
        }
        if(!Character.isLetter(input.charAt(0))){
            return false;
        }

        if(!Character.isLetter(input.charAt(input.length()-1))){
            return false;
        }
        for (int i = 1; i < input.length(); i++) {
            char thisChar = input.charAt(i);
    
            if (!Character.isLetter(thisChar) && thisChar != '-' && thisChar != '\'') {
                return false;
            }
    
            if (thisChar == '-') {
                if (prevHypen) {
                    return false; 
                }
                prevHypen = true; 
            } else {
                prevHypen = false; 
            }
        }

        return true;
    }
}
