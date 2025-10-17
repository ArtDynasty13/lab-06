package com.example.listycity;

import java.util.Objects;

/**
 * This is a class representing a city object.
 */
public class City implements Comparable{
    private String city;
    private String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    /** This method compares cities based on city name field
     * @return -1 if the caller is greater than the argument,
     */
    public int compareTo(Object o) {
        City city = (City) o; // typecasting
        return this.city.compareTo(city.getCity());
    }

    /**
     * Compare
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return city.equals(other.city) && province.equals(other.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
