import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = Laptop.createLaptopSet();

        Map<String, String> filterCriteria = Laptop.getFilterCriteriaFromUser();

        Set<Laptop> filteredLaptops = Laptop.filterLaptops(laptops, filterCriteria);

        Laptop.printLaptops(filteredLaptops);
    }
}