/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tobi
 */
public class MastermindModelTest {
    private MastermindModel master;
    
    @Before
    public void setUp() {
        master = new MastermindModel();
        int[] wert = {1,2,3,4};
        master.setZahlen(wert);
    }
    
    /**
     * Test of check method, of class MastermindModel.
     */
    @Test
    public void konstruktorTest() {
        int[] wert = {1,2,3,4};
        master = new MastermindModel(wert);
        master.check(wert);
        assertEquals(master.sieg(), true);
        int[] wert1 = {1,2,3,4,5};
        master = new MastermindModel(wert1);
        master.check(wert);
        assertEquals(master.sieg(), false);
    }

    /**
     * Test of check method, of class MastermindModel.
     */
    @Test
    public void checkSiegTest() {
        int[] wert = {1,2,3,4};
        master.check(wert);
        assertEquals(master.sieg(), true);
        assertEquals(master.niederlage(),false);
        assertEquals(master.check(wert).size(),1); // Testet ob es jetzt nicht berbrueft 
        //da schon durch denn ersten check gewonnen wurde
        master.restart();
        master.restart();
        assertEquals(master.sieg(),false); // testet ob das zuruecksetzen funtkioniert hat
    }
    
    /**
     * Test of check method, of class MastermindModel.
     */
    @Test
    public void checkVerlorenTest() {
        int[] wert = {1,2,2,2};
        for(int i = 0; i < 10;i++) {
            master.check(wert);
        }
        assertEquals(master.sieg(), false);
        assertEquals(master.niederlage(),true);
    }

    /**
     * Test of stringHTML method, of class MastermindModel.
     */
    @Test
    public void stringHTMLTest() {
        int[] wert = {1,2,3,4};
        master.check(wert);
        String aus = master.stringHTML();
    }
}