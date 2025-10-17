package com.example.listycity;

import java.util.Objects;

/**
 * This is a class representing a city object.
 */
public class City implements Comparable{
    private String city;
    private String province;

    /**
     * Constructor for a city object
     * @param city: the name of the city
     * @param province: the province of the city
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * getter for the city name
     * @return city: the name of the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the city name
     * @param city: city to set the name to
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the city province
     * @return province: the province of the city
     */
    public String getProvince() {
        return province;
    }

    /**
     * Setter for the city province
     * @param province: the province to set the city's province to
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Compares this city with another by name.
     * @param o the object to compare
     * @return a negative, zero, or positive value based on name order
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o; // typecasting
        return this.city.compareTo(city.getCity());
    }

    /**
     * Determines if a city is equal to another, based on whether
     * the city name and the province are the same between both cities
     * @param obj: the other city to compare against
     * @return True if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return city.equals(other.city) && province.equals(other.province);
    }

    /** This method generates a hash code based on the city and province strings for some city
     * The reason we need to do this is a contract with Java, since we overid equals,
     * if two cities are logically equal, they also need to have the same hashcodes
     * @return the hashcode for the city
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
