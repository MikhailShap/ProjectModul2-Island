package LifeForm.Animals.Herbivores;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import Utils.DietType;
import Utils.SexLifeForm;

public class Deer extends AbstractAnimal {
    public Deer(int locationHeight, int locationWeight) {
        super(SexLifeForm.getRandomSex(), DietType.HERBIVORES, 300, 20, 4,
                50, TypeLifeForm.DEER, locationHeight, locationWeight, 5);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD8C" + getSexLifeForm() + getHashCodeID();
    }
}
