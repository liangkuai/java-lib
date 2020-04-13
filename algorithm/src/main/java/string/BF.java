package string;

/**
 * 基于 Brute force 算法
 *
 * @author liukai
 * @date 2020-04-13
 */
public class BF {

    /**
     * 判断主串 str 中是否包含模式串 pattern
     *
     * @param str 主串
     * @param pattern 模式串
     *
     * @return true/false
     */
    public static boolean contain(String str, String pattern) {
        char[] s = str.toCharArray(), p = pattern.toCharArray();
        int lens = s.length, lenp = p.length;

        // 只需要对主串中的前 lens - lenp + 1 个字符进行匹配
        for (int i = 0; i <= lens - lenp; i++) {
            // 模式串每轮都从头开始匹配
            int j = 0;
            while (j < lenp) {
                // 失配直接开始下一轮
                if (s[i + j] != p[j]) break;
                j++;
            }
            // 模式串全部匹配，直接返回
            if (j == lenp) return true;
        }
        return false;
    }

}
