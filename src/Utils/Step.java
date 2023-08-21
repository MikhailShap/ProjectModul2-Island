package Utils;

import Island.*;
import IslandController.IslandController;

import java.util.concurrent.ThreadLocalRandom;

public enum Step {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Step getRandomStep() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int randomStep = threadLocalRandom.nextInt(4);
        switch (randomStep) {
            case 0 -> {
                return UP;
            }
            case 1 -> {
                return DOWN;
            }
            case 2 -> {
                return LEFT;
            }
            case 3 -> {
                return RIGHT;
            }
            default -> {
                return null;
            }

        }
    }

    public static boolean validStep(int locationHeight, int locationWeight, Step step) {
        Island island = IslandController.getIsland();
        Location[][] location = island.getLocations();
        switch (step) {
            case UP -> {
                if (locationHeight - 1 < 0) {
                    return false;
                }
                return true;
            }
            case DOWN -> {
                if (locationHeight + 1 >= location.length) {
                    return false;
                }
                return true;

            }
            case LEFT -> {
                if (locationWeight - 1 < 0) {
                    return false;
                }
                return true;
            }
            case RIGHT -> {
                if (locationWeight + 1 >= location[0].length) {
                    return false;
                }
                return true;
            }
            default -> {
                return false;
            }
        }
    }

}
