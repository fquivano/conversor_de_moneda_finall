import java.util.Map;
import java.util.Scanner;

// Clase para manejar la lógica de conversión de monedas
public class ConversorMoneda {
    private final ConsultaMoneda consulta;

    public ConversorMoneda() {
        this.consulta = new ConsultaMoneda();
    }

    public void convertir(String monedaBase, String monedaDestino) {
        try {
            Moneda moneda = consulta.buscaMoneda(monedaBase);
            System.out.println("Código base: " + moneda.base_code());

            Map<String, Double> tasasDeConversion = moneda.conversion_rates();
            Double tasaDeCambio = tasasDeConversion.get(monedaDestino);

            if (tasaDeCambio != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese la cantidad a convertir desde " + monedaBase + " a " + monedaDestino + ":");
                int cantidad = scanner.nextInt();

                double resultado = cantidad * tasaDeCambio;
                System.out.println(cantidad + " " + monedaBase + " es equivalente a " + resultado + " " + monedaDestino);
            } else {
                System.out.println("La moneda de destino no se encuentra disponible.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Error al realizar la conversión.");
        }
    }
}
