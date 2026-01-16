package dev;

import java.time.LocalDateTime;

public class EmailMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "📩 Email Message sent at " + LocalDateTime.now();
    }

    @Override
    public String getServiceType() {
        return "EMAIL";
    }

}
