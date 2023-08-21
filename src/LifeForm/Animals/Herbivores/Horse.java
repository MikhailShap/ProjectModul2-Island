package LifeForm.Animals.Herbivores;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Horse extends AbstractAnimal {
    public Horse(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.HERBIVORES, 400, 20, 4,
                60, TypeLifeForm.HORSE, locationHeight, locationWeight, 6);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC0E" + getSexLifeForm() + getHashCodeID();
    }
}
