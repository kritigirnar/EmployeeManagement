import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    
    {
    "customers": [
        {
            "customerId": "0434556574",
            "paymentCode": "90501"
        }
    ]
}
You would need to classes to match the JSON structure:
    Arrays are mentioned as -->[] IN. JSON
        they are mapped with the help of list

public class CustomersData {
    private List<Customer> customers;

    // Constructor, getter and setter
}
public class Customer {
    private String customerId;
    private String paymentCode;

    // Constructor, getter and setter
}
    
    


}
