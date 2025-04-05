package org.miumg;


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

// Continue adding connections for other departments as needed

// Crear instancia del algoritmo
        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra(grafo);

// Ejecutar el algoritmo desde Guatemala (índice 0)
        int departamentoOrigen = 0;
        dijkstra.encontrarCaminosMinimos(grafo, departamentoOrigen);

// Mostrar los pasos del algoritmo
        System.out.println("\n=== Ejecución paso a paso del algoritmo ===");
        dijkstra.mostrarPasos();

// Mostrar los resultados
        dijkstra.mostrarResultados(departamentoOrigen);
    }
}