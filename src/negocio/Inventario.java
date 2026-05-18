package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private ArrayList<Producto> listaProductos;

    private double presupuestoMaximo;
    private int espacioMaximo;

    public Inventario() {

        listaProductos = new ArrayList<>();

        presupuestoMaximo = 10000;
        espacioMaximo = 500;
    }

    public void registrarProducto() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== REGISTRO PRODUCTO =====");

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Stock: ");
        int stock = sc.nextInt();

        System.out.print("Precio Unitario: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        double valorInventario = stock * precio;

        double sumaInventario = 0;
        int sumaStock = 0;

        for (Producto p : listaProductos) {

            sumaInventario += p.getValorInventario();
            sumaStock += p.getStock();
        }

        // Restricciones
        if ((sumaInventario + valorInventario) > presupuestoMaximo) {

            System.out.println("ERROR: Presupuesto excedido.");
            return;
        }

        if ((sumaStock + stock) > espacioMaximo) {

            System.out.println("ERROR: Espacio insuficiente.");
            return;
        }

        System.out.println("\nTipo de producto:");
        System.out.println("1. Perecedero");
        System.out.println("2. No Perecedero");
        System.out.print("Seleccione: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        Producto nuevo;

        switch (opcion) {

            case 1:

                System.out.print("Fecha de vencimiento (AAAA-MM-DD): ");
                String fechaTexto = sc.nextLine();

                LocalDate fecha = LocalDate.parse(fechaTexto);

                nuevo = new ProductoPerecedero(
                        id,
                        marca,
                        nombre,
                        stock,
                        precio,
                        valorInventario,
                        fecha
                );

                break;

            case 2:

                System.out.print("Material: ");
                String material = sc.nextLine();

                nuevo = new ProductoNoPerecedero(
                        id,
                        marca,
                        nombre,
                        stock,
                        precio,
                        valorInventario,
                        material
                );

                break;

            default:

                System.out.println("Tipo inválido.");
                return;
        }

        nuevo.calcularValorInventario();

        listaProductos.add(nuevo);

        System.out.println("Producto registrado correctamente.");
    }

    public void mostrarInventario() {

        if (listaProductos.isEmpty()) {

            System.out.println("Inventario vacío.");
            return;
        }

        System.out.println("\n===== INVENTARIO =====");

        for (Producto p : listaProductos) {

            System.out.println("ID: " + p.getId());
            System.out.println("Marca: " + p.getMarca());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Stock: " + p.getStock());
            System.out.println("Precio Unitario: " + p.getPrecioUnitario());
            System.out.println("Valor Inventario: " + p.getValorInventario());

            System.out.println("--------------------------");
        }
    }
}
