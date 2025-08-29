package com.tallerwebi.TDD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDD {

    public static String validarFortaleza(String contrasenia) {

        if(contrasenia == null || contrasenia.isEmpty()){
            return "INVALIDA";
        } else{
            Matcher buscadorDeLetras = Pattern.compile("[a-zA-Z]{1}").matcher(contrasenia);
            Matcher buscadorParaCaracteresEspeciales = Pattern.compile("[-_%$?!@]{1}").matcher(contrasenia);
            Matcher buscadorParaNumeros = Pattern.compile("[0-9]{1}").matcher(contrasenia);

            int cantidadDeletras = 0;
            while (buscadorDeLetras.find()) {
                cantidadDeletras++;
            }
            int cantidadDeCaracteresEspeciales = 0;
            while (buscadorParaCaracteresEspeciales.find()) {
                cantidadDeCaracteresEspeciales++;
            }
            int cantidadDeNumeros = 0;
            while (buscadorParaNumeros.find()) {
                cantidadDeNumeros++;
            }

            if ( contrasenia.length() <= 8 && cantidadDeletras == contrasenia.length() ) {
                return "DEBIL";
            } else if ( cantidadDeCaracteresEspeciales == 1 && cantidadDeNumeros == 1) {
                return "MEDIANA";
            } else {
                return "FUERTE";
            }
        }


    }
}
