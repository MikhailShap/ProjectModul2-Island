package IslandController;

import Island.*;
import LifeForm.Animals.AbstractAnimal;
import LifeForm.LifeForm;
import Utils.ColorOut;
import Utils.Step;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IslandController {
    static private Island island;
    static private Location[][] locations;

    public static void initialIslandController(Island island) {
        IslandController.island = island;
        locations = island.getLocations();
    }

    public static Island getIsland() {
        return island;
    }

    public static boolean moveTheLiveForm(int locationHeight, int locationWeight, int maxSpeed, AbstractAnimal movedAnimal) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int countStep = threadLocalRandom.nextInt(1, maxSpeed + 1);
        int moveLocationHeight = locationHeight;
        int moveLocationWeight = locationWeight;
        for (int i = 0; i < countStep; i++) {
            Step step = Step.getRandomStep();
            if (!Step.validStep(moveLocationHeight, moveLocationWeight, step)) {
                i--;
                continue;
            }
            switch (step) {
                case UP -> {
                    moveLocationHeight--;
                }
                case DOWN -> {
                    moveLocationHeight++;

                }
                case LEFT -> {
                    moveLocationWeight--;
                }
                case RIGHT -> {
                    moveLocationWeight++;
                }
            }
        }
        if (moveLocationHeight == locationHeight && moveLocationWeight == locationWeight) {
            return false;
        }

        Location locationForRemovingTheAnimal = locations[locationHeight][locationWeight];
        List<LifeForm> lifeFormListRemoving = locationForRemovingTheAnimal.getLifeFormList();
        lifeFormListRemoving.remove(movedAnimal);

        Location locationForAddingAnAnimal = locations[moveLocationHeight][moveLocationWeight];
        synchronized (locationForAddingAnAnimal) {
            List<LifeForm> lifeFormListAdding = locationForAddingAnAnimal.getLifeFormListAddToLocationFromOtherLocations();
            lifeFormListAdding.add(movedAnimal);
        }

        movedAnimal.setLocationHeight(moveLocationHeight);
        movedAnimal.setLocationWeight(moveLocationWeight);
        return true;
    }

    public static void removeDeadAnimal(LifeForm deadAnimal) {
        int locationHeight = deadAnimal.getLocationHeight();
        int locationWeight = deadAnimal.getLocationWeight();
        Location locationForRemovingTheAnimal = locations[locationHeight][locationWeight];
        List<LifeForm> lifeFormListRemoving = locationForRemovingTheAnimal.getLifeFormList();
        lifeFormListRemoving.remove(deadAnimal);

    }

    public static void removeDeadAnimalBecauseOfMovement(LifeForm deadAnimal) {
        int locationHeight = deadAnimal.getLocationHeight();
        int locationWeight = deadAnimal.getLocationWeight();
        Location locationForRemovingTheAnimal = locations[locationHeight][locationWeight];
        List<LifeForm> lifeFormListRemoving = locationForRemovingTheAnimal.getLifeFormListAddToLocationFromOtherLocations();
        lifeFormListRemoving.remove(deadAnimal);

    }

    public static void addNewLifeFormOnLocation(LifeForm lifeForm) {
        int maxLifeFormOnLocation = lifeForm.getMaxLifeFormOnLocation();
        int locationHeight = lifeForm.getLocationHeight();
        int locationWeight = lifeForm.getLocationWeight();
        Location locationWhereCurrentLifeFormWasBorn = locations[locationHeight][locationWeight];
        int lifeFormsOfThisTypeOnLocation = locationWhereCurrentLifeFormWasBorn.findTheNumberOfCertainLifeForm(lifeForm.getTypeLifeForm());

        if (lifeFormsOfThisTypeOnLocation < maxLifeFormOnLocation) {
            List<LifeForm> lifeFormListAddToLocationFromOtherLocations = locationWhereCurrentLifeFormWasBorn.getLifeFormListAddToLocationFromOtherLocations();
            synchronized (lifeFormListAddToLocationFromOtherLocations) {
                lifeFormListAddToLocationFromOtherLocations.add(lifeForm);
            }

            System.out.println(ColorOut.ANSI_WHITE + "Родился " + lifeForm + ColorOut.ANSI_RESET);
        }
    }
}
