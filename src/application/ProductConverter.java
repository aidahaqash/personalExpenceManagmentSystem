package application;

import java.util.HashMap;
import java.util.Map;

import javafx.util.StringConverter;

public class ProductConverter extends StringConverter<Product> {

    /** Cache of Products */
    private Map<String, Product> productMap = new HashMap<String, Product>();

    @Override
    public String toString(Product product) {
        productMap.put(product.getName(), product);
        return product.getName();
    }

    @Override
    public Product fromString(String name) {
        return productMap.get(name);
    }

}
