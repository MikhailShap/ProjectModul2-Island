package Utils.Info;

import LifeForm.Animals.AbstractAnimal;
import Utils.TypeLifeForm;
import LifeForm.LifeForm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ProbabilityOfEating {
    public static boolean getPermissionFromProbability(AbstractAnimal currentAnimal, LifeForm foodAnimal) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomNum = threadLocalRandom.nextInt(101);

        TypeLifeForm typeCurrentAnimal = currentAnimal.getTypeLifeForm();
        TypeLifeForm typeFoodAnimal = foodAnimal.getTypeLifeForm();

        Map<TypeLifeForm, Integer> mapForCurrentAnimal = allMapAnimalProbabilityOfEating.get(typeCurrentAnimal);
        Integer valueProbabilityOfEating = mapForCurrentAnimal.getOrDefault(typeFoodAnimal, 0);
        return randomNum < valueProbabilityOfEating;
    }

    private static final Map<TypeLifeForm, Integer> WOLF_PROBABILITY_OF_EATING;

    static {
        WOLF_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HORSE, 10);
            put(TypeLifeForm.DEER, 15);
            put(TypeLifeForm.RABBIT, 60);
            put(TypeLifeForm.MOUSE, 80);
            put(TypeLifeForm.GOAT, 60);
            put(TypeLifeForm.SHEEP, 70);
            put(TypeLifeForm.BOAR, 15);
            put(TypeLifeForm.BUFFALO, 10);
            put(TypeLifeForm.DUCK, 40);
        }};
    }


    private static final Map<TypeLifeForm, Integer> BOA_PROBABILITY_OF_EATING;

    static {
        BOA_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.FOX, 15);
            put(TypeLifeForm.RABBIT, 20);
            put(TypeLifeForm.MOUSE, 40);
            put(TypeLifeForm.DUCK, 10);
        }};
    }

    private static final Map<TypeLifeForm, Integer> FOX_PROBABILITY_OF_EATING;

    static {
        FOX_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.RABBIT, 70);
            put(TypeLifeForm.MOUSE, 90);
            put(TypeLifeForm.DUCK, 60);
            put(TypeLifeForm.CATERPILLAR, 40);
        }};
    }

    private static final Map<TypeLifeForm, Integer> BEAR_PROBABILITY_OF_EATING;

    static {
        BEAR_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.BOA, 80);
            put(TypeLifeForm.HORSE, 40);
            put(TypeLifeForm.DEER, 80);
            put(TypeLifeForm.RABBIT, 80);
            put(TypeLifeForm.MOUSE, 90);
            put(TypeLifeForm.GOAT, 70);
            put(TypeLifeForm.SHEEP, 70);
            put(TypeLifeForm.BOAR, 50);
            put(TypeLifeForm.BUFFALO, 20);
            put(TypeLifeForm.DUCK, 10);
        }};
    }

    private static final Map<TypeLifeForm, Integer> EAGLE_PROBABILITY_OF_EATING;

    static {
        EAGLE_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.FOX, 10);
            put(TypeLifeForm.RABBIT, 90);
            put(TypeLifeForm.MOUSE, 90);
            put(TypeLifeForm.DUCK, 80);
        }};
    }

    private static final Map<TypeLifeForm, Integer> HORSE_PROBABILITY_OF_EATING;

    static {
        HORSE_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> DEER_PROBABILITY_OF_EATING;

    static {
        DEER_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> RABBIT_PROBABILITY_OF_EATING;

    static {
        RABBIT_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> MOUSE_PROBABILITY_OF_EATING;

    static {
        MOUSE_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.CATERPILLAR, 90);
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> GOAT_PROBABILITY_OF_EATING;

    static {
        GOAT_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> SHEEP_PROBABILITY_OF_EATING;

    static {
        SHEEP_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> BOAR_PROBABILITY_OF_EATING;

    static {
        BOAR_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.MOUSE, 50);
            put(TypeLifeForm.CATERPILLAR, 90);
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> BUFFALO_PROBABILITY_OF_EATING;

    static {
        BUFFALO_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> DUCK_PROBABILITY_OF_EATING;

    static {
        DUCK_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.CATERPILLAR, 90);
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Integer> CATERPILLAR_PROBABILITY_OF_EATING;

    static {
        CATERPILLAR_PROBABILITY_OF_EATING = new HashMap<>() {{
            put(TypeLifeForm.HibiscusFlower, 100);
            put(TypeLifeForm.CloverFlower, 100);
            put(TypeLifeForm.Grass, 100);
        }};
    }

    private static final Map<TypeLifeForm, Map<TypeLifeForm, Integer>> allMapAnimalProbabilityOfEating;

    static {
        allMapAnimalProbabilityOfEating = new HashMap<>() {{
            put(TypeLifeForm.WOLF, WOLF_PROBABILITY_OF_EATING);
            put(TypeLifeForm.BOA, BOA_PROBABILITY_OF_EATING);
            put(TypeLifeForm.FOX, FOX_PROBABILITY_OF_EATING);
            put(TypeLifeForm.BEAR, BEAR_PROBABILITY_OF_EATING);
            put(TypeLifeForm.EAGLE, EAGLE_PROBABILITY_OF_EATING);
            put(TypeLifeForm.HORSE, HORSE_PROBABILITY_OF_EATING);
            put(TypeLifeForm.DEER, DEER_PROBABILITY_OF_EATING);
            put(TypeLifeForm.RABBIT, RABBIT_PROBABILITY_OF_EATING);
            put(TypeLifeForm.MOUSE, MOUSE_PROBABILITY_OF_EATING);
            put(TypeLifeForm.GOAT, GOAT_PROBABILITY_OF_EATING);
            put(TypeLifeForm.SHEEP, SHEEP_PROBABILITY_OF_EATING);
            put(TypeLifeForm.BOAR, BOAR_PROBABILITY_OF_EATING);
            put(TypeLifeForm.BUFFALO, BUFFALO_PROBABILITY_OF_EATING);
            put(TypeLifeForm.DUCK, DUCK_PROBABILITY_OF_EATING);
            put(TypeLifeForm.CATERPILLAR, CATERPILLAR_PROBABILITY_OF_EATING);
        }};
    }
}
