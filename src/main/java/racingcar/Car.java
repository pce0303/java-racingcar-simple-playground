package racingcar;

import java.util.Random;

public class Car {

    private String name;
    private Random random = new Random();
    private int number = random.nextInt(10);
    private int distance;

    public Car(String name, Random random) {
        this.name = name;
        this.distance = 0;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public int addDistance() {
        if (number >= 4) {
            distance++;
        }
        return distance;
    }

    public int getDistance() {
        return distance;
    }

}