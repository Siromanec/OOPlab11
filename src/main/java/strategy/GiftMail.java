package strategy;

public class GiftMail implements MailCode{
    private static final String TEMPALTE = "hi %NAME, happy CyberMonday! Receive your gift now";

    @Override
    public String generate(Client client) {
        return TEMPALTE.replaceAll("%NAME", client.getName());
    }
}
