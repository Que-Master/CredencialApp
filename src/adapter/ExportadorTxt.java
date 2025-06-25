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
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorTxt implements Exportador {

    @Override
    public void exportar(Credencial credencial) {
        System.out.println("[EXPORTACIÓN TXT]");
        System.out.println(credencial.obtenerContenido());
    }

    public void exportarTodos(List<Credencial> listaCredenciales, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            int contador = 1;
            for (Credencial cred : listaCredenciales) {
                writer.write("[" + contador++ + "] [EXPORTACIÓN TXT]\n");
                writer.write(cred.obtenerContenido() + "\n");
                writer.write("-----------------------------\n");
            }
            System.out.println(" Archivo generado: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println(" Error al escribir archivo: " + e.getMessage());
        }
    }
}

