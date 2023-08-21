package LifeForm.Animals.Omnivorous;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Duck extends AbstractAnimal {
    public Duck(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.OMNIVOROUS, 1, 200, 4,
                0.15, TypeLifeForm.DUCK, locationHeight, locationWeight, 0.015);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD86" + getSexLifeForm() + getHashCodeID();
    }
}
