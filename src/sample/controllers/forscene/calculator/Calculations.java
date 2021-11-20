package sample.controllers.forscene.calculator;

import sample.controllers.ControllerAction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations extends ControllerAction {

    private static final BigDecimal CEN_IN_MET_SQ_CONVERT_FACTOR = BigDecimal.valueOf(10000);
    private static final int BOX_AREA_CONV_FACTOR = 100;

    public static final String ERROR_MESSAGE = "Не все поля заполнены!";

    protected String countLaminateInMeters(int length, int width) {
        BigDecimal bDLength = BigDecimal.valueOf(length);
        BigDecimal bDWidth = BigDecimal.valueOf(width);

        return (bDLength.multiply(bDWidth).divide(CEN_IN_MET_SQ_CONVERT_FACTOR,
                0, RoundingMode.CEILING)).toString();
    }

    protected String countLaminateInBoxes(int length, int width, int boxArea) {

        BigDecimal area = BigDecimal.valueOf(length * width);
        BigDecimal convertedBoxArea = BigDecimal.valueOf(boxArea*BOX_AREA_CONV_FACTOR);

        return (area.divide(convertedBoxArea, 0, RoundingMode.CEILING)).toString();
    }

}
