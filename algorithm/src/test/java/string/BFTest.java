package string;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * @author liukai
 * @date 2020-04-13
 */
public class BFTest {

    @Test
    public void containTest() {
        String str = generateRandomString(10000000);
        String pattern = str.substring(str.length() - 100);

        long start = System.currentTimeMillis();

        assertTrue(BF.contain(str, pattern));
//        assertTrue(str.contains(pattern));

        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();

//        assertTrue(BF.contain(str, pattern));
        assertTrue(str.contains(pattern));

        System.out.println(System.currentTimeMillis() - start);

//        assertEquals(BF.contain(str, pattern), str.contains(pattern));
    }

    private String generateRandomString(int len) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        while (len-- > 0) {
            sb.append(r.nextInt());
        }
        return sb.toString();
    }

}