package gr.uninystems.rdi.iot_data_aquisition.routes;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr.uninystems.rdi.iot_data_aquisition.model.Bored;
import gr.uninystems.rdi.iot_data_aquisition.service.BoredService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoredRoute extends RouteBuilder {

    @Autowired
    private BoredService boredService;

    @Override
    public void configure() throws Exception {
        from("timer://foo?period=10000")
                .setHeader("CamelHttpMethod", constant("GET"))
                .to("https://bored-api.appbrewery.com/random")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode jsonNode = mapper.readTree(body);

                    Bored data = new Bored();
                    data.setActivity(jsonNode.path("activity").asText());
                    data.setAvailability(jsonNode.path("availability").asText());
                    data.setType(jsonNode.path("type").asText());
                    data.setParticipants(jsonNode.path("participants").asText());
                    data.setPrice(jsonNode.path("price").asText());
                    data.setAccessibility(jsonNode.path("accessibility").asText());
                    data.setDuration(jsonNode.path("duration").asText());
                    data.setKidFriendly(jsonNode.path("kidFriendly").asBoolean());
                    data.setLink(jsonNode.path("link").asText());
                    data.setKey(jsonNode.path("key").asLong());

                    boredService.saveBored(data);
                })
                .log("Response: Test +  ${body}");
    };


    }
