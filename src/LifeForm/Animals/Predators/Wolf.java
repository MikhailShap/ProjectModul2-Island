package LifeForm.Animals.Predators;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Wolf extends AbstractAnimal {
    // Сколько тратят каллорий за ход

    public Wolf(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.PREDATOR, 50, 30, 3, 8, TypeLifeForm.WOLF, locationHeight, locationWeight, 0.8);
    }


    @Override
    public String toString() {
        return "\uD83D\uDC3A" + getSexLifeForm() + " " + getHashCodeID();
    }
}
