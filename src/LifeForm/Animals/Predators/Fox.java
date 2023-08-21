package LifeForm.Animals.Predators;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Fox extends AbstractAnimal {
    public Fox(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.PREDATOR, 8, 30,
                2, 2, TypeLifeForm.FOX, locationHeight, locationWeight, 0.2);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD8A" + getSexLifeForm() + getHashCodeID();
    }
}
