/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.calculo;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author mariocelis
 */
public class CalculoEstadisticaTest {

    public CalculoEstadisticaTest() {
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
     * Test of normalizarValor method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testNormalizarValor() {
        System.out.println("normalizarValor");
        String valorUno = "18";
        String valorDos = "3";
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 6.0;
        Double result = instance.normalizarValor(valorUno, valorDos);
        assertEquals(expResult, result);
    }

    /**
     * Test of sumatoria method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testSumatoria() {
        System.out.println("sumatoria");
        List<String> datos = new ArrayList<>();
        datos.add("6.0000");
        datos.add("6.0000");
        datos.add("8.3333");
        datos.add("10.3333");
        datos.add("12.3333");
        datos.add("16.4000");
        datos.add("20.5000");
        datos.add("21.7500");
        datos.add("22.2500");
        datos.add("23.0000");
        datos.add("28.3333");
        datos.add("29.0000");
        datos.add("55.8000");
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 260.0332;
        Double result = instance.sumatoria(datos);
        assertEquals(expResult, result);
    }

    /**
     * Test of promedioLogaritmoNatural method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testPromedioLogaritmoNatural() {
        System.out.println("promedioLogaritmoNatural");
        List<String> datos = new ArrayList<>();
        datos.add("6.0000");
        datos.add("6.0000");
        datos.add("8.3333");
        datos.add("10.3333");
        datos.add("12.3333");
        datos.add("16.4000");
        datos.add("20.5000");
        datos.add("21.7500");
        datos.add("22.2500");
        datos.add("23.0000");
        datos.add("28.3333");
        datos.add("29.0000");
        datos.add("55.8000");
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 2.801516675361432;
        Double result = instance.promedioLogaritmoNatural(datos);
        assertEquals(expResult, result);
    }

    /**
     * Test of varianza method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testVarianza() {
        System.out.println("varianza");
        List<String> datos = new ArrayList<>();
        datos.add("6.0000");
        datos.add("6.0000");
        datos.add("8.3333");
        datos.add("10.3333");
        datos.add("12.3333");
        datos.add("16.4000");
        datos.add("20.5000");
        datos.add("21.7500");
        datos.add("22.2500");
        datos.add("23.0000");
        datos.add("28.3333");
        datos.add("29.0000");
        datos.add("55.8000");
        double promedioLogaritmoNatural = 2.8015;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 0.4362535590219627;
        Double result = instance.varianza(datos, promedioLogaritmoNatural);
        assertEquals(expResult, result);
    }

    /**
     * Test of desviacionEstandar method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testDesviacionEstandar() {
        System.out.println("desviacionEstandar");
        Double varianza = 0.4363;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 0.6605300901548695;
        Double result = instance.desviacionEstandar(varianza);
        assertEquals(expResult, result);
    }

    /**
     * Test of verySmall method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testVerySmall() {
        System.out.println("verySmall");
        double promedioLogaritmoNatural = 2.8015;
        double desviacionEstandar = 0.6605;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 4.395142702968957;
        Double result = instance.verySmall(promedioLogaritmoNatural, desviacionEstandar);
        assertEquals(expResult, result);
    }

    /**
     * Test of small method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testSmall() {
        System.out.println("small");
        double promedioLogaritmoNatural = 2.8015;
        double desviacionEstandar = 0.6605;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 8.50794131765075;
        Double result = instance.small(promedioLogaritmoNatural, desviacionEstandar);
        assertEquals(expResult, result);
    }

    /**
     * Test of medium method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testMedium() {
        System.out.println("medium");
        double promedioLogaritmoNatural = 2.8015;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 16.469332250734894;
        Double result = instance.medium(promedioLogaritmoNatural);
        assertEquals(expResult, result);
    }

    /**
     * Test of large method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testLarge() {
        System.out.println("large");
        double promedioLogaritmoNatural = 2.8015;
        double desviacionEstandar = 0.6605;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 31.880674144093902;
        Double result = instance.large(promedioLogaritmoNatural, desviacionEstandar);
        assertEquals(expResult, result);
    }

    /**
     * Test of veryLarge method, of class CalculoEstadistica.
     */
    @org.junit.Test
    public void testVeryLarge() {
        System.out.println("veryLarge");
        double promedioLogaritmoNatural = 2.8015;
        double desviacionEstandar = 0.6605;
        CalculoEstadistica instance = new CalculoEstadistica();
        Double expResult = 61.71333290313241;
        Double result = instance.veryLarge(promedioLogaritmoNatural, desviacionEstandar);
        assertEquals(expResult, result);
    }

}