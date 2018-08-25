public class Convertor {


    public static double convertFromMetersToCm(double m) {
        return m * 100;
    }

    public static double convertFromMetersToMm(double m) {
        return m * 1000;
    }

    public static double convertFromCMetersToMm(double cm) {
        return cm * 10;
    }

    public static double convertFromCMetersToM(double cm) {
        return cm / 100;
    }

    public static double convertFromMMetersToM(double mm) {
        return mm / 1000;
    }

    public static double convertFromMMetersToCm(double mm) {
        return mm / 10;
    }

    public static double convertFromKgToGrams(double kg) {
        return kg * 1000;
    }

    public static double convertFromKgToMg(double kg) {
        return kg * 1000000;
    }

    public static double convertFromMgToKg(double mg) {
        return mg / 1000000;
    }

    public static double convertFromMgToGrams(double mg) {
        return mg / 1000;
    }

    public static double convertFromGramsToKg(double g) {
        return g / 1000;
    }

    public static double convertFromGramsToMg(double g) {
        return g * 1000;
    }
}
