package com.example.simpleparadox.listycity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private City city1;
    private City city2;
    private City city3;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
        city1 = new City("Halifax","NS");
        city2 = new City("Edmonton","AB");
        city3 = new City("Vancouver","BC");
    }


    @Test
    public void addCityTest() {

        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        assertFalse(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
        assertFalse(list.hasCity(city3));

        list.addCity(city1);

        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
        assertFalse(list.hasCity(city3));

        list.addCity(city2);

        assertTrue(list.hasCity(city1));
        assertTrue(list.hasCity(city2));
        assertFalse(list.hasCity(city3));

        list.addCity(city3);

        assertTrue(list.hasCity(city1));
        assertTrue(list.hasCity(city2));
        assertTrue(list.hasCity(city3));
    }

    @Test
    public void deleteTest() {


        int len;

        list.addCity(city1);
        list.addCity(city2);
        list.addCity(city3);

        assertTrue(list.hasCity(city1));
        assertTrue(list.hasCity(city2));
        assertTrue(list.hasCity(city3));

        len = list.getCount();
        list.delete(city2);

        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
        assertTrue(list.hasCity(city3));
        assertEquals(list.getCount(), len-1);

        len = list.getCount();
        list.delete(city1);

        assertFalse(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
        assertTrue(list.hasCity(city3));
        assertEquals(list.getCount(), len-1);


        len = list.getCount();
        list.delete(city3);

        assertFalse(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
        assertFalse(list.hasCity(city3));
        assertEquals(list.getCount(), len-1);

    }

}