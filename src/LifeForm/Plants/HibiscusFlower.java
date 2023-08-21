package LifeForm.Plants;

import Utils.SexLifeForm;
import Utils.TypeLifeForm;

public class HibiscusFlower extends  Plant{
    public HibiscusFlower(int locationHeight, int locationWeight) {
        super(TypeLifeForm.HibiscusFlower, SexLifeForm.getRandomSex(), 200, 1, locationHeight, locationWeight);
    }
    @Override
    public String toString() {
        return "\uD83C\uDF3A" + getSexLifeForm();
    }
}
