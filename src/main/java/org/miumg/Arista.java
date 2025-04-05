package org.miumg;

/**
 * Clase para representar una arista
 */
public class Arista {
    private final int origen;
    private final int destino;
    private final int peso;

    /**
     * Constructor de la arista
     * @param origen vértice de origen
     * @param destino vértice de destino
     * @param peso peso de la arista
     */
    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Método para obtener el vértice de origen
     * @return vértice de origen
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * Método para obtener el vértice de destino
     * @return vértice de destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * Método para obtener el peso de la arista
     * @return peso de la arista
     */
    public int getPeso() {
        return peso;
    }
}
