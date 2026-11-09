import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String listar() {
        return view.listado("WIDGETS ACTIVOS", model.getWidgets());
    }

    public String buscar(String criterio) {
        Widget w;
        try {
            w = model.buscar(Integer.parseInt(criterio.trim()));
        } catch (NumberFormatException e) {
            w = model.buscar(criterio);
        }
        return (w == null) ? view.noEncontrado(criterio) : view.configuracion(w);
    }

    public String ordenarPorMemoria(boolean descendente) {
        List<Widget> ordenados = model.ordenarPorMemoria(descendente);
        return view.listado("WIDGETS ORDENADOS POR MEMORIA " + (descendente ? "(mayor a menor)" : "(menor a mayor)"), ordenados);
    }

    private String renderizar(Renderizable r) {
        return r.renderizar();
    }

    public String renderizarDashboard() {
        List<String> renders = new ArrayList<>();
        for (Widget w : model.getWidgets()) renders.add(renderizar(w));
        return view.dashboard(renders);
    }

    private String interactuar(Interactivo i) {
        return i.alHacerClic();
    }

    private String interactuar(Interactivo i, String datos) {
        return (datos == null || datos.trim().isEmpty()) ? i.alActualizar() : i.alActualizar(datos.trim());
    }

    public String clicEnWidget(int id) {
        Widget w = model.buscar(id);
        if (w == null) return view.noEncontrado("ID " + id);
        if (!(w instanceof Interactivo)) return view.noInteractivo(w);
        return view.resultadoInteraccion(w.getNombre(), interactuar((Interactivo) w));
    }

    public String actualizarWidget(int id, String datos) {
        Widget w = model.buscar(id);
        if (w == null) return view.noEncontrado("ID " + id);
        if (!(w instanceof Interactivo)) return view.noInteractivo(w);
        return view.resultadoInteraccion(w.getNombre(), interactuar((Interactivo) w, datos));
    }

    public String actualizarTodos() {
        List<String> resultados = new ArrayList<>();
        int omitidos = 0;
        for (Widget w : model.getWidgets()) {
            if (w instanceof Interactivo) {
                resultados.add(view.resultadoInteraccion(w.getNombre(), interactuar((Interactivo) w, null)));
            } else {
                omitidos++;
            }
        }
        return view.resumenTiempoReal(resultados, omitidos);
    }
}
