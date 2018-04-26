package algs.other;

public class HexOct {
    public static String oct2Bin(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(number % 2);
            number = number / 2;
        }
        while (number != 0);
        return stringBuilder.reverse().toString();
    }

    public static String commonTransform(int hex, int number) {
        if (hex == 1) {
            return Integer.toString(number);
        }
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(number % hex);
            number = number / hex;
        }
        while (number != 0);
        return stringBuilder.reverse().toString();
    }
}
