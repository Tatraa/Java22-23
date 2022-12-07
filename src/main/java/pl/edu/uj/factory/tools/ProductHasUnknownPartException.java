package pl.edu.uj.factory.tools;

import pl.edu.uj.factory.model.PartsCollection;
import pl.edu.uj.factory.model.Product;

public class ProductHasUnknownPartException extends Exception {
    public ProductHasUnknownPartException(int product, int partId ) {
        super("Product" + product + "needs an unknown part" + partId + "for manufacturing");
    }
}
