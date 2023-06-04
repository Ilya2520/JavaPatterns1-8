package prac6.Fabric;

abstract class Restaurant {
    private String name;
    private String address;
    private int capacity;

    public Restaurant(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public abstract void open();
    public abstract void close();
}

class ItalianRestaurant extends Restaurant {
    public ItalianRestaurant(String name, String address, int capacity) {
        super(name, address, capacity);
    }

    @Override
    public void open() {
        System.out.println("Italian restaurant " + getName() + " is open!");
    }

    @Override
    public void close() {
        System.out.println("Italian restaurant " + getName() + " is closed!");
    }
}

class ChineseRestaurant extends Restaurant {
    public ChineseRestaurant(String name, String address, int capacity) {
        super(name, address, capacity);
    }

    @Override
    public void open() {
        System.out.println("Chinese restaurant " + getName() + " is open!");
    }

    @Override
    public void close() {
        System.out.println("Chinese restaurant " + getName() + " is closed!");
    }
}

class RestaurantFactory {
    public Restaurant createRestaurant(String type, String name, String address, int capacity) {
        if (type.equalsIgnoreCase("italian")) {
            return new ItalianRestaurant(name, address, capacity);
        } else if (type.equalsIgnoreCase("chinese")) {
            return new ChineseRestaurant(name, address, capacity);
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RestaurantFactory factory = new RestaurantFactory();

        Restaurant italianRestaurant = factory.createRestaurant("italian", "Pasta Palace", "123 Main St", 50);
        italianRestaurant.open();
        italianRestaurant.close();

        Restaurant chineseRestaurant = factory.createRestaurant("chinese", "Chopsticks", "456 Elm St", 75);
        chineseRestaurant.open();
        chineseRestaurant.close();
    }
}

