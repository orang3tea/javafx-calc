package sample.controllers.forscene.calculator;

import sample.controllers.ControllerAction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations extends ControllerAction {

    private static final BigDecimal CEN_IN_MET_SQ_CONVERT_FACTOR = BigDecimal.valueOf(10000);
    private static final int BOX_AREA_CONV_FACTOR = 100;
    private static final BigDecimal CEN_SQ_TO_MET_CUB = BigDecimal.valueOf(1000);
    public static final String ERROR_MESSAGE = "Не все поля заполнены!";



    private static final BigDecimal PUTTU_CONSUMPTION = new BigDecimal("1000.0");
    private static final BigDecimal CONCRETE_PLASTER_CONSUMPTION = new BigDecimal("1700");
    private static final BigDecimal GYPSUM_PLASTER_CONSUMPTION = new BigDecimal("1100");
    private static final BigDecimal FLOOR_CONCRETE_CONSUMPTION = new BigDecimal("1980");
    private static final BigDecimal CONCRETE_PROPORTION_IN_MIX = new BigDecimal("0.33");
    private static final BigDecimal SAND_PROPORTION_IN_MIX = new BigDecimal("0.67");



    protected String countFloorArea(int length, int width) {
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

    protected String countMaterialsVolume(String surfaceArea, String depth) {
        BigDecimal bDWallsArea = new BigDecimal(surfaceArea);
        BigDecimal bDDepth = new BigDecimal(depth);

        return bDWallsArea.multiply(bDDepth).divide(CEN_SQ_TO_MET_CUB, 2, RoundingMode.CEILING).toString();
    }

    protected String countMaterialPack(String volume, String material, String packMass) {
        BigDecimal materialConsumption = null;
        BigDecimal materialVolume = new BigDecimal(volume);
        BigDecimal bDPackMass = new BigDecimal(packMass);

        switch (material) {
            case "цем-я штукатурка" -> materialConsumption = CONCRETE_PLASTER_CONSUMPTION;
            case "гипс-я штукатурка" -> materialConsumption = GYPSUM_PLASTER_CONSUMPTION;
            case "шпатлевка" -> materialConsumption = PUTTU_CONSUMPTION;

        }
        assert materialConsumption != null;
        return materialConsumption.multiply(materialVolume).divide(bDPackMass, 0, RoundingMode.CEILING).toString();
    }

    protected String[] countMaterialPack(String volume, String packMass) {

        String[] sandAndConcreteResults = new String[2];

        BigDecimal materialVolume = new BigDecimal(volume);
        BigDecimal bDPackMass = new BigDecimal(packMass);
        BigDecimal materialMass = (materialVolume.multiply(FLOOR_CONCRETE_CONSUMPTION));

        sandAndConcreteResults[0] = materialMass.multiply(CONCRETE_PROPORTION_IN_MIX).
                divide(bDPackMass,0,RoundingMode.CEILING).toString();
        sandAndConcreteResults[1] = materialMass.multiply(SAND_PROPORTION_IN_MIX)
                .setScale(0,RoundingMode.CEILING).toString();

        return sandAndConcreteResults;
    }

    protected int countPackArea(int length, int width) {
        return length*width;
    }

}
