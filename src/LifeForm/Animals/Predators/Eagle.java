package LifeForm.Animals.Predators;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Eagle extends AbstractAnimal {
    public Eagle(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.PREDATOR, 6, 20, 3,
                1, TypeLifeForm.EAGLE, locationHeight, locationWeight, 0.1);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD85" + getSexLifeForm() + getHashCodeID();
    }
}
