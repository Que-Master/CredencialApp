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
import java.util.ArrayList;
import java.util.List;
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
            System.out.println("1. Gestionar Asistente");
            System.out.println("2. Mostrar y exportar credenciales");
            System.out.println("3. Cambiar exportador (TXT/PDF)");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
                    boolean volver = false;
                    while (!volver) {
                        System.out.println("\n--- GESTIONAR ASISTENTE ---");
                        System.out.println("1. Agregar asistente");
                        System.out.println("2. Ver lista de asistentes");
                        System.out.println("3. Eliminar asistente");
                        System.out.println("4. Volver al menu principal");
                        System.out.print("Opcion: ");
                        int subOpcion = Integer.parseInt(scanner.nextLine());

                        switch (subOpcion) {
                            case 1 -> {
                                System.out.print("Nombre: ");
                                String nombre = scanner.nextLine();
                                System.out.print("RUT: ");
                                String rut = scanner.nextLine();

                                if (!ValidarRut.validar(rut)) {
                                    System.out.println(" RUT invalido. Intente nuevamente.");
                                    break;
                                }

                                System.out.print("Tipo de acceso: ");
                                String acceso = scanner.nextLine();

                                Asistente a = new Asistente(nombre, rut, acceso);
                                lista.agregar(a);
                                sujeto.notificar("Nuevo asistente agregado: " + nombre);
                                System.out.println(" Asistente agregado correctamente.");
                            }

                            case 2 -> {
                                System.out.println("\n Lista de asistentes:");
                                int i = 1;
                                for (Asistente asistente : lista) {
                                    System.out.println(i++ + ". " + asistente.getNombre() + " | " + asistente.getRut() + " | " + asistente.getTipoAcceso());
                                }
                            }

                            case 3 -> {
                                if (!lista.tieneElementos()) {
                                    System.out.println(" No hay asistentes para eliminar.");
                                    break;
                                }

                                System.out.println("\n Selecciona el número del asistente a eliminar:");
                                int i = 1;
                                for (Asistente asistente : lista) {
                                    System.out.println(i++ + ". " + asistente.getNombre() + " | " + asistente.getRut());
                                }

                                System.out.print("Número: ");
                                int indice = Integer.parseInt(scanner.nextLine()) - 1;

                                if (indice >= 0 && indice < lista.obtenerTodos().size()) {
                                    Asistente eliminado = lista.eliminar(indice);
                                    System.out.println(" Asistente eliminado: " + eliminado.getNombre());
                                } else {
                                    System.out.println(" Índice inválido.");
                                }
                            }

                            case 4 ->
                                volver = true;

                            default ->
                                System.out.println(" Opción inválida.");
                        }
                    }
                }

                case 2 -> {
                    System.out.println("Lista de credenciales ");
                    List<Credencial> credenciales = new ArrayList<>();
                    int contador = 1;

                    for (Asistente asistente : lista) {
                        Credencial c = GeneradorCredenciales.getInstancia().generar(asistente);
                        System.out.println("[" + contador++ + "]");
                        exportador.exportar(c);
                        credenciales.add(c);
                    }

                    if (exportador instanceof ExportadorTxt txt) {
                        String ruta = System.getProperty("user.home") + "\\Desktop\\credenciales.txt";
                        txt.exportarTodos(credenciales, ruta);
                    } else {
                        System.out.println(" Credenciales exportadas por consola (modo PDF simulado).");
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
