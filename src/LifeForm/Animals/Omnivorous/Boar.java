package LifeForm.Animals.Omnivorous;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Boar extends AbstractAnimal {
    public Boar(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.OMNIVOROUS, 400, 50, 2,
                50, TypeLifeForm.BOAR, locationHeight, locationWeight, 5);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC17" + getSexLifeForm() + getHashCodeID();
    }
}
