import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by David Derichs on 28.01.2018.
 */
public class JavaFXElementeUeberblick extends Application{

    Paint color = Paint.valueOf("white");

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("JavaFX-Elemente-Ueberblick");
        AnchorPane root = FXMLLoader.load(getClass().getResource("javafxElementeUeberblick.fxml"));

        Circle circle = new Circle();
        circle.setCenterX(50.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(25.0f);
        circle.setFill(Paint.valueOf("white"));
        circle.setStroke(Paint.valueOf("black"));

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                50.0, 200.0,
                75.0, 250.0,
                25.0, 250.0});
        polygon.setStroke(Paint.valueOf("black"));
        polygon.setFill(Paint.valueOf("white"));

        Line line = new Line();
        line.setStartX(25.0f);
        line.setStartY(300.0f);
        line.setEndX(75.0f);
        line.setEndY(300.0f);

        Rectangle rectangle = new Rectangle(50, 25, Color.BLACK);
        rectangle.setX(25);
        rectangle.setY(350);
        rectangle.setFill(color);
        rectangle.setStroke(Paint.valueOf("black"));

        Button btn = new Button("ok");
        btn.setLayoutX(450);
        btn.setLayoutY(25);
        btn.setMinWidth(25);
        btn.setMinHeight(10);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circle.setFill(color);
                polygon.setFill(color);
                line.setStroke(color);
                rectangle.setFill(color);
                if (color.equals(Paint.valueOf("white"))) {
                    line.setStroke(Paint.valueOf("black"));
                }
            }
        });

        Label label = new Label("Switch to selected Color");
        label.setLayoutX(300);
        label.setLayoutY(25);
        label.setMinWidth(25);

        MenuBar menuBar = new MenuBar();
        menuBar.setMinWidth(300);
        Menu menu = new Menu();
        menu.setText("Color");

        ToggleGroup radioGroup = new ToggleGroup();

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                try {
                    RadioMenuItem rmi = (RadioMenuItem) newValue;
                    color = Paint.valueOf(rmi.getText());
                } catch (NullPointerException e) {
                }
            }
        });

        RadioMenuItem white = new RadioMenuItem();
        white.setText("white");
        white.setToggleGroup(radioGroup);

        RadioMenuItem black = new RadioMenuItem();
        black.setText("black");
        black.setToggleGroup(radioGroup);

        RadioMenuItem red = new RadioMenuItem();
        red.setText("red");
        red.setToggleGroup(radioGroup);

        menu.getItems().add(white);
        menu.getItems().add(black);
        menu.getItems().add(red);
        menuBar.getMenus().add(menu);

        root.getChildren().add(circle);
        root.getChildren().add(polygon);
        root.getChildren().add(line);
        root.getChildren().add(btn);
        root.getChildren().add(label);
        root.getChildren().add(menuBar);
        root.getChildren().addAll(rectangle);

        Scene scene = new Scene(root, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
