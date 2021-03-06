import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.video.v1.Room;
import com.twilio.rest.video.v1.Room.RoomStatus;

public class Example {
    // Get your Account SID and Auth Token from https://twilio.com/console
    // To set up environment variables, see http://twil.io/secure
    public static final String API_KEY_SID = System.getenv("TWILIO_API_KEY_SID");;
    public static final String API_KEY_SECRET = System.getenv("TWILIO_API_KEY_SECRET");

    public static void main(String args[]) {
        // Initialize the client
        Twilio.init(API_KEY_SID, API_KEY_SECRET);

        ResourceSet<Room> rooms = Room.reader().setStatus(RoomStatus.COMPLETED)
                .setUniqueName("DailyStandup").read();

        // Loop over rooms and print out a property for each one.
        for (Room room : rooms) {
            System.out.println(room.getSid());
        }
    }
}
