/*
  Evan Knight
  3-3-2021
  CMSC 256
  Sec 004
 */



package cmsc256;


public class CustomDate implements Comparable<CustomDate>{
    int day;
    int month;
    int year;


    public CustomDate() {
        setYear(1900);
        setMonth(1);
        setDay(1);
    }


    public CustomDate(int newMonth, int newDay, int newYear) {
        setYear(newYear);
        setMonth(newMonth);
        setDay(newDay);
    }


    public CustomDate(String newMonth, int newDay, int newYear) {
        setYear(newYear);
        setMonth(newMonth);
        setDay(newDay);
    }

    //checks if day is less than the number of days that are allowed in each month
    public void setDay(int day) throws IllegalArgumentException{
        int numOfDaysInMonth = 0;
        if (getMonth() == 1) numOfDaysInMonth = 31;
        if (getMonth() == 2) {
            if (isLeapYear()) {
                numOfDaysInMonth = 29;
            }
            else numOfDaysInMonth = 28;
        }
        if (getMonth() == 3) numOfDaysInMonth = 31;
        if (getMonth() == 4) numOfDaysInMonth = 30;
        if (getMonth() == 5) numOfDaysInMonth = 31;
        if (getMonth() == 6) numOfDaysInMonth = 30;
        if (getMonth() == 7) numOfDaysInMonth = 31;
        if (getMonth() == 8) numOfDaysInMonth = 31;
        if (getMonth() == 9) numOfDaysInMonth = 30;
        if (getMonth() == 10) numOfDaysInMonth = 31;
        if (getMonth() == 11) numOfDaysInMonth = 30;
        if (getMonth() == 12) numOfDaysInMonth = 31;

        if (day > numOfDaysInMonth|| day < 1) {
            throw new IllegalArgumentException("Invalid day input.");
        }
        this.day = day;
    }


    public void setMonth(int month) throws IllegalArgumentException{
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Invalid month input. Month should be ");
        }
        this.month = month;
    }


    public void setMonth(String month) throws IllegalArgumentException {
        month = month.toLowerCase();
        if (!month.equals("january") && !month.equals("february") && !month.equals("march") && !month.equals("april") &&
                !month.equals("may") && !month.equals("june") && !month.equals("july") && !month.equals("august") &&
                !month.equals("september") && !month.equals("october") && !month.equals("november") && !month.equals("december")) {
            throw new IllegalArgumentException("Invalid month input. Proper input example:\"January\"");
        }

        else {
            switch (month) {
                case "january":
                    this.month = 1;
                    break;
                case "february":
                    this.month = 2;
                    break;
                case "march":
                    this.month = 3;
                    break;
                case "april":
                    this.month = 4;
                    break;
                case "may":
                    this.month = 5;
                    break;
                case "june":
                    this.month = 6;
                    break;
                case "july":
                    this.month = 7;
                    break;
                case "august":
                    this.month = 8;
                    break;
                case "september":
                    this.month = 9;
                    break;
                case "october":
                    this.month = 10;
                    break;
                case "november":
                    this.month = 11;
                    break;
                case "december":
                    this.month = 12;
                    break;
            }
        }
    }


    public void setYear(int year) throws IllegalArgumentException{
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year input");
        }
        this.year = year;
    }


    public int getDay() {
        return day;
    }


    public int getMonth() {
        return month;
    }


    public int getYear() {
        return year;
    }


    public String toString() {
        //pads day, month, and year with 0's to match formatting standards
        String dayMod = String.valueOf(getDay());
        String monthMod = String.valueOf(getMonth());
        String yearMod = String.valueOf(getYear());
        if (getDay() < 10) {
            dayMod = "0" + getDay();
        }
        if (getMonth() < 10) {
            monthMod = "0" + getMonth();
        }
        if (getYear() < 999 && getYear() > 99) {
            yearMod = "0" + getYear();
        }
        if (getYear() < 99 && getYear() > 9) {
            yearMod = "00" + getYear();
        }
        if (getYear() < 9 && getYear() > 0) {
            yearMod = "000" + getYear();
        }

        return monthMod + "/" + dayMod + "/" + yearMod;
    }


    public boolean isLeapYear() {
        return (getYear() % 4) == 0 && (getYear() % 100) != 0;
    }


    public int getNumOfDaysInMonth() {
        int numOfDaysInMonth = 0;
        if (getMonth() == 1) numOfDaysInMonth = 31;
        if (getMonth() == 2) {
            if (isLeapYear()) {
                numOfDaysInMonth = 29;
            }
            else numOfDaysInMonth = 28;
        }
        if (getMonth() == 3) numOfDaysInMonth = 31;
        if (getMonth() == 4) numOfDaysInMonth = 30;
        if (getMonth() == 5) numOfDaysInMonth = 31;
        if (getMonth() == 6) numOfDaysInMonth = 30;
        if (getMonth() == 7) numOfDaysInMonth = 31;
        if (getMonth() == 8) numOfDaysInMonth = 31;
        if (getMonth() == 9) numOfDaysInMonth = 30;
        if (getMonth() == 10) numOfDaysInMonth = 31;
        if (getMonth() == 11) numOfDaysInMonth = 30;
        if (getMonth() == 12) numOfDaysInMonth = 31;
        return numOfDaysInMonth;
    }


    public void advanceOneDay() {
        if ((getDay() + 1) > getNumOfDaysInMonth()) {
            if ((getMonth() + 1) > 12) {
                setMonth(1);
                setYear(getYear() + 1);
                setDay(1);
            }
            else {
                setMonth(getMonth() + 1);
                setDay(1);
            }
        }
        else {
            setDay(getDay() + 1);
        }
    }


    public void advanceOneWeek() {
        if ((getDay() + 7) > getNumOfDaysInMonth()) {
            if ((getMonth() + 1) > 12) {
                setDay(7 - (getNumOfDaysInMonth() - getDay()));
                setMonth(1);
                setYear(getYear() + 1);
            }
            else {
                setDay(7 - (getNumOfDaysInMonth() - getDay()));
                setMonth(getMonth() + 1);
            }
        }
        else {
            setDay(getDay() + 7);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDate that = (CustomDate) o;
        return day == that.day && month == that.month && year == that.year;
    }


    @Override
    public int compareTo(CustomDate o) {
        if (o.getYear() == getYear()) {
            if (o.getMonth() == getMonth()) {
                if (o.getDay() == getDay()) {
                    return 0;
                }
                if (o.getDay() > getDay()) {
                    return -1;
                }
                else return 1;
            }
            if (o.getMonth() > getMonth()) {
                return -1;
            }
            else return 1;
        }
        if (o.getYear() > getYear()) {
            return -1;
        }
        else return 1;
    }
}
