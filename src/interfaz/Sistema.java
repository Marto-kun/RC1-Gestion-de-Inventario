package interfaz;

//Importacion de clases necesarias
import modelo.Producto;
import modelo.ProductoNoPerecedero;
import modelo.ProductoPerecedero;
import negocio.Inventario;

import java.time.LocalDate;
import java.util.Scanner;

//Clase principal del sistema
public class Sistema {

    //Objeto inventario para almacenar productos
    private Inventario inventario;

    //Objeto Scanner para leer datos del teclado
    private Scanner sc;

    //Constructor de la clase
    public Sistema() {

        //Inicializacion del inventario
        inventario = new Inventario();

        //Inicializacion del Scanner
        sc = new Scanner(System.in);
    }

    //Metodo principal del sistema
    public void ejecutarSistema() {

        //Variable para guardar opcion del menu
        int opcion;

        //Ciclo principal del sistema
        do {

            //Menu
            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Registrar producto perecedero");
            System.out.println("2. Registrar producto no perecedero");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");

            //Validacion de opcion
            while (!sc.hasNextInt()) {

                System.out.println("Ingrese una opcion valida");
                sc.next();
            }

            //Guardar opcion
            opcion = sc.nextInt();

            //Limpiar buffer
            sc.nextLine();

            //Estructura de opciones
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

    //Metodo para verificar si el ID ya existe
    public boolean idExiste(String id) {

        for (Producto producto : inventario.getListaProductos()) {

            if (producto.getId().equalsIgnoreCase(id)) {

                return true;
            }
        }

        return false;
    }

    //Metodo para registrar productos perecederos
    public void registrarPerecedero() {

        System.out.println("\n--- PRODUCTO PERECEDERO ---");

        //Ingreso y validacion de ID
        String id;

        while (true) {

            System.out.print("ID: ");
            id = sc.nextLine();

            if (idExiste(id)) {

                System.out.println("El ID ya existe");

            } else {

                break;
            }
        }

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        //Variable stock
        int stock;

        //Validacion de stock
        while (true) {

            System.out.print("Stock: ");

            if (sc.hasNextInt()) {

                stock = sc.nextInt();

                //El stock debe ser mayor a 0
                if (stock > 0) {

                    break;

                } else {

                    System.out.println("El stock debe ser mayor a 0");
                }

            } else {

                System.out.println("No se permiten letras, ingrese un numero");
                sc.next();
            }
        }

        //Variable precio
        double precio;

        //Validacion de precio
        while (true) {

            System.out.print("Precio unitario: ");

            if (sc.hasNextDouble()) {

                precio = sc.nextDouble();

                //El precio debe ser mayor a 0
                if (precio > 0) {

                    break;

                } else {

                    System.out.println("El precio debe ser mayor a 0");
                }

            } else {

                System.out.println("No se permiten letras, ingrese un numero");
                sc.next();
            }
        }

        //Variable fecha
        LocalDate fecha;

        //Validacion de fecha
        while (true) {

            System.out.print("Anio de vencimiento: ");

            while (!sc.hasNextInt()) {

                System.out.println("No se permiten letras, ingrese un anio valido");
                sc.next();
            }

            int anio = sc.nextInt();

            //Restriccion de años
            if (anio < 2027) {

                System.out.println("Anio invalido");
                continue;
            }

            System.out.print("Mes de vencimiento: ");

            while (!sc.hasNextInt()) {

                System.out.println("No se permiten letras, ingrese un mes valido");
                sc.next();
            }

            int mes = sc.nextInt();

            System.out.print("Dia de vencimiento: ");

            while (!sc.hasNextInt()) {

                System.out.println("No se permiten letras, ingrese un dia valido");
                sc.next();
            }

            int dia = sc.nextInt();

            //Verificacion de fecha
            try {

                //Creacion de fecha
                fecha = LocalDate.of(anio, mes, dia);

                //La fecha debe ser futura
                if (fecha.isAfter(LocalDate.now())) {

                    break;

                } else {

                    System.out.println("La fecha debe ser futura");
                }

            } catch (Exception e) {

                //Error si la fecha no existe
                System.out.println("Fecha invalida");
            }
        }

        //Limpiar buffer
        sc.nextLine();

        //Verificacion de restricciones
        if (inventario.verificacionRestricciones(stock, precio)) {

            //Creacion del producto perecedero
            ProductoPerecedero producto =
                    new ProductoPerecedero(id, marca, nombre,
                            stock, precio, fecha);

            //Registro del producto
            inventario.registrarProducto(producto);

            System.out.println("Producto perecedero registrado");
        }
    }

    //Metodo para registrar productos no perecederos
    public void registrarNoPerecedero() {

        System.out.println("\n--- PRODUCTO NO PERECEDERO ---");

        //Ingreso y validacion de ID
        String id;

        while (true) {

            System.out.print("ID: ");
            id = sc.nextLine();

            if (idExiste(id)) {

                System.out.println("El ID ya existe");

            } else {

                break;
            }
        }

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        //Variable stock
        int stock;

        //Validacion de stock
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

                System.out.println("No se permiten letras, ingrese un numero");
                sc.next();
            }
        }

        //Variable precio
        double precio;

        //Validacion de precio
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

                System.out.println("No se permiten letras, ingrese un numero");
                sc.next();
            }
        }

        //Limpiar buffer
        sc.nextLine();

        //Ingreso de material
        System.out.print("Material: ");
        String material = sc.nextLine();

        //Verificacion de restricciones
        if (inventario.verificacionRestricciones(stock, precio)) {

            //Creacion del producto no perecedero
            ProductoNoPerecedero producto =
                    new ProductoNoPerecedero(id, marca, nombre,
                            stock, precio, material);

            //Registro del producto
            inventario.registrarProducto(producto);

            System.out.println("Producto no perecedero registrado");
        }
    }

    //Metodo para mostrar productos
    public void mostrarProductos() {

        System.out.println("\n===== LISTA DE PRODUCTOS =====");

        //Verifica si no hay productos
        if (inventario.getListaProductos().isEmpty()) {

            System.out.println("No existen productos registrados");
            return;
        }

        //Recorrer lista de productos
        for (Producto producto : inventario.getListaProductos()) {

            System.out.println("---------------------------");

            //Mostrar informacion
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
            System.out.println("Valor Inventario: " + producto.getValorInventario());
        }
    }
}
