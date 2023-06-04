package prac7.swap;
interface Restaurant {
    void takeOrder(String order);
}

class RealRestaurant implements Restaurant {
    @Override
    public void takeOrder(String order) {
        System.out.println("Taking order: " + order);
    }
}

class ProxyRestaurant implements Restaurant {
    private RealRestaurant realRestaurant;

    @Override
    public void takeOrder(String order) {
        if (realRestaurant == null) {
            realRestaurant = new RealRestaurant();
        }
        System.out.println("Checking customer's ID...");
        realRestaurant.takeOrder(order);
        System.out.println("Thank you for your order!");
    }
}
public class RestaurantTest {
    public static void main(String[] args) {
        Restaurant restaurant = new ProxyRestaurant();
        restaurant.takeOrder("Steak");
        restaurant.takeOrder("Burger");
        restaurant.takeOrder("Wine");
    }
}
