import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.dao.MealDaoSQL;
import rs.itbootcamp.model.MealModel;

public class TestiranjeMetoda2 {
    public static void main(String[] args) {
        MealDaoSQL md = new MealDaoSQL();
        MealModel meal = new MealModel(1, "Grasak", "Kuvani grasak sa pilecim mesom", "srednji nivo" );

        //md.insert(meal);
         meal.setMealDesc("Kuvano jelo");
         md.update(meal);
        System.out.println(md.getMeal(1));
        System.out.println(md.getAllMeals());

        


    }
}
