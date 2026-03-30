package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGame {
    List<Car> cars = new ArrayList<>();

    public void createCar(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void racing(int n, Random random) {
        for (int i = 0; i < n; i++) {
            for (Car car : cars) {
                int number = random.nextInt(10);
                car.addDistance(number);
            }
        }
    }

    public List<String> winner() {
        List<String> winners = new ArrayList<>();
        int max = 0;

        for (Car car : cars) {
            int dis = car.getDistance();
            if (dis > max) {
                max = dis;
            }
        }

        if (max == 0) {
            throw new IllegalStateException("모든 차가 출발하지 않았습니다.");
        }

        for (Car car : cars) {
            int dis = car.getDistance();
            if (dis == max) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}