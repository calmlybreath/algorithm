package algs.offer;

/*
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
