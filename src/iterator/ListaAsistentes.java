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

    @Override
    public Iterator<Asistente> iterator() {
        return asistentes.iterator();
    }
}
