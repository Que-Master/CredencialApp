/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

/**
 *
 * @author aniba
 */
import model.Asistente;
import model.Credencial;

public class GeneradorCredenciales {

    private static GeneradorCredenciales instancia;

    private GeneradorCredenciales() {
    }

    public static GeneradorCredenciales getInstancia() {
        if (instancia == null) {
            instancia = new GeneradorCredenciales();
        }
        return instancia;
    }

    public Credencial generar(Asistente asistente) {
        return new Credencial(asistente);
    }
}
