package LifeForm.Plants;

import Utils.TypeLifeForm;
import LifeForm.LifeForm;
import Utils.SexLifeForm;

public abstract class Plant extends LifeForm {


    public Plant(TypeLifeForm typeLifeForm, SexLifeForm sexLifeForm, int maxLifeFormOnLocation, double lifeFormWeightKg, int locationHeight, int locationWeight) {
        super(typeLifeForm, sexLifeForm, maxLifeFormOnLocation, lifeFormWeightKg, locationHeight, locationWeight);
    }






}
