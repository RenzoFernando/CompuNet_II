package org.example.services;

import java.util.ArrayList;

/**
 * Esta es la capa de Servicio (Service Layer).
 * Su responsabilidad es contener la lógica de negocio de la aplicación.
 * Actúa como un intermediario entre la capa de presentación (el Servlet) y la capa de datos (que aquí está simulada).
 *
 * En este ejemplo, la "lógica de negocio" es simplemente añadir y obtener ítems de una lista.
 * En una aplicación real, aquí irían validaciones, cálculos, orquestación de llamadas a repositorios, etc.
 */
public class ShopService {
    // En una aplicación real, esta lista sería reemplazada por una capa de Repositorio
    // que interactuaría con una base de datos.
    // Por ahora, usamos una lista en memoria para mantenerlo simple.
    private ArrayList<String> shoplist = new ArrayList<>();

    /**
     * Añade un nuevo ítem a la lista de compras.
     * @param item El producto a añadir.
     */
    public void addItem(String item) {
        shoplist.add(item);
    }

    /**
     * Devuelve la lista completa de ítems.
     * @return Un ArrayList con todos los ítems de la compra.
     */
    public ArrayList<String> getItems() {
        return shoplist;
    }

}
