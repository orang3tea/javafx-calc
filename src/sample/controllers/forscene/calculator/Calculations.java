package sample.controllers.forscene.calculator;

import sample.controllers.ControllerAction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations extends ControllerAction {

    private static final BigDecimal CEN_IN_MET_SQ_CONVERT_FACTOR = BigDecimal.valueOf(10000);
    private static final int BOX_AREA_CONV_FACTOR = 100;
    public static final String ERROR_MESSAGE = "Не все поля заполнены!";


    protected String countInMeters(int length, int width) {
        BigDecimal bDLength = BigDecimal.valueOf(length);
        BigDecimal bDWidth = BigDecimal.valueOf(width);

        return (bDLength.multiply(bDWidth).divide(CEN_IN_MET_SQ_CONVERT_FACTOR,
                0, RoundingMode.CEILING)).toString();
    }

    protected String countInPacks(int length, int width, int boxArea) {

        BigDecimal area = BigDecimal.valueOf(length * width);
        BigDecimal convertedBoxArea = BigDecimal.valueOf(boxArea*BOX_AREA_CONV_FACTOR);

        return (area.divide(convertedBoxArea, 0, RoundingMode.CEILING)).toString();
    }

    protected String wallsArea(int length, int width, int height) {

        BigDecimal bDLength = BigDecimal.valueOf(length);
        BigDecimal bDWidth = BigDecimal.valueOf(width);
        BigDecimal bDHeight = BigDecimal.valueOf(height);

        return ((bDLength.multiply(bDHeight).add(bDWidth.multiply(bDHeight))).multiply(BigDecimal.valueOf(2))
                .divide(CEN_IN_MET_SQ_CONVERT_FACTOR, 0, RoundingMode.CEILING)).toString();

    }

    protected String countTubes(String wallsArea, int packArea) {
        BigDecimal bDWallsArea = new BigDecimal(wallsArea);
        BigDecimal bDPackArea = BigDecimal.valueOf(packArea);

        return bDWallsArea.multiply(CEN_IN_MET_SQ_CONVERT_FACTOR).divide(bDPackArea, 0, RoundingMode.CEILING)
                .toString();
    }

    protected int countPackArea(int length, int width) {
        return length*width;
    }

}
