package LifeForm.Plants;

import Utils.SexLifeForm;
import Utils.TypeLifeForm;

public class CloverFlower extends  Plant{
    public CloverFlower(int locationHeight, int locationWeight) {
        super(TypeLifeForm.CloverFlower, SexLifeForm.getRandomSex(), 200, 1, locationHeight, locationWeight);
    }
    @Override
    public String toString() {
        return "\uD83C\uDF3E" + getSexLifeForm();
    }
}
