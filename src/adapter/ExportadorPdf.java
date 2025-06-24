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

public class ExportadorPdf implements Exportador {

    @Override
    public void exportar(Credencial credencial) {
        System.out.println("[EXPORTACION PDF SIMULADA]");
        System.out.println(">>> Documento generado <<<");
        System.out.println(credencial.obtenerContenido());
    }
}
