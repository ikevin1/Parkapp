package Ikevin_U2_ParkingApp.Test;

import Ikevin_U2_ParkingApp.Record;
import Ikevin_U2_ParkingApp.Time;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a unit test class
 * It helps us define the flow of execution of our code with different Annotations.
 */
class TimeTest {

    @org.junit.jupiter.api.Test
/**
 * Testing for method getfee()
 * to verify if fee for special event parking of $20
 * returns true
 */
    void theEvent() {
        Record record = new Record();
        for (Time t : record.getRecord()){
            assertTrue(t.theEvent() && t.getFee() ==  20);
        }
    }
}