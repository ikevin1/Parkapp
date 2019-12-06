package Ikevin_U2_ParkingApp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Time class is for all the parking fees, determine if
 * ticket was lost and or a special event parking plus time parked.
 * Also generates parking ID for all checked in vehicle.
 * @author iKevin
 */
public class Time{
    private final Calendar inTime;
    private final Calendar outTime;
    private static double fee;
    private static boolean lost;
    private static boolean event;
    private static AtomicInteger uniqueID = new AtomicInteger(1000);
    static int parkingID;

    /**
     * Constructor for the flat parking fee and the parking calendar time.
     */
    public Time() {
       // super();
        parkingID = uniqueID.getAndIncrement();
        this.inTime = Calendar.getInstance();
        this.outTime = Calendar.getInstance();
        this.fee = 5;
        this.lost = false;
        this.event = false;
        parkingID++;
    }

    public Time(Calendar inTime, Calendar outTime, double fee) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.fee = fee;
        lost = fee == 25;
        event = fee == 20;
        parkingID++;
    }

    public Time(boolean lost, boolean event, Calendar inTime, Calendar outTime) {
        this.inTime = inTime;
        this.outTime = outTime;

        this.fee = fee;
        lost = fee == 25;


        this.fee = fee;
        event = fee == 20;

    }
    public double getFee() {
        return fee;
    }

    public Time( Calendar inTime, Calendar outTime){
        this.inTime = inTime;
        this.outTime = outTime;
        this.fee = fee;

    }

    /**
     * Randomly generates time for checkin
     */
    public void checkIns() {
        ParkingCalendar date = new ParkingCalendar(1);
        inTime.setTime(date.calendar.getTime());
    }
    /**
     * Randomly generates time for checkout calendar
     */
    public void checkOuts() {
        ParkingCalendar date = new ParkingCalendar(2);
        outTime.setTime(date.calendar.getTime());
    }

    public static String getParkingID(){
        return Integer.toString(parkingID);
    }

    /**
     * generates fee for the receipt using the in and out time and the specified fee
     */
    public void calculateFee(){
        double hoursParked = outTime.get(Calendar.HOUR_OF_DAY) - inTime.get(Calendar.HOUR_OF_DAY);
        double minutesParked = outTime.get(Calendar.MINUTE) - inTime.get(Calendar.MINUTE);
        double timeParked= hoursParked + (minutesParked / 60);
        for(int i = 4; i < timeParked; i++){
            fee++;
        }
        if(fee > 15){
            fee = 15;
        }
    }

    /**
     * checks if ticket lost is true or false
     * @return
     */
    public boolean isLost() {
        return lost;
    }

    /**
     * sets the flat fee rate for a lost ticket
     * @return lost 25 when true
     */
    public static class lostTicket {

        public static void lost() {
            fee = 25;
            lost = true;
        }
        public static boolean isLost(){
            lost = true;
            return true;
        }
    }
    /**
     * sets the flat fee rate for a special event ticket
     * @return event, returns 20 when true
     */
    public boolean theEvent() {
        return event;
    }
    public static class specialEvent{

        public static void event() {
            fee = 20;
            event = true;
        }
        public  boolean theEvent(){
            event = true;
            return true;
        }
    }

    /**
     * Prints a detailed ticket info
     */
    public void receipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM'-'d HH:mm a", Locale.ENGLISH);
        System.out.println("***********************************");
        System.out.println("Receipt for Parking ID #" + parkingID); //add a method call for vehicle ID
        System.out.println("Time in>>>>  " + dateFormat.format(inTime.getTime()));
        System.out.println("***********************************");
        System.out.println("==>");
    }

    /**
     * prints the parking ID and time checked in or out
     */
    public void altReceipt(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM'-'d HH:mm a", Locale.ENGLISH);
        System.out.println("***********************************");
        System.out.println("Receipt for Parking ID #" + parkingID); //add a method call for vehicle ID
        System.out.println("***********************************");
        if(lost) {
            System.out.println("******Lost Ticket !!!");
        }else if(event) {
            System.out.println("Special Event Ticket!!!");
        }else{
            System.out.println("Time in>>>>  " + dateFormat.format(inTime.getTime()));
            System.out.println("Time out>>>> " + dateFormat.format(outTime.getTime()));
        }
        System.out.println("***********************************");
        System.out.println("==>Pay Now: $" + fee + " <==");
        System.out.println("***********************************");
        System.out.println("==>");
    }

    /**
     * On prints, it returns the String in and out time plus the fee for the event that happened.
     * @return fee, in and out time
     */
    @Override
    public String toString(){
        return inTime.getTime() + "," + outTime.getTime() + "," + fee;
    }
}

