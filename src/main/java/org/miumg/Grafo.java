package org.miumg;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private final int numVertices;
    private final List<List<Arista>> listaAdyacencia;

    /**
     * Constructor del grafo
     * @param numVertices número de vértices del grafo
     */
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    /**
     * Método para agregar una arista al grafo
     * @param origen vértice de origen
     * @param destino vértice de destino
     * @param peso peso de la arista
     */
    public void agregarArista(int origen, int destino, int peso) {
        Arista arista = new Arista(origen, destino, peso);
        listaAdyacencia.get(origen).add(arista);
    }

    /**
     * Método para obtener la lista de adyacencia
     * @return lista de adyacencia
     */
    public List<List<Arista>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    /**
     * Método para obtener el número de vértices
     * @return número de vértices
     */
    public int getNumVertices() {
        return numVertices;
    }
}