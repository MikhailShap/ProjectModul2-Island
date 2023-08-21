package LifeForm.Animals;

import Utils.Info.ProbabilityOfEating;
import IslandController.IslandController;
import LifeForm.LifeForm;
import Utils.ColorOut;
import Utils.DietType;
import Utils.SexLifeForm;
import Utils.TypeLifeForm;

import java.math.BigDecimal;

public abstract class AbstractAnimal extends LifeForm {
    private final DietType dietType;
    private final BigDecimal wasteCaloriesAfterTheMove;

    private final int maxMovementSpeed;

    private final BigDecimal foodRequiredForFullSatisfactionKg;

    private boolean isFull;

    private BigDecimal countFull;

    public AbstractAnimal(SexLifeForm sexLifeForm, DietType dietType, double animalWeightKg,
                          int maxAnimalsPerCell, int maxMovementSpeed,
                          double foodRequiredForFullSatisfactionKg, TypeLifeForm typeLifeForm,
                          int locationHeight, int locationWeight, double wasteCaloriesAfterTheMove) {

        super(typeLifeForm, sexLifeForm, maxAnimalsPerCell, animalWeightKg, locationHeight, locationWeight);

        this.dietType = dietType;
        this.maxMovementSpeed = maxMovementSpeed;
        this.foodRequiredForFullSatisfactionKg = new BigDecimal(foodRequiredForFullSatisfactionKg);
        this.wasteCaloriesAfterTheMove = new BigDecimal(wasteCaloriesAfterTheMove);

        countFull = new BigDecimal(foodRequiredForFullSatisfactionKg);
    }


    public final BigDecimal getWasteCaloriesAfterTheMove() {
        return wasteCaloriesAfterTheMove;
    }

    public DietType getDietType() {
        return dietType;
    }

    public synchronized BigDecimal getCountFull() {
        return countFull;
    }

    public boolean isFull() {
        return isFull;
    }

    public int getMaxMovementSpeed() {
        return maxMovementSpeed;
    }


    public synchronized void move() {
        boolean stepOk = false;
        while (!stepOk) {
            stepOk = IslandController.moveTheLiveForm(getLocationHeight(), getLocationWeight(), getMaxMovementSpeed(), this);
        }
        removeToCounterFullAfterMove(getWasteCaloriesAfterTheMove());
        System.out.println(ColorOut.ANSI_BLUE + this + " Передвинулся" + ColorOut.ANSI_RESET);
        if (getCountFull().compareTo(BigDecimal.ZERO) < 0) {
            IslandController.removeDeadAnimalBecauseOfMovement(this);
            System.out.println(ColorOut.ANSI_PURPLE + this + " Умер от голодания" + ColorOut.ANSI_RESET);
        }
    }

    public synchronized boolean eat(LifeForm lifeForm) {
        if (!isFull() && ProbabilityOfEating.getPermissionFromProbability(this, lifeForm)) {
            IslandController.removeDeadAnimal(lifeForm);
            addToCountFull(lifeForm.getLifeFormWeightKg());
            System.out.println(ColorOut.ANSI_GREEN + this + " съел " + lifeForm + ColorOut.ANSI_RESET);
            return true;
        }
        return false;
    }

    public void removeToCounterFullAfterMove(BigDecimal kg) {
        countFull = countFull.subtract(kg);
        if (countFull.compareTo(foodRequiredForFullSatisfactionKg) < 0) {
            isFull = false;
        }
    }

    public void addToCountFull(BigDecimal kg) {
        if (countFull.add(kg).compareTo(foodRequiredForFullSatisfactionKg) > 0) {
            countFull = foodRequiredForFullSatisfactionKg;
            isFull = true;
        } else {
            countFull = countFull.add(kg);
            if (countFull.compareTo(foodRequiredForFullSatisfactionKg) >= 0) {
                isFull = true;
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal animal = (AbstractAnimal) o;
        return getHashCodeID() == animal.getHashCodeID();
    }
}