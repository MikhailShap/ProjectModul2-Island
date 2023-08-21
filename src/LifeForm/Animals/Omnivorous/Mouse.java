package LifeForm.Animals.Omnivorous;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Mouse extends AbstractAnimal {
    public Mouse(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.OMNIVOROUS, 0.05, 500, 1,
                0.01, TypeLifeForm.MOUSE, locationHeight, locationWeight, 0.001);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC00" + getSexLifeForm() + getHashCodeID();
    }
}
