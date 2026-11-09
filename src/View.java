import java.util.List;

public class View {
    private static final String LINEA = "==============================================================";

    public String bienvenida() {
        return LINEA + "\n   DASHBOARD MODULAR - Motor de widgets\n" + LINEA;
    }

    public String menu() {
        return "\n--------------------------- MENÚ ---------------------------\n"
             + " 1. Listar todos los widgets activos\n"
             + " 2. Buscar widget por ID o nombre (ver configuración)\n"
             + " 3. Ordenar widgets por memoria (KB)\n"
             + " 4. Renderizar dashboard completo\n"
             + " 5. Hacer clic en un widget (por ID)\n"
             + " 6. Actualizar un widget (por ID)\n"
             + " 7. Simular actualización en tiempo real (todos)\n"
             + " 0. Salir\n"
             + "------------------------------------------------------------";
    }

    public String pedirOpcion() { return "Seleccione una opción: "; }
    public String pedirCriterio() { return "Ingrese ID o nombre del widget: "; }
    public String pedirId() { return "Ingrese el ID del widget: "; }
    public String pedirDatos() { return "Datos de actualización (Enter para actualización automática): "; }
    public String pedirOrden() { return "¿Orden descendente (mayor a menor)? (s/n): "; }

    public String listado(String titulo, List<Widget> widgets) {
        StringBuilder sb = new StringBuilder("\n" + titulo + "\n" + LINEA + "\n");
        for (Widget w : widgets) sb.append(w).append("\n");
        sb.append(LINEA).append("\nTotal: ").append(widgets.size()).append(" widgets");
        return sb.toString();
    }

    public String configuracion(Widget w) {
        return "\n--- Configuración del widget ---\n" + w.getConfiguracion();
    }

    public String dashboard(List<String> renders) {
        StringBuilder sb = new StringBuilder("\n" + LINEA + "\n                    DASHBOARD\n" + LINEA + "\n");
        for (String r : renders) sb.append(r).append("\n");
        sb.append(LINEA);
        return sb.toString();
    }

    public String resultadoInteraccion(String widget, String resultado) {
        return "> " + widget + ": " + resultado;
    }

    public String resumenTiempoReal(List<String> resultados, int omitidos) {
        StringBuilder sb = new StringBuilder("\n--- Actualización en tiempo real ---\n");
        for (String r : resultados) sb.append(r).append("\n");
        sb.append("Widgets estáticos omitidos (no soportan interacción): ").append(omitidos);
        return sb.toString();
    }

    public String noEncontrado(String criterio) { return "No se encontró ningún widget con: " + criterio; }
    public String noInteractivo(Widget w) { return "El widget \"" + w.getNombre() + "\" es estático y no soporta interacción."; }
    public String opcionInvalida() { return "Opción inválida. Intente de nuevo."; }
    public String despedida() { return "\nCerrando dashboard. ¡Hasta pronto!"; }
}
