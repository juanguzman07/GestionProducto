package com.mycompany.GestionProducto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Juan Camilo Campo
 */

   
class Producto {
    private int id;
    private String nombre;
    private double precio;
  

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
         
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
 
    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio ;
    }
}

public class GestionProducto {  //Menu con opciones que hace el programa
    private static List<Producto> productos = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Listar productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Borrar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    double precio = scanner.nextDouble();
                    agregarProducto(nombre, precio);
                    break;
                case 3:
                    System.out.print("ID del producto a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    actualizarProducto(idActualizar, nuevoNombre, nuevoPrecio);
                    break;
                case 4:
                    System.out.print("ID del producto a borrar: ");
                    int idBorrar = scanner.nextInt();
                    borrarProducto(idBorrar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void listarProductos() { //Desde este punto empieza el crud del programa 
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Lista de productos:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public static void agregarProducto(String nombre, double precio) {
        Producto producto = new Producto(nextId, nombre, precio);
        nextId++;
        productos.add(producto);
        System.out.println("Producto agregado con éxito.");
    }

    public static void actualizarProducto(int id, String nuevoNombre, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                System.out.println("Producto actualizado con éxito.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public static void borrarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                System.out.println("Producto borrado con éxito.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
}
