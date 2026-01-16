package dev;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MessageServiceRegistrar.class)
public class WebConfig {

    // beans

    /*
     * still works
     * 
     * @Bean
     * public EmailMessageService emailMessageService() {
     * return new EmailMessageService();
     * }
     */

}
