package random.lc;

import java.util.Random;

public class Solution_470_M {
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            if (num <= 40) {
                return 1 + num % 10;
            }
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60) {
                return 1 + num % 10;
            }
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) {
                return 1 + num % 10;
            }

        }
    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
