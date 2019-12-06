package Ikevin_U2_ParkingApp;

import Ikevin_U2_ParkingApp.Time.lostTicket;
import Ikevin_U2_ParkingApp.Time.specialEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class creates and save a new ticket.
 * An ArrayList was created to hold all Tickets.
 * @author iKevin
 */

public class Record {
      private final List<Time> record = new ArrayList<Time>();
      private final File file = new File("car.txt");

    /**
     * This constructor only initialize the Ticket list from the previous,
     * then create into the Arrays of Tickets and read from the file
     */
    public Record() {
        try {
            Scanner inputFile = new Scanner(file);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            while (inputFile.hasNext())
            {
                String line = inputFile.nextLine();
                String[] lineInfo = line.split(",");
                Calendar newIn = Calendar.getInstance();
                newIn.setTime(dateFormat.parse(lineInfo[0]));
                Calendar newOut = Calendar.getInstance();
                newOut.setTime(dateFormat.parse(lineInfo[1]));
                record.add(new Time(newIn, newOut, Double.parseDouble(lineInfo[2])));

            }
            inputFile.close();
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * Create a new Ticket and adds to record list
     */
    public void parkingTicket(){
        record.add(new Time());
    }

    /**
     * This prints the time for the user, then check last in-ticket.
     */
    public void printInward(){
        record.get(record.size() - 1).checkIns();
        record.get(record.size() - 1).receipt();
    }

    public void printOutward(){
        record.get(record.size() - 1).checkOuts();
       record.get(record.size() - 1).calculateFee();
        record.get(record.size() - 1).altReceipt();
        saveTickets();
    }

    public void lostTicket(){

        lostTicket.lost();
        record.get(record.size() - 1).altReceipt();
        saveTickets();
    }

    public void specialEvent(){
        specialEvent.event();
        record.get(record.size() - 1).altReceipt();
        saveTickets();
    }

    private void saveTickets(){
        try{
            PrintWriter output = new PrintWriter(file);
            for (Time toSave : record) {
                output.println(toSave.toString());
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
public void printReceipt(){
    int payNow = 0;
    int bill = 0;

    int billLost = 0;
    int noTicket = 0;

    int myEvent = 0;
    int special = 0;


    for (Time t : record) {
        if (t.isLost()) {
            noTicket++;
            billLost += t.getFee();
        }else if (t.theEvent()){
            special++;
            myEvent += t.getFee();
        }
          else{
             payNow++;
             bill += t.getFee();
         }

    }
    System.out.println("********************************");
    System.out.println("Ticket(s) counted  to" + Time.getParkingID());
    System.out.println("********************************" );

    System.out.println("$" + bill + " was collected from " + payNow + " paid tickets.");
    System.out.println("$" + billLost + " was collected from " + noTicket + " lost tickets.");
    System.out.println("$" + myEvent + " was collected from " + special + " special event");
    System.out.println("********************************");
    System.out.println("$" + (billLost + bill + myEvent) + " collected overall.");
    System.out.println("********************************");
    System.out.println("==>");

    }

    /**
     * returns data
     * for test unit
     * @return theEvent
     */

    public List<Time> getRecord(){
        return record;
    }
}
