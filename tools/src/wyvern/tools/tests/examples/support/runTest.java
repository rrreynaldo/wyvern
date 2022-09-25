package wyvern.tools.tests.examples.support;

import static wyvern.tools.tests.examples.support.WindowFX.wfx;

public class runTest {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        wfx.addButton();
        wfx.goRun();
    }

    public static void test2() {
        wfx.addButton("A BUTTON NAME HERE");
        wfx.addLabel("HI I AM A LABEL", 0, -100);
        wfx.setTitle("THIS TITLE SHOULD APPEAR ON TOP");
        wfx.goRun();

    }

    public static void test3() {
        wfx.addButton("CLICK ME", 50, 0);
        wfx.setTitle("SOME TEXT FOR THE TITLE HERE");
        wfx.addLabel("NEW LABEL HERE", 10, -100);
        wfx.setSceneWidth(750);
        wfx.setSceneHeight(750);
        wfx.goRun();
    }
}
