import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private ArrayList<Producto> listaProductos;
    private double presupuestoMaximo;
    private int espacioMaximo;

    public Inventario() {

        listaProductos = new ArrayList<>();

        presupuestoMaximo = 1000;
        espacioMaximo = 100;
    }

    public void registrarProducto() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese costo unitario: ");
        double costo = sc.nextDouble();

        System.out.print("Ingrese cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese fecha de ingreso: ");
        String fecha = sc.nextLine();

        double costoTotal = costo * cantidad;

        double sumaCostos = 0;
        int sumaCantidad = 0;

        for (Producto p : listaProductos) {

            sumaCostos += p.getCostoTotal();
            sumaCantidad += p.getCantidad();
        }

        if ((sumaCostos + costoTotal) > presupuestoMaximo) {

            System.out.println("ERROR: Presupuesto excedido.");

        } else if ((sumaCantidad + cantidad) > espacioMaximo) {

            System.out.println("ERROR: Espacio insuficiente.");

        } else {

            Producto nuevo = new Producto(nombre, costo, cantidad, fecha);

            listaProductos.add(nuevo);

            System.out.println("Producto registrado correctamente.");
        }
    }

    public void mostrarInventario() {

        if (listaProductos.isEmpty()) {

            System.out.println("Inventario vacio.");

        } else {

            for (Producto p : listaProductos) {

                p.mostrarProducto();
                System.out.println("------------------");
            }
        }
    }
}
