package prac7.lighteight;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private MenuFactory menuFactory;
    private Map<String, MenuItem> menuItems = new HashMap<>();

    public Restaurant(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
    }

    public void addMenuItem(String name, String description, double price, String category) {
        MenuItem menuItem = menuItems.get(name);

        if (menuItem == null) {
            menuItem = menuFactory.createMenuItem(name, description, price, category);
            menuItems.put(name, menuItem);
        }
    }

    public void printMenu() {
        for (MenuItem menuItem : menuItems.values()) {
            menuItem.print();
        }
    }
}

interface MenuFactory {
    MenuItem createMenuItem(String name, String description, double price, String category);
}

class ConcreteMenuFactory implements MenuFactory {
    private Map<String, MenuItem> menuItems = new HashMap<>();

    @Override
    public MenuItem createMenuItem(String name, String description, double price, String category) {
        MenuItem menuItem = menuItems.get(name);

        if (menuItem == null) {
            menuItem = new ConcreteMenuItem(name, description, price, category);
            menuItems.put(name, menuItem);
        }

        return menuItem;
    }
}

interface MenuItem {
    void print();
}

class ConcreteMenuItem implements MenuItem {
    private String name;
    private String description;
    private double price;
    private String category;

    public ConcreteMenuItem(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println();
    }
}

