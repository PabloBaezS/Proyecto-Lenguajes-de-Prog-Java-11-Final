import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
        System.out.println("|/         PROYECTO DE LENGUAJES DE PROG         /|");
        System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
        Scanner scan  = new Scanner(System.in);
        int ciclo = 0;
        int caso = 0;
        //Ciclo while para correr el menu hasta que se salga del programa
        while(ciclo == 0) {
            System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
            System.out.println("|/    PRESIONA UN NUMERO PARA LA OPERACION       /|");
            System.out.println("|/    (1) Para leer la Metadata                  /|");
            System.out.println("|/    (2) Para buscar hechos por año             /|");
            System.out.println("|/    (3) Para buscar hechos por palabra clave   /|");
            System.out.println("|/    (4) Para buscar hechos por texto           /|");
            System.out.println("|/    (0) Para Salir                             /|");
            System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
            System.out.print("|/ Ingrese una opcion --> ");
            //Comprobacion por si se ingresa algo diferente de un entero
            if (scan.hasNextInt()) {
                caso = scan.nextInt();
            }else{
                System.out.println("Inicie de nuevo el programa ingresando un entero valido!");
            }
            // Switch case para analizar el input del usuario
            switch (caso) {
                case 0: //Caso para salir del programa
                    System.out.println("Gracias por usar el programa!");
                    ciclo = 1;
                    break;
                case 1: // Caso para leer el csv
                    Methods.leerCSV();
                    break;
                case 2: // Caso para usar el programa ingresando un año
                    Methods.hechosAños();
                    break;
                case 3: // Caso para usar el programa ingresando una palabra
                    Methods.hechosPalabra();
                    break;
                case 4: // Caso para usar el programa ingresando un texto
                    Methods.hechosTexto();
                    break;
            }
        }
    }
}

