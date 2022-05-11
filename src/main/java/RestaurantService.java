import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    // For part 3
    private List<Item> userItems = new ArrayList<>();
    private int totalCost = 0;
    private Restaurant selectedRestaurant;
    // end

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // For part 3
    public void addItemToUserSelectedItemList(Item itemName) {
        this.userItems.add(itemName);
        totalCost += itemName.getPrice();
    }

    public void removeItemfromUserSeletedItemList(Item itemName) {
        userItems.remove(itemName);
        totalCost += itemName.getPrice();
    }

    public Restaurant selectRestaurant(String restaurantName) throws restaurantNotFoundException {
        this.selectedRestaurant = this.findRestaurantByName(restaurantName);
        return this.selectedRestaurant;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public void resetUserItems() {
        userItems = null;
        totalCost = 0;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Restaurant getSelectedRestaurant() {
        return this.selectedRestaurant;
    }
    // End
}
