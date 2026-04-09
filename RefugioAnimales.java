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