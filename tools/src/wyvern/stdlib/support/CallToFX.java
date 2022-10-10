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
                if (obfx.getBinding() != -1) {
                    ObservableList<Node> objToFront = lay.getChildren();
                    for (Node sBinded : objToFront) {
                        if (Integer.parseInt(sBinded.getId()) == obfx.getBinding()) {
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

    public void goLaunch() {
        //objFXDebug();
        launch();
    }

    public void objFXDebug() {
        for (ObjectFX ofx : objectList) {
            System.out.println(ofx);
        }
    }

    public void bindButton(ObjectFX button, int target, String name) {
        button.setBinding(target);
        button.setTextBinding(name);
    }

    public void invokeWindow(String title, int width, int height) {
        setTitle(title);
        setSceneWidth(width);
        setSceneHeight(height);
    }

    public void invokeObject(int id, int objectType, String text, boolean editable,
                             int translateXX, int translateYY, int width, int height, int binding, String strBinding) {
        OFXType parseOFX = null;
        if (objectType == 1) {
            parseOFX = OFXType.LABEL;
        } else if (objectType == 2) {
            parseOFX = OFXType.FIELD;
        } else if (objectType == 3) {
            parseOFX = OFXType.BUTTON;
        }
        ObjectFX tempFX = new ObjectFX(id, parseOFX, text, editable, translateXX, translateYY,
                                        width, height, binding, strBinding);
        objectList.add(tempFX);
    }

    public int getIdCounter() {
        int cIdVal = idCounter;
        idCounter++;
        return cIdVal;
    }
}
