/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author aniba
 */
public class Asistente {

    private String id;
    private String nombre;
    private String rut;
    private String tipoAcceso;

    public Asistente(String nombre, String rut, String tipoAcceso) {
        UUID uuid = UUID.randomUUID();
        this.id = "CRED-" + uuid.toString().substring(0, 6).toUpperCase();
        this.nombre = nombre;
        this.rut = rut;
        this.tipoAcceso = tipoAcceso;
    }

    public String getId() {
        return id;
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

