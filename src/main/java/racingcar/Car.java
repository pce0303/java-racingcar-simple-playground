package racingcar;

import java.util.Random;

public class Car {

    private final String name;
    private int distance;
    private final Random random;

    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void addDistance() {
        int number = random.nextInt(10);
        if (number >= 4) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}