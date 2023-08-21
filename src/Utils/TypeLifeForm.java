package Utils;

import java.util.concurrent.ThreadLocalRandom;

public enum TypeLifeForm {
    WOLF,
    BOA,
    FOX,
    BEAR,
    EAGLE,
    HORSE,
    DEER,
    RABBIT,
    MOUSE,
    GOAT,
    SHEEP,
    BOAR,
    BUFFALO,
    DUCK,
    CATERPILLAR,
    HibiscusFlower,
    CloverFlower,
    Grass;
    static public TypeLifeForm getTypeLifeFormRandom() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomNum = threadLocalRandom.nextInt(16);
        TypeLifeForm[] values = TypeLifeForm.values();
        return values[randomNum];
    }
}
