package lcof;

public class Offer046 {
    public static int translateNum(int num) {
//        多余操作啊，没让求每种是什么啊。。。
        /*char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l'
                , 'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
*/
        int[] dp = new int[32];
        int a = 1, b = 1, num1 = num, x, y = num % 10;
        while (num1 != 0) {
            num1 /= 10;
            x = num1 % 10;
            int tmp = x * 10 + y;
            int c = tmp >= 10 && tmp <= 25 ? a + b : a;
            b = a;
            a = c;
            y = x;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(translateNum(1000000000));
    }
}
