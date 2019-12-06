package Ikevin_U2_ParkingApp;

public class Parking {
    static final Record record = new Record();
    private static CheckIns come;
    private static CheckOuts go;
    private static boolean isOpen;
    private static boolean isEmpty;

    public Parking() {
        come = new CheckIns();
        go = new CheckOuts();
        isOpen = true;
        isEmpty = true;
    }
    public static void open(){
        while(isOpen){
            if(isEmpty) {
                come.enter();
            }else{
                go.enter();
            }
        }
    }
    public static void close(){
        System.out.println("**************");
        System.out.println("Garage closed.");
        System.out.println("**************");
        isOpen = false;
    }

    public static void fill(){
        isEmpty = false;

    }

    public static void empty(){
        isEmpty = true;
    }

}
