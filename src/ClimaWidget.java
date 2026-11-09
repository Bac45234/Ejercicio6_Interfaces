public class ClimaWidget extends Widget implements Interactivo {
    private final String ciudad;
    private double temperatura;
    private String condicion;

    public ClimaWidget(String nombre, int memoriaKB, String ciudad, double temperatura, String condicion) {
        super(nombre, memoriaKB);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.condicion = condicion;
    }

    @Override public String getTipo() { return "Clima"; }
    @Override protected String getDetalle() { return ciudad + ", " + temperatura + " °C, " + condicion; }
    @Override public String renderizar() { return "[Clima " + ciudad + "] " + temperatura + " °C - " + condicion; }

    @Override public String alHacerClic() {
        return "Mostrando pronóstico extendido de " + ciudad + " (condición actual: " + condicion + ").";
    }

    @Override public String alActualizar(String datos) {
        String[] partes = datos.split(",");
        try {
            this.temperatura = Double.parseDouble(partes[0].trim());
            if (partes.length > 1) this.condicion = partes[1].trim();
            return "Clima de " + ciudad + " actualizado: " + temperatura + " °C, " + condicion + ".";
        } catch (NumberFormatException e) {
            return "Datos inválidos. Use el formato: temperatura,condicion (ej. 24.5,Soleado).";
        }
    }

    @Override public String alActualizar() {
        temperatura = Math.round((temperatura + 0.5) * 10) / 10.0;
        return "Sensor de " + ciudad + " actualizado: " + temperatura + " °C.";
    }
}
