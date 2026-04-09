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
        
    //Filtramos la lista de animales para obtener solo los que están "Disponible"
    List<String> disponibles = animales.stream()
            .filter(a -> estadoAnimal.get(a).equals("Disponible")) // estado del animal
            .collect(Collectors.toList()); // convertimos el Stream en una lista

    // Si no hay animales disponibles, mostramos mensaje y salimos del método
    if (disponibles.isEmpty()) {
        System.out.println("No hay disponibles.");
        return;
    }

    // Mostramos los animales disponibles numerados para que el usuario elija
    System.out.println("Animales disponibles:");

    for (int i = 0; i < disponibles.size(); i++) {
        System.out.println((i + 1) + ". " + disponibles.get(i));
    }

    // Pedimos al usuario que seleccione un animal por número
    System.out.print("Seleccione: ");

    int op;

    try {
        // Convertimos la entrada del usuario a número entero
        op = Integer.parseInt(sc.nextLine());

        // Validamos que la opción esté dentro del rango de la lista
        if (op < 1 || op > disponibles.size()) {
            System.out.println("Opción inválida.");
            return;
        }

    } catch (Exception e) {
        // Si el usuario no escribe un número válido
        System.out.println("Debe ingresar número.");
        return;
    }

    // Obtenemos el animal seleccionado según la posición elegida
    String seleccionado = disponibles.get(op - 1);

    // Cambiamos el estado del animal a "Adoptado"
    estadoAnimal.put(seleccionado, estados[1]);

    // Confirmamos la adopción
    System.out.println("✔ " + seleccionado + " adoptado.");
}

    public static void mostrarAnimalesDisponibles() {

    }

    public static void mostrarAnimalesAdoptados() {

    }

    public static void reporteGeneral() {
    }
}
