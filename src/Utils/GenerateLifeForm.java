package Utils;

import LifeForm.Animals.Herbivores.*;
import LifeForm.Animals.Omnivorous.Boar;
import LifeForm.Animals.Omnivorous.Duck;
import LifeForm.Animals.Omnivorous.Mouse;
import LifeForm.Animals.Predators.*;
import LifeForm.LifeForm;
import LifeForm.Plants.CloverFlower;
import LifeForm.Plants.Grass;
import LifeForm.Plants.HibiscusFlower;

public class GenerateLifeForm {
    public static LifeForm generateRandom(int locationHeight, int locationWeight) {
        TypeLifeForm typeLifeFormRandom = TypeLifeForm.getTypeLifeFormRandom();
        return generateForType(locationHeight, locationWeight, typeLifeFormRandom);
    }

    public static LifeForm generateForType(int locationHeight, int locationWeight, TypeLifeForm typeLifeForm) {
        switch (typeLifeForm) {
            case WOLF -> {
                return new Wolf(locationHeight, locationWeight);
            }
            case FOX -> {
                return new Fox(locationHeight, locationWeight);
            }
            case EAGLE -> {
                return new Eagle(locationHeight, locationWeight);
            }
            case BOA -> {
                return new Boa(locationHeight, locationWeight);
            }
            case BEAR -> {
                return new Bear(locationHeight, locationWeight);
            }
            case MOUSE -> {
                return new Mouse(locationHeight, locationWeight);
            }
            case DUCK -> {
                return new Duck(locationHeight, locationWeight);
            }
            case BOAR -> {
                return new Boar(locationHeight, locationWeight);
            }
            case SHEEP -> {
                return new Sheep(locationHeight, locationWeight);
            }
            case RABBIT -> {
                return new Rabbit(locationHeight, locationWeight);
            }
            case HORSE -> {
                return new Horse(locationHeight, locationWeight);
            }
            case GOAT -> {
                return new Goat(locationHeight, locationWeight);
            }
            case DEER -> {
                return new Deer(locationHeight, locationWeight);
            }
            case CATERPILLAR -> {
                return new Caterpillar(locationHeight, locationWeight);
            }
            case BUFFALO -> {
                return new Buffalo(locationHeight, locationWeight);
            }
            case HibiscusFlower -> {
                return new HibiscusFlower(locationHeight, locationWeight);
            }
            case CloverFlower -> {
                return new CloverFlower(locationHeight, locationWeight);
            }
            case Grass -> {
                return new Grass(locationHeight, locationWeight);
            }
        }
        return null;
    }
}
