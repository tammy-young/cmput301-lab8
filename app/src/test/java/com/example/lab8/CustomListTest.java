package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     * */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add a new city to the list
     * add the city to the list
     * check that list has the city
     */
    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * add a new city
     * delete the city
     * check that the list does not contain the city
     * try removing the city again and check that it throws an exception
     */
    @Test
    void testDelete() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        list.delete(city);
        assertFalse(list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }

    /**
     * add 3 cities to the list
     * check that the list has 3 cities in it
     */
    @Test
    void testCountCities() {
        list = MockCityList();
        City city1 = new City("Yellowknife", "Northwest Territories");
        City city2 = new City("Charlottetown", "Prince Edward Island");
        City city3 = new City("Regina", "Saskatchewan");
        list.addCity(city1);
        list.addCity(city2);
        list.addCity(city3);
        assertEquals(3, list.countCities());
    }

}
