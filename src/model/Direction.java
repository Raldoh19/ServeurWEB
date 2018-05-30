package model;



/**
 *  Enumeration that lists all the possible direction
 *  that could be taken.
 *  @author Aymane RAMACH
 */

public enum Direction
{
    None("NONE"),
    North("NORTH"),
    South("SOUTH"),
    East("EAST"),
    West("WEST");

    /**
     * Name of the direction
     */
    private final String name;

    /**
     * Constructor of the direction
     * @param s the name of the direction
     */
    private Direction(String s) {
        name = s;
    }

    /**
     * Comparator equals of Directions
     * @param otherName name of the direction
     * @return true if equal, false if not
     */
    public boolean equals(String otherName)
    {
        return name.equals(otherName);
    }

    /**
     * Return the name of the direction
     * @return A string that contains the direction
     */
    public String toString() {
        return this.name;
    }
}