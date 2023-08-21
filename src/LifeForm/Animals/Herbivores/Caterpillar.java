package LifeForm.Animals.Herbivores;

import Utils.TypeLifeForm;
import LifeForm.LifeForm;
import Utils.SexLifeForm;

public class Caterpillar extends LifeForm {
    //НЕ ПЕРЕДВИГАЕТСЯ И НЕ ЕСТ
    public Caterpillar(int locationHeight, int locationWeight) {
        super(TypeLifeForm.CATERPILLAR, SexLifeForm.getRandomSex(), 1000, 0.01, locationHeight, locationWeight);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC1B" + getSexLifeForm() + getHashCodeID();
    }
}
