package cmsc256;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
// import cmsc256.MyIndexOutOfBoundsException;
// import cmsc256.RamString;
// import cmsc256.WackyStringInterface;


public class RamStringSampleTest {
	 WackyStringInterface normalString;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		normalString = new RamString("Computer Science @ VCU Spring 2021");
	}

	// test if the constructor properly sets the value of the string
	@Test
	public void testRamStringParameterizedConstructor1() {
		assertTrue("Computer Science @ VCU Spring 2021".equals(normalString.getWackyString()));
	}

	// test if the constructor correctly throws the exception for a null string
	@Test (expected = IllegalArgumentException.class)
	public void testRamStringParameterizedConstructor2() {
		RamString tryNull = new RamString(null);
	}

	// test the countDoubleDigits with a string containing 0 double digits
	@Test
	public void testCountDoubleDigits1() {
		assertEquals(0, normalString.countDoubleDigits());
	}

	// test the countDoubleDigits with a string containing 1 double digit pair
	@Test
	public void testCountDoubleDigits2() {
		RamString temp = new RamString("Computer Science @ VCU 50 g00d!");
		assertEquals(1, temp.countDoubleDigits());
	}











	//Test default string value
	@Test
	public void testGetEveryThirdCharacter1() {
		RamString testString = new RamString("Rodney, the Ram");

		String everyThird = testString.getEveryThirdCharacter();
		assertTrue("dyt m".equals(everyThird));
	}

	//Test string without 3 characters
	@Test
	public void testGetEveryThirdCharacter2() {
		RamString testString = new RamString("hi");
		String everyThird = testString.getEveryThirdCharacter();
		assertTrue("".equals(everyThird));
	}

	//Test string that is only 3 characters
	@Test
	public void testGetEveryThirdCharacter3() {
		RamString testString = new RamString("dog");
		String everyThird = testString.getEveryThirdCharacter();
		assertTrue("g".equals(everyThird));
	}

	//Test string with numbers
	@Test
	public void testGetEveryThirdCharacter4() {
		RamString testString = new RamString("123456789");
		String everyThird = testString.getEveryThirdCharacter();
		assertTrue("369".equals(everyThird));
	}


	//test normal string with "odd"
	@Test
	public void testGetEvenOrOddCharacters1() {
		RamString testString = new RamString("Rodney");
		String oddString = testString.getEvenOrOddCharacters("odd");
		assertTrue("Rde".equals(oddString));
	}


	//test normal string with "even"
	@Test
	public void testGetEvenOrOddCharacters2() {
		RamString testString = new RamString("Rodney");
		String evenString = testString.getEvenOrOddCharacters("even");
		assertTrue("ony".equals(evenString));
	}


	//test string with numbers with "odd"
	@Test
	public void testGetEvenOrOddCharacters3() {
		RamString testString = new RamString("123456");
		String oddString = testString.getEvenOrOddCharacters("odd");
		assertTrue("135".equals(oddString));
	}



	//test string with 1 double digit
	@Test
	public void testCountDoubleDigits3() {
		RamString testString = new RamString("11");
		int numDoubles = testString.countDoubleDigits();
		assertEquals(1, numDoubles);
	}


	//test string with characters and digits
	@Test
	public void testCountDoubleDigits4() {
		RamString testString = new RamString("hello 11");
		int numDoubles = testString.countDoubleDigits();
		assertEquals(1, numDoubles);
	}


	//test string with a triple digit number
	@Test
	public void testCountDoubleDigits5() {
		RamString testString = new RamString("333");
		int numDoubles = testString.countDoubleDigits();
		assertEquals(0, numDoubles);
	}


	//test string with no numbers
	@Test
	public void testCountDoubleDigits6() {
		RamString testString = new RamString("hello");
		int numDoubles = testString.countDoubleDigits();
		assertEquals(0, numDoubles);
	}



	//test string that ends with @vcu.edu
	@Test
	public void testIsValidEmail1() {
		RamString testString = new RamString("test@vcu.edu");
		assertTrue("valid email", testString.isValidVCUEmail());
	}

	//test string that ends with @mymail.vcu.edu
	@Test
	public void testIsValidEmail2() {
		RamString testString = new RamString("test@mymail.vcu.edu");
		assertTrue("valid email", testString.isValidVCUEmail());
	}


	//test string that has no characters before the @
	@Test
	public void testIsValidEmail3() {
		RamString testString = new RamString("@vcu.edu");
		assertFalse("invalid email", testString.isValidVCUEmail());
	}


	//test string that has no characters after the @
	@Test
	public void testIsValidEmail4() {
		RamString testString = new RamString("test@");
		assertFalse("invalid email", testString.isValidVCUEmail());
	}


	//test string that has no @
	@Test
	public void testIsValidEmail5() {
		RamString testString = new RamString("testvcu.edu");
		assertFalse("invalid email", testString.isValidVCUEmail());
	}


/*
	//test string with1 single 0
	@Test
	public void testRamifyString1() {
		RamString testString = new RamString("test0");
		String ramified = testString.ramifyString();
		assertEquals("testGo Rams", testString.ramifyString());
	}

	//test string with 1 double zero
	@Test
	public void testRamifyString2() {
		RamString testString = new RamString();
		String testString = "test00";
		String ramified = ramifyString(testString);
		assertEquals("testCS@VCU", ramified);

	}

	//test string with no zeroes
	@Test
	public void testRamifyString3() {
		RamString testString = new RamString();
		String testString = "test";
		String ramified = ramifyString(testString);
		assertEquals("test", ramified);

	}

	//test string with 1 single zero and 1 double zero
	@Test
	public void testRamifyString4() {
		RamString testString = new RamString();
		String testString = "0test00";
		String ramified = ramifyString(testString);

		assertEquals("Go RamstestCS@VCU", ramified);

	}


	//test string with no numbers
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring1() {
		RamString testString = new RamString();
		String testString = "test";
		String convertedToRoman = convertDigitstoRomanNumeralsInSubstring(testString);
		assertEquals("test", convertedToRoman);
	}

	//test string with 1 number
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring2() {
		RamString testString = new RamString();
		String testString = "1";
		String convertedToRoman = convertDigitstoRomanNumeralsInSubstring(testString);
		assertEquals("I", convertedToRoman);

	}

	//test string with numbers including 0
	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring3() {
		RamString testString = new RamString();
		String testString = "30";
		String convertedToRoman = convertDigitstoRomanNumeralsInSubstring(testString);
		assertEquals("III0", convertedToRoman);
	}
*/















}
