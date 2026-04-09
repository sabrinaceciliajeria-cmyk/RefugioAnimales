import java.util.*;

public class ChallengerRefugioAnimalesClaud {

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

    }

    public static void reporteGeneral() {
    }
}
