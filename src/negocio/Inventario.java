package negocio;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {

    //Atributos de la clase - declaracion de la lista
    private List<Producto> listaProductos;
    private double presupuesto;
    private int espacio;

    //Constructor para inicializar valores de inventario - instanciacion de lista de productos
    public Inventario() {
        this.listaProductos = new ArrayList<Producto>();
        this.presupuesto = 10000.0;
        this.espacio = 500;
    }

    //Metodos de la clase para verificaciones y registros

    /**
     * Verificacion de presupuesto y de espacio en bodegas
     *
     * @param nuevoStock  cantidad del producto a verificar
     * @param nuevoPrecio precio del producto a verificar
     * @return true si cumple con las restricciones
     */
    public boolean verificacionRestricciones(int nuevoStock, double nuevoPrecio) {

        double precioNuevoProducto = nuevoPrecio * nuevoStock;
        double sumaInventario = 0;
        int sumaStock = 0;

        //Ciclo para calcular el precio de productos en el inventario y su stock actual
        for (Producto producto : listaProductos) {
            sumaInventario += producto.getValorInventario();
            sumaStock += producto.getStock();
        }

        if ((sumaInventario + precioNuevoProducto) > presupuesto) {     //Si el stock actual mas el nuevo sobrepasan
            // el espacio disponible no cumple
            System.out.println("Error: Presupuesto de compras excedido");
            return false;
        }

        if ((sumaStock + nuevoStock) > espacio) {    //Si el stock actual mas el nuevo sobrepasan
            // el espacio disponible no cumple
            System.out.println("Error: Espacio en bodegas insuficiente");
            return false;
        }


        return true;
    }

    /**
     * Metodo para ingresar productos directamente a la lista
     *
     * @param prod
     */
    public void registrarProducto(Producto prod) {
        if (prod != null) {      //Si el producto no es nulo se agrega a la lista
            prod.calcularValorInventario();
            listaProductos.add(prod);
        }
    }

    //Getter para la lista
    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
