import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMoneda conversor = new ConversorMoneda();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        String menu =
                """
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda =)
                
                1) Dolar => Peso argentino
                2) Peso argentino => Dolar
                3) Dolar => Real brasileño
                4) Real brasileño => Dolar
                5) Dolar => Peso colombiano
                6) Peso colombiano => Dolar
                7) Salir
                Elija una opcion valida:
                ****************************************************
                """;

        while (opcion != 7) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> conversor.convertir("USD", "ARS");
                case 2 -> conversor.convertir("ARS", "USD");
                case 3 -> conversor.convertir("USD", "BRL");
                case 4 -> conversor.convertir("BRL", "USD");
                case 5 -> conversor.convertir("USD", "COP");
                case 6 -> conversor.convertir("COP", "USD");
                case 7 -> System.out.println("Saliendo de la aplicación.");
                default -> System.out.println("Opción no válida");
            }
        }
    }
}
