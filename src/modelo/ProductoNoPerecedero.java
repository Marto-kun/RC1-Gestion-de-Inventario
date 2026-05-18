package modelo;

public class ProductoNoPerecedero extends Producto {

    private String material;

    public ProductoNoPerecedero(String id, String marca, String nombre, int stock,
                                double precioUnitario, String material) {
        super(id, marca, nombre, stock, precioUnitario);
        this.material = material;
    }

    @Override
    public double calcularValorInventario() {

        double inventario = getStock() * getPrecioUnitario();
        setValorInventario(inventario);

        return getValorInventario();
    }
}
