package dev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

// @Configuration
public class WebConfig {

    /*
     * with bean configuration - to much boilerplate
     */
    // @Bean
    // TodoService todoService(RestClient.Builder restClientBuilder) {
    // var restClient =
    // restClientBuilder.baseUrl("https://jsonplaceholder.typicode.com/").build();

    // RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
    // HttpServiceProxyFactory factory =
    // HttpServiceProxyFactory.builderFor(restClientAdapter).build();
    // return factory.createClient(TodoService.class);
    // }

}
