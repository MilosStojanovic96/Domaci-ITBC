package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoSQL implements FoodDao {
    private static final Connection conn = DatabaseConnection.getConnection();


    @Override
    public void add(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO food " +
                    "VALUES (?,?,?,?,?,?)");
            st.setInt(1, fm.getFoodId());
            st.setString(2, fm.getFoodName());
            st.setDouble(3, fm.getFoodKcal());
            st.setDouble(4, fm.getFoodProteins());
            st.setDouble(5, fm.getFoodCarbohydrates());
            st.setDouble(6, fm.getFoodFat());
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addToMeal(int meal_id, int food_id, double mass) {
        // TODO: adding to mealfood table
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO mealfood VALUES (?, ?, ?);");
            st.setInt(1, meal_id);
            st.setInt(2, food_id);
            st.setDouble(3, mass);
            st.executeUpdate();
            st.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addToFridge(int fridge_id, int food_id, double mass) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO fridgefood VALUES (?, ?, ?) " +
                                  "ON CONFLICT (fridge_id, food_id) DO UPDATE SET mass = (SELECT mass FROM fridgefood " +
                               "WHERE fridge_id = ? AND food_id = ?) + ?");
            st.setInt(1,fridge_id);
            st.setInt(2,food_id);
            st.setDouble(3,mass);
            st.setInt(4, fridge_id);
            st.setInt(5, food_id);
            st.setDouble(6, mass);
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM food WHERE food_id = ?;");
            st.setInt(1,id);
            st.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE food " +
                    "SET food_id = ?, " +
                    "food_name = ?, " +
                    "food_kcal = ?, " +
                    "food_proteins = ?, " +
                    "food_carbs = ?, " +
                    "food_fat = ? " +
                    "WHERE food_id = ?");
            st.setInt(1, fm.getFoodId());
            st.setString(2, fm.getFoodName());
            st.setDouble(3, fm.getFoodKcal());
            st.setDouble(4, fm.getFoodProteins());
            st.setDouble(5, fm.getFoodCarbohydrates());
            st.setDouble(6, fm.getFoodFat());
            st.setInt(7, fm.getFoodId());
            st.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public FoodModel getFood(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food WHERE food_id = " + id);
            if (rs.next()){
                return new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );

            }else {
                System.out.println("No results");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodModel> getAllFood() {
        List<FoodModel> allFood = new ArrayList<>();
        try {
            Statement st = conn.createStatement();   // moze i sa prepareStatement
            ResultSet rs = st.executeQuery("SELECT * FROM food"); // --> executequery kada je samo select
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                        );

                allFood.add(newFood);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allFood;
    }

    @Override
    public List<FoodModel> searchFood(String s) {
        List<FoodModel> searchList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food WHERE LOWER (food_name) LIKE LOWER ('%" + s +"%')");
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );

                searchList.add(newFood);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return searchList;
    }
}
