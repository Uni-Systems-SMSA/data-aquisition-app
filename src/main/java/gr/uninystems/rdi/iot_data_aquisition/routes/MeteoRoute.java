//package gr.uninystems.rdi.iot_data_aquisition.routes;
//
//
//import org.apache.camel.builder.RouteBuilder;
//
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//public class MeteoRoute extends RouteBuilder {
//    @Override
//    public void configure() throws Exception {
//        from("timer://foo?period=100000")
//                .setHeader("CamelHttpMethod", constant("GET"))
//                .to("https://stratus.meteo.noa.gr/data/stations/latestValues_unisystems.json")
//                .log("Response: Test +  ${body}");
//    }
//}
//
//
