/*
Es como abrir una caja de herramientas completa.
El * significa "trae todo lo que hay dentro de java.util",
que incluye listas, mapas, conjuntos, el scanner, etc.
Sin esto, Java no sabría qué es un ArrayList o un Scanner.
*/
import java.util.*;
/*
Es el contenedor principal del programa.
En Java, todo el código vive dentro de una clase.
public significa que cualquier parte del programa puede verla.
El nombre RefugioAnimales es simplemente cómo la identificamos.
*/

// se inicializa la clase principal del programa

public class RefugioAnimales {

    // ---------------------------------------------------------
    // Scanner global para todo el programa
    // static define que una clase o metodo pertenece
    // a la clase en general, no a un objeto en particular
    // Una buena forma de entenderlo es si la clase
    // de RefugioAnimales fuera una receta, static, seria
    // un ingrediente que comparten todas las versiones receta

    // ------------------------------------------------------------------------
    /*
    * Oido del programa, Le permite leer las instrucciones del usuario
    * System.in es la entrada estandar (el teclado), se declara como static
    * para que todos puedan usarlo sin tener que repetirlo en diferentes
    * partes del codigo
    * */

    static Scanner sc = new Scanner(System.in);


    // ------------------------------------------------------------------------
    // 1️⃣ Lista de animales
    static List<String> animales = new ArrayList<>();
    // -------------------------------------------------------------------------

    // 2️⃣ Estado del animala
    // Un diccionario que usa llave y valor, una llave nos indicara un valor
    // La clave en este caso es un String, que nos indica el nombre del animal,
    // Y su valor es su estado, que es otro String, que puede ser "Disponible" o "Adoptado"

    static Map<String, String> estadoAnimal = new HashMap<>();

    // -------------------------------------------------------------------------

    // 3️⃣ Set de especies
    // Un conjunto que no permite repeticion de valores, es decir, si ingresamos
    // una especie (nombre de variable), de nombre dorado, no podemos volver a
    // engresar la misma variable
    // variable en cuestior -->  Set<String> especies = new HashSet<>();
    // tiene un inicializador de clase -> new, y se contruye un HashSet,
    // que es una implementacion de Set

    static Set<String> especies = new HashSet<>();

    // -----------------------------------------------------------------------------
    // 4️⃣ Relación animal → especie
    // Otro diccionario que guarda a qué especie pertenece cada animal.
    // Ejemplo: "Luna" → "perro".
    static Map<String, String> animalEspecie = new HashMap<>();

    // -------------------------------------------------------------------------------
    // 5️⃣ Array de estados
    // Un arreglo fijo con exactamente dos opciones de estado.
    // Se usa estados[0] para "Disponible" y estados[1] para "Adoptado".
    // Centralizar estos valores evita errores de escritura en el resto del código.

    static String[] estados = {"Disponible", "Adoptado"};

    //----------------------------------------------------------------------------------
    // Puerta de entrada al programa, Java Busca este codigo, para saber donde empezar
    // Siempre mantiene esta forma, se puede usar psvm+enter, y lo puedes escribir
    // automaticamente
    public static void main(String[] args) {

        // ------------------------------------------------------------------------
        // inicializacion de una variable dentro de esta funcion
        // esta variable solo es accesible estando dentro de esto trozo de codigo
        // una funcion externa no puede accedr a ella.
        int opcion = 0;

        // ------------------------------------------------------------------------
        // Se llama do-while y es una estructura de control de repetición
        // El do solo no significa nada por sí mismo. Siempre va acompañado del while al final,
        // por eso su nombre completo es do-while. Son una unidad inseparable.
        //
        // funcion dentro del programa main, esto es un ciclo que se repite
        // hasta que el usuario elija salir (opcion 7).
        // solo se inicializa una vez, y se actualiza cada vez que el
        // usuario ingresa una nueva opcion
        // solo dentro de main, no es accesible por fuera.

        //
        do {
            // Metodo definido por nosotro
            // es un metodo que trae un menu, solo imprime texto, es inicializado
            // dentro de la funcion de main, que es la ejecucion del programa
            mostrarMenu();
            //----------------------------------------------------------------
            // una variblo que almacena el resultado de una funcion, donde se recibe un
            // parametro (texto);
            opcion = leerEntero("Seleccione una opción: ");

            // ----------------------------------------------------------------------
            // switch = estructura de selección múltiple. () contiene variable evaluada.
            // switch es una estructura de control
            // Es un distribuidor de decisiones.
            // Según el número que eligió el usuario,
            // ejecuta el método correspondiente.
            //  Es más limpio que escribir muchos if/else seguidos.
            //  La flecha -> es una sintaxis moderna de Java que hace el código más corto.

            switch (opcion) {
                // case indica que accion tomar segun el dato
                // contenido dentro de la varible OPCION
                case 1 -> registrarAnimal();
                case 2 -> registrarEspecie();
                case 3 -> marcarAdoptado();
                case 4 -> mostrarDisponibles();
                case 5 -> mostrarAnimalesAdoptados();
                case 6 -> reporteGeneral();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println(" Opción inválida");
            }
        // while correspondiente al DO, do-while van siempre juntos
        // y el while debe tener una condicion especifica que cumplir
        // para ver si se sigue iterando el do previo
        } while (opcion != 7);
        sc.close();
    }

    // =========================
    // MENÚ
    // =========================
    // funcion que imprime valores
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
    // funcion para el registro de animales
    public static void registrarAnimal() {
        // primero otorgamos una instruccion al usuario
        System.out.print("Ingrese el nombre del animal: ");
        // usamos una de las variables declaradas fuera de main (ejecucion del programa)
        // para poder almacemar la informacion que el usuario tipee, al
        // llamar esta funcion
        // al escribir sc, llamamos al scanner inicializado en un variable previa mente
        // con nextLine(), que es una funcion de la clase Scanner,
        //      leemos la linea completa que el usuario ingresa, y la guardamos.
        // con .trim() eliminamos los espacios en blanco al inicio, y al final del texto
        //    Esto es importante para evitar errores de registro, por ejemplo,
        //    si el usuario ingresa " Luna " con espacios, se guardaría como " Luna ", y
        //    luego si intenta registrar "Luna" sin espacios, el programa no lo reconocería como el mismo animal.
        //    Al usar .trim(), ambos casos se guardarán como "Luna", evitando confusiones.
        String nombre = sc.nextLine().trim();

        // VALIDAMOS SI LA VARIABLE INGRESADA ESTA DENTRO DE NUESTRA VARIABLE DE ANIMALES,
        // SI ES ASI, SE LE INFORMA AL USUARIO Y SE TERMINA LA FUNCION
        if (animales.contains(nombre)) {
            System.out.println("Este animal ya está registrado.");
            return;
        }

        // VALIDAMOS SI HAY ESPECIES REGISTRADAS ANTES DE PERMITIR REGISTRAR UN ANIMAL,
        // SI NO HAY ESPECIES, SE LE INFORMA AL USUARIO Y SE TERMINA LA FUNCION.
        if (especies.isEmpty()) {
            System.out.println("No hay especies registradas. Registre una primero.");
            return;
        }
        // Si niguna validacion termino el funcionamiento del programa SEGUIMOS AQUI
        // le indicamos al usuario las especies disponibles
        // y ademas le indicamos que debe ingresar una de las especies disponibles
        // mostradas por pantalla.
        System.out.println("Especies disponibles: " + especies);
        System.out.print("Ingrese la especie del animal: ");

        // almacenamos la informacion entregada por el usuario en una variable llamada especie
        String especie = sc.nextLine().trim();

        // validamos si la especie existe dentro de nustra variable especies
        // traduccion: si la variable especies no contiene la variable especie, entonces se le informa
        // al usuario que la especie no es valida, y se termina la funcion
        if (!especies.contains(especie)) {
            System.out.println("Especie no válida.");
            return;
        }

        // una vez listas las variables, se agrega de manera correspondiente segun cada caso
        // nombre se guarda en animales
        // especie se guarda en animalEspecie, con el nombre del animal como clave, y la especie como valor
        // estadoAnimal se actualiza con el nombre del animal como clave, y "Disponible" como valor,
        // usando el arreglo de estados para evitar errores de escritura
        animales.add(nombre);
        animalEspecie.put(nombre, especie);
        estadoAnimal.put(nombre, estados[0]); // "Disponible" por defecto

        System.out.println("Animal registrado exitosamente: " + nombre + " (" + especie + ")");
    }


    //PARTE 2 NATALIA REGISTRAR ESPECIE
    public static void registrarEspecie() {
        // Informacion para dar instruccion al usuario sobre lo que debe hacer
        System.out.print("Ingrese el nombre de la especie: ");
        // se define varible especie, para recibir el valor entregado por el usuario
        // lo importante es que al llamar al scanner para ingresar valores usamos
        // nextLine() para leer la linea completa, y no solo la primera palabra,
        // y ademas usamos .toLowerCase() para convertir todo a minuscula,
        //  y .trim() para eliminar espacios al inicio y al final del texto,
        //  esto es importante para evitar errores de registro, por ejemplo,
        //  si el usuario ingresa " Perro " con espacios y mayusculas,
        //  se guardaría como " Perro ", y luego si intenta registrar "perro"
        //  sin espacios y en minuscula, el programa no lo reconocería como la misma especie.
        //  Al usar .toLowerCase() y .trim() ambos casos se guardarán como "perro", evitando
        //  confusiones.
        String especie = sc.nextLine().toLowerCase().trim();

        // especies.add(especies) -> intenta agregar la especie al conjunto de especies,
        // si la especie ya existe, no se agrega y retorna false
        //
        boolean agregado = especies.add(especie);

        // validacion de si especi
        if (agregado) {
            System.out.println("Especie registrada correctamente.");
        } else {
            System.out.println("La especie ya existe.");
        }
    }

    // ============================================================
    // 3. MARCAR ANIMAL COMO ADOPTADO (RINA)
    // ============================================================
    static void marcarAdoptado() {
        // se define variable para mostrar titulo de la seccion
        // Filtra los animales que están disponibles
        List<String> disponibles = animales.stream()
                .filter(a -> estadoAnimal.get(a).equals("Disponible"))
                .toList();

        // Si no hay animales disponibles, se muestra mensaje y se termina
        if (disponibles.isEmpty()) {
            System.out.println("No hay animales disponibles para adopción.");
            return;
        }

        // Muestra los animales disponibles con número
        System.out.println("Animales disponibles:");

        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i));
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

    // =========================
    // OPCIÓN 4
    // =========================
    public static void mostrarDisponibles() {

        System.out.println("\n--- Animales Disponibles ---"); // Título de la sección

        boolean encontrado = false; // Indica ui se encontró al menos un animal

        for (String animal : animales) { // Recorre todos los animales
            if (estadoAnimal.get(animal).equals("Disponible")) { // Verifica si está disponible
                System.out.println("- " + animal + " (" + animalEspecie.get(animal) + ")"); // Muestra nombre y especie
                encontrado = true; // Marca que sí hay resultados
            }
        }

        if (!encontrado) { // Si no se encontró ninguno
            System.out.println("⚠️ No hay animales disponibles."); // Mensaje de aviso
        }
    }

    public static void mostrarAnimalesAdoptados() {
        System.out.println("\n--- Animales Adoptados ---"); // Título de la sección

        boolean encontrado = false; // Indica si se encontró al menos un animal

        for (String animal : animales) { // Recorre todos los animales
            if (estadoAnimal.get(animal).equals("Adoptado")) { // Verifica si está adoptado
                System.out.println("- " + animal + " (" + animalEspecie.get(animal) + ")"); // Muestra nombre y especie
                encontrado = true; // Marca que sí hay resultados
            }
        }

        if (!encontrado) { // Si no se encontró ninguno
            System.out.println("⚠️ No hay animales adoptados."); // Mensaje de aviso
        }
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

        int totalDisponibles = (int) estadoAnimal.values().stream()
                .filter(estado -> estado.equals(estados[0])) // Filtra por "Disponible"
                .count(); // Cuenta los resultados

        int totalAdoptados = (int) estadoAnimal.values().stream()
                .filter(estado -> estado.equals(estados[1])) // Filtra por "Adoptado"
                .count(); // Cuenta los resultados

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

    public static int leerEntero(String mensaje) {
        int numero;

        while (true) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(sc.nextLine());
                return numero;
            } catch (Exception e) {
                System.out.println(" Debes ingresar un número válido.");
            }
        }
    }
}