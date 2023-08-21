package Island;


import LifeForm.Animals.AbstractAnimal;
import LifeForm.Animals.Herbivores.Caterpillar;
import LifeForm.Plants.Plant;
import Lock.ObjectLock;
import Utils.DietType;
import Utils.GenerateLifeForm;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Island {
    public Location[][] getLocations() {
        return locations;
    }

    private final int allLocation;
    private final Location[][] locations;


    public Island(int width, int height, int numberOfAnimalsPerLocation) {
        locations = new Location[height][width];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location();
                Location location = locations[i][j];
                for (int k = 0; k < numberOfAnimalsPerLocation; k++) {
                    location.getLifeFormList().add(GenerateLifeForm.generateRandom(i, j));
                }
            }
        }
        allLocation = width * height;
    }

    public void startIsland(int timeSecondWork) {
        printAllStatistic();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                printAllStatistic();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ObjectLock objectLock = ObjectLock.OBJECT_LOCK;
                synchronized (objectLock) {
                    objectLock.notifyAll();
                }
            }
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(allLocation);
        for (Location[] locationArr : locations) {
            for (Location location : locationArr) {
                scheduledExecutorService.scheduleWithFixedDelay(location, 0, 10, TimeUnit.MILLISECONDS);
            }
        }
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
        scheduledExecutorService2.scheduleWithFixedDelay(runnable, 1, 1, TimeUnit.SECONDS);


        try {
            TimeUnit.SECONDS.sleep(timeSecondWork);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        scheduledExecutorService.shutdownNow();
        try {
            scheduledExecutorService2.awaitTermination(300, TimeUnit.MILLISECONDS);
            System.out.println("Завершение симуляции...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scheduledExecutorService2.shutdownNow();

    }


    public int allLifeForm() {
        int countAllLifeForm = 0;

        for (Location[] location : locations) {
            for (Location location1 : location) {
                int countLifeFormFromLocation = location1.getLifeFormList().size();
                countAllLifeForm += countLifeFormFromLocation;
            }
        }

        return countAllLifeForm;
    }


    private void printAllStatistic() {
        String format = "%n%-15s %-12s %-12s %-12s %-12s%n";
        System.out.printf(format, "Всего форм жизни", "Травоядных", "Хищников", "Всеядных", "Растений");
        System.out.println(allStatistic());
    }

    public String allStatistic() {
        long countHerbivores = 0;
        long countOmnivorous = 0;
        long countPredators = 0;
        long countPlant = 0;
        for (Location[] locationArr : locations) {
            for (Location location : locationArr) {
                countHerbivores += location.getLifeFormList().stream().
                        filter(lifeForm -> lifeForm instanceof AbstractAnimal).
                        filter(lifeForm -> ((AbstractAnimal) lifeForm).getDietType() == DietType.HERBIVORES).
                        count();
                countOmnivorous += location.getLifeFormList().stream().
                        filter(lifeForm -> lifeForm instanceof AbstractAnimal).
                        filter(lifeForm -> ((AbstractAnimal) lifeForm).getDietType() == DietType.OMNIVOROUS).
                        count();
                countPredators += location.getLifeFormList().stream().
                        filter(lifeForm -> lifeForm instanceof AbstractAnimal).
                        filter(lifeForm -> ((AbstractAnimal) lifeForm).getDietType() == DietType.PREDATOR).
                        count();
                countPlant += location.getLifeFormList().stream().
                        filter(lifeForm -> lifeForm instanceof Plant).
                        count();
                countHerbivores += location.getLifeFormList().stream().
                        filter(lifeForm -> lifeForm instanceof Caterpillar).
                        count();
            }
        }
        String format = "       %-13d %-11d %-12d %-12d %-12d%n";
        return String.format(format, allLifeForm(), countHerbivores, countPredators, countOmnivorous, countPlant);
    }
}
