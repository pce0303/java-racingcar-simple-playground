package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGame {
    List<Car> cars = new ArrayList<>();

    public void createCar(List<String> names, List<Random> random) {
        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i), random.get(i)));
        }
    }

    public void racing(int n) {
        for (int i = 0; i < n; i++) {
            for (Car car : cars) {
                car.addDistance();
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

        if (max == 0) {
            throw new IllegalStateException("모든 차가 출발하지 않았습니다.");
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