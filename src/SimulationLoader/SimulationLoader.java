package SimulationLoader;

import Island.*;
import IslandController.IslandController;

public class SimulationLoader {
    public static void startSimulation(int width, int height, int numberOfAnimalsPerLocation, int timeSecondsWork) {
        Island island = new Island(width, height, numberOfAnimalsPerLocation);
        IslandController.initialIslandController(island);
        island.startIsland(timeSecondsWork);
    }
}
