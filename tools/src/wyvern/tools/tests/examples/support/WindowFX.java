package wyvern.tools.tests.examples.support;

public class WindowFX {

    public static WindowFX wfx = new WindowFX();

    // Singleton design still not possible
    // Error object NULL
    public static WindowFX getInstance() {
        if (wfx == null) {
            wfx = new WindowFX();
            return wfx;
        }
        return wfx;
    }

    public void addButton() {
        CallToFX.addButton();
    }

    public void addButton(String name) {
        CallToFX.addButton(name);
    }

    public void addButton(String name, double xx, double yy) {
        CallToFX.addButton(name, xx, yy);
    }

    public void addLabel() {
        CallToFX.addLabel();
    }

    public void addLabel(String name) {
        CallToFX.addLabel(name);
    }

    public void addLabel(String name, double xx, double yy) {
        CallToFX.addLabel(name, xx, yy);
    }

    public void setTitle(String title) {
        CallToFX.setTitle(title);
    }

    public void setSceneHeight(double height) {
        CallToFX.setSceneHeight(height);
    }

    public void setSceneWidth(double width) {
        CallToFX.setSceneWidth(width);
    }

    public void setSceneSize(double width, double height) {
        CallToFX.setSceneSize(width, height);
    }

    public void goRun() {
        CallToFX.goRun();
    }
}
