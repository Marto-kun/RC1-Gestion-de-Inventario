package modelo;

public class ProductoNoPerecedero extends Producto {

    private String material;


    @Override
    public double calcularValorInventario() {

        double inventario = getStock() * getPrecioUnitario();
        setValorInventario(inventario);

        return getValorInventario();
    }
}
