package algs.other;

/**
 * The type Hex oct.
 */
public class HexOct {
    /**
     * 十进制转二进制
     *
     * @param number the number
     * @return the string
     */
    public static String oct2Bin(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(number % 2);
            number = number / 2;
        }
        while (number != 0);
        return stringBuilder.reverse().toString();
    }

    /**
     * 十进制转任意进制
     *
     * @param hex    the hex
     * @param number the number
     * @return the string
     */
    public static String commonTransform(int hex, int number) {
        if (hex == 1) {
            return Integer.toString(number);
        }
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(number % hex);
            number = number / hex;
        } while (number != 0);
        
        return stringBuilder.reverse().toString();
    }
}
