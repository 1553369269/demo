package algorithmAndDataStructure.trueQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-09 20:18
 **/
public class AbbreviationCheck {

    public static void main(String[] args) {
        System.out.println(valid("internationalization","i12iz4n"));
    }

    public static boolean valid(String word, String abbr) {
        if (abbr == null || abbr.isEmpty()) return false;
        int point = -1; // 用来存储abbr中部署数组的字符在word中的下标
        int num = 0; // 用来得到数字
        for (int i = 0; i < abbr.length(); i++) {
            char ch = abbr.charAt(i);
            //判断是否是数字
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                point = point + num + 1;
                num = 0; // 数字的下一位不是数字，数字重新开始取
                // 先判断长度， 再判断当前位置的字符是否相同
                if (point > word.length() - 1 || ch != word.charAt(point)) {
                    return false;
                }
            }
        }
        // 结尾是数字
        if (num > 0) {
            point = point + num;
        }
        return point == word.length() - 1;
    }
}
