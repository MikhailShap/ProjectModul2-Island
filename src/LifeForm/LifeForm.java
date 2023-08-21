package LifeForm;

import IslandController.IslandController;
import Utils.TypeLifeForm;
import Utils.GenerateLifeForm;
import Utils.SexLifeForm;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LifeForm {

    private volatile static AtomicInteger countTypeAnimal = new AtomicInteger(1);
    private final int hashCodeID;
    private final TypeLifeForm typeLifeForm;
    private final SexLifeForm sexLifeForm;
    private final int maxLifeFormOnLocation;
    private final BigDecimal lifeFormWeightKg;
    private volatile int locationHeight;
    private volatile int locationWeight;

    public LifeForm(TypeLifeForm typeLifeForm, SexLifeForm sexLifeForm, int maxLifeFormOnLocation, double lifeFormWeightKg, int locationHeight, int locationWeight) {
        this.typeLifeForm = typeLifeForm;
        this.sexLifeForm = sexLifeForm;
        this.maxLifeFormOnLocation = maxLifeFormOnLocation;
        this.lifeFormWeightKg = new BigDecimal(lifeFormWeightKg);
        this.locationHeight = locationHeight;
        this.locationWeight = locationWeight;

        hashCodeID = countTypeAnimal.getAndIncrement();

    }

    public int getHashCodeID() {
        return hashCodeID;
    }

    public int getMaxLifeFormOnLocation() {
        return maxLifeFormOnLocation;
    }

    public BigDecimal getLifeFormWeightKg() {
        return lifeFormWeightKg;
    }

    public SexLifeForm getSexLifeForm() {
        return sexLifeForm;
    }

    public int getLocationHeight() {
        return locationHeight;
    }

    public void setLocationHeight(int locationHeight) {
        this.locationHeight = locationHeight;
    }

    public int getLocationWeight() {
        return locationWeight;
    }

    public void setLocationWeight(int locationWeight) {
        this.locationWeight = locationWeight;
    }

    public TypeLifeForm getTypeLifeForm() {
        return typeLifeForm;
    }

    public synchronized boolean mate(LifeForm otherLifeForm) {
        if (this.getTypeLifeForm() != otherLifeForm.getTypeLifeForm() || this.getSexLifeForm() == otherLifeForm.getSexLifeForm()) {
            return false;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomNum = threadLocalRandom.nextInt(2);
        if (randomNum == 1) {
            LifeForm newLifeForm = GenerateLifeForm.generateForType(getLocationHeight(), getLocationWeight(), getTypeLifeForm());
            IslandController.addNewLifeFormOnLocation(newLifeForm);
        }
        return true;

    }
}
