package cmsc256;


public class MyBook implements Comparable<MyBook> {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String ISBN10;
    private String ISBN13;


    public MyBook() {
        this.title = "None Given";
        this.authorFirstName = "None Given";
        this.authorLastName = "None Given";
        this.ISBN10 = "0000000000";
        this.ISBN13 = "0000000000000";
    }


    public void setTitle(String title) throws IllegalArgumentException{
            if (title == null) {
                throw new IllegalArgumentException("Title cannot be null.");
            }
            this.title = title;
    }



    public void setAuthorFirstName(String authorFirstName) throws IllegalArgumentException{

            if (authorFirstName == null) {
                throw new IllegalArgumentException("authorFirstName cannot be null");
            }
            this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) throws IllegalArgumentException{
            if (authorLastName == null) {
                throw new IllegalArgumentException("authorLastName cannot be null");
            }
            this.authorLastName = authorLastName;

    }

    public void setISBN10(String ISBN10) throws IllegalArgumentException{
            if (ISBN10 == null) {
                throw new IllegalArgumentException("ISBN10 cannot be null.");
            }
            if (ISBN10.length() != 10) {
                throw new IllegalArgumentException("ISBN10 must be of length 10.");
            }
            for (int i = 0; i < ISBN10.length(); i++) {
                if (Character.isDigit(ISBN10.charAt(i)) == false) {
                    throw new IllegalArgumentException("Character is not a digit");
                }
            }

        this.ISBN10 = ISBN10;
    }

    public void setISBN13(String ISBN13) throws IllegalArgumentException{
            if (ISBN13 == null) {
                throw new IllegalArgumentException("ISBN13 cannot be null.");
            }
            if (ISBN13.length() != 13) {
                throw new IllegalArgumentException("ISBN13 must be of length 10.");
            }
            for (int i = 0; i < ISBN13.length(); i++) {
                if (Character.isDigit(ISBN13.charAt(i)) == false) {
                    throw new IllegalArgumentException("Character is not a digit");
                }
            }


        this.ISBN13 = ISBN13;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getISBN10() {
        return ISBN10;
    }

    public String getISBN13() {
        return ISBN13;
    }


    public MyBook(String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13) {
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setISBN10(ISBN10);
        setISBN13(ISBN13);
    }

    public String toString() {
        return "Title: " + getTitle() + "\n" + "Author: " + getAuthorFirstName() + " " + getAuthorLastName() +
                "\n" + "ISBN10: " + getISBN10() + "\n" + "ISBN13: " + getISBN13();
    }



    public boolean equals(Object otherBook) {
        // are the variables referencing the same object?
        if(this == otherBook) {
            return true;
        }
        // is the parameter a MyBook object?
        if(!(otherBook instanceof MyBook)) {
            return false;
        }
        MyBook other = (MyBook)otherBook;

        if (getISBN10() == other.getISBN10()) {
            return true;
        }
        else {
            return false;
        }
    }

    public int compareTo(MyBook other) {
        int result = getAuthorLastName().compareTo(other.getAuthorLastName());

        if (result == 0) {
            result = getAuthorFirstName().compareTo(other.getAuthorFirstName());
            if (result == 0) {
                result = getTitle().compareTo(other.getTitle());
                return result;
            }
            else {
                return result;
            }
        }
        else {
            return result;
        }

    }
}