import java.util.Scanner;

public class Main extends ReadCSV{
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int ciclo = 0;
        while(ciclo == 0) {
            System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
            System.out.println("|/         PROYECTO DE LENGUAJES DE PROG         /|");
            System.out.println("|/    PRESIONA UN NUMERO PARA CADA OPERACION     /|");
            System.out.println("|/    (1) Para leer la Metadata                  /|");
            System.out.println("|/    (2) Para buscar hechos por año             /|");
            System.out.println("|/    (3) Para buscar hechos por palabra clave   /|");
            System.out.println("|/    (4) Para buscar hechos por texto           /|");
            System.out.println("|/    (0) Para Salir                             /|");
            System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
            int caso = scan.nextInt();
            // Switch case para analizar el input del usuario
            switch (caso) {
                case 0: //Caso para salir del programa
                    System.out.println("Gracias por usar el programa!");
                    ciclo = 1;
                    break;
                case 1: // Caso para leer el csv
                    ReadCSV.leerCSV();
                    System.out.println("CSV leido con exito, ya puede ser usado!");
                    break;
                case 2:
                    ReadCSV.hechosAños();
                    break;
                case 3:
                    ReadCSV.hechosPalabra();
                    break;
                case 4:
                    ReadCSV.hechosTexto();
                    break;
            }
        }
    }
}
