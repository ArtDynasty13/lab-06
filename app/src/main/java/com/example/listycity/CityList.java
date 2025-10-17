package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class holds our City type objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city type object to a the cities list
     * @param city: the city to add
     * //@throws: IllegalArgumentException if c already exists in the cities list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This method returns a sorted list of cities
     * @return Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method checks for if the list of cities has a specific city
     * @param city: the city to check for
     * @return true if cities has the city and false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This method removes a city if it is in the list of cities,
     * and throws an IllegalArgumentException if it is not
     * @param city
     */
    public void removeCity(City city) {
        if (this.hasCity(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method returns the number of cities in the list of cities
     * @return an integer, which is the size of the cities list
     */
    public int citiesCount() {
        return cities.size();
    }
}
