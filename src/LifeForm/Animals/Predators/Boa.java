package LifeForm.Animals.Predators;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Boa extends AbstractAnimal {
    public Boa(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.PREDATOR, 15, 30,
                1, 3, TypeLifeForm.BOA, locationHeight, locationWeight, 0.3);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC0D" + getSexLifeForm() + getHashCodeID();
    }
}
