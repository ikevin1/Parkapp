package Ikevin_U2_ParkingApp;

import java.util.Random;
import java.util.Scanner;

import static Ikevin_U2_ParkingApp.Parking.record;

public class CheckIns {

    public static void  enter(){
        Scanner keyboard = new Scanner(System.in);
        String choice;

        /**
         * Print Menu for garage checkin
         */
        System.out.println("");
            System.out.println("*****Welcome to Ultimate 24/7 Parking******");
            System.out.println("Choose from the menu below\n");
            System.out.println("0 - press zero to open");
            choice = keyboard.nextLine();

        /**
         * parking menu selection
         * @param checkin gives the option of a regular or special event parking. Each has a separate parking fee
         * we have to save the call in another class called checkInOption
         */
        switch (choice) {
                case "0"://Open the garage
                    System.out.println("****************");
                    System.out.println("1 - Check in");
                    System.out.println("2 - Staff * or ** Authorized personnel===>(Scan ID/iPass)");
                    System.out.println("3 - Close Garage");
                    System.out.println("==>");
                    choice = keyboard.nextLine();

                    /**
                     * Checkin Menu selection case
                     */
                    switch (choice) {
                        case "1"://check into the garage
                        case "come":
                        case "check ins":
                            CheckInOption.option();
                            System.out.println("**************************");
                            System.out.println("Garage open\n ==CAUTION!!!\n Please drive 5 MPH.");
                            System.out.println("**************************");
                            record.parkingTicket();
                            record.printInward();
                            Parking.fill();
                            break;
                        case "2"://check into the garage
                        case "check out":
                            System.out.println("**************************");
                            System.out.println("Oh no, something bad just happened");
                            System.out.println("Sorry you're not authorized to use this selection");
                            System.out.println("**************************");
                            break;
                        case "3": //close the garage
                        case "close":
                        case "close parking":
                            record.printReceipt();
                            Parking.close();
                            break;
                        default:
                            System.out.println("***********************************");
                            System.out.println("Please make selection from the menu");
                    }
                    break;

                default:
                    System.out.println("Please make a selection.");
            }

        }


}
