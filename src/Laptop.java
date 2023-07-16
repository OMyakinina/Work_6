// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.*;
public class Laptop {
    private String model;
    private int ram;
    private int storageCapacity;
    private String operatingSystem;
    private String color;

    public Laptop(String model, int ram, int storageCapacity, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
    public static Set<Laptop> createLaptopSet() {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Dell XPS 13", 16, 512, "Windows 10", "Silver"));
        laptops.add(new Laptop("MacBook Pro", 8, 256, "macOS", "Space Gray"));
        laptops.add(new Laptop("HP Spectre x360", 16, 1_000, "Windows 10", "Poseidon Blue"));
        laptops.add(new Laptop("Lenovo ThinkPad X1 Carbon", 16, 512, "Windows 10", "Black"));
        laptops.add(new Laptop("Asus ZenBook 14", 8, 512, "Windows 10", "Royal Blue"));

        return laptops;
    }

    public static Map<String, String> getFilterCriteriaFromUser() {
        Map<String, String> filterCriteria = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.print("Введите минимальное значение ОЗУ: ");
                String ram = scanner.nextLine();
                filterCriteria.put("ram", ram);
                break;
            case "2":
                System.out.print("Введите минимальное значение объёма ЖД: ");
                String storageCapacity = scanner.nextLine();
                filterCriteria.put("storageCapacity", storageCapacity);
                break;
            case "3":
                System.out.print("Введите операционную систему: ");
                String operatingSystem = scanner.nextLine();
                filterCriteria.put("operatingSystem", operatingSystem);
                break;
            case "4":
                System.out.print("Введите цвет: ");
                String color = scanner.nextLine();
                filterCriteria.put("color", color);
                break;
            default:
                System.out.println("Неверный выбор ");
                break;
        }

        return filterCriteria;
    }

public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, String> filterCriteria) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean meetsCriteria = true;

            for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                switch (key) {
                    case "ram":
                        if (laptop.getRam() < Integer.parseInt(value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "storageCapacity":
                        if (laptop.getStorageCapacity() < Integer.parseInt(value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "operatingSystem":
                        if (!laptop.getOperatingSystem().equalsIgnoreCase(value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase(value)) {
                            meetsCriteria = false;
                        }
                        break;
                    default:
                        System.out.println("Некорректный критерий фильтрации.");
                        break;
                }
            }

            if (meetsCriteria) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

    public static void printLaptops(Set<Laptop> laptops) {
        if (laptops.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих заданным критериям.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : laptops) {
                System.out.println("Модель: " + laptop.getModel());
                System.out.println("ОЗУ: " + laptop.getRam() + " ГБ");
                System.out.println("Объём ЖД: " + laptop.getStorageCapacity() + " ГБ");
                System.out.println("Операционная система: " + laptop.getOperatingSystem());
                System.out.println("Цвет: " + laptop.getColor());
                System.out.println("-------------------");
            }
        }
    }
}

