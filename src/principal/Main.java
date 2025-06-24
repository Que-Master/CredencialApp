/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.Scanner;
import iterator.*;
import singleton.GeneradorCredenciales;
import model.*;
import adapter.*;
import observer.*;

/**
 *
 * @author aniba
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaAsistentes lista = new ListaAsistentes();
        SujetoAsistentes sujeto = new SujetoAsistentes();
        sujeto.agregarObservador(new Logger());

        Exportador exportador = new ExportadorTxt(); // default

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar asistente");
            System.out.println("2. Mostrar credenciales");
            System.out.println("3. Cambiar exportador (TXT/PDF)");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("RUT: ");
                    String rut = scanner.nextLine();
                    System.out.print("Tipo de acceso: ");
                    String acceso = scanner.nextLine();

                    Asistente a = new Asistente(nombre, rut, acceso);
                    lista.agregar(a);
                    sujeto.notificar("Nuevo asistente agregado: " + nombre);
                }
                case 2 -> {
                    for (Asistente asistente : lista) {
                        Credencial c = GeneradorCredenciales.getInstancia().generar(asistente);
                        exportador.exportar(c);
                    }
                }
                case 3 -> {
                    System.out.print("Elegir exportador (1 = TXT, 2 = PDF): ");
                    int tipo = Integer.parseInt(scanner.nextLine());
                    exportador = (tipo == 1) ? new ExportadorTxt() : new ExportadorPdf();
                }
                case 4 -> {
                    System.out.println("¡Hasta pronto!");
                    return;
                }
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }
}
