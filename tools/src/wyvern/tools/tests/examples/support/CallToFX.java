package wyvern.tools.tests.examples.support;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CallToFX extends Application {

    public static final CallToFX cfx = new CallToFX();
    private static Boolean cButton = false;
    private static String textButton = "Default button";
    private static double buttonXX = -1;
    private static double buttonYY = -1;
    private static Boolean cLabel = false;
    private static String textLabel = "Default label";
    private static double labelX = -1;
    private static double labelY = -1;

    private static String stageTitle = "";
    private static double sceneHeight = 250;
    private static double sceneWidth = 500;

    @Override
    public void start(Stage stage) throws IOException {
        StackPane lay = new StackPane();

        if (cButton) {
            Button button = new Button();
            button.setText(textButton);

            if (buttonXX != -1) {
                button.setTranslateX(buttonXX);
            }
            if (buttonYY != -1) {
                button.setTranslateY(buttonYY);
            }

            lay.getChildren().add(button);
        }

        if (cLabel) {
            Label label = new Label();
            label.setText(textLabel);

            if (labelX != -1) {
                label.setTranslateX(labelX);
            }
            if (labelY != -1) {
                label.setTranslateY(labelY);
            }

            lay.getChildren().add(label);
        }

        Scene scene = new Scene(lay, sceneWidth, sceneHeight);

        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
    }

    public static void goRun() {
        launch();
    }

    public static void addButton() {
        cButton = true;
    }

    public static void addButton(String name) {
        textButton = name;
        addButton();
    }

    public static void addButton(String name, double xx, double yy) {
        buttonXX = xx;
        buttonYY = yy;
        addButton(name);
    }

    public static void addLabel() {
        cLabel = true;
    }

    public static void addLabel(String name) {
        textLabel = name;
        addLabel();
    }

    public static void addLabel(String name, double xx, double yy) {
        labelX = xx;
        labelY = yy;
        addLabel(name);
    }

    public static void setTitle(String title) {
        stageTitle = title;
    }

    public static void setSceneHeight(double height) {
        sceneHeight = height;
    }

    public static void setSceneWidth(double width) {
        sceneWidth = width;
    }

    public static void setSceneSize(double width, double height) {
        sceneHeight = height;
        sceneWidth = width;
    }
}
