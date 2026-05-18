package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductoPerecedero extends Producto {

    //Atributo tipo fecha
    private LocalDate fechaVencimiento;


    //Constructor con argumentos para producto perecedero
    public ProductoPerecedero(String id, String marca, String nombre, int stock,
                              double precioUnitario, LocalDate fechaVencimiento) {
        super(id, marca, nombre, stock, precioUnitario);
        this.fechaVencimiento = fechaVencimiento;
    }


    @Override
    public double calcularValorInventario() {

        LocalDate hoy = LocalDate.now();   //Fecha actual
        long diasParaVencer = ChronoUnit.DAYS.between(hoy, this.fechaVencimiento);   //Calculo de dias entre la fecha actual
        // y la fecha de vencimiento establecida del producto
        double inventario = getStock() * getPrecioUnitario();

        //Restricciones:
        if (diasParaVencer <= 0) {
            setValorInventario(0.0);     //El valor del producto es 0 si la fecha de vencimiento ya pasó
            return getValorInventario();
        } else if (diasParaVencer <= 30) {
            inventario *= 0.8;  //Descuento del 20% si es que la fecha de vencimiento esta a 30 dias o menos de hoy
        }

        setValorInventario(inventario);
        return getValorInventario();
    }
}
