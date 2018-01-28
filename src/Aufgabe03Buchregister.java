import java.util.HashMap;
import java.util.Map;

/***
 * Buchregister speichert obere Klasse Buch als Datensatz in HashMap.
 */
public class Aufgabe03Buchregister{

    private Map<Integer, Buch> buecherListe = new HashMap();

    public Buch sucheBuch(int id){
        return buecherListe.get(id);
    }

    public void add(Buch buch){
        this.buecherListe.put(buch.id, buch);
    }

    public int size(){
        return this.buecherListe.size();
    }

    public void gibAlleDatenAus(){
        for (Map.Entry<Integer,Buch> eintrag : buecherListe.entrySet()){
            int id = eintrag.getKey();
            Buch buch = eintrag.getValue();
            // String.format Erkl�rung:
            // String.format("......", parameter1, parameter 2 ...)
            // "......" : Enth�lt den String, den man ausgeben will. Man kann da erst einmal alles reinschreiben.
            // Will man die Werte aus den �bergebenen Parametern an eine bestimmte Stelle schreiben, dann nutzt man
            // den %-Operator. Dieser ersetzt sich selbst durch den Wert des jeweiligen Parameters.
            // Dabei muss man schauen, der wievielte Parameter es ist.
            // Also der erste %-Operator nimmt den wert des ersten �bergebenen Parameters an.
            // WICHTIG: F�r verschiedene Typen bei den �bergabe-Parametern gibts auch verschiedene %-Operatoren.
            //          %f - Float
            //          %d - Dezimal (Integer)
            //          %s - String
            //          %4s - Die 4 Steht f�r die Mindestlaenge, Falls der Parameter zu klein ist wird mit Leerzeichen am Anfang aufgef�llt. Wie im CSS (Float: right)
            //          %-4s - Dasselbe, nur das Die Leerzeichen am Ende aufgef�llt werden. Wie im CSS (Float: left)
            String output = String.format("%-10s -> [ ID: %-2d, Verfasser: %-15s, Signatur: %-15s ]%n",
                    id,
                    buch.verfasser,
                    buch.signatur
                    );
            System.out.print(output);
        }
    }
}
