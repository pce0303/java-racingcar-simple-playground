package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGame {
    List<Car> cars = new ArrayList<>();

    public void createCar(List<String> names, Random random, int n) {
        for (String name : names) {
            cars.add(new Car(name, random));
        }

    }

    public void racing(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).addDistance();
            }
        }
    }

    public List<String> winner() {
        List<String> winners = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < cars.size(); i++) {
            int dis = cars.get(i).getDistance();
            if (dis > max) {
                max = dis;
            }
        }
        for (int i = 0; i < cars.size(); i++) {
            int dis = cars.get(i).getDistance();
            if (dis == max) {
                winners.add(cars.get(i).getName());
            }
        }
        return winners;
    }
}