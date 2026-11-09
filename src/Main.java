import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        Scanner sc = new Scanner(System.in);

        System.out.println(view.bienvenida());
        int opcion;
        do {
            System.out.println(view.menu());
            opcion = leerEntero(sc, view.pedirOpcion());
            System.out.println(procesar(opcion, sc, controller, view));
        } while (opcion != 0);
        sc.close();
    }

    private static String procesar(int opcion, Scanner sc, Controller c, View v) {
        switch (opcion) {
            case 1: return c.listar();
            case 2: return c.buscar(leerTexto(sc, v.pedirCriterio()));
            case 3: return c.ordenarPorMemoria(leerTexto(sc, v.pedirOrden()).equalsIgnoreCase("s"));
            case 4: return c.renderizarDashboard();
            case 5: return c.clicEnWidget(leerEntero(sc, v.pedirId()));
            case 6:
                int id = leerEntero(sc, v.pedirId());
                return c.actualizarWidget(id, leerTexto(sc, v.pedirDatos()));
            case 7: return c.actualizarTodos();
            case 0: return v.despedida();
            default: return v.opcionInvalida();
        }
    }

    private static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.hasNextLine() ? sc.nextLine() : "";
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        if (!sc.hasNextLine()) return 0;
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
