package cmsc256;

public class Main {
    public static void main(String[] args) {
        RamString basic = new RamString();
        RamString ram = new RamString("12link23");
        String thirdCharacter = ram.getEveryThirdCharacter();
        System.out.println(thirdCharacter);
        String evens = ram.getEvenOrOddCharacters("even");
        System.out.println(evens);
        String odds= ram.getEvenOrOddCharacters("odd");
        System.out.println(odds);
        int doubleDigits = ram.countDoubleDigits();
        System.out.println(doubleDigits);

        RamString email = new RamString("sadasd@vcu.edu");
        boolean validEmail = email.isValidVCUEmail();
        System.out.println(validEmail);

        RamString phone = new RamString("my number is 912-227-132");
        String cell = phone.standardizePhoneNumber();
        System.out.println(cell);





    }
}
