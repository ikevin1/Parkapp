package Ikevin_U2_ParkingApp;

import java.util.Scanner;
import static Ikevin_U2_ParkingApp.Parking.record;

public class CheckOuts {

    public static void enter () {
        Scanner keyboard = new Scanner(System.in);
        String choice;
            System.out.println("");
            System.out.println("**************Thanks for using our service @ Ultimate 24/7 Parking********************");
            System.out.println("Choose from the menu below to check out\n");
            System.out.println("3 - Did you need a car wash?(Y/N)\n\n (......Oooops!!! Car wash is not active right now, press 3 to continue)");
            choice = keyboard.nextLine();
        /**
         * Checkout Menu selection
         */
        switch (choice) {
                case "3"://quit the car wash and continue to check out
                    System.out.println("we're sorry our car wash is not available due to technical difficulties");
                    //
                    System.out.println("4 - Check out");
                    System.out.println("5 - Ticket lost");
                    System.out.println("6 - Special Event");
                    System.out.println("==>");
                    choice = keyboard.nextLine();

                    switch (choice) {
                        case "4"://check out the garage
                        case "go":
                            record.printOutward();
                            Parking.empty();
                            break;
                        case "5": //close the garage
                        case "lost":
                            System.out.println("*************************************");
                            System.out.println("Lost Ticket.\n Warning!!!\nThere's a $25 charge.");
                            System.out.println("*************************************");
                            System.out.println("==>");
                            record.lostTicket();
                            Time.lostTicket.lost();
                            Parking.empty();
                            break;
                        case "6": //close the garage
                            System.out.println("*************************************");
                            System.out.println("Special Ticket.\n Warning!!!\nThis's a flat fee $20 charge.");
                            System.out.println("*************************************");
                            System.out.println("==>");
                            record.specialEvent();
                            Time.specialEvent.event();
                            Parking.empty();
                            break;
                        default:
                            System.out.println("*************************************");
                            System.out.println("Please enter a good selection from the menu");
                    }
                    break;

                default:
                    System.out.println("Please enter 0 to continue.");
            }
    }
}
