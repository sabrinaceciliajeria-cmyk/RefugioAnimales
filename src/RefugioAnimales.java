import java.util.*;

public class RefugioAnimales{

    // Scanner global para todo el programa
    static Scanner sc = new Scanner(System.in);

    // 1️⃣ Lista de animales
    static List<String> animales = new ArrayList<>();

    // 2️⃣ Estado del animal
    static Map<String, String> estadoAnimal = new HashMap<>();

    // 3️⃣ Set de especies
    static Set<String> especies = new HashSet<>();

    // 4️⃣ Relación animal → especie
    static Map<String, String> animalEspecie = new HashMap<>();

    // 5️⃣ Array de estados
    static String[] estados = {"Disponible", "Adoptado"};

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    registrarAnimal();
                }

                case 2 ->{
                    registrarEspecie();
                }
                case 3 ->{
                    adoptarAnimal();
                }
                case 4 -> {
                    mostrarDisponibles();
                }
                case 5 -> {
                    mostrarAdoptados();
                }
                case 6 -> {
                    mostrarReporte();
                }
                case 7 -> {
                    System.out.println("Saliendo del sistema...");
                }
                default -> {
                    System.out.println(" Opción inválida");
                }
            }

        } while (opcion != 7);
    }

    // =========================
    // MENÚ
    // =========================
    public static void mostrarMenu() {
        System.out.println("\n=== REFUGIO DE ANIMALES ===");
        System.out.println("1. Registrar animal");
        System.out.println("2. Registrar especie");
        System.out.println("3. Marcar animal como adoptado");
        System.out.println("4. Mostrar animales disponibles");
        System.out.println("5. Mostrar animales adoptados");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir");
    }


}

public static void registrarAnimal() {

}

public static void registrarEspecie() {

}

public static void marcarComoAdoptado() {
}

public static void mostrarAnimalesDisponibles() {

}

public static void mostrarAnimalesAdoptados() {
    int TotalDeAnimales = animales.size();

    return;
    System.out.println("");

}

public static void reporteGeneral() {

    System.out.println("\n=== REPORTE GENERAL ===");

    // 1. Verificar si hay animales registrados antes de hacer cálculos
    if (animales.isEmpty()) {
        System.out.println("Aún no hay animales registrados en el refugio.");
        return;
    }

    // 2. Calcular los totales usando
    int totalAnimales = animales.size(); // Total de animales

    int totalDisponibles = estadoAnimal.values().stream()
            .filter(estado -> estado.equals(estados[0])) // Filtra por "Disponible"
            .count(); // Cuenta los resultados

    int totalAdoptados = estadoAnimal.values().stream()
            .filter(estado -> estado.equals(estados[1])) // Filtra por "Adoptado"
    // count(); // Cuenta los resultados

    // 3. Mostrar la sección de totales
    System.out.println("Total de animales: " + totalAnimales);
    System.out.println("Total disponibles: " + totalDisponibles);
    System.out.println("Total adoptados: " + totalAdoptados);

    // 4. Mostrar el listado con formato de tabla
    System.out.println("\nListado de animales:");
    // Uso de printf para mantener las columnas alineadas a 15 caracteres
    System.out.printf("%-15s | %-15s | %-15s%n", "Nombre", "Especie", "Estado");
    System.out.println("==================================================");

    // Iterar sobre la lista de animales para asegurar el orden de registro
    for (String animal : animales) {
        String especie = animalEspecie.get(animal);
        String estado = estadoAnimal.get(animal);

        // Imprimir cada fila respetando el mismo espaciado de la cabecera
        System.out.printf("%-15s | %-15s | %-15s%n", animal, especie, estado);
    }
}
    }
}
