package dp.command;

import lombok.AllArgsConstructor;
import org.apache.log4j.helpers.ISO8601DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
public class RemoteControl {
    private Command command;

    public void hitButton() {
        command.execute();
    }

    public static void main(String[] args) throws ParseException {
        //  System.out.println(new Date("2020-06-08T10:47:09.359Z"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date parse = format.parse("2020-06-08T10:47:09.359Z");
        System.out.println(parse);
        try {

            Date date = new Date("2020-06-08T10:47:09.359Z");
        } catch (Exception e) {
            System.out.println("you created a bug in the lib");
        }

    }
}
