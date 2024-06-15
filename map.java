import java.util.Map;

class ResistorColorTrio {
    String label(String[] colors) {
        if(colors.length < 3) {
            throw new IllegalArgumentException("At least three colors are required");
        }

        Map<String, Integer> colorCodeMap = Map.of(
            "black", 0,
            "brown", 1,
            "red", 2,
            "orange", 3,
            "yellow", 4,
            "green", 5,
            "blue", 6,
            "violet", 7,
            "grey", 8,
            "white", 9
        );

        int firstDigit = colorCodeMap.getOrDefault(colors[0], -1);
        int secondDigit = colorCodeMap.getOrDefault(colors[1], -1);
        int multiplier = colorCodeMap.getOrDefault(colors[2], -1);

        if(firstDigit == -1 || secondDigit == -1 || multiplier == -1) {
            throw new IllegalArgumentException("Unknown color");
        }

        int baseValue = firstDigit * 10 + secondDigit;

        long resistanceValue = baseValue * (long)Math.pow(10,multiplier);

        String unit;

        if(resistanceValue >= 1_000_000_000) {
            unit = " gigaohms";
            resistanceValue /= 1_000_000_000;
        } else if(resistanceValue >= 1_000_000) {
            unit = " megaohms";
            resistanceValue /= 1_000_000;
        } else if(resistanceValue >= 1_000) {
            unit = " kiloohms";
            resistanceValue /= 1_000;
        } else {
            unit = " ohms";
        }

        return resistanceValue + unit;

    }
}
