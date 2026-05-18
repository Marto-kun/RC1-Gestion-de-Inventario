package interfaz;

import modelo.Producto;
import modelo.ProductoNoPerecedero;
import modelo.ProductoPerecedero;
import negocio.Inventario;

import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {

    private Inventario inventario;
    private Scanner sc;

    //Constructor
    public Sistema() {
        inventario = new Inventario();
        sc = new Scanner(System.in);
    }

    //Metodo principal
    public void ejecutarSistema() {

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Registrar producto perecedero");
            System.out.println("2. Registrar producto no perecedero");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.println("Ingrese una opcion valida");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarPerecedero();
                    break;

                case 2:
                    registrarNoPerecedero();
                    break;

                case 3:
                    mostrarProductos();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);
    }

    //Registrar producto perecedero
    public void registrarPerecedero() {

        System.out.println("\n--- PRODUCTO PERECEDERO ---");

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int stock;

        while (true) {

            System.out.print("Stock: ");

            if (sc.hasNextInt()) {

                stock = sc.nextInt();

                if (stock > 0) {
                    break;
                } else {
                    System.out.println("El stock debe ser mayor a 0");
                }

            } else {

                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }

        double precio;

        while (true) {

            System.out.print("Precio unitario: ");

            if (sc.hasNextDouble()) {

                precio = sc.nextDouble();

                if (precio > 0) {
                    break;
                } else {
                    System.out.println("El precio debe ser mayor a 0");
                }

            } else {

                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }

        int anio;
        int mes;
        int dia;

        while (true) {

            System.out.print("Anio de vencimiento: ");

            if (sc.hasNextInt()) {
                anio = sc.nextInt();
                break;
            } else {
                System.out.println("Ingrese un anio valido");
                sc.next();
            }
        }

        while (true) {

            System.out.print("Mes de vencimiento: ");

            if (sc.hasNextInt()) {

                mes = sc.nextInt();

                if (mes >= 1 && mes <= 12) {
                    break;
                } else {
                    System.out.println("Ingrese un mes entre 1 y 12");
                }

            } else {
                System.out.println("Ingrese un mes valido");
                sc.next();
            }
        }

        while (true) {

            System.out.print("Dia de vencimiento: ");

            if (sc.hasNextInt()) {

                dia = sc.nextInt();

                if (dia >= 1 && dia <= 31) {
                    break;
                } else {
                    System.out.println("Ingrese un dia valido");
                }

            } else {
                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }

        sc.nextLine();

        if (inventario.verificacionRestricciones(stock, precio)) {

            LocalDate fecha = LocalDate.of(anio, mes, dia);

            ProductoPerecedero producto =
                    new ProductoPerecedero(id, marca, nombre,
                            stock, precio, fecha);

            inventario.registrarProducto(producto);

            System.out.println("Producto perecedero registrado");
        }
    }

    //Registrar producto no perecedero
    public void registrarNoPerecedero() {

        System.out.println("\n--- PRODUCTO NO PERECEDERO ---");

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int stock;

        while (true) {

            System.out.print("Stock: ");

            if (sc.hasNextInt()) {

                stock = sc.nextInt();

                if (stock > 0) {
                    break;
                } else {
                    System.out.println("El stock debe ser mayor a 0");
                }

            } else {

                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }

        double precio;

        while (true) {

            System.out.print("Precio unitario: ");

            if (sc.hasNextDouble()) {

                precio = sc.nextDouble();

                if (precio > 0) {
                    break;
                } else {
                    System.out.println("El precio debe ser mayor a 0");
                }

            } else {

                System.out.println("Ingrese un numero valido");
                sc.next();
            }
        }

        sc.nextLine();

        System.out.print("Material: ");
        String material = sc.nextLine();

        if (inventario.verificacionRestricciones(stock, precio)) {

            ProductoNoPerecedero producto =
                    new ProductoNoPerecedero(id, marca, nombre,
                            stock, precio, material);

            inventario.registrarProducto(producto);

            System.out.println("Producto no perecedero registrado");
        }
    }

    //Mostrar productos
    public void mostrarProductos() {

        System.out.println("\n===== LISTA DE PRODUCTOS =====");

        if (inventario.getListaProductos().isEmpty()) {

            System.out.println("No existen productos registrados");
            return;
        }

        for (Producto producto : inventario.getListaProductos()) {

            System.out.println("---------------------------");
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Precio: " + producto.getPrecioUnitario());
            System.out.println("Valor Inventario: " + producto.getValorInventario());
        }
    }
}
