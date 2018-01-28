import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by David Derichs on 27.01.2018.
 */

public class Aufgabe04Dateizugriff {

    public static void main(String[] args){
        // IOException bei Datei-Zugriffen eventuell mitbeachten (Denke das ist optional).
        try {
            // Datei einlesen Pfad und Modus (lesen, schreiben, beides)
            RandomAccessFile file = new RandomAccessFile("src/textdatei.txt", "r");
            int zeile = 1;
            int numberofspaces = 0;
            // Zeile einlesen:
            String line = file.readLine();

            // Wenn Zeile eingelesen, ist diese null, wenn das Ende der Datei erreicht ist.
            // Deshalb Prüfung auf null.
            while (line!=null){

                // Leerzeichen erfassen.
                // line.charAt(index) gibt true zurück, wenn Zeichen gefunden.
                // ACHTUNG: ' ' verwenden, damit es auch wirklich ein Char ist. AUF KEINEN FALL " " - Das wäre ein String.
                for (int i=0; i<line.length(); i++){
                    if (line.charAt(i)==' ')numberofspaces++;
                }

                // String.format Erklärung:
                // String.format("......", parameter1, parameter 2 ...)
                // "......" : Enthält den String, den man ausgeben will. Man kann da erst einmal alles reinschreiben.
                // Will man die Werte aus den übergebenen Parametern an eine bestimmte Stelle schreiben, dann nutzt man
                // den %-Operator. Dieser ersetzt sich selbst durch den Wert des jeweiligen Parameters.
                // Dabei muss man schauen, der wievielte Parameter es ist.
                // Also der erste %-Operator nimmt den wert des ersten übergebenen Parameters an.
                // WICHTIG: Für verschiedene Typen bei den Übergabe-Parametern gibts auch verschiedene %-Operatoren.
                //          %f - Float
                //          %d - Dezimal (Integer)
                //          %s - String
                //          %4s - Die 4 Steht für die Mindestlaenge, Falls der Parameter zu klein ist wird mit Leerzeichen am Anfang aufgefüllt. Wie im CSS (Float: right)
                //          %-4s - Dasselbe, nur das Die Leerzeichen am Ende aufgefüllt werden. Wie im CSS (Float: left)
                String out = String.format("Zeile: %-2d   Inhalt: %s   Laenge: %d   Leerzeichen: %d%n", zeile, line, line.length(), numberofspaces);
                System.out.print(out);

                // WICHTIG: Parameter für den nächsten Schleifen-Durchlauf anpassen :)
                line = file.readLine();
                numberofspaces = 0;
                zeile++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
