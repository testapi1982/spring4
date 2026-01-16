package dev;

public class SmsMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "📱 SMS Message sent at " + java.time.LocalDateTime.now();
    }

    @Override
    public String getServiceType() {
        return "SMS";
    }

}
