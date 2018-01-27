import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by David Derichs on 27.01.2018.
 */
public class Aufgabe02Messlatte extends Application{

    private Group root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("mein Programm");
        // Root-Element ist eine Group
        root = new Group();
        // Rechtecke werden gezeichnet.
        zeichneRechtecke(50, Color.WHITE);
        // Scene wird mit Group initialisiert.
        Scene scene = new Scene(root, 800, 600);
        // Scene wird an die Stage übergeben.
        primaryStage.setScene(scene);
        // Stage wird angezeigt.
        primaryStage.show();
    }

    /**
     * Zeichnet Rechtecke rekursiv.
     * Bricht bei x>550px ab.
     * @param x Koordinate
     * @param color Farbe des Rechtecks
     */
    public void zeichneRechtecke(int x, Color color){
        if (x>550) return;

        // Farbe ändern:
        if (color == Color.WHITE) color = Color.BLACK;
        else color = Color.WHITE;

        // Rechteck zeichnen:
        // Rectangle(int breite, int laenge, Color fuellFarbe)
        Rectangle rectangle = new Rectangle(15, 5, color);
        // X-Koordinate angeben
        rectangle.setX(x);
        // y-Koordinate angeben (Da waagerecht, hier immer 50px)
        rectangle.setY(50);
        // Zur Group hinzufuegen
        root.getChildren().add(rectangle);
        // Position verändern und Rekursion fortsetzen
        zeichneRechtecke(15+x, color);
    }
}
