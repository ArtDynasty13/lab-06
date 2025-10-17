package com.example.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City c = new City("Regina", "SK");
        cityList.add(c);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(c));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class, ()->{cityList.add(c);
        });
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City c = new City("England", "IsMyCity");
        assertFalse(cityList.hasCity(c));
        cityList.add(c);
        assertTrue(cityList.hasCity(c));
    }

    @Test
    public void testRemove() {
        CityList cityList = mockCityList();
        City c = new City("Edmonton", "AB");
        cityList.removeCity(c);
        assertFalse(cityList.hasCity(c));
    }

    @Test
    public void testRemoveCityException() {
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        assertThrows(IllegalArgumentException.class, ()->{cityList.removeCity(c);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.citiesCount());
        City c = new City("England", "IsMyCity");
        cityList.add(c);
        assertEquals(2, cityList.citiesCount());
        cityList.removeCity(c);
        assertEquals(1, cityList.citiesCount());
    }
}