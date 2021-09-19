package rs.itbootcamp.model;

public class UserModel {
    private int UserId;
    private String userName, emal, password;
    private boolean admin;

    public UserModel(int userId, String userName, String emal, String password, boolean admin) {
        UserId = userId;
        this.userName = userName;
        this.emal = emal;
        this.password = password;
        this.admin = admin;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Username: " + getUserName() + " Email:" + getEmal() + " User admin: " + isAdmin();
    }
}
