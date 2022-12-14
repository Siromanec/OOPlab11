package strategy;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
public class MailSender {
    private static final String API_KEY = "";
    private static final String API_SECRET = "";
    public static void main(String[] args) throws MailjetException, MailjetSocketTimeoutException {
        MailCode mailCode = new GiftMail();
        Client client = new Client("serhii", "serhii.ivanov@ucu.edu.ua");
        MailInfo mailInfo = new MailInfo(mailCode, client);
        MailjetClient mailjetClient;
        MailjetRequest request;
        MailjetResponse response;
        mailjetClient = new MailjetClient(API_KEY, API_SECRET, new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "serhii.ivanov@ucu.edu.ua")
                                        .put("Name", "Me"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", client.getEmail())
                                                .put("Name", client.getName())))
                                .put(Emailv31.Message.SUBJECT, "Greetings from Mailjet.")
                                .put(Emailv31.Message.TEXTPART, "My first Mailjet email")
                                .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
                                .put(Emailv31.Message.HTMLPART, mailInfo.generate())
                                .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
        response = mailjetClient.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
