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
    "phoneNumbers":[
            {
            "type":"home", "number":"212 555-1234"
            },
         {
            "type":"fax", "number":"212 555-1234"
         }
     ],
     "firstName":"John"

         
         JSONArray ja = (JSONArray) jo.get("phoneNumbers");
          
        // iterating phoneNumbers
        Iterator itr2 = ja.iterator();
          
        while (itr2.hasNext()) 
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    
    JSONParser parser = new JSONParser();

Object obj = parser.parse(new FileReader("simple.json"));

JSONObject jsonObject = (JSONObject) obj;

for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
  String key = (String) iterator.next();
  System.out.println(jsonObject.get(key));
}


}
