package dev;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class MessageServiceRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {
        String messageType = env.getProperty("app.message-type", "email");
        System.out.println("Registering MessageService of type: " + messageType);
        switch (messageType.toLowerCase()) {
            case "email" -> registry.registerBean("messageService", EmailMessageService.class,
                    spec -> spec.description("Email Message service registered via the BeanRegistrar"));
            case "sms" -> registry.registerBean("messageService", SmsMessageService.class,
                    spec -> spec.description("SMS Message service registered via the BeanRegistrar"));

            default -> throw new IllegalArgumentException("Unknown message type " + messageType);
        }
    }

}
