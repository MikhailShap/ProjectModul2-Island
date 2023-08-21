package Island;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import LifeForm.LifeForm;
import Lock.ObjectLock;
import Utils.ColorOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Location implements Runnable {

    private volatile List<LifeForm> lifeFormList;
    private volatile List<LifeForm> lifeFormListAddToLocationFromOtherLocations;

    public Location() {
        lifeFormList = new ArrayList<>();
        lifeFormListAddToLocationFromOtherLocations = new ArrayList<>();
    }

    public synchronized List<LifeForm> getLifeFormListAddToLocationFromOtherLocations() {
        return lifeFormListAddToLocationFromOtherLocations;
    }

    public List<LifeForm> getLifeFormList() {
        return lifeFormList;
    }

    @Override
    public void run() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomAction = threadLocalRandom.nextInt(3);

        for (int i = 0; i < lifeFormList.size(); i++) {

            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            switch (randomAction) {
                case 0 -> {
                    if (actionMove(i)) {
                        i--;
                    } else {
                        System.out.println(ColorOut.CYAN + lifeFormList.get(i) + " Пытался передвинуться, но не может" + ColorOut.ANSI_RESET);
                    }
                }
                case 1 -> {
                    if (!actionEat(i, threadLocalRandom)) {
                        System.out.println(ColorOut.CYAN + lifeFormList.get(i) + " Пытался покушать, но не получилось" + ColorOut.ANSI_RESET);
                    }
                }
                case 2 -> {
                    if (!actionMate(i, threadLocalRandom)) {
                        System.out.println(ColorOut.CYAN + lifeFormList.get(i) + " Пытался спариться, но не получилось" + ColorOut.ANSI_RESET);
                    }
                }

            }

        }

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lifeFormList.addAll(lifeFormListAddToLocationFromOtherLocations);
        lifeFormListAddToLocationFromOtherLocations.clear();

        Collections.shuffle(lifeFormList);

        ObjectLock objectLock = ObjectLock.OBJECT_LOCK;
        synchronized (objectLock) {
            try {
                objectLock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private boolean actionMate(int i, ThreadLocalRandom threadLocalRandom) {
        LifeForm lifeForm = lifeFormList.get(i);
        int random = threadLocalRandom.nextInt(2);
        switch (random) {
            case 0 -> {
                if (i - 1 > 0) {
                    LifeForm perhapsAnAnimalForMating = lifeFormList.get(i - 1);
                    return lifeForm.mate(perhapsAnAnimalForMating);
                } else if (i + 1 < lifeFormList.size()) {
                    LifeForm perhapsAnAnimalForMating = lifeFormList.get(i + 1);
                    return lifeForm.mate(perhapsAnAnimalForMating);
                }
            }
            case 1 -> {
                if (i + 1 < lifeFormList.size()) {
                    LifeForm perhapsAnAnimalForMating = lifeFormList.get(i + 1);
                    return lifeForm.mate(perhapsAnAnimalForMating);
                } else if (i - 1 > 0) {
                    LifeForm perhapsAnAnimalForMating = lifeFormList.get(i - 1);
                    return lifeForm.mate(perhapsAnAnimalForMating);
                }
            }
        }
        return false;
    }

    private boolean actionEat(int i, ThreadLocalRandom threadLocalRandom) {
        LifeForm lifeForm = lifeFormList.get(i);
        if (lifeForm instanceof AbstractAnimal) {
            AbstractAnimal currentAnimal = (AbstractAnimal) lifeForm;

            int random = threadLocalRandom.nextInt(2);
            switch (random) {
                case 0 -> {
                    if (i - 1 > 0) {
                        LifeForm foodAnimal = lifeFormList.get(i - 1);
                        return currentAnimal.eat(foodAnimal);
                    } else if (i + 1 < lifeFormList.size()) {
                        LifeForm foodAnimal = lifeFormList.get(i + 1);
                        return currentAnimal.eat(foodAnimal);
                    }
                }
                case 1 -> {
                    if (i + 1 < lifeFormList.size()) {
                        LifeForm foodAnimal = lifeFormList.get(i + 1);
                        return currentAnimal.eat(foodAnimal);
                    } else if (i - 1 > 0) {
                        LifeForm foodAnimal = lifeFormList.get(i - 1);
                        return currentAnimal.eat(foodAnimal);
                    }
                }
            }

        }
        return false;
    }

    private boolean actionMove(int i) {
        LifeForm lifeForm = lifeFormList.get(i);
        if (lifeForm instanceof AbstractAnimal) {
            AbstractAnimal animal = (AbstractAnimal) lifeForm;
            animal.move();
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return lifeFormList.toString() + "\t";
    }

    public int findTheNumberOfCertainLifeForm(TypeLifeForm typeLifeForm) {
        int countLifeForm = 0;
        for (LifeForm lifeForm : lifeFormList) {
            if (lifeForm.getTypeLifeForm() == typeLifeForm) {
                countLifeForm++;
            }
        }
        return countLifeForm;
    }


}
