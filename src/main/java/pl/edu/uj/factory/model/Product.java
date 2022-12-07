package pl.edu.uj.factory.model;

import java.util.Map;

public class Product {
    int productId;
    String name;
    Map<Integer, Integer> partsIdsNeededCount;
    int producedCount = 0;

    public void setProductId(int id) {
        this.productId = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Integer> getPartsIdsNeededCount() {
        return partsIdsNeededCount;
    }

    int getProducedCount() {
        return producedCount;
    }
}
