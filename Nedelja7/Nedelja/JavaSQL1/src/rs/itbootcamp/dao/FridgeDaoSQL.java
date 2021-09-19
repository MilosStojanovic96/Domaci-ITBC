package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FridgeDaoSQL implements FridgeDao{

    private static final Connection conn = DatabaseConnection.getConnection();

    @Override
    public void add(FridgeModel f) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO fridge VALUES (?, ?)");
            st.setInt(1,f.getFridgeId());
            st.setInt(2,f.getUserId());
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE from fridge WHERE fridge_id = ?;");
            st.setInt(1,id);
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(FridgeModel f) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE fridge " +
                    "SET fridge_id = ?, " +
                    "user_id = ? " +
                    "WHERE fridge_id = ?");
            st.setInt(1, f.getFridgeId());
            st.setInt(2, f.getUserId());
            st.setInt(3,f.getFridgeId());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<FoodModel> getAllFood(int fridge_id) {
        List<FoodModel> allFood = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food f INNER JOIN fridgefood ff ON ff.food_id = f.food_id WHERE fridge_id = " + fridge_id);
            while(rs.next())
                allFood.add(new FoodModel(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getDouble(5),
                                rs.getDouble(6)
                               )
                );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allFood;
    }
}
