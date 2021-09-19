import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.model.FoodModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestiranjeMetoda {
    public static void main(String[] args) {
        FoodDaoSQL fd = new FoodDaoSQL();
        FoodModel food = new FoodModel(15496, "Jogurt", 58.5, 23.4, 35.8, 3);
        // 2. Primer: FoodModel food2 = new FoodModel(15496, "Jogurt", 58.5, 23.4, 35.8, 5); --> pravimo isti objekat sa dparametrom koji zelimo da menjamo

        // fd.insert(food);  --> Vec je insertovano (runovano), tako da vec postoji
        food.setFoodFat(5);
        fd.update(food);  // --> ovde ne pravimo novi objekat sa istim id da zauzme njegovo mesto, vec isti objekat menjamo updateujemo tako sto pre toga promenimo vrednost pa onda izvrsimo update metodu koja ce ga promeniti i u SQL bazi
        // 2. Priemr: fd.update(food2); --> ovo bi bilo kada bi napravili novi objekat sa sitim idijem i u njemu menjali

      //  fd.addToMeal(1,15496,100);

        System.out.println(fd.getFood(15496));



    }
}
