package LifeForm.Animals.Herbivores;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Goat extends AbstractAnimal {
    public Goat(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.HERBIVORES, 60, 140, 3,
                10, TypeLifeForm.GOAT, locationHeight, locationWeight, 1);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC10" + getSexLifeForm() + getHashCodeID();
    }
}
