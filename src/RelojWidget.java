import java.time.LocalTime;
import java.time.ZoneOffset;

public class RelojWidget extends Widget {
    private final String zona;
    private final int offsetHoras;

    public RelojWidget(String nombre, int memoriaKB, String zona, int offsetHoras) {
        super(nombre, memoriaKB);
        this.zona = zona;
        this.offsetHoras = offsetHoras;
    }

    @Override public String getTipo() { return "Reloj"; }

    @Override protected String getDetalle() {
        return "Zona " + zona + " (UTC" + (offsetHoras >= 0 ? "+" : "") + offsetHoras + ")";
    }

    @Override public String renderizar() {
        LocalTime hora = LocalTime.now(ZoneOffset.ofHours(offsetHoras)).withNano(0);
        return "[Reloj " + zona + "] " + hora;
    }
}
