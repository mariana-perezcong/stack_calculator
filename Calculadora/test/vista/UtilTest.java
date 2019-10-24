/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SMUNOZA
 */
public class UtilTest {
    
    public UtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of esOperador method, of class Util.
     */
    @Test
    public void testEsOperador() {
        System.out.println("esOperador");
        char a = '+';
        boolean expResult = true;
        boolean result = Util.esOperador(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of eliminarEspacios method, of class Util.
     */
    @Test
    public void testEliminarEspacios() {
        System.out.println("eliminarEspacios");
        String cadena = "5 + 9 + 8 - 3";
        String expResult = "5+9+8-3";
        String result = Util.eliminarEspacios(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrioridad method, of class Util.
     */
    @Test
    public void testGetPrioridad() {
        System.out.println("getPrioridad");
        char operador = '+';
        int expResult = 0;
        int result = Util.getPrioridad(operador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addInversoAditivo method, of class Util.
     */
    @Test
    public void testAddInversoAditivo() {
        System.out.println("addInversoAditivo");
        String cadena = "(4-3)*5";
        String expResult = "(4+( -1 )*3)*5";
        String result = Util.addInversoAditivo(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of quitaSignosMas method, of class Util.
     */
    @Test
    public void testQuitaSignosMas() {
        System.out.println("quitaSignosMas");
        String cad = "+ 5 ";
        String expResult = " 5 ";
        String result = Util.quitaSignosMas(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
