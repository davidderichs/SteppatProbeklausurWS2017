import java.util.HashMap;
import java.util.Map;

/**
 * Created by David Derichs on 27.01.2018.
 */

class Buch {
    public int id;
    public String verfasser;
    public String signatur;
}

/***
 * Buchregister speichert obere Klasse Buch als Datensatz in HashMap.
 */
public class Aufgabe03Buchregister{

    Map<String, Buch> buecherListe = new HashMap();

    public Buch sucheBuch(String titel){
        return buecherListe.get(titel);
    }

    public void gibAlleDatenAus(){
        for (Map.Entry<String,Buch> eintrag : buecherListe.entrySet()){
            String titel = eintrag.getKey();
            Buch buch = eintrag.getValue();
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
            String output = String.format("%-10s -> [ ID: %-2d, Verfasser: %-15s, Signatur: %-15s ]%n",
                    titel,
                    buch.id,
                    buch.verfasser,
                    buch.signatur
                    );
            System.out.print(output);
        }
    }

    /*** NICHT IN DER KLAUSUR:
     * Test-Methode. Gehört später nicht zur Antwort in der Klausur.
     * @param args
     */
    public static void main (String[] args){
        Aufgabe03Buchregister register = new Aufgabe03Buchregister();
        Buch buch = new Buch();
        buch.id = 1;
        buch.verfasser = "Verfasser1";
        buch.signatur = "Signatur1";
        String titel = "Titel1";
        register.buecherListe.put(titel, buch);

        buch = new Buch();
        buch.id = 2;
        buch.verfasser = "Verfasser2";
        buch.signatur = "Signatur2";
        titel = "Titel2";
        register.buecherListe.put(titel, buch);

        buch = new Buch();
        buch.id = 11;
        buch.verfasser = "Verfasser11";
        buch.signatur = "Signatur11";
        titel = "Titel11";
        register.buecherListe.put(titel, buch);

        register.gibAlleDatenAus();
        System.out.println("Gesuchtes Buch Titel1 Signatur:" + register.sucheBuch("Titel1").signatur);
    }
}
