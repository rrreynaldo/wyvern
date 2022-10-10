package wyvern.stdlib.support;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import wyvern.target.corewyvernIL.expression.ObjectValue;

public class ObjectFX {
    public static final ObjectFX ofx = new ObjectFX();

    private static int idCounter = 1;

    private int id;
    private OFXType type;
    private String text;
    private boolean editable = false;
    private int translateXX = -1;
    private int translateYY = -1;
    private int width = -1;
    private int height = -1;
    private int binding = -1;
    private String textBinding;

    public ObjectFX() {
        this.id = idCounter;
        idCounter++;
    }

    public ObjectFX(int id, OFXType type, String text, boolean editable, int translateXX,
                    int translateYY, int width, int height, int binding, String strBinding) {
        this.id = id;
        this.type = type;
        this.text = text;
        this.editable = editable;
        this.translateXX = translateXX;
        this.translateYY = translateYY;
        this.width = width;
        this.height = height;
        this.binding = binding;
        this.textBinding = strBinding;
    }

    public int getId() {
        return id;
    }

    public OFXType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public boolean isEditable() {
        return editable;
    }

    public int getTranslateXX() {
        return translateXX;
    }

    public int getTranslateYY() {
        return translateYY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBinding() {
        return binding;
    }

    public String getTextBinding() {
        return textBinding;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(OFXType type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEditable(boolean editable) {
        if (this.type == OFXType.FIELD) {
            this.editable = editable;
        }
    }

    public void setTranslateXX(int translateXX) {
        this.translateXX = translateXX;
    }

    public void setTranslateYY(int translateYY) {
        this.translateYY = translateYY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBinding(int binding) {
        this.binding = binding;
    }

    public void setTextBinding(String textBinding) {
        this.textBinding = textBinding;
    }

    public Button createButton() {
        Button temp = new Button();
        // Setting the id of the button
        temp.setId(String.valueOf(id));
        if (text != null) {
            temp.setText(text);
        }

        if (translateXX != -1) {
            temp.setTranslateX(translateXX);
        }

        if (translateYY != -1) {
            temp.setTranslateY(translateYY);
        }

        if (width != -1) {
            temp.setMinWidth(width);
            temp.setMaxWidth(width);
        }

        if (height != -1) {
            temp.setMinHeight(height);
            temp.setMaxHeight(height);
        }
        return temp;
    }

    public Label createLabel() {
        Label temp = new Label();
        temp.setId(String.valueOf(id));
        if (text != null) {
            temp.setText(text);
        }

        if (translateXX != -1) {
            temp.setTranslateX(translateXX);
        }

        if (translateYY != -1) {
            temp.setTranslateY(translateYY);
        }

        if (width != -1) {
            temp.setMinWidth(width);
            temp.setMaxWidth(width);
        }

        if (height != -1) {
            temp.setMinHeight(height);
            temp.setMaxHeight(height);
        }
        return temp;
    }

    public TextField createField() {
        TextField temp = new TextField();
        temp.setId(String.valueOf(id));
        if (text != null) {
            temp.setText(text);
        }

        if (translateXX != -1) {
            temp.setTranslateX(translateXX);
        }

        if (translateYY != -1) {
            temp.setTranslateY(translateYY);
        }

        if (width != -1) {
            temp.setMinWidth(width);
            temp.setMaxWidth(width);
        }

        if (height != -1) {
            temp.setMinHeight(height);
            temp.setMaxHeight(height);
        }
        temp.setEditable(editable);
        return temp;
    }

    @Override
    public String toString() {
        return "ObjectFX{" +
                "id=" + id +
                ", type=" + type +
                ", text='" + text + '\'' +
                ", editable=" + editable +
                ", translateXX=" + translateXX +
                ", translateYY=" + translateYY +
                ", width=" + width +
                ", height=" + height +
                ", binding=" + binding +
                ", textBinding='" + textBinding + '\'' +
                '}';
    }
}
