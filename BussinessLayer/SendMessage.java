package BussinessLayer;

public class SendMessage {
    public void SendAMessage(String recepient, String MessageContent, String Subject) throws Exception{
        JavaMailUtil.sendMail(recepient, MessageContent, Subject);
    }
}
