package LifeForm.Animals.Predators;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Bear extends AbstractAnimal {
    public Bear(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.PREDATOR, 500, 5, 2,
                80, TypeLifeForm.BEAR, locationHeight, locationWeight, 8);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC3B" + getSexLifeForm() + getHashCodeID();
    }


}
