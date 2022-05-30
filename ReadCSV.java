import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList <String[]> metadata = new ArrayList<String[]>();
    public static void leerCSV(){
        try {
            // Se usa el bufferReader para leer el archivo linea por linea
            BufferedReader reader = new BufferedReader(new FileReader("data1.csv"));
            //Se quita la primera linea del CSV para que no de fallos
            String dato = reader.readLine();
            while ((dato = reader.readLine()) != null) {
                String[] parts = dato.split(":");
                ReadCSV.metadata.add(parts);
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void hechosAños() {
        System.out.println("___ (2) Buscar hechos importantes por año ___ ");
        boolean found = false;
        int totalParts = ReadCSV.metadata.size();
        String dato = scan.next();
        dato.toString();
        System.out.println("Datos del año " + dato + ":");
        for (int i = 0; i < totalParts; i++) {
            if (dato.compareTo(ReadCSV.metadata.get(i)[0]) == 0) {
                System.out.println(ReadCSV.metadata.get(i)[1]);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("!!!Dato no encontrado, regresando!");
        }
    }
    public static void hechosPalabra() {
        System.out.println("___ (3) Buscar hechos importantes por palabra ___ ");
        System.out.print("Ingrese la palabra clave para buscar:");
        String palabra = scan.next();
        System.out.println("Los hechos importantes con la palabra " + palabra + " son: ");
        int contador = 0;
        //usar el ignorecase
        for (int i = 1; i < ReadCSV.metadata.size(); i++) {
            if (ReadCSV.metadata.get(i)[1].contains(palabra) == true) {
                System.out.print("En el año " + ReadCSV.metadata.get(i)[0] + ":");
                System.out.println(ReadCSV.metadata.get(i)[1]);
                contador ++;
            }
        }
        if (contador == 0){
            System.out.println("No se encontraron hechos con la palabra "+ palabra);
        }
    }
    public static void hechosTexto(){
        System.out.println("___ (4) Buscar hechos importantes por texto ___ ");
        System.out.print("Ingrese el texto clave para buscar:");
        String texto = scan.next();

    }
}

