package modelo;

public abstract class Producto {

    //Atributos privados para heredar a nuevas clases
    private String id;
    private String marca;
    private String nombre;
    private int stock;
    private double precioUnitario;
    private double valorInventario = 0;

    //Constructor vacio
    public Producto() {
    }

    //Constructor con argumentos
    public Producto(String id, String marca, String nombre, int stock,
                    double precioUnitario) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
    }

    //Metodo abstracto para diferentes productos del inventario

    /**
     * Metodo para calcular el valor en inventario de un producto específico
     *
     * @return Valor del inventario
     */
    public abstract double calcularValorInventario();


    //Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getValorInventario() {
        return valorInventario;
    }

    public void setValorInventario(double valorInventario) {
        this.valorInventario = valorInventario;
    }
}
