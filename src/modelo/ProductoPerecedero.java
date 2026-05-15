package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductoPerecedero extends Producto {

    private LocalDate fechaVencimiento;


    @Override
    public double calcularValorInventario() {

        LocalDate hoy = LocalDate.now();
        double diasParaVencer = ChronoUnit.DAYS.between(hoy, this.fechaVencimiento);
        double inventario = getStock() * getPrecioUnitario();

        if (diasParaVencer <= 0) {
            return 0.0;  //El valor del producto es 0 si la fecha de vencimiento ya pasó
        } else if (diasParaVencer <= 30) {
            inventario *= 0.8;  //Descuento del 20% si es que la fecha de vencimiento esta a 30 dias o menos de hoy
        }

        setValorInventario(inventario);
        return getValorInventario();
    }
}
