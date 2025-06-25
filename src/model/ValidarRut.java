/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aniba
 */
public class ValidarRut {

    public static boolean validar(String rutCompleto) {
        if (rutCompleto == null || rutCompleto.isEmpty()) {
            return false;
        }

        rutCompleto = rutCompleto.replace(".", "").replace("-", "").toUpperCase();

        if (!rutCompleto.matches("\\d{7,8}[0-9K]")) {
            return false;
        }

        String numero = rutCompleto.substring(0, rutCompleto.length() - 1);
        char dv = rutCompleto.charAt(rutCompleto.length() - 1);

        return calcularDV(numero).equals(String.valueOf(dv));
    }

    private static String calcularDV(String rut) {
        int suma = 0, factor = 2;
        for (int i = rut.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(rut.charAt(i)) * factor;
            factor = (factor == 7) ? 2 : factor + 1;
        }
        int resto = 11 - (suma % 11);
        if (resto == 11) {
            return "0";
        }
        if (resto == 10) {
            return "K";
        }
        return String.valueOf(resto);
    }

}
