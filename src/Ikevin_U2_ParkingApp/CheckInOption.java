package Ikevin_U2_ParkingApp;

import java.util.Scanner;

/**
 * The class holds a checkin option of the checkin parking garage
 */
public class CheckInOption {
    //public CheckIns checkIns;

    public static void  option() {
        Scanner keyboard = new Scanner(System.in);
        String choice;
        String specialEvent;
        String regular;


        System.out.println("****************");
        System.out.println("7 - Regular");
        System.out.println("8 - Special Event");
        System.out.println("==>");
        choice = keyboard.nextLine();
        switch (choice) {
            case "7":
            case "regular":
                System.out.println("<<<<<<Regular parking selected>>>>>>");
                System.out.println("Rate starts at $5/hr");
                break;

            case "8":
            case "special Event":
                System.out.println("<<<<<< Special Event Parking Selected>>>>>>>>");
                System.out.println("Flat rate of $20");
                Time.specialEvent.event();
                break;

            default:
                System.out.println("***********************************");
                System.out.println("Please make selection for check-in option");
        }
    }
}
