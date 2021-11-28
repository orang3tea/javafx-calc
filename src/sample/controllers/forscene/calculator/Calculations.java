package sample.controllers.forscene.calculator;

import sample.controllers.ControllerAction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations extends ControllerAction {

    private static final BigDecimal CEN_IN_MET_SQ_CONVERT_FACTOR = BigDecimal.valueOf(10000);
    private static final int BOX_AREA_CONV_FACTOR = 100;
    private static final BigDecimal CEN_SQ_TO_MET_CUB = BigDecimal.valueOf(1000);
    public static final String ERROR_MESSAGE = "Не все поля заполнены!";

    private static final BigDecimal CONCRETE_PLASTER_DENSITY = BigDecimal.valueOf(1800);
    private static final BigDecimal GYPSUM_PLASTER_DENSITY = BigDecimal.valueOf(900);
    private static final BigDecimal START_PUTTY_DENSITY  = BigDecimal.valueOf(1200);
    private static final BigDecimal FINISH_PUTTY_DENSITY = BigDecimal.valueOf(800);



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

    protected String countMaterialsVolume(String wallsArea, String depth) {
        BigDecimal bDWallsArea = new BigDecimal(wallsArea);
        BigDecimal bDDepth = new BigDecimal(depth);
        return bDWallsArea.multiply(bDDepth).divide(CEN_SQ_TO_MET_CUB, 1, RoundingMode.CEILING).toString();
    }

    protected String countMaterialWeight(String volume, String material) {
        BigDecimal materialDensity = null;
        BigDecimal materialVolume = new BigDecimal(volume);
        switch (material) {
            case "цем-я штукатурка" -> materialDensity = CONCRETE_PLASTER_DENSITY;
            case "гипс-я штукатурка" -> materialDensity = GYPSUM_PLASTER_DENSITY;
            case "шпатлевка старт" -> materialDensity = START_PUTTY_DENSITY;
            case "шпатлевка финиш" -> materialDensity = FINISH_PUTTY_DENSITY;
        }
        assert materialDensity != null;
        return materialDensity.multiply(materialVolume).toString();
    }

    protected int countPackArea(int length, int width) {
        return length*width;
    }

}
