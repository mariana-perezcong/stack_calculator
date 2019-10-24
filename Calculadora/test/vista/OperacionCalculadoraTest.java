/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
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
public class OperacionCalculadoraTest {
    
    public OperacionCalculadoraTest() {
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
     * Test of revisaParentesis method, of class OperacionCalculadora.
     */
    @Test
    public void testRevisaParentesis() {
        System.out.println("revisaParentesis");
        String cadena = "(5+4)*(4+8)";
        boolean expResult = true;
        boolean result = OperacionCalculadora.revisaParentesis(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of operadoresRepetidos method, of class OperacionCalculadora.
     */
    @Test
    public void testOperadoresRepetidos() {
        System.out.println("operadoresRepetidos");
        String cad = "5+4";
        boolean expResult = false;
        boolean result = OperacionCalculadora.operadoresRepetidos(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of convertirAPostFijo method, of class OperacionCalculadora.
     */
    @Test
    public void testConvertirAPostFijo() {
        System.out.println("convertirAPostFijo");
        char[] inFija = {' ','5',' ','+',' ','6',' '};
        ArrayList expResult = new ArrayList();
        expResult.add(' ');
        expResult.add('5');
        expResult.add(' ');
        expResult.add(' ');
        expResult.add('6');
        expResult.add(' ');
        expResult.add('+');
        ArrayList result = OperacionCalculadora.convertirAPostFijo(inFija);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of evaluarPostFija method, of class OperacionCalculadora.
     */
    @Test
    public void testEvaluarPostFija() {
        System.out.println("evaluarPostFija");
        ArrayList postFija = new ArrayList();
        postFija.add(' ');
        postFija.add('3');
        postFija.add(' ');
        postFija.add(' ');
        postFija.add('4');
        postFija.add(' ');
        postFija.add('+');
        String expResult = "7.0";
        String result = OperacionCalculadora.evaluarPostFija(postFija);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
