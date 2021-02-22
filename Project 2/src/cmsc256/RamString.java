/*
 * Evan Knight
 * 2-5-2021
 * CMSC 256
 * Sec 004
 */



package cmsc256;



public class RamString implements WackyStringInterface{
    private String string;


/**
* Default constructor. It sets string to "Let's Go Rams and CS@VCU!".
*/
    public RamString() { this.string = "Let's Go Rams and CS@VCU!"; }

/**
*Pparametized constructor that takes a String input and throws an IllegalArgumentException if null.
*/
    public RamString(String string) throws IllegalArgumentException{
        if (string == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }
        this.string = string; }

/**
* Takes a String input and sets string instance variable.
*/
    public void setWackyString(String string) { this.string = string; }

/**
* Returns string.
*/
    public String getWackyString() {
        return this.string;
    }



/**
* Returns a string that consists of every third character in the string instance variable.
*/
    public String getEveryThirdCharacter() {
        String everyThree = "";
        for (int i = 0; i < string.length(); i++) {
            if ((i + 1) % 3 == 0) {
                everyThree = everyThree.concat(string.substring(i, i + 1));
            }
        }
        return everyThree;
    }

/**
* This method, depending on String input being "even" or "odd", returns the even or odd characters of the string variable. 
* @param evenOrOdd Is a string input that must be "even" or "odd" or it throws an IllegalArgumentException.
*/
    public String getEvenOrOddCharacters(String evenOrOdd) throws IllegalArgumentException{
        StringBuilder evenOrOddChars = new StringBuilder();

        if (!evenOrOdd.equals("even") && !evenOrOdd.equals("odd")) {
            throw new IllegalArgumentException("Input must be 'even' or 'odd'.");
        }

        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < string.length(); i++) {
                if ((i % 2) != 0) {
                    evenOrOddChars.append(string.charAt(i));
                }
            }
        }

        else {
            for (int i = 0; i < string.length(); i ++) {
                if ((i % 2) == 0) {
                    evenOrOddChars.append(string.charAt(i));
                }
            }
        }

        return evenOrOddChars.toString();
    }


/**
* Counts the number of double digits in the string.
*/
    public int countDoubleDigits() {
        StringBuilder temp = new StringBuilder(string);
        int count = 0;
        
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(temp.charAt(i))) {
                temp.setChar(i, '1');
            }
            else {
                temp.setChar(i, '0');
        }
            
        String tempString = temp.toString();
        tempString.replace("0110", "2");
        tempString.replace("2110", "22");

           
        for (int i = 0; i < tempString.length(); i++) {
            if (temoString.charAt(i) == '2') {
                count+= 1;
            }
        }
            
        if (tempString.startsWith("110") {
            count+= 1;
        }
        if (tempString.endsWith("011") {
            count+= 1:
        }
            
        return count;
    }

/**
* Determines whether the string is a valid VCU email or not.
*/
    public boolean isValidVCUEmail() {
        int atIndex = string.indexOf('@');
        int tagIndex = string.lastIndexOf("vcu.edu");

        if (!string.contains("@")) {
            return false;
        }
        if (!string.contains("vcu.edu") && !string.contains("mymail.vcu.edu")) {
            return false;
        }
        if(!string.endsWith("edu")) {
            return false;
        }
        if (atIndex < 1) {
            return false;
        }
        if (tagIndex < atIndex) {
            return false;
        }
        else {
            return true;
        }
    }

/**
* This method formats the string into a standard phone number format, if there are 10 digits in the string.
*/
    public String standardizePhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if (Character.isDigit(temp)) {
                phoneNumber.append(temp);
            }
        }
        if (phoneNumber.length() != 10) {
            return "This WackyString is not a phone number.";
        }
        else {
            return "(" + phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6);
        }
    }

/**
* Replaces "00" with "CS@VCU", and "0" with "Go Rams".
*/
    public void ramifyString() {
        String ramified = string.replace("00", "CS@VCU");
        ramified = ramified.replace("0", "Go Rams");
        string = ramified;
    }

/**
* Converts all the digits in a specified substring to roman numerals, 0 is not changed.
* @param 
*/
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition) throws MyIndexOutOfBoundsException, IllegalArgumentException {

        if (startPosition < 1 || endPosition > string.length() - 1) {
            throw new MyIndexOutOfBoundsException("Start or End position invalid.");
        }
        if (startPosition > endPosition) {
            throw new IllegalArgumentException("Start position cannot be greater than End position.");
        }

        String selectedPortion = string.substring(startPosition - 1, endPosition - 1);
        selectedPortion = selectedPortion.replace("1", "I");
        selectedPortion = selectedPortion.replace("2", "II");
        selectedPortion = selectedPortion.replace("3", "III");
        selectedPortion = selectedPortion.replace("4", "IV");
        selectedPortion = selectedPortion.replace("5", "V");
        selectedPortion = selectedPortion.replace("6", "VI");
        selectedPortion = selectedPortion.replace("7", "VII");
        selectedPortion = selectedPortion.replace("8", "VIII");
        selectedPortion = selectedPortion.replace("9", "IX");

        string = string.replace(string.substring(startPosition - 1, endPosition - 1), selectedPortion);



        }
    }




