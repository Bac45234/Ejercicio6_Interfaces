public class NoticiasWidget extends Widget {
    private String titular;

    public NoticiasWidget(String nombre, int memoriaKB, String titular) {
        super(nombre, memoriaKB);
        this.titular = titular;
    }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    @Override public String getTipo() { return "Noticias"; }
    @Override protected String getDetalle() { return "Titular: " + titular; }
    @Override public String renderizar() { return "[Noticias] " + titular; }
}
