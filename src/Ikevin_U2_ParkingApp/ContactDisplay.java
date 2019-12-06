package Ikevin_U2_ParkingApp;

public class ContactDisplay implements ContactMsg {
    @Override
    public void phone() {
        System.out.println("If you encounter any issue, call 1-800-366-PARK");
    }

    @Override
    public String toString() {
        return "Stop at the front desk, Our customer service can help!!";
    }
}
