package string;

/**
 * @author liukai
 * @date 2020-04-12
 */
public class KMP {

    /**
     * 判断目标字符串 s 是否包含模式字符串 p
     *
     * @param s 目标字符串
     * @param p 模式字符串
     *
     * @return s 是否包含 p
     */
    public static boolean kmp(String s, String p) {
        int[] next = pmt(p);

        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        return j == p.length();
    }


    /**
     * 计算字符串 p 的部分匹配表（Partial Match Table）
     *
     * @return 存储部分匹配表的数组
     */
    public static int[] pmt(String p) {
        int len = p.length();
        int[] pmt = new int[len];
        pmt[0] = -1;

        int i = 0, j = -1;
        while (i < len) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
                pmt[i] = j;
            } else {
                j = pmt[j];
            }
        }
        return pmt;
    }

}
