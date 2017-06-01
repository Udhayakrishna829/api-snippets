import com.twilio.twiml.Dial;
import com.twilio.twiml.Number;
import com.twilio.twiml.Redirect;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.TwiMLException;


public class Example {
    public static void main(String[] args) {
        Number number = new Number.Builder("415-123-4567").build();
        Dial dial = new Dial.Builder().number(number).build();
        Redirect redirect = new Redirect.Builder()
            .url("http://www.foo.com/nextInstructions").build();
        VoiceResponse response = new VoiceResponse.Builder().dial(dial)
            .redirect(redirect).build();

        try {
            System.out.println(response.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
    }
}