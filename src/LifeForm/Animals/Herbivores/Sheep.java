package LifeForm.Animals.Herbivores;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Sheep extends AbstractAnimal {
    public Sheep(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.HERBIVORES, 70, 140, 3,
                15, TypeLifeForm.SHEEP, locationHeight, locationWeight, 1.5);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC11" + getSexLifeForm() + getHashCodeID();
    }
}
