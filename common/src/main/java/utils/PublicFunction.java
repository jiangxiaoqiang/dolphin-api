package utils;

import java.util.Random;

public class PublicFunction {

    private static char[] base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    /**
     * 随机生成16位字符串
     *
     * @return 16位随机字符串
     */
    public String getRandomStr() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int len = base.length;
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(len);
            sb.append(base[number]);
        }
        return sb.toString();
    }

}
