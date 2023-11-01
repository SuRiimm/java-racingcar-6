package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;

public class Race {
  private List<Car> cars;

  public Race(List<Car> cars) {
    this.cars = cars;
  }

  public int getRandomValue() {
    int randomValue = Randoms.pickNumberInRange(0, 9);
    return randomValue;
  }

  public void startRace(int moveCount) {
    for (int move = 0; move < moveCount; move++) {
      int[] randomValues = new int[cars.size()];
      for (int i = 0; i < cars.size(); i++) {
        randomValues[i] = getRandomValue();
      }
      for(int i = 0; i<cars.size(); i++){
        Car car = cars.get(i);
        car.move(randomValues[i]);
      }
    }
  }

  public String getWinners() {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = Math.max(maxPosition, car.getPosition());
    }
    StringBuilder winners = new StringBuilder();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        if (winners.length() > 0) {
          winners.append(", ");
        }
        winners.append(car.getName());
      }
    }
    return winners.toString();
  }
}
