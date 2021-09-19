package rs.itbootcamp.dao;

import rs.itbootcamp.model.UserModel;

public interface UserDao {
    void add(UserModel user);
    void delete(int id);
    void update(UserModel user);
    UserModel getUser(int id);
    void addMealGrade(int user_id, int meal_id, int grade); // upsert --> update OR insert
    boolean login(String entry, String password);

}
