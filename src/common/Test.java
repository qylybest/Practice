package common;

/**
 * Created by eric on 2017/5/15.
 */
public class Test {
    public static void main(String[] args) {
        Money money = new Money();

        money.setAmount(null);
        System.out.println(money.getCent());
    }
}
