package string.sort.lsd;

import java.util.Arrays;

/**
 * @author liukai
 * @date 18-9-20
 */
public class LSDSortTest {

    public static void main(String[] args) {
        String a[] = {"4PGC938", "2IYE230", "3CIO720", "1ICK750",
                "1OHV845", "4JZY524", "1ICK750", "3CIO720",
                "1OHV845", "1OHV845", "2RLA629", "2RLA629",
                "3ATW723"};

        LSDSort s = new LSDSort();
        System.out.println(Arrays.toString(s.sort(a)));
    }

}