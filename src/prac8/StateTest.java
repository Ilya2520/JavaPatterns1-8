package prac8;

class Car {
    private State state;

    public Car() {
        state = new ParkedState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void start() {
        state.start(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void accelerate() {
        state.accelerate(this);
    }

    public void decelerate() {
        state.decelerate(this);
    }
}

interface State {
    void start(Car car);
    void stop(Car car);
    void accelerate(Car car);
    void decelerate(Car car);
}

class ParkedState implements State {
    @Override
    public void start(Car car) {
        car.setState(new RunningState());
        System.out.println("The car is now running");
    }

    @Override
    public void stop(Car car) {
        System.out.println("The car is already stopped");
    }

    @Override
    public void accelerate(Car car) {
        System.out.println("You need to start the car first");
    }

    @Override
    public void decelerate(Car car) {
        System.out.println("You need to start the car first");
    }
}

class RunningState implements State {
    @Override
    public void start(Car car) {
        System.out.println("The car is already running");
    }

    @Override
    public void stop(Car car) {
        car.setState(new ParkedState());
        System.out.println("The car is now stopped");
    }

    @Override
    public void accelerate(Car car) {
        System.out.println("The car is accelerating");
    }

    @Override
    public void decelerate(Car car) {
        System.out.println("The car is decelerating");
    }
}

public class StateTest {
    public static void main(String[] args) {
        Car car = new Car();

        car.accelerate();
        car.decelerate();
        car.start();
        car.accelerate();
        car.decelerate();

        car.stop();
        car.accelerate();
        car.decelerate();

    }
}