/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterator;

import model.Asistente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aniba
 */
public class ListaAsistentes implements Iterable<Asistente> {

    private List<Asistente> asistentes = new ArrayList<>();

    public void agregar(Asistente a) {
        asistentes.add(a);
    }

    public Asistente eliminar(int indice) {
        return asistentes.remove(indice);
    }

    public boolean tieneElementos() {
        return !asistentes.isEmpty();
    }

    public List<Asistente> obtenerTodos() {
        return asistentes;
    }

    @Override
    public Iterator<Asistente> iterator() {
        return asistentes.iterator();
    }
}
