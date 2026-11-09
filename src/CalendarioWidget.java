public class CalendarioWidget extends Widget {
    private final String mes;
    private final int diaDestacado;

    public CalendarioWidget(String nombre, int memoriaKB, String mes, int diaDestacado) {
        super(nombre, memoriaKB);
        this.mes = mes;
        this.diaDestacado = diaDestacado;
    }

    @Override public String getTipo() { return "Calendario"; }
    @Override protected String getDetalle() { return "Mes " + mes + ", día destacado " + diaDestacado; }
    @Override public String renderizar() { return "[Calendario] " + mes + " - hoy: día " + diaDestacado; }
}
