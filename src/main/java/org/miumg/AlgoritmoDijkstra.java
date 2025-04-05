package org.miumg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para el algoritmo de Dijkstra
 */
public class AlgoritmoDijkstra {
    private final int[] distancias;
    private final boolean[] visitados;
    private final int[] predecesores;
    private final int numVertices;
    private final List<String> pasos; // Para guardar los pasos del algoritmo

    /**
     * Constructor del algoritmo de Dijkstra
     * @param grafo grafo sobre el que se aplicará el algoritmo
     */
    public AlgoritmoDijkstra(Grafo grafo) {
        this.numVertices = grafo.getNumVertices();
        distancias = new int[numVertices];
        visitados = new boolean[numVertices];
        predecesores = new int[numVertices];
        pasos = new ArrayList<>();
    }

    /**
     * Método para encontrar el camino más corto desde un vértice de origen a todos los demás
     * @param grafo grafo sobre el que se aplicará el algoritmo
     * @param origen vértice de origen
     * @return arreglo con las distancias mínimas
     */
    public int[] encontrarCaminosMinimos(Grafo grafo, int origen) {
        // Inicialización
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(visitados, false);
        Arrays.fill(predecesores, -1);
        distancias[origen] = 0;

        pasos.add("Paso 0: Inicialización");
        pasos.add("  - Distancias: " + Arrays.toString(distancias).replace("2147483647", "∞"));
        pasos.add("  - Visitados: " + Arrays.toString(visitados));
        pasos.add("  - Predecesores: " + Arrays.toString(predecesores));

        // Algoritmo principal
        for (int i = 0; i < numVertices - 1; i++) {
            int verticeActual = obtenerVerticeNoVisitadoConDistanciaMinima();
            if (verticeActual == -1) {
                break; // No hay más vértices alcanzables
            }

            visitados[verticeActual] = true;

            pasos.add("\nPaso " + (i + 1) + ": Seleccionado vértice " + verticeActual);
            pasos.add("  - Vértice " + verticeActual + " marcado como visitado");

            // Actualizar distancias de los vértices adyacentes
            List<Arista> aristasAdyacentes = grafo.getListaAdyacencia().get(verticeActual);
            for (Arista arista : aristasAdyacentes) {
                int verticeDestino = arista.getDestino();

                if (!visitados[verticeDestino]) {
                    int nuevaDistancia = distancias[verticeActual] + arista.getPeso();

                    pasos.add("  - Evaluando arista: " + verticeActual + " -> " + verticeDestino + " (Peso: " + arista.getPeso() + ")");
                    pasos.add("    * Distancia actual a " + verticeDestino + ": " +
                            (distancias[verticeDestino] == Integer.MAX_VALUE ? "∞" : distancias[verticeDestino]));
                    pasos.add("    * Nueva posible distancia: " + distancias[verticeActual] + " + " + arista.getPeso() + " = " + nuevaDistancia);

                    if (nuevaDistancia < distancias[verticeDestino]) {
                        distancias[verticeDestino] = nuevaDistancia;
                        predecesores[verticeDestino] = verticeActual;
                        pasos.add("    * ¡Mejora encontrada! Actualizando distancia a " + verticeDestino + " a " + nuevaDistancia);
                        pasos.add("    * Predecesor de " + verticeDestino + " actualizado a " + verticeActual);
                    } else {
                        pasos.add("    * No se encontró mejora. Manteniendo distancia actual.");
                    }
                }
            }

            pasos.add("  - Después de la iteración " + (i + 1) + ":");
            pasos.add("    * Distancias: " + Arrays.toString(distancias).replace("2147483647", "∞"));
            pasos.add("    * Visitados: " + Arrays.toString(visitados));
            pasos.add("    * Predecesores: " + Arrays.toString(predecesores));
        }

        return distancias;
    }

    /**
     * Método para obtener el vértice no visitado con la distancia mínima
     * @return vértice con la distancia mínima
     */
    private int obtenerVerticeNoVisitadoConDistanciaMinima() {
        int minDistancia = Integer.MAX_VALUE;
        int verticeMinimo = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!visitados[i] && distancias[i] < minDistancia) {
                minDistancia = distancias[i];
                verticeMinimo = i;
            }
        }

        return verticeMinimo;
    }

    /**
     * Método para obtener la ruta desde el origen hasta un destino
     * @param destino vértice de destino
     * @return lista con la ruta
     */
    public List<Integer> obtenerRuta(int destino) {
        List<Integer> ruta = new ArrayList<>();

        if (distancias[destino] == Integer.MAX_VALUE) {
            return ruta; // No hay ruta al destino
        }

        int actual = destino;
        while (actual != -1) {
            ruta.add(0, actual);
            actual = predecesores[actual];
        }

        return ruta;
    }

    /**
     * Método para mostrar los pasos del algoritmo
     */
    public void mostrarPasos() {
        for (String paso : pasos) {
            System.out.println(paso);
        }
    }

    /**
     * Método para mostrar los resultados del algoritmo
     * @param origen vértice de origen
     */
    public void mostrarResultados(int origen) {
        System.out.println("\n=== Resultados finales ===");
        System.out.println("Distancias mínimas desde el vértice " + origen + ":");

        for (int i = 0; i < numVertices; i++) {
            System.out.print("Al vértice " + i + ": ");
            if (distancias[i] == Integer.MAX_VALUE) {
                System.out.println("No alcanzable");
            } else {
                System.out.println(distancias[i]);
                List<Integer> ruta = obtenerRuta(i);
                System.out.println("  Ruta: " + ruta);
            }
        }
    }
}