import controller.CustomerKiosk;
import model.Product;
import model.Store;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        CustomerKiosk ck = new CustomerKiosk();
        ck.status = 1;
        ck.customerKioskStart();
    }
}