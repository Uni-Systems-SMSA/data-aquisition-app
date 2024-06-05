package gr.uninystems.rdi.iot_data_aquisition.routes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr.uninystems.rdi.iot_data_aquisition.model.ParkingSpot;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 */

@Component
public class ParkingSpotRoute extends RouteBuilder {
//    @Value("${routes.cicicom.documents.base-rest-path}")
//    private String documentsBaseRestPath;

    @Override
    public void configure() throws Exception {

//        rest(documentsBaseRestPath)
//                .get(CustomRestClientsConstants.ID_PATH_PARAMETER)
//                .id(getRestRouteID("information", HttpMethod.GET))
//                .routeId(getRestRouteID("information", HttpMethod.GET))
//                .description("Retrieves DMS document information for the specified document ID")
//                .produces(MediaType.APPLICATION_JSON_VALUE)
//                .outType(ParkingSpot.class)
//                .log(ParkingSpot.class.getName());
//                .param().name(CamelExchangeConstants.CAMEL_EXCHANGE_REST_REQUEST_ID_HEADER_PROPERTY).type(RestParamType.path).dataType(RouteConstants.ROUTE_STRING_PARAM_DATA_TYPE).description("The ID of the document").endParam()
//                .to(DIRECT_DMS_DOCUMENT_INFORMATION_GET_ROUTE_ID);


        //
        // ggps style working !!
        //
        //from("timer://foo?period=10000")
        from("direct:getAllParkingSensors")
                .routeId("direct:getAllParkingSensors")
                .setHeader("Authorization", constant("CicicomOath 7KeTc/33v06l8Reegnf+GQ=="))
                .to("http://dev.smartgridnet.com/smartGridPortalDev/api/CitizentsΒΟ/GetAllParkingSensors")
                .log("asdasdsa")
                //.unmarshal().json(JsonLibrary.Jackson, ParkingSpot[].class)
                .log("Response: ${body}");
//        rest()
//                from("direct:parking")
//                .get("/GetAllParkingSensors")
//
//                .to("direct:parking");




    }

}
