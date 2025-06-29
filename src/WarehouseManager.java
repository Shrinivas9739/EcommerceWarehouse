import java.util.*;
import java.util.stream.Collectors;

public class WarehouseManager {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product p) {
        productList.add(p);
    }

    public void updateProduct(int id, String newName, double newPrice, int newQuantity) {
        productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(p -> {
                    p.setName(newName);
                    p.setPrice(newPrice);
                    p.setQuantity(newQuantity);
                });
    }

    public void deleteProduct(int id) {
        productList.removeIf(p -> p.getId() == id);
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public List<Product> searchByPrice(double maxPrice) {
        return productList.stream()
                .filter(p -> p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public double calculateInventoryValue() {
        return productList.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public Product getProductById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
