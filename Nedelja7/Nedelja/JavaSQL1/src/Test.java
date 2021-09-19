import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;
import rs.itbootcamp.model.UserModel;

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
        UserDao ud = new UserDaoSQL();

//         System.out.println(md.getAllMeals());
//         md.add(new MealModel(1,"Ime jela","Opis","5"));
//         md.delete(1);
//         md.add(new MealModel(5,"23423432","dsfsd","1"));
//         md.update(new MealModel(5,"Paprikas","Posni","4"));
//         md.add(new MealModel(6,"sdfasdjhf","12312","2"));
//         System.out.println(fd.getFood(15496));
//
//         for(int i = 1; i < 5; i++){
//             fd.add(new FoodModel(i,"Name"+i,200+i*13.7,0.5*i+2,1,2));
//         }
//
//         //1, 3, 15496  -> 5
//         fd.addToMeal(5,1,213.5);
//         fd.addToMeal(5,3,45.2);
//         fd.addToMeal(5,15496,564);

       // System.out.println(md.getMeal(5));

       //ud.add(new UserModel(1,"Marko", "marko@gmail.com", "12345", true));
       // ud.add(new UserModel(2,"Nikola", "nikola@gmail.com", "54321", false));
       // ud.add(new UserModel(3,"Nevena", "nevena@gmail.com", "nevena", true));
       //ud.delete(3);
       //ud.add(new UserModel(3, "Darko", "darko@gmail.com", "darko123", true));
       //ud.add(new UserModel(4, "Lana", "lana@gmail.com", "sifra", false));
       //ud.update(new UserModel(3, "Milica", "milica@gmail.com", "milica", false));
       // System.out.println(ud.getUser(3));

        System.out.println("Unesite emal ili username: ");
        String entry = sc.next();
        System.out.println("Unesite password: ");
        String pw = sc.next();

        if(ud.login(entry,pw)){
            System.out.println("USPESNO");
        } else {
            System.out.println("NEUSPESNO");
        }





//        String menu = """
//                0. Exit
//                1. Dodaj u tabelu Food
//                2. Prikazi tabelu Food
//                3. Izbrisi hranu
//                """;
//
//        int choice = 5;
//        while(choice != 0){
//            System.out.println(menu);
//            choice = sc.nextInt();
//            switch(choice){
//                case 0:
//                    break;
//                case 1:
//                    fd.add(userNewFood());
//                    break;
//                case 2:
//                    System.out.println(fd.getAllFood());
//                    break;
//                case 3:
//                    System.out.println("Unesite id za brsianje: ");
//                    int id = sc.nextInt();
//                    fd.delete(id);
//                    System.out.println("Uspesno brisanje");
//                    break;
//            }
//        }

    }
}
