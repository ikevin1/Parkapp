package Ikevin_U2_ParkingApp;

//public class TicketValidated {
//    private static final TicketValidated instance = new TicketValidated();
//
//    //private constructor to avoid client applications to use constructor
//    private TicketValidated(){}
//
//    public static TicketValidated getInstance(){
//        return instance;
//    }
//}

public class TicketValidated {

    /**
     * Static member holds only one instance of the (Singleton)
     *
     *     TicketValidated class
     */

    private static TicketValidated ticketValidated;

    /**
     * Constructor
     * TicketValidated prevents any other class from instantiating
     */

    private TicketValidated() {

    }

    /**
     * Providing Global point of access
     * @return
     */

    public static TicketValidated getTicketValidated() {

        if (null == ticketValidated) {

            ticketValidated = new TicketValidated();

        }

        return ticketValidated;

    }

    public void printTicketValidated(){

        System.out.println("Ticket Validated");

    }

}