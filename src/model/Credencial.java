/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aniba
 */
public class Credencial {

    private Asistente asistente;

    public Credencial(Asistente asistente) {
        this.asistente = asistente;
    }

    public String obtenerContenido() {
        return "Nombre: " + asistente.getNombre()
                + "\nRUT: " + asistente.getRut()
                + "\nAcceso: " + asistente.getTipoAcceso();
    }

    public Asistente getAsistente() {
        return asistente;
    }
}

