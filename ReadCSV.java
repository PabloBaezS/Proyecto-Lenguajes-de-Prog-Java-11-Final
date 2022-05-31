import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
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
                dato = dato.toLowerCase(Locale.ROOT);
                dato = dato.replace(";;", " ");
                String[] parts = dato.split(":");
                ReadCSV.metadata.add(parts);
                }
            System.out.println("CSV leido con exito, ya puede ser usado!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void hechosAños() {
        if(ReadCSV.metadata.isEmpty() == true){
            System.out.println("Primero se debe leer el CSV, leyendo...");
            ReadCSV.leerCSV();
        }
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
            System.out.println("!!!Datos con el año no encontrados, regresando!");
        }
    }
    public static void hechosPalabra() {
        if(ReadCSV.metadata.isEmpty() == true){
            System.out.println("Primero se debe leer el CSV, leyendo...");
            ReadCSV.leerCSV();
        }
        System.out.println("___ (3) Buscar hechos importantes por palabra ___ ");
        System.out.print("Ingrese la palabra clave para buscar:");
        String palabra = scan.nextLine();
        System.out.println("Los hechos importantes con la palabra " + palabra + " son: ");
        int contador = 0;
        for (int i = 1; i < ReadCSV.metadata.size(); i++) {
            if(ReadCSV.metadata.get(i)[1].isEmpty() == true){
                break;
            }
            if (ReadCSV.metadata.get(i)[1].contains(palabra) == true) {
                System.out.print("En el año " + ReadCSV.metadata.get(i)[0] + ":");
                System.out.println(ReadCSV.metadata.get(i)[1]);
                contador ++;
            }
        }
        if (contador == 0){
            System.out.println("No se encontraron hechos con la palabra "+ palabra);
        }else{
            System.out.println("Se encontraron en total "+ contador + " hechos con la palabra " +palabra);
        }
    }
    public static void hechosTexto(){
        if(ReadCSV.metadata.isEmpty() == true){
            System.out.println("Primero se debe leer el CSV, leyendo...");
            ReadCSV.leerCSV();
        }
        System.out.println("___ (4) Buscar hechos importantes por texto ___ ");
        System.out.print("Ingrese el texto clave para buscar:");
        String texto = scan.nextLine();
        String[] cadenatexto = texto.split(" ");
        int contador = 0;
        for (int i = 1; i < ReadCSV.metadata.size(); i++) {
            if(ReadCSV.metadata.get(i)[1].isEmpty() == true){
                break;
            }
            if (ReadCSV.metadata.get(i)[1].contains(cadenatexto[0]) == true && ReadCSV.metadata.get(i)[1].contains(cadenatexto[1]) == true) {
                System.out.print("En el año " + ReadCSV.metadata.get(i)[0] + ":");
                System.out.println(ReadCSV.metadata.get(i)[1]);
                contador ++;
            }
        }
        if (contador == 0){
            System.out.println("No se encontraron hechos con el texto: "+ texto);
        }else{
            System.out.println("Se encontraron en total "+ contador + " hechos con el texto: " +texto);
        }
    }
}
