import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    private final List<Widget> widgets = new ArrayList<>();

    public Model() {
        cargaInicial();
    }

    private void cargaInicial() {
        agregar(new RelojWidget("Reloj Guatemala", 120, "Guatemala", -6));
        agregar(new RelojWidget("Reloj Tokio", 125, "Tokio", 9));
        agregar(new RelojWidget("Reloj UTC", 110, "UTC", 0));
        agregar(new ClimaWidget("Clima Ciudad Guatemala", 640, "Ciudad de Guatemala", 23.5, "Parcialmente nublado"));
        agregar(new ClimaWidget("Clima Quetzaltenango", 610, "Quetzaltenango", 15.0, "Frío y despejado"));
        agregar(new TareasWidget("Tareas del equipo", 380, "Revisar PR", "Reunión de UI", "Entregar ejercicio 6"));
        agregar(new AlertaWidget("Alerta CPU", 90, "ADVERTENCIA", "Uso de CPU al 92%"));
        agregar(new AlertaWidget("Alerta Seguridad", 95, "CRITICA", "Intento de acceso no autorizado"));
        agregar(new CalendarioWidget("Calendario", 450, "Noviembre", 8));
        agregar(new NoticiasWidget("Noticias internas", 300, "Nueva versión del dashboard disponible"));
        agregar(new VentasWidget("Ventas del día", 820, 15250.75));
    }

    public void agregar(Widget widget) {
        widgets.add(widget);
    }

    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }

    public Widget buscar(int id) {
        for (Widget w : widgets) {
            if (w.getId() == id) return w;
        }
        return null;
    }

    public Widget buscar(String nombre) {
        String criterio = nombre.trim().toLowerCase();
        for (Widget w : widgets) {
            if (w.getNombre().toLowerCase().contains(criterio)) return w;
        }
        return null;
    }

    public List<Widget> ordenarPorMemoria() {
        Collections.sort(widgets);
        return getWidgets();
    }

    public List<Widget> ordenarPorMemoria(boolean descendente) {
        if (descendente) Collections.sort(widgets, Collections.reverseOrder());
        else Collections.sort(widgets);
        return getWidgets();
    }
}
