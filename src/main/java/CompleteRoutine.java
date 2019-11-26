import java.util.ArrayList;

public class CompleteRoutine {
    ArrayList<EmptyRoom> saturdayRooms,
                          sundayRooms,
                           mondayRooms,
                            tuesdayRooms,
                             wednesdayRooms,
                              ThursdayRooms;

    public CompleteRoutine(ArrayList<EmptyRoom> saturdayRooms, ArrayList<EmptyRoom> sundayRooms, ArrayList<EmptyRoom> mondayRooms, ArrayList<EmptyRoom> tuesdayRooms, ArrayList<EmptyRoom> wednesdayRooms, ArrayList<EmptyRoom> thursdayRooms) {
        this.saturdayRooms = saturdayRooms;
        this.sundayRooms = sundayRooms;
        this.mondayRooms = mondayRooms;
        this.tuesdayRooms = tuesdayRooms;
        this.wednesdayRooms = wednesdayRooms;
        ThursdayRooms = thursdayRooms;
    }
}
