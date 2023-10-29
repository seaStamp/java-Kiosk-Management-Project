import controller.CustomerKiosk;
import controller.ManagerKiosk;
import model.Product;
import model.Store;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        CustomerKiosk cKiosk = new CustomerKiosk();
        Store store = new Store();
        store.init();
        while(true){
            cKiosk.customerKioskStart();
            ManagerKiosk.managerKioskStart();
        }
    }
}