package LifeForm.Animals.Herbivores;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Buffalo extends AbstractAnimal {
    public Buffalo(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.HERBIVORES, 700, 10, 3,
                100, TypeLifeForm.BUFFALO, locationHeight, locationWeight, 10);
    }


    @Override
    public String toString() {
        return "\uD83E\uDDAC" + getSexLifeForm() + getHashCodeID();
    }
}
