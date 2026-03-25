package racingcar;

import java.util.Random;

public class RacingCar {
    private String name;
    private Random random = new Random();
    private int number = random.nextInt(10);
    private int distance = 0;

    public int move() {
        if (number >= 4) {
            distance++;
        }
        return distance;
    }
}