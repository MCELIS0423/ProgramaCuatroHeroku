/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.calculo;

import java.util.List;

/**
 *
 * @author mariocelis
 */
public class CalculoEstadistica implements ICalculoEstadistica {

    @Override
    public Double normalizarValor(String valorUno, String valorDos) {
        Double cociente = null;
        try {
            cociente = Double.parseDouble(valorUno) / Double.parseDouble(valorDos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cociente;
    }

    /**
     * @since 02/03/2016
     * @param datos
     * @return La sumatoria de todos los números ingresados como parámetros a
     * través de una lista
     */
    @Override
    public Double sumatoria(List<String> datos) {
        double sumatoria = 0;
        try {
            for (String dato : datos) {
                sumatoria += Double.valueOf(dato);
            }
        } catch (Exception e) {
            System.out.println("Error calculando la sumatoria el primer " + e.getMessage());
        }
        return sumatoria;
    }

    /**
     * @since 02/03/2016
     * @param datos
     * @return El promedio de todos los números ingresados como parámetros a
     * través de una lista
     */
    @Override
    public Double promedioLogaritmoNatural(List<String> datos) {
        Integer numeroRegistros;
        Double media = null;
        double sumatoria = 0;
        numeroRegistros = datos.size();
        try {
            if (numeroRegistros != 0) {
                for (String dato : datos) {
                    sumatoria += Math.log((Double.parseDouble(dato)));
                }
                media = sumatoria / numeroRegistros;
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error en el calculo del promedio del logaritmo natural "
                    + "- Detalle: " + e.getMessage());
        }
        return media;
    }

    @Override
    public Double varianza(List<String> datos, double promedioLogaritmoNatural) {
        Integer numeroRegistros;
        double sumatoria = 0;
        Double varianza = null;
        numeroRegistros = datos.size();
        try {
            if (numeroRegistros != 0) {
                for (String dato : datos) {
                    sumatoria += Math.pow(Math.log(Double.parseDouble(dato)) - promedioLogaritmoNatural, 2);
                }
                varianza = sumatoria / (numeroRegistros - 1);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error en el calculo del promedio del logaritmo natural "
                    + "- Detalle: " + e.getMessage());
        }
        return varianza;
    }

    @Override
    public Double desviacionEstandar(Double varianza) {
        Double desviacionEstandar = null;
        try {
            desviacionEstandar = Math.sqrt(varianza);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular la desviación estándar - Detalle: " + e.getMessage());
        }
        return desviacionEstandar;
    }

    @Override
    public Double verySmall(double promedioLogaritmoNatural, double desviacionEstandar) {
        Double vs = null;
        try {
            vs = Math.exp(promedioLogaritmoNatural - 2 * (desviacionEstandar));
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular el verySmall - Detalle: " + e.getMessage());
        }
        return vs;
    }

    @Override
    public Double small(double promedioLogaritmoNatural, double desviacionEstandar) {
        Double s = null;
        try {
            s = Math.exp(promedioLogaritmoNatural - desviacionEstandar);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular el small - Detalle: " + e.getMessage());
        }
        return s;
    }

    @Override
    public Double medium(double promedioLogaritmoNatural) {
        Double m = null;
        try {
            m = Math.exp(promedioLogaritmoNatural);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular el medium - Detalle: " + e.getMessage());
        }
        return m;
    }

    @Override
    public Double large(double promedioLogaritmoNatural, double desviacionEstandar) {
        Double l = null;
        try {
            l = Math.exp(promedioLogaritmoNatural + desviacionEstandar);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular el large - Detalle: " + e.getMessage());
        }
        return l;
    }

    @Override
    public Double veryLarge(double promedioLogaritmoNatural, double desviacionEstandar) {
        Double vl = null;
        try {
            vl = Math.exp(promedioLogaritmoNatural + 2 * (desviacionEstandar));
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular el very large - Detalle: " + e.getMessage());
        }
        return vl;
    }

}