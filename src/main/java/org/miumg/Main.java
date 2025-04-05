package org.miumg;


import java.util.List;

public class Main {
    public static void main(String[] args) {
// Ejemplo práctico: Representar departamentos y conexiones entre ellos
        String[] departamentos = {
                "Guatemala", "Sacatepéquez", "Chimaltenango", "Escuintla", "Quetzaltenango",
                "Huehuetenango", "Alta Verapaz", "Baja Verapaz", "Chiquimula", "El Progreso",
                "Izabal", "Jalapa", "Jutiapa", "Petén", "Quiché",
                "Retalhuleu", "San Marcos", "Santa Rosa", "Sololá", "Suchitepéquez",
                "Totonicapán", "Zacapa"
        };
        int numDepartamentos = departamentos.length;

        System.out.println("=== Ejemplo de Algoritmo de Dijkstra ===");
        System.out.println("Departamentos representados por índices:");
        for (int i = 0; i < numDepartamentos; i++) {
            System.out.println(i + ": " + departamentos[i]);
        }

// Crear el grafo
        Grafo grafo = new Grafo(numDepartamentos);

// Agregar conexiones (aristas con pesos en kilómetros)
// Guatemala (0) conexiones
        grafo.agregarArista(0, 1, 30);  // Guatemala -> Sacatepéquez
        grafo.agregarArista(0, 2, 55);  // Guatemala -> Chimaltenango
        grafo.agregarArista(0, 3, 75);  // Guatemala -> Escuintla
        grafo.agregarArista(0, 4, 200); // Guatemala -> Quetzaltenango
        grafo.agregarArista(0, 5, 260); // Guatemala -> Huehuetenango

// Sacatepéquez (1) conexiones
        grafo.agregarArista(1, 6, 90);  // Sacatepéquez -> Alta Verapaz
        grafo.agregarArista(1, 7, 100); // Sacatepéquez -> Baja Verapaz

// Chimaltenango (2) conexiones
        grafo.agregarArista(2, 8, 120); // Chimaltenango -> Chiquimula
        grafo.agregarArista(2, 9, 130); // Chimaltenango -> El Progreso

// Escuintla (3) conexiones
        grafo.agregarArista(3, 10, 140); // Escuintla -> Izabal
        grafo.agregarArista(3, 11, 150); // Escuintla -> Jalapa

// Quetzaltenango (4) conexiones
        grafo.agregarArista(4, 12, 160); // Quetzaltenango -> Jutiapa
        grafo.agregarArista(4, 13, 170); // Quetzaltenango -> Petén

// Huehuetenango (5) conexiones
        grafo.agregarArista(5, 14, 180); // Huehuetenango -> Quiché
        grafo.agregarArista(5, 15, 190); // Huehuetenango -> Retalhuleu

// Alta Verapaz (6) conexiones
        grafo.agregarArista(6, 16, 200); // Alta Verapaz -> San Marcos
        grafo.agregarArista(6, 17, 210); // Alta Verapaz -> Santa Rosa

// Baja Verapaz (7) conexiones
        grafo.agregarArista(7, 18, 220); // Baja Verapaz -> Sololá
        grafo.agregarArista(7, 19, 230); // Baja Verapaz -> Suchitepéquez

// Chiquimula (8) conexiones
        grafo.agregarArista(8, 20, 240); // Chiquimula -> Totonicapán
        grafo.agregarArista(8, 21, 250); // Chiquimula -> Zacapa

// Izabal (10) conexiones
        grafo.agregarArista(10, 13, 280); // Izabal -> Petén
        grafo.agregarArista(10, 21, 150); // Izabal -> Zacapa

// Jalapa (11) conexiones
        grafo.agregarArista(11, 12, 50);  // Jalapa -> Jutiapa
        grafo.agregarArista(11, 21, 80);  // Jalapa -> Zacapa

// Jutiapa (12) conexiones
        grafo.agregarArista(12, 17, 100); // Jutiapa -> Santa Rosa
        grafo.agregarArista(12, 11, 50);  // Jutiapa -> Jalapa

// Petén (13) conexiones
        grafo.agregarArista(13, 10, 280); // Petén -> Izabal
        grafo.agregarArista(13, 14, 200); // Petén -> Quiché

// Quiché (14) conexiones
        grafo.agregarArista(14, 13, 200); // Quiché -> Petén
        grafo.agregarArista(14, 5, 180);  // Quiché -> Huehuetenango

// Retalhuleu (15) conexiones
        grafo.agregarArista(15, 19, 60);  // Retalhuleu -> Suchitepéquez
        grafo.agregarArista(15, 16, 70);  // Retalhuleu -> San Marcos

// San Marcos (16) conexiones
        grafo.agregarArista(16, 15, 70);  // San Marcos -> Retalhuleu
        grafo.agregarArista(16, 4, 50);   // San Marcos -> Quetzaltenango

// Santa Rosa (17) conexiones
        grafo.agregarArista(17, 12, 100); // Santa Rosa -> Jutiapa
        grafo.agregarArista(17, 3, 80);   // Santa Rosa -> Escuintla

// Sololá (18) conexiones
        grafo.agregarArista(18, 2, 40);   // Sololá -> Chimaltenango
        grafo.agregarArista(18, 19, 50);  // Sololá -> Suchitepéquez

// Suchitepéquez (19) conexiones
        grafo.agregarArista(19, 15, 60);  // Suchitepéquez -> Retalhuleu
        grafo.agregarArista(19, 18, 50);  // Suchitepéquez -> Sololá

// Totonicapán (20) conexiones
        grafo.agregarArista(20, 4, 30);   // Totonicapán -> Quetzaltenango
        grafo.agregarArista(20, 14, 70);  // Totonicapán -> Quiché

// Zacapa (21) conexiones
        grafo.agregarArista(21, 10, 150); // Zacapa -> Izabal
        grafo.agregarArista(21, 11, 80);  // Zacapa -> Jalapa

// Crear instancia del algoritmo
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo);

// Ejecutar el algoritmo desde Jutiapa (índice 12) a Petén (índice 13)
        int departamentoOrigen = 12; // Jutiapa
        int departamentoDestino = 13; // Petén

        System.out.println("\n=== Buscando la ruta más corta de " + departamentos[departamentoOrigen] +
                " a " + departamentos[departamentoDestino] + " ===");

        dijkstra.encontrarCaminosMinimos(grafo, departamentoOrigen);

        // Mostrar los pasos del algoritmo
        System.out.println("\n=== Ejecución paso a paso del algoritmo ===");
        dijkstra.mostrarPasos();

        // Mostrar la ruta específica
        List<Integer> ruta = dijkstra.obtenerRuta(departamentoDestino);
        System.out.println("\n=== Ruta más corta encontrada ===");
        System.out.println("Distancia total: " + dijkstra.distancias[departamentoDestino] + " kilómetros");
        System.out.print("Ruta: ");
        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(departamentos[ruta.get(i)]);
            if (i < ruta.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}