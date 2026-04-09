import java.util.*;

public class RefugioAnimales {

    static Map<String, String> registroAdopciones = new HashMap<>();
    public static void main(String[] args) {

        int opcion;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("===BIENVENIDO AL REFUGIO===");
            System.out.println("1. Registrar Animal");
            System.out.println("2. Registrar Especie");
            System.out.println("3. Marcar Animal como Adoptado");
            System.out.println("4. Mostrar Animales Disponibles");
            System.out.println("5. Mostrar Animales Adoptados");
            System.out.println("6. Mostrar Reporte General");
            System.out.println("0. Salir");

            switch (opcion) {
                case 1 -> {
                }

                case 2 -> {
                }

                case 3 -> {

                }

                case 4 ->{

                }

                case 5 ->{

                }

                case 6 ->{

                }

                case 7 -> {

                }
                default ->
                        System.out.println("Opcion no valida");

            }
        }while(true);

    }

    public static void registrarAnimal() {

    }

    public static void registrarEspecie() {

    }

    public static void marcarComoAdoptado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre del animal: ");
        String animal = scanner.nextLine();
        System.out.print("Ingrese nombre del adoptante: ");
        String adoptante = scanner.nextLine();

        registroAdopciones.put(animal, adoptante);
        System.out.println("¡Registro de adopción exitoso!");
    }

    public static void mostrarAnimalesDisponibles() {

    }

    public static void mostrarAnimalesAdoptados() {
        System.out.println("\n--- LISTA DE ANIMALES ADOPTADOS ---");
        
        if (registroAdopciones.isEmpty()) {
            System.out.println("No hay adopciones registradas todavía.");
        } else {
            // Usamos un EntrySet para mostrar Clave y Valor
            for (Map.Entry<String, String> entry : registroAdopciones.entrySet()) {
                System.out.println("Animal: " + entry.getKey() + " | Adoptado por: " + entry.getValue());
            }
        }
    
    }

    public static void reporteGeneral() {
    }
}