public class AlertaWidget extends Widget implements Interactivo {
    private String mensaje;
    private final String nivel;
    private boolean leida;

    public AlertaWidget(String nombre, int memoriaKB, String nivel, String mensaje) {
        super(nombre, memoriaKB);
        this.nivel = nivel;
        this.mensaje = mensaje;
        this.leida = false;
    }

    @Override public String getTipo() { return "Alerta"; }
    @Override protected String getDetalle() { return nivel + " - " + mensaje + (leida ? " (leída)" : " (nueva)"); }
    @Override public String renderizar() { return "[Alerta " + nivel + "] " + mensaje + (leida ? " (leída)" : " (NUEVA)"); }

    @Override public String alHacerClic() {
        leida = true;
        return "Alerta marcada como leída: " + mensaje;
    }

    @Override public String alActualizar(String datos) {
        this.mensaje = datos;
        this.leida = false;
        return "Nueva alerta recibida: " + datos;
    }

    @Override public String alActualizar() {
        return leida ? "Alerta sin cambios (ya leída)." : "Alerta pendiente de lectura: " + mensaje;
    }
}
