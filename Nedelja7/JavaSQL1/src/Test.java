import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.dao.MealDao;
import rs.itbootcamp.dao.MealDaoSQL;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.util.Scanner;

public class Test {
    private static MealModel usernewMeal(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite id: ");
        int id = sc.nextInt();
        System.out.println("Unesite name: ");
        String name = sc.next();
        System.out.println("Unesite opis: ");
        String desc = sc.next();
        System.out.println("Unesite nivo: ");
        String difficulty = sc.next();
        return new MealModel(id, name, desc, difficulty);
    }

    private static FoodModel userNewFood(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesite id: ");
        int id = sc.nextInt();
        System.out.println("Unesite name: ");
        String name = sc.next();
        System.out.println("Unesite kcal: ");
        double kcal = sc.nextDouble();
        System.out.println("Unesite proteine: ");
        double proteins = sc.nextDouble();
        System.out.println("Unesite UH: ");
        double carbs = sc.nextDouble();
        System.out.println("Unesite masti: ");
        double fats = sc.nextDouble();
        return new FoodModel(id,name,kcal,proteins,carbs,fats);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDao fd = new FoodDaoSQL();
        MealDao md = new MealDaoSQL();

        String menu = """
                0. Exit
                1. Dodaj u tabelu Food
                2. Prikazi tabelu Food
                3. Dodaj u tabelu Meal
                4. Prikazi tabelu Meal
                """;

        int choice = 5;
        while(choice != 0){
            System.out.println(menu);
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    break;
                case 1:
                    fd.insert(userNewFood());
                    break;
                case 2:
                    System.out.println(fd.getAllFood());
                    break;
                case 3:
                    md.insert(usernewMeal());
                case 4:
                    System.out.println(md.getAllMeals());

            }
        }

    }
}
