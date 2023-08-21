package Utils;

import java.util.concurrent.ThreadLocalRandom;

public enum SexLifeForm {
    Male,
    Female;

    public static SexLifeForm getRandomSex() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomNum = threadLocalRandom.nextInt(2);
        return SexLifeForm.values()[randomNum];
    }
}
