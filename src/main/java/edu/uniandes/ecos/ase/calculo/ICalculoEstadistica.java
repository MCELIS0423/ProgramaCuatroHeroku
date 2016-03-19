/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.calculo;

import java.util.List;

/**
 * Clase encargada de realizar calculos estadísticos generales
 * @author mariocelis
 */
public interface ICalculoEstadistica {
    
    /**
     * Función encargada de la normalización de datos
     * @param valorUno
     * @param valorDos
     * @return Coeficiente resultante de la normalización
     */
    public Double normalizarValor(String valorUno, String valorDos);
    
    /**
     * Suma todos los valores ingresados en un arreglo
     * @param datos
     * @return Resultado de la sumatoria de todos los números ingresados, para
     * el caso del conjunto de datos
     */
    public Double sumatoria(List<String> datos);
    
    /**
     * Calcula el promedio del logaritmo natural de los numeros ingresados en un arreglo
     * @param datos
     * @return Promedio del logaritmo natural de los parámetros ingresados
     */
    public Double promedioLogaritmoNatural(List<String> datos);
    
    /**
     * Calcula el valor de la varianza
     * @param datos
     * @param promedioLogaritmoNatural
     * @return valor de la varianza
     */
    public Double varianza(List<String> datos, double promedioLogaritmoNatural);
    
    /**
     * Calcula la desviación estandar
     * @param varianza
     * @return valor de la desviación estandar
     */
    public Double desviacionEstandar(Double varianza);
    
    /**
     * Calcula el rango logaritmico VERY SMALL
     * @param promedioLogaritmoNatural
     * @param desviacionEstandar
     * @return valor very small
     */
    public Double verySmall(double promedioLogaritmoNatural, double desviacionEstandar);
    
    /**
     * Calcula el rango logaritmico SMALL
     * @param promedioLogaritmoNatural
     * @param desviacionEstandar
     * @return retorna el valor small
     */
    public Double small(double promedioLogaritmoNatural, double desviacionEstandar);
    
    /**
     * Calcula el rango logaritmico MEDIUM
     * @param promedioLogaritmoNatural
     * @return retorna el valor medium
     */
    public Double medium(double promedioLogaritmoNatural);
    
    /**
     * Calcula el rango logaritmico LARGE
     * @param promedioLogaritmoNatural
     * @param desviacionEstandar
     * @return retorna el valor large
     */
    public Double large(double promedioLogaritmoNatural, double desviacionEstandar);
    
    /**
     * Calcula el rango logaritmico VERY LARGE
     * @param promedioLogaritmoNatural
     * @param desviacionEstandar
     * @return retorna el valor very large
     */
    public Double veryLarge(double promedioLogaritmoNatural, double desviacionEstandar);
}