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
    System.out.print("Ingrese el nombre del animal: ");
    String nombre = sc.nextLine().trim();

    if (animales.contains(nombre)) {
        System.out.println("Este animal ya está registrado.");
        return;
    }

    if (especies.isEmpty()) {
        System.out.println("No hay especies registradas. Registre una primero.");
        return;
    }

    System.out.println("Especies disponibles: " + especies);
    System.out.print("Ingrese la especie del animal: ");
    String especie = sc.nextLine().trim();

    if (!especies.contains(especie)) {
        System.out.println("Especie no válida.");
        return;
    }

    animales.add(nombre);
    animalEspecie.put(nombre, especie);
    estadoAnimal.put(nombre, estados[0]); // "Disponible" por defecto

    System.out.println("Animal registrado exitosamente: " + nombre + " (" + especie + ")");
}

public static void registrarEspecie() {

}

// ============================================================
// 3. MARCAR ANIMAL COMO ADOPTADO (RINA)
// ============================================================
static void marcarAdoptado() {

    // Filtra los animales que están disponibles
    List<String> disponibles = animales.stream()
            .filter(a -> estadoAnimal.get(a).equals("Disponible"))
            .collect(Collectors.toList());

    // Si no hay animales disponibles, se muestra mensaje y se termina
    if (disponibles.isEmpty()) {
        System.out.println("No hay animales disponibles para adopción.");
        return;
    }

    // Muestra los animales disponibles con número
    System.out.println("Animales disponibles:");

    for (int i = 0; i < disponibles.size(); i++) {
        System.out.println((i + 1) + ". " + disponibles.get(i));
    
///Marcar animal como adoptado (Rina)//
}

    // Solicita selección del usuario
    System.out.print("Seleccione un animal: ");

    int opcion;

    try {
        // Convierte entrada a número
        opcion = Integer.parseInt(sc.nextLine());

        // Valida rango de selección
        if (opcion < 1 || opcion > disponibles.size()) {
            System.out.println("❌ Opción inválida.");
            return;
        }

    } catch (Exception e) {
        // ❌ Manejo de error si no es número
        System.out.println("❌ Debe ingresar un número válido.");
        return;
    }

    //Obtiene el animal seleccionado
    String seleccionado = disponibles.get(opcion - 1);

    //Cambia estado a "Adoptado"
    estadoAnimal.put(seleccionado, "Adoptado");

    //Confirmación
    System.out.println("✔ El animal ha sido adoptado: " + seleccionado);
}

/================================================================//
    public static void mostrarAnimalesAdoptados() {

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
