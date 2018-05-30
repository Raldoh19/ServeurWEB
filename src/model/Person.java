package model;

/**
 * Represents a person using first name, last name
 * @author Aymane RAMACH
 */

public class Person
{
    /**
     * First name of the person
     */
    private String firstName;

    /**
     * Last name of the person
     */
    private String lastName;

    /**
     * Constructor of the object Person with all the attributes
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get the first name of the person
     * @return String that contains the first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set the first name of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the person
     * @return String that contains the last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the person
     * @param lastName String that contains the last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}