package modelo;

public class ProductoNoPerecedero extends Producto {

    private String material;

    public ProductoNoPerecedero(String id, String marca, String nombre, int stock,
                                double precioUnitario, double valorInventario, String material) {
        super(id, marca, nombre, stock, precioUnitario, valorInventario);
        this.material = material;
    }

    @Override
    public double calcularValorInventario() {

        double inventario = getStock() * getPrecioUnitario();
        setValorInventario(inventario);

        return getValorInventario();
    }
}
