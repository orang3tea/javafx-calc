package sample.controllers.forscene.calculator;

import sample.controllers.ControllerAction;

public class Calculations extends ControllerAction {

    public static final String ERROR_MESSAGE = "Не все поля заполнены!";

    protected String countLaminateInMeters(int length, int width) {
        return (float)(length * width ) / 10000 + "";
    }

    protected String countLaminateInBoxes(int length, int width, int boxArea) {
        return (float)(length * width ) / 10000 / boxArea + "";
    }

}
