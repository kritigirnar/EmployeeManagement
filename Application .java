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
//
    for (int i = 0; i < getArray.length(); i++) {
            JSONObject objects = getArray.getJSONObject(i);
            Iterator key = objects.keys();
            while (key.hasNext()) {
                String k = key.next().toString();
                System.out.println("Key : " + k + ", value : "
                        + objects.getString(k));
            }
            // System.out.println(objects.toString());
            System.out.println("-----------");

        }
    --------
    
    import org.json.*;

// Assuming the JSON object is stored in a String variable called "jsonString"
JSONObject jsonObj = new JSONObject(jsonString);

// Accessing the "ammenities" array
JSONArray amenitiesArray = jsonObj.getJSONArray("ammenities");

// Accessing the first (and only) object in the "ammenities" array
JSONObject amenitiesObj = amenitiesArray.getJSONObject(0);

// Accessing the entire "ammenities" object
String amenitiesResponse = amenitiesObj.toString();
-------
    import java.util.List;
import java.util.Map;

public class Amenities {
    private Map<String, Object> business;
    private Map<String, Object> first;
    private Map<String, Object> premiumEconomy;
    private Map<String, Object> economy;

    public Amenities(Map<String, Object> business, Map<String, Object> first, Map<String, Object> premiumEconomy, Map<String, Object> economy) {
        this.business = business;
        this.first = first;
        this.premiumEconomy = premiumEconomy;
        this.economy = economy;
    }

    public Map<String, Object> getBusiness() {
        return business;
    }

    public Map<String, Object> getFirst() {
        return first;
    }

    public Map<String, Object> getPremiumEconomy() {
        return premiumEconomy;
    }

    public Map<String, Object> getEconomy() {
        return economy;
    }
}

    
    ----
        
import com.fasterxml.jackson.databind.ObjectMapper;

// Assuming the JSON object is stored in a String variable called "jsonString"
ObjectMapper objectMapper = new ObjectMapper();
Amenities amenities = objectMapper.readValue(jsonString, Amenities.class);

}
