package prac8.Observe;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String model;
    private int speed;
    private List<Observer> observers = new ArrayList<>();

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        notifyObservers();
    }

    public int getSpeed() {
        return speed;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

interface Observer {
    void update(Car car);
}

class Speedometer implements Observer {
    private Car car;

    public Speedometer(Car car) {
        this.car = car;
        car.addObserver(this);
    }

    @Override
    public void update(Car car) {
        System.out.println("Current speed: " + car.getSpeed());
    }
}

class FuelGauge implements Observer {
    private Car car;

    public FuelGauge(Car car) {
        this.car = car;
        car.addObserver(this);
    }

    @Override
    public void update(Car car) {
        System.out.println("Current fuel level: " + (car.getSpeed() / 10) + " liters");
    }
}
public class ObserverTest {
    public static void main(String[] args) {
        Car car = new Car("Ford", 0);
        Speedometer speedometer = new Speedometer(car);
        FuelGauge fuelGauge = new FuelGauge(car);

        car.setSpeed(50);
        car.setSpeed(70);
    }
}
