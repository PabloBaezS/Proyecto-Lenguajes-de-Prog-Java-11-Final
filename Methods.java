import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Methods {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<String[]> metadata = new ArrayList<>();

    public static void leerCSV() {
        try {
            // Se usa el bufferReader para leer el archivo linea por linea
            BufferedReader reader = new BufferedReader(new FileReader("data1.csv"));
            //Se quita la primera linea del CSV para que no de fallos
            String dato = reader.readLine();
            while ((dato = reader.readLine()) != null) {
                dato = dato.toLowerCase(Locale.ROOT);
                dato = dato.replace(";;", " ");
                String[] parts = dato.split(":");
                Methods.metadata.add(parts);
            }
            System.out.println("CSV leido con exito, ya puede ser usado!");
        }
        //La excepcion por si el archivo no se encuentra no de error, solo salta el mensaje para poderse corregir!
        catch (IOException e) {
            System.out.println("El archivo no se ha encontrado! cambie el nombre e intente de nuevo!");
        }

    }

    public static void hechosAños() {
        //En cada metodo se comprueba si el CSV fue leido para no dar valores vacios
        if (Methods.metadata.isEmpty()) {
            System.out.println("Primero se debe leer el CSV, leyendo...");
            Methods.leerCSV();
        }
        System.out.println("___ (2) Buscar hechos importantes por año ___ ");
        boolean found = false;
        int totalParts = Methods.metadata.size();
        int dato = 0;
        if (scan.hasNextInt()) {
            dato = scan.nextInt();
        } else {
            System.out.println("Ingrese un año valido!");
        }
        String datoOk = String.valueOf(dato);
        System.out.println("Datos del año " + datoOk + ":");
        //Recorre el arreglo comparando la columna 1 (años) con el año ingresado
        for (int i = 0; i < totalParts; i++) {
            if (datoOk.compareTo(Methods.metadata.get(i)[0]) == 0) {
                System.out.println("> " + Methods.metadata.get(i)[1]);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("!!!Datos con el año no encontrados, regresando!");
        }
    }

    public static void hechosPalabra() {
        //En cada metodo se comprueba si el CSV fue leido para no dar valores vacios
        if (Methods.metadata.isEmpty() == true) {
            System.out.println("Primero se debe leer el CSV, leyendo...");
            Methods.leerCSV();
        }
        System.out.println("___ (3) Buscar hechos importantes por palabra ___ ");
        System.out.print("Ingrese la palabra clave para buscar:");
        String palabra = scan.next();
        System.out.println("Los hechos importantes con la palabra " + palabra + " son: ");
        int contador = 0;
        //Recorre el arreglo comparando la columna 2 (hechos) con la palabra ingresada
        for (int i = 1; i < Methods.metadata.size(); i++) {
            //Comprobacion por si la columna 2 de ese array esta vacia se ignore y siga con el proceso
            if (Methods.metadata.get(i)[1].isEmpty() == true) {
                break;
            }
            if (Methods.metadata.get(i)[1].contains(palabra) == true) {
                System.out.print("> En el año " + Methods.metadata.get(i)[0] + ":");
                System.out.println(Methods.metadata.get(i)[1]);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No se encontraron hechos con la palabra " + palabra);
        } else {
            System.out.println("Se encontraron en total " + contador + " hechos con la palabra " + palabra);
        }
    }

    public static void hechosTexto() {
        //En cada metodo se comprueba si el CSV fue leido para no dar valores vacios
        if (Methods.metadata.isEmpty() == true) {
            System.out.println("Primero se debe leer el CSV, leyendo...");
            Methods.leerCSV();
        }
        System.out.println("___ (4) Buscar hechos importantes por texto ___ ");
        System.out.print("Ingrese el texto clave para buscar (Nota: el texto puede contener 2 o 3 palabras clave): ");
        String texto = scan.nextLine();
        if (texto != " ") {
             String[] cadenatexto = texto.split(" ");
            int contador = 0;
        /*
         Recorre el arreglo comparando la columna 2 (hechos) con el texto ingresado,
         es similar al metodo anterior solo que este recorre cada palabra del texto verificando
         que si se encuentre dentro de los hechos e imprime los que si coincidan con el texto
         */
            if (cadenatexto.length > 3) {
                System.out.println("Ingrese un texto valido!");
                System.out.print("Ingrese el texto clave para buscar (Nota: el texto puede contener 2 o 3 palabras clave): ");
                texto = scan.nextLine();
                cadenatexto = texto.split(" ");
            }
            for (int i = 1; i < Methods.metadata.size(); i++) {
                if (Methods.metadata.get(i)[1].isEmpty() == true) {
                    break;
                }
                if (cadenatexto.length == 2) {
                    if (Methods.metadata.get(i)[1].contains(cadenatexto[0]) == true && Methods.metadata.get(i)[1].contains(cadenatexto[1]) == true) {
                        System.out.print("En el año " + Methods.metadata.get(i)[0] + ":");
                        System.out.println(Methods.metadata.get(i)[1]);
                        contador++;
                    }
                } else if (cadenatexto.length == 3) {
                    if (Methods.metadata.get(i)[1].contains(cadenatexto[0]) == true && Methods.metadata.get(i)[1].contains(cadenatexto[1]) == true && Methods.metadata.get(i)[1].contains(cadenatexto[2]) == true) {
                        System.out.print("En el año " + Methods.metadata.get(i)[0] + ":");
                        System.out.println(Methods.metadata.get(i)[1]);
                        contador++;
                    }
                }
            }
            if (contador == 0 && cadenatexto.length != 1) {
                System.out.println("No se encontraron hechos con el texto: " + texto);
            } else {
                System.out.println("Se encontraron en total " + contador + " hechos con el texto: " + texto);
            }
        }
    }
}
