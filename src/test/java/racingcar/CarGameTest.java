package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameTest {

    Random Move = new Random() {
        @Override
        public int nextInt(int bound) {
            return 4;
        }
    };
    Random Stop = new Random() {
        @Override
        public int nextInt(int bound) {
            return 2;
        }
    };

    @Test
    @DisplayName("모든 차가 똑같이 전진할 때")
    public void allMove() {
        CarGame carGame = new CarGame();
        carGame.createCar(List.of("choeun", "sieun", "sanghun"));

        carGame.racing(5, Move);

        List<String> winner = carGame.winner();
        assertThat(winner).contains("choeun", "sieun", "sanghun");
    }

    @Test
    @DisplayName("한 대만 전진하고 나머지는 중간에 멈출 때")
    public void oneWinner() {
        CarGame carGame = new CarGame();
        carGame.createCar(List.of("choeun", "sieun", "sanghun"));
        carGame.racing(5, );

        List<String> winner = carGame.winner();
        assertThat(winner).contains("choeun");
    }

    @Test
    @DisplayName("모든 차가 멈출 때")
    public void allStop() {
        CarGame carGame = new CarGame();
        carGame.createCar(List.of("choeun", "sieun", "sanghun"));
        carGame.racing(5, Stop);

        assertThatThrownBy(carGame::winner).isInstanceOf(IllegalStateException.class);
    }
}