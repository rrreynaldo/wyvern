package wyvern.stdlib.support;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import wyvern.target.corewyvernIL.expression.ObjectValue;
import wyvern.target.corewyvernIL.expression.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CallToFX extends Application {

    public static final CallToFX cfx = new CallToFX();

    private static ArrayList<ObjectFX> objectList = new ArrayList<>();
    private static int idCounter = 1;

    private static String stageTitle = "";
    private static int sceneHeight = 250;
    private static int sceneWidth = 500;

    @Override
    public void start(Stage stage) throws IOException {
        StackPane lay = new StackPane();

        for (ObjectFX obfx : objectList) {
            if (obfx.getType() == OFXType.BUTTON) {
                Button button = obfx.createButton();
                if (obfx.getBinding() != null) {
                    ObservableList<Node> objToFront = lay.getChildren();
                    for (Node sBinded : objToFront) {
                        if (Integer.parseInt(sBinded.getId()) == obfx.getBinding().getId()) {
                            if (sBinded.getStyleClass().contains("label")) {
                                Label lbl = (Label) sBinded;
                                button.setOnMouseClicked((event) -> {
                                    lbl.setText(obfx.getTextBinding());
                                });
                            } else if (sBinded.getStyleClass().contains("text-field")) {
                                TextField lbl = (TextField) sBinded;
                                button.setOnMouseClicked((event) -> {
                                    lbl.setText(obfx.getTextBinding());
                                });
                            }
                            break;
                        }
                    }
                }
                lay.getChildren().add(button);
            }
            else if (obfx.getType() == OFXType.LABEL) {
                Label lbl = obfx.createLabel();
                lay.getChildren().add(lbl);
            }
            else if (obfx.getType() == OFXType.FIELD) {
                TextField lbl = obfx.createField();
                lay.getChildren().add(lbl);
            }
        }

        Scene scene = new Scene(lay, sceneWidth, sceneHeight);

        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
    }

    public void setTitle(String title) {
        stageTitle = title;
    }

    public void setSceneHeight(int height) {
        sceneHeight = height;
    }

    public void setSceneWidth(int width) {
        sceneWidth = width;
    }

    public void addObjectFX(Object obj) {
        System.out.println("SUCCESSS");
        System.out.println(obj);;
        ObjectFX ofx = (ObjectFX) obj;
        System.out.println("SUCCESS");
        System.out.println(ofx.getText());
        System.out.println(ofx.getId());
        System.out.println(ofx.getTranslateXX());
        objectList.add(ofx);
    }

    public void invoke(String title, int width, int height) {
        setSceneHeight(height);
        setSceneWidth(width);
        setTitle(title);
        launch();
    }

    public void goRun() {
        launch();
    }

    public void testParsingAL(ArrayList<ObjectFX> val) {
        ArrayList<ObjectFX> testVal = val;
        System.out.println("WENT HERERERERERE");
        System.out.println(testVal);
        return;
    }

    public void bindButton(ObjectFX button, ObjectFX target, String name) {
        button.setBinding(target);
        button.setTextBinding(name);
    }
}
