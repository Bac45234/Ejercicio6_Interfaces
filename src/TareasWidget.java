import java.util.ArrayList;

public class TareasWidget extends Widget implements Interactivo {
    private final ArrayList<String> tareas = new ArrayList<>();

    public TareasWidget(String nombre, int memoriaKB, String... tareasIniciales) {
        super(nombre, memoriaKB);
        for (String t : tareasIniciales) tareas.add(t);
    }

    @Override public String getTipo() { return "Tareas"; }
    @Override protected String getDetalle() { return tareas.size() + " tarea(s) pendiente(s)"; }

    @Override public String renderizar() {
        return tareas.isEmpty() ? "[Tareas] Sin pendientes"
                : "[Tareas] " + tareas.size() + " pendientes: " + String.join(", ", tareas);
    }

    @Override public String alHacerClic() {
        if (tareas.isEmpty()) return "No hay tareas por completar.";
        return "Tarea completada: " + tareas.remove(0);
    }

    @Override public String alActualizar(String datos) {
        tareas.add(datos);
        return "Tarea agregada: " + datos;
    }

    @Override public String alActualizar() {
        return "Sincronizado. Pendientes actuales: " + tareas.size();
    }
}
