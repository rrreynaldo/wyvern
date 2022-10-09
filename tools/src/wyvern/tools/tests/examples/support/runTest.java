package wyvern.tools.tests.examples.support;

import wyvern.stdlib.support.CallToFX;

import wyvern.stdlib.support.OFXType;
import wyvern.stdlib.support.ObjectFX;

public class runTest {

    static CallToFX cfx = CallToFX.cfx;
    static ObjectFX ofx = ObjectFX.ofx;

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
    }

    public static void test1() {
        ObjectFX label = new ObjectFX();
        label.setType(OFXType.LABEL);
        label.setText("1");
        label.setTranslateYY(-30);
        label.setTranslateXX(-100);
        label.setWidth(150);
        label.setHeight(20);
        label.setEditable(false);
        cfx.addObjectFX(label);

        ObjectFX field = new ObjectFX();
        field.setType(OFXType.FIELD);
        field.setText("2");
        field.setTranslateYY(-30);
        field.setTranslateXX(150);
        field.setWidth(150);
        field.setHeight(20);
        field.setEditable(false);
        cfx.addObjectFX(field);

        ObjectFX button1 = new ObjectFX();
        button1.setType(OFXType.BUTTON);
        button1.setText("Change1");
        button1.setTranslateXX(-100);
        button1.setEditable(false);

        cfx.addObjectFX(button1);

        ObjectFX button2 = new ObjectFX();
        button2.setType(OFXType.BUTTON);
        button2.setText("Change2");
        button2.setTranslateXX(150);
        button2.setEditable(false);
        cfx.addObjectFX(button2);

        cfx.bindButton(button1, label, "Text From Button Click");
        cfx.bindButton(button2, field, "Change some text");

        cfx.invoke("Window 1", 500, 250);
    }
}
