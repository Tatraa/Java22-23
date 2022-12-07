package pl.edu.uj.factory.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.edu.uj.factory.model.PartsCollection;
import pl.edu.uj.factory.model.Product;

public class FactoryHelper {
    List<Product> allProducts;
    PartsCollection allParts;

    Map<Integer, Integer> howManyUnitsOfTheProducts() throws ProductHasUnknownPartException {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> parts = allParts.getPartsIdsStockCount();

        for(int i = 0; i < allProducts.size(); i++) {
            int productId = allProducts.get(i).getProductId();
            Map<Integer, Integer> partsIdsNeededCount = allProducts.get(i).getPartsIdsNeededCount();
            int amount = 100000;

            for(Map.Entry<Integer, Integer> entry: partsIdsNeededCount.entrySet()) {
                int temp = parts.get(entry.getKey()) / entry.getValue();
                amount = amount < temp ? temp : amount;
            }

            map.put(allProducts.get(i).getProductId(), amount);
        }

        return map;
    }
}
