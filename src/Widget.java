public abstract class Widget implements Renderizable, Comparable<Widget> {

    private static int siguienteId = 1;

    private final int id;
    private String nombre;
    private int memoriaKB;

    protected Widget(String nombre, int memoriaKB) {
        this.id = siguienteId++;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getMemoriaKB() { return memoriaKB; }
    public void setMemoriaKB(int memoriaKB) { this.memoriaKB = memoriaKB; }

    public abstract String getTipo();

    protected abstract String getDetalle();

    public boolean esInteractivo() {
        return this instanceof Interactivo;
    }

    public String getConfiguracion() {
        return "ID: " + id
             + "\nNombre: " + nombre
             + "\nTipo: " + getTipo()
             + "\nMemoria: " + memoriaKB + " KB"
             + "\nInteractivo: " + (esInteractivo() ? "Sí" : "No")
             + "\nDetalle: " + getDetalle();
    }

    @Override
    public int compareTo(Widget otro) {
        int cmp = Integer.compare(this.memoriaKB, otro.memoriaKB);
        return (cmp != 0) ? cmp : Integer.compare(this.id, otro.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Widget)) return false;
        return id == ((Widget) o).id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }

    @Override
    public String toString() {
        return String.format("[%02d] %-22s %-12s %5d KB  %s",
                id, nombre, getTipo(), memoriaKB, esInteractivo() ? "Interactivo" : "Estático");
    }
}
