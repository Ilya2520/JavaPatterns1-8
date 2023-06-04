package prac6.Prototype;

abstract class Restaurant implements Cloneable {
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

    @Override
    public Restaurant clone() {
        Restaurant clone = null;
        try {
            clone = (Restaurant) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
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

public class Main {
    public static void main(String[] args) {
        ItalianRestaurant originalItalianRestaurant = new ItalianRestaurant("Pasta Palace", "123 Main St", 50);
        ChineseRestaurant originalChineseRestaurant = new ChineseRestaurant("Chopsticks", "456 Elm St", 75);

        ItalianRestaurant clonedItalianRestaurant = (ItalianRestaurant) originalItalianRestaurant.clone();
        ChineseRestaurant clonedChineseRestaurant = (ChineseRestaurant) originalChineseRestaurant.clone();

        System.out.println(originalItalianRestaurant.getName().equals(clonedItalianRestaurant.getName()));
        System.out.println(originalChineseRestaurant.getName().equals(clonedChineseRestaurant.getName()));
    }
}
