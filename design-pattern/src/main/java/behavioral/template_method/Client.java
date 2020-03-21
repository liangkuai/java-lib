package behavioral.template_method;

/**
 * @author liangkuai
 * @date 2018/11/16
 */
public class Client {

    public static void main(String[] args) {
        Beverage beberage = new Coffee();
        beberage.prepareRecipe();

        System.out.println("-----------");

        beberage = new Tea();
        beberage.prepareRecipe();
    }
}