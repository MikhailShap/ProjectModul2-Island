package LifeForm.Animals.Herbivores;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Rabbit extends AbstractAnimal {
    public Rabbit(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.HERBIVORES, 2, 150, 2,
                0.45, TypeLifeForm.RABBIT, locationHeight, locationWeight, 0.045);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC07" + getSexLifeForm() + getHashCodeID();
    }
}
