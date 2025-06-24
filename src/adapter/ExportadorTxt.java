/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

/**
 *
 * @author aniba
 */
import model.Credencial;

public class ExportadorTxt implements Exportador {

    @Override
    public void exportar(Credencial credencial) {
        System.out.println("[EXPORTACION TXT]");
        System.out.println(credencial.obtenerContenido());
    }
}
