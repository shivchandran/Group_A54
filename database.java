import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDeliveryApp {
    
    // Store all the restaurants in a HashMap
    private Map<String, Restaurant> restaurantMap;
    
    // Store all the orders in a HashMap
    private Map<String, Order> orderMap;
    
    // Store all the customers in a HashMap
    private Map<String, Customer> customerMap;
    
    // Constructor
    public FoodDeliveryApp() {
        restaurantMap = new HashMap<>();
        orderMap = new HashMap<>();
        customerMap = new HashMap<>();
    }
    
    // Add a new restaurant to the app
    public void addRestaurant(String restaurantName, Restaurant restaurant) {
        restaurantMap.put(restaurantName, restaurant);
    }
    
    // Add a new customer to the app
    public void addCustomer(String customerId, Customer customer) {
        customerMap.put(customerId, customer);
    }
    
    // Create a new order
    public void createOrder(String orderId, String customerId, String restaurantName, List<FoodItem> foodItems) {
        Customer customer = customerMap.get(customerId);
        Restaurant restaurant = restaurantMap.get(restaurantName);
        Order order = new Order(orderId, customer, restaurant, foodItems);
        orderMap.put(orderId, order);
    }
    
    // Get a list of all the orders for a particular restaurant
    public List<Order> getRestaurantOrders(String restaurantName) {
        List<Order> restaurantOrders = new ArrayList<>();
        for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
            Order order = entry.getValue();
            if (order.getRestaurant().getName().equals(restaurantName)) {
                restaurantOrders.add(order);
            }
        }
        return restaurantOrders;
    }
    
    // Get a list of all the orders for a particular customer
    public List<Order> getCustomerOrders(String customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
            Order order = entry.getValue();
            if (order.getCustomer().getId().equals(customerId)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }
    
    // Update the status of an order
    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orderMap.get(orderId);
        order.setStatus(status);
    }
    
    // Get the status of an order
    public OrderStatus getOrderStatus(String orderId) {
        Order order = orderMap.get(orderId);
        return order.getStatus();
    }
}
