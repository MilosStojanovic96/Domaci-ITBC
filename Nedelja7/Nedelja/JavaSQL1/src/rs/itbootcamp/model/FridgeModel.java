package rs.itbootcamp.model;

public class FridgeModel {
    private int fridgeId;
    private int userId;

    public FridgeModel(int fridgeId, int userId) {
        this.fridgeId = fridgeId;
        this.userId = userId;
    }

    public int getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(int fridgeId) {
        this.fridgeId = fridgeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Fridge ID: " + fridgeId + " User ID: " + userId;
    }
}
