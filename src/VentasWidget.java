public class VentasWidget extends Widget implements Interactivo {
    private double ventasDia;
    private boolean verDetalle;

    public VentasWidget(String nombre, int memoriaKB, double ventasDia) {
        super(nombre, memoriaKB);
        this.ventasDia = ventasDia;
    }

    @Override public String getTipo() { return "Ventas"; }
    @Override protected String getDetalle() { return "Ventas del día: Q" + ventasDia; }

    @Override public String renderizar() {
        return "[Ventas] Q" + ventasDia + (verDetalle ? " (vista detallada)" : " (vista resumen)");
    }

    @Override public String alHacerClic() {
        verDetalle = !verDetalle;
        return "Vista cambiada a " + (verDetalle ? "detallada." : "resumen.");
    }

    @Override public String alActualizar(String datos) {
        try {
            ventasDia += Double.parseDouble(datos.trim());
            return "Ventas actualizadas: Q" + ventasDia;
        } catch (NumberFormatException e) {
            return "Monto inválido. Ingrese un número.";
        }
    }

    @Override public String alActualizar() {
        ventasDia += 125.0;
        return "Nueva venta registrada. Total: Q" + ventasDia;
    }
}
