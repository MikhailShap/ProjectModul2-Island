package LifeForm.Plants;

import Utils.SexLifeForm;
import Utils.TypeLifeForm;

public class Grass extends  Plant{
    public Grass(int locationHeight, int locationWeight) {
        super(TypeLifeForm.Grass, SexLifeForm.getRandomSex(), 200, 1, locationHeight, locationWeight);
    }
    @Override
    public String toString() {
        return "\uD83C\uDF3F" + getSexLifeForm();
    }
}
