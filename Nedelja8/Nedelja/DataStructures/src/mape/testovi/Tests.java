package mape.testovi;

import mape.zadaci.Zadaci;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    /*
    * Najmanje ponavljanje
    * */
    @Test
    void PonavljanjeTest1(){
        assertEquals( 5, Zadaci.najmanjePonavljanje(new int[]{1, 2, 3, 2, 1, 3, 4, 1, 5, 4}));
    }

    @Test
    void PonavljanjeTest2(){
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{1}));
    }

    // U radom testovima moze da se desi da imamo vise najmanjih, vratiti manji od njih
    @Test
    void PonavljanjeRandomTest(){
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{4, 3, 1, 2, 6, 3, 9, 9, 4, 5, 4, 9, 5, 5, 2, 6, 7, 2, 5}));
        assertEquals(3, Zadaci.najmanjePonavljanje(new int[]{3, 2, 2, 6, 2}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{5, 1}));
        assertEquals(5, Zadaci.najmanjePonavljanje(new int[]{2, 8, 3, 5, 3, 1, 9, 1, 2}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{3, 8, 6, 1, 3, 1, 2, 4, 5, 6, 9}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{6, 2}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{7, 7, 4, 1, 9}));
        assertEquals(8, Zadaci.najmanjePonavljanje(new int[]{9, 6, 3, 7, 5, 5, 2, 6, 4, 1, 4, 1, 8, 3, 2, 4, 7, 5, 1, 6}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{1, 6, 5, 9, 1, 5, 6, 6, 5, 1, 2, 6, 7, 3, 8, 4, 3, 3}));
        assertEquals(4, Zadaci.najmanjePonavljanje(new int[]{7, 6, 5, 4, 6, 6}));
        assertEquals(4, Zadaci.najmanjePonavljanje(new int[]{3, 1, 3, 3, 4, 9, 1, 9, 9, 3, 1, 5}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{7, 8, 2, 1, 3, 3, 6, 5, 9, 2, 4, 6, 6, 9, 3, 6, 3, 8, 9, 3}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{9, 4, 2, 7, 8, 1, 6, 1, 1, 4, 1}));
        assertEquals(3, Zadaci.najmanjePonavljanje(new int[]{3, 7, 5, 5, 5, 7, 4, 6}));
        assertEquals(5, Zadaci.najmanjePonavljanje(new int[]{6, 7, 9, 9, 1, 5, 7, 6, 9, 1, 9, 1}));
        assertEquals(4, Zadaci.najmanjePonavljanje(new int[]{6, 5, 4, 8}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{5, 6, 3, 5, 6, 6, 2, 4, 6, 4, 6, 5, 9}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{1, 4}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{5, 4, 2, 9, 5, 7, 5, 4, 6, 2, 9, 8, 7, 9, 8, 1, 9, 6}));
        assertEquals(8, Zadaci.najmanjePonavljanje(new int[]{2, 9, 8, 2}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{1, 9, 6, 6, 7}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{8, 5, 1, 6, 4, 5, 3, 5, 3, 4, 7, 3, 8, 4, 4}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{8, 1, 8, 7, 8, 2, 1, 5, 3}));
        assertEquals(7, Zadaci.najmanjePonavljanje(new int[]{7, 8}));
        assertEquals(4, Zadaci.najmanjePonavljanje(new int[]{9, 8, 6, 1, 7, 6, 9, 5, 6, 3, 3, 1, 3, 3, 4, 5}));
        assertEquals(3, Zadaci.najmanjePonavljanje(new int[]{1, 4, 4, 1, 3, 4, 5, 7, 5}));
        assertEquals(3, Zadaci.najmanjePonavljanje(new int[]{8, 2, 8, 3, 2, 9}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{9, 1, 3, 9, 9, 9, 5, 3, 5, 2, 9, 9, 2, 4}));
        assertEquals(2, Zadaci.najmanjePonavljanje(new int[]{2, 6, 6, 9, 7, 1, 7, 9, 3, 3, 5, 6, 8, 6, 9, 3, 1}));
        assertEquals(1, Zadaci.najmanjePonavljanje(new int[]{1, 2, 3, 3, 2, 2, 5, 8}));
    }


    /*
    * Najopasnija posada
    * */
    @Test
    void WantedTest1(){
        assertEquals("Heart", Zadaci.wanted(new ArrayList<>(Arrays.asList("s, s, 1", "Roronoa Zoro, Strawhat, 320000", "Trafalgar D. Water Law, Heart, 500000", "Nami, Strawhat, 66000", "Brook, Strawhat, 84000", "Bepo, Heart, 500"))));
    }

    @Test
    void WantedTest2(){
        assertEquals("Strawhat", Zadaci.wanted(new ArrayList<>(Arrays.asList("Monkey D. Luffy, Strawhat, 1500000", "Roronoa Zoro, Strawhat, 320000", "Nami, Strawhat, 66000", "God Usopp, Strawhat, 200000", "Vinsmoke Sanji, Strawhat, 330000", "Tony Tony Chopper, Strawhat, 100", "Buggy the Clown, Buggys delivery, 15000", "Alvida, Buggys delivery, 5000", "Mr. 3, Buggys delivery, 24000"))));
    }


    @Test
    void MolekuliTest1(){
        assertEquals("H2O4S1", Zadaci.molekul("H2SO4"));
    }

    @Test
    void MolekuliTest2(){
        assertEquals("O12S3X2", Zadaci.molekul("X2(SO4)3"));
    }


}
