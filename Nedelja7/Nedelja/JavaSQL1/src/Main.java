import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.dao.MealDao;
import rs.itbootcamp.dao.MealDaoSQL;
import rs.itbootcamp.model.FoodModel;

import java.util.List;
import java.util.Scanner;

public class Main {
    static FoodDao fd = new FoodDaoSQL();
    static MealDao md = new MealDaoSQL();
    static int fridge_id = 1;
    private static void welcomeMessage(){
        System.out.println("Welcome to kitchen!!!");
        System.out.println("------------------------");
    }

    private static void addFoodToFridge(Scanner sc){
        List<FoodModel> foodList = fd.getAllFood();
        int choice = -1;

        while(choice != 0){
            //pagination - stranicenje
            for(int i = 0; i < foodList.size(); i++){
                System.out.println((i+1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if(choice > 0 && choice <= foodList.size()){
                System.out.println("How much: (in grams)");
                double mass = sc.nextDouble();
                fd.addToFridge(fridge_id,foodList.get(choice - 1).getFoodId(),mass);
                System.out.println("++");
            }
        }
    }

    private static void removeFoodFromFridge(Scanner sc){
        int choice = -1;
        while(choice !=0){
            List<FoodModel> foodList = fd.getAllFood();

            for (int i = 0; i < foodList.size(); i++) {
                System.out.println((i+1) + ", " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if(choice > 0 && choice <= foodList.size()){
                System.out.println("Enter id by whom you are removing food: ");
                int fridgeId = sc.nextInt();
                fd.delete(fridgeId);
                System.out.println("--");
            }
        }
    }

    private static void lookInFoodFromFridge(){
    }

    private static void searchFood(Scanner sc){

        System.out.println("Enter a word by whom you want to search food: ");
        String s = sc.next();
        s = s.replaceAll("\\s", "").toLowerCase().trim();
        System.out.println(fd.searchFood(s));
    }

    private static void searchMeal(Scanner sc){
        System.out.println("Enter a word by whom you want to search meals:");
        String s = sc.next();
        s = s.replaceAll("\\s", "").toLowerCase().trim();
        System.out.println(md.searchMeal(s));
    }


    private static void fridgeMenu(Scanner sc){
        int choice;
        do{
            System.out.println("My Fridge:");
            System.out.println("--------");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Search");
            System.out.println("4. Look in");
            System.out.println("5. Create meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch(choice){
                case 1 -> addFoodToFridge(sc);
                case 2 -> removeFoodFromFridge(sc); //"Remove food from fridge");
                case 3 -> searchFood(sc);
                case 4 -> System.out.println("Write all food from fridge");
                case 5 -> System.out.println("Create meal");
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    private static void mainMenu(Scanner sc){
        int choice;
        do{
            System.out.println("Main menu:");
            System.out.println("-----------");
            System.out.println("1. My Fridge");
            System.out.println("2. Meals");
            System.out.println("3. All food");
            System.out.println("4. Add new food");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1 -> fridgeMenu(sc);
                case 2 -> System.out.println("Meals");
                case 3 -> System.out.println("All food");
                case 4 -> System.out.println("Add new food");
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeMessage();

        mainMenu(sc);
    }
}
