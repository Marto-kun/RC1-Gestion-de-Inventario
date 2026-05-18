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

        //Inicializacion del scanner
        sc = new Scanner(System.in);
    }

    //Metodo principal del sistema
    public void ejecutarSistema() {

        //Variable para controlar el menu
        int opcion;

        //Ciclo do while para repetir el menu hasta salir
        do {

            //Menu de opciones
            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Registrar producto perecedero");
            System.out.println("2. Registrar producto no perecedero");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");

            //Validacion para que solo se ingresen numeros enteros
            while (!sc.hasNextInt()) {

                System.out.println("Ingrese una opcion valida");
                sc.next();
            }

            //Lectura de opcion
            opcion = sc.nextInt();

            //Limpieza del buffer
            sc.nextLine();

            //Switch para ejecutar opciones del menu
            switch (opcion) {

                case 1:

                    //Llamada al metodo para registrar perecederos
                    registrarPerecedero();
                    break;

                case 2:

                    //Llamada al metodo para registrar no perecederos
                    registrarNoPerecedero();
                    break;

                case 3:

                    //Llamada al metodo para mostrar productos
                    mostrarProductos();
                    break;

                case 4:

                    //Mensaje de salida
                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    //Mensaje si la opcion no existe
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);
    }

    //Metodo para registrar productos perecederos
    public void registrarPerecedero() {

        System.out.println("\n--- PRODUCTO PERECEDERO ---");

        //Ingreso de datos tipo texto
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        //Variable stock
        int stock;

        //Validacion del stock
        while (true) {

            System.out.print("Stock: ");

            //Verifica si el usuario ingreso un entero
            if (sc.hasNextInt()) {

                stock = sc.nextInt();

                //Verifica que el stock sea mayor a 0
                if (stock > 0) {
                    break;
                } else {

                    System.out.println("El stock debe ser mayor a 0");
                }

            } else {

                //Mensaje si el usuario ingresa letras
                System.out.println("Ingrese un numero valido");

                //Limpia el dato incorrecto
                sc.next();
            }
        }

        //Variable precio
        double precio;

        //Validacion del precio
        while (true) {

            System.out.print("Precio unitario: ");

            //Verifica si el usuario ingreso un decimal
            if (sc.hasNextDouble()) {

                precio = sc.nextDouble();

                //Verifica que el precio sea mayor a 0
                if (precio > 0) {
                    break;
                } else {

                    System.out.println("El precio debe ser mayor a 0");
                }

            } else {

                //Mensaje si el usuario ingresa letras
                System.out.println("Ingrese un numero valido");

                //Limpia el dato incorrecto
                sc.next();
            }
        }

        //Variable para almacenar la fecha
        LocalDate fecha;

        //Validacion de fecha
        while (true) {

            //Ingreso del anio
            System.out.print("Anio de vencimiento: ");

            while (!sc.hasNextInt()) {

                System.out.println("Ingrese un anio valido");
                sc.next();
            }

            int anio = sc.nextInt();

            //Ingreso del mes
            System.out.print("Mes de vencimiento: ");

            while (!sc.hasNextInt()) {

                System.out.println("Ingrese un mes valido");
                sc.next();
            }

            int mes = sc.nextInt();

            //Ingreso del dia
            System.out.print("Dia de vencimiento: ");

            while (!sc.hasNextInt()) {

                System.out.println("Ingrese un dia valido");
                sc.next();
            }

            int dia = sc.nextInt();

            try {

                //Creacion de fecha
                fecha = LocalDate.of(anio, mes, dia);

                //Verifica que la fecha sea futura
                if (fecha.isAfter(LocalDate.now())) {

                    break;

                } else {

                    System.out.println("La fecha debe ser futura");
                }

            } catch (Exception e) {

                //Mensaje si la fecha no existe
                System.out.println("Fecha invalida");
            }
        }

        //Limpieza de buffer
        sc.nextLine();

        //Verificacion de restricciones del inventario
        if (inventario.verificacionRestricciones(stock, precio)) {

            //Creacion del producto perecedero
            ProductoPerecedero producto =
                    new ProductoPerecedero(
                            id,
                            marca,
                            nombre,
                            stock,
                            precio,
                            fecha
                    );

            //Registro del producto en inventario
            inventario.registrarProducto(producto);

            //Mensaje de confirmacion
            System.out.println("Producto perecedero registrado");
        }
    }

    //Metodo para registrar productos no perecederos
    public void registrarNoPerecedero() {

        System.out.println("\n--- PRODUCTO NO PERECEDERO ---");

        //Ingreso de datos tipo texto
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        //Variable stock
        int stock;

        //Validacion del stock
        while (true) {

            System.out.print("Stock: ");

            if (sc.hasNextInt()) {

                stock = sc.nextInt();

                //Verifica que el stock sea positivo
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

        //Variable precio
        double precio;

        //Validacion del precio
        while (true) {

            System.out.print("Precio unitario: ");

            if (sc.hasNextDouble()) {

                precio = sc.nextDouble();

                //Verifica que el precio sea positivo
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

        //Limpieza del buffer
        sc.nextLine();

        //Ingreso del material
        System.out.print("Material: ");
        String material = sc.nextLine();

        //Verificacion de restricciones
        if (inventario.verificacionRestricciones(stock, precio)) {

            //Creacion del producto no perecedero
            ProductoNoPerecedero producto =
                    new ProductoNoPerecedero(
                            id,
                            marca,
                            nombre,
                            stock,
                            precio,
                            material
                    );

            //Registro del producto
            inventario.registrarProducto(producto);

            //Mensaje de confirmacion
            System.out.println("Producto no perecedero registrado");
        }
    }

    //Metodo para mostrar productos registrados
    public void mostrarProductos() {

        System.out.println("\n===== LISTA DE PRODUCTOS =====");

        //Verifica si la lista esta vacia
        if (inventario.getListaProductos().isEmpty()) {

            System.out.println("No existen productos registrados");
            return;
        }

        //Recorrido de la lista de productos
        for (Producto producto : inventario.getListaProductos()) {

            System.out.println("---------------------------");

            //Muestra datos del producto
            System.out.println("ID: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Marca: " + producto.getMarca());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
            System.out.println("Valor Inventario: " + producto.getValorInventario());
        }
    }
}
