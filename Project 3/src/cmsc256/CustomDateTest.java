package cmsc256;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class CustomDateTest {
    CustomDate normalTest;
    CustomDate testWithString;
    CustomDate leapYear;

    @Before
    public void setUp() {
        normalTest = new CustomDate();
        testWithString = new CustomDate("April", 20, 2001);
        leapYear = new CustomDate(2, 28, 1904);
    }

    //test that constructor accepts and implements day input correctly
    @Test
    public void testCustomDateDefaultConstructor1() {
        assertEquals("Day should be 1.", 1, normalTest.getDay());
    }

    //test that constructor accepts and implements month input correctly
    @Test
    public void testCustomDateDefaultConstructor2() {
        assertEquals("Month should be 1.", 1, normalTest.getMonth());
    }

    //test that constructor accepts and implements year input correctly
    @Test
    public void testCustomDateDefaultConstructor3() {
        assertEquals("Year should be 1900.", 1900, normalTest.getYear());
    }

    //test that constructor accepts and implements string input for month
    @Test
    public void testCustomDate() {
        assertEquals("Constructor should be able to take in a string for the month.", 4, testWithString.getMonth());
    }


    //test setDay() with valid input
    @Test
    public void testSetDay1() {
        normalTest.setDay(10);
        assertEquals("Set day should change day.", 10, normalTest.getDay());
    }

    //test setDay() with invalid input
    @Test (expected = IllegalArgumentException.class)
    public void testSetDay2() {
        normalTest.setDay(40);
    }

    //test setDay() with invalid input
    @Test (expected = IllegalArgumentException.class)
    public void testSetDay3() {
        normalTest.setDay(32);
    }

    //test setDay() with an input that should only work on a leap year
    @Test
    public void testSetDay5() {
        leapYear.setDay(29);
        assertEquals("Set day should change day.", 29, leapYear.getDay());
    }

    //test setMonth() with a valid integer input
    @Test
    public void testSetMonth1() {
        normalTest.setMonth(10);
        assertEquals(10, normalTest.getMonth());
    }

    //test setMonth() with a valid string input
    @Test
    public void testSetMonth2() {
        normalTest.setMonth("April");
        assertEquals(4, normalTest.getMonth());
    }

    //test setMonth() with a valid string input, no uppercase
    @Test
    public void testSetMonth3() {
        normalTest.setMonth("december");
        assertEquals(12, normalTest.getMonth());
    }

    //test setMonth() with invalid string input
    @Test (expected = IllegalArgumentException.class)
    public void testSetMonth4() {
        normalTest.setMonth("Tuesday");
    }

    //test setYear() with invalid input
    @Test (expected = IllegalArgumentException.class)
    public void testSetYear1() {
        normalTest.setYear(0);
    }

    //test setYear() with invalid input, too large
    @Test (expected = IllegalArgumentException.class)
    public void testSetYear2() {
        normalTest.setYear(10000);
    }

    //test setYear() with valid input
    @Test
    public void testSetYear3() {
        normalTest.setYear(1000);
        assertEquals(1000, normalTest.getYear());
    }

    //test toString() with valid input, padding required for month and day
    @Test
    public void testToString1() {
        assertEquals("01/01/1900", normalTest.toString());
    }

    //test toString() with different valid input
    @Test
    public void testToString2() {
        assertEquals("04/20/2001", testWithString.toString());
    }

    //test toString() with no padding needed
    @Test
    public void testToString3() {
        testWithString.setMonth(12);
        assertEquals("12/20/2001", testWithString.toString());
    }

    //test isLeapYear() with a leap year
    @Test
    public void testIsLeapYear1() {
        testWithString.setYear(1904);
        assertTrue("A leap year is a year that is divisible by 4 but not by 100.", testWithString.isLeapYear());
    }

    //test isLeapYear() with a non leap year
    @Test
    public void testIsLeapYear2() {
        assertFalse("A leap year is a year that is divisible by 4 but not by 100.", normalTest.isLeapYear());
    }

    //test advanceOneDay() with input that only advance day
    @Test
    public void testAdvanceOneDay1() {
        normalTest.advanceOneDay();
        assertEquals("Day should be increased by one.", 2, normalTest.getDay());
    }

    //test advanceOneDay() with input that advances month
    @Test
    public void testAdvanceOneDay2() {
        normalTest.setDay(31);
        normalTest.advanceOneDay();
        assertEquals("Month should advance if you advanced past the last day of current month", 2, normalTest.getMonth());
    }

    //test advanceOneDay() with input that advances year
    @Test
    public void testAdvanceOneDay3() {
        normalTest.setDay(31);
        normalTest.setMonth(12);
        normalTest.advanceOneDay();
        assertEquals("Year should advance if you advance past the last day of the current year.", 1901, normalTest.getYear());
    }

    //test advanceOneWeek() with input that only advances day
    @Test
    public void testAdvanceOneWeek1() {
        normalTest.advanceOneWeek();
        assertEquals("Day should increase by 7", 8, normalTest.getDay());
    }

    //test advanceOneDay() with input that advances month
    @Test
    public void testAdvanceOneWeek2() {
        normalTest.setDay(30);
        normalTest.advanceOneWeek();
        assertEquals("Day should increase by 7, month should also increase if necessary.", 6, normalTest.getDay());
    }

    //test advanceOneDay() with input that advances month
    @Test
    public void testAdvanceOneWeek3() {
        normalTest.setDay(30);
        normalTest.advanceOneWeek();
        assertEquals("Day should increase by 7, month should also increase if necessary.", 2, normalTest.getMonth());
    }

    //test advanceOneDay() with input that advances year
    @Test
    public void testAdvanceOneWeek4() {
        normalTest.setDay(30);
        normalTest.setMonth(12);
        normalTest.advanceOneWeek();
        assertEquals("Day should increase by 7, month and year should also increase if necessary.", 6, normalTest.getDay());
    }

    //test advanceOneDay() with input that advances year
    @Test
    public void testAdvanceOneWeek5() {
        normalTest.setDay(30);
        normalTest.setMonth(12);
        normalTest.advanceOneWeek();
        assertEquals("Day should increase by 7, month and year should also increase if necessary.", 1, normalTest.getMonth());
    }

    //test advanceOneDay() with input that advances 2 years
    @Test
    public void testAdvanceOneWeek6() {
        normalTest.setDay(30);
        normalTest.setMonth(12);
        for (int i = 60; i > 0; i--) {
            normalTest.advanceOneWeek();
        }
        assertEquals("Day should increase by 7, month and year should also increase if necessary.", 1902, normalTest.getYear());
    }

    //test equals() with same object
    @Test
    public void testEquals1() {
        assertTrue(normalTest.equals(normalTest));
    }

    //test equals() with different object
    @Test
    public void testEquals2() {
        assertFalse(normalTest.equals(testWithString));
    }

    //test compareTo() with CustomDate greater than the CustomDate being tested
    @Test
    public void testCompareTo1() {
        assertTrue(normalTest.compareTo(testWithString) == -1);
    }

    //test compareTo() with CustomDate less than the CustomDate being tested
    @Test
    public void testCompareTo2() {
        assertTrue(testWithString.compareTo(normalTest) == 1);
    }

    //test compareTo() with CustomDate equal to the CustomDate being tested
    @Test
    public void testCompareTo3() {
        assertTrue(normalTest.compareTo(normalTest) == 0);
    }
}
