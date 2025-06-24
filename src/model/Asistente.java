/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aniba
 */
public class Asistente {

    private String nombre;
    private String rut;
    private String tipoAcceso;

    public Asistente(String nombre, String rut, String tipoAcceso) {
        this.nombre = nombre;
        this.rut = rut;
        this.tipoAcceso = tipoAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getTipoAcceso() {
        return tipoAcceso;
    }
}
