//package gr.uninystems.rdi.iot_data_aquisition.routes;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.rest.RestBindingMode;
//import org.apache.camel.model.rest.RestPropertyDefinition;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CamelContextConfigurationRoute extends RouteBuilder {
//
//    private static final Logger logger = LoggerFactory.getLogger(CamelContextConfigurationRoute.class);
//
//    private static final String CONTEXT_CONFIGURATION_STARTUP_ROUTE_ID = "context-configuration-startup-route";
//    private static final String OPENAPI_ROUTE_ID = "openapi-route";
//
//    @Value("${camel.rest.component}")
//    private String camelRestComponent;
//
//    @Value("${server.servlet.context-path}")
//    private String applicationContextPath;
//
//    @Value("${api.path:/openapi}")
//    private String openApiContextPath;
//
//    @Value("${api.title:}")
//    private String openApiTitle;
//
//    @Value("${api.description:}")
//    private String openApiDescription;
//
//    @Value("${api.version:}")
//    private String openApiVersion;
//
//    @Override
//    public void configure() throws Exception {
//        // Prepare components
//        prepareRestComponent();
//        prepareJackson();
//
//        // Log the component used for REST
//        logger.info("REST component: {}", camelRestComponent);
//
//        // Define a startup route
//        from("direct:start")
//                .startupOrder(HIGHEST)
//                .routeId(CONTEXT_CONFIGURATION_STARTUP_ROUTE_ID)
//                .log("Context configuration startup route executed")
//                .to("mock:result");
//    }
//
//    /**
//     * Configure Jackson for JSON processing in Camel.
//     */
//    private void prepareJackson() {
//        getCamelContext().getGlobalOptions().put("CamelJacksonEnableTypeConverter", "true");
//        getCamelContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo", "true");
//    }
//
//    /**
//     * Configure the REST component and OpenAPI documentation.
//     */
//    private void prepareRestComponent() {
//        List<RestPropertyDefinition> apiProperties = new ArrayList<>();
//        apiProperties.add(new RestPropertyDefinition("api.title", openApiTitle));
//        apiProperties.add(new RestPropertyDefinition("api.description", openApiDescription));
//        apiProperties.add(new RestPropertyDefinition("api.version", openApiVersion));
//
//        restConfiguration()
//                //.component(camelRestComponent)
//                .host("localhost")
//                .port(8080)
//                .contextPath(applicationContextPath + "/camel")
//                .bindingMode(RestBindingMode.auto)
//                .enableCORS(true)
//                .apiContextPath(openApiContextPath)
//                .apiContextRouteId(OPENAPI_ROUTE_ID)
//                .setApiProperties(apiProperties);
//    }
//}



package gr.uninystems.rdi.iot_data_aquisition.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestPropertyDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CamelContextConfigurationRoute extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(CamelContextConfigurationRoute.class);


    private static final String CONTEXT_CONFIGURATION_STARTUP_ROUTE_ID = "context-configuration-startup-route";
    private static final String OPENAPI_ROUTE_ID = "openapi-route";

    @Value("${camel.rest.component}")
    private String camelRestComponent;

    @Value("${server.servlet.context-path}")
    private String applicationContextPath;

    @Value("${api.path:/openapi}")
    private String openApiContextPath;

    @Value("${api.title:}")
    private String openApiTitle;

    @Value("${api.description:}")
    private String openApiDescription;

    @Value("${api.version:}")
    private String openApiVersion;

//    @Value("${opentracing.jaeger.enabled}")
//    private String tracingEnabled;

    @Override
    public void configure() throws Exception {
        prepareRestComponent();
        //prepareMetricsComponent();
        prepareJackson();
        //prepareTracer();
        //preparePropertiesComponent();

        logger.info("Properties locations:{}", getContext().getComponent(camelRestComponent));

        from("direct:start")
            .startupOrder(HIGHEST)
            .routeId(CONTEXT_CONFIGURATION_STARTUP_ROUTE_ID)
            .to("mock:result");

    }

    /**
     * Prepare Jackson for Camel
     */
    private void prepareJackson() {
        getCamelContext().getGlobalOptions().put("CamelJacksonEnableTypeConverter", "true");
        getCamelContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo", "true");
    }

    /**
     * Prepare Rest component
     */
    private void prepareRestComponent() {

        List<RestPropertyDefinition> apiProperties = new ArrayList<>();
        apiProperties.add(new RestPropertyDefinition("api.title", openApiTitle));
        apiProperties.add(new RestPropertyDefinition("api.description", openApiDescription));
        apiProperties.add(new RestPropertyDefinition("api.version", openApiVersion));

        restConfiguration()

            .component(camelRestComponent)
            .contextPath(applicationContextPath + "/camel")
            .bindingMode(RestBindingMode.auto)
            .enableCORS(true)
            .apiContextPath(openApiContextPath)
            .apiContextRouteId(OPENAPI_ROUTE_ID)
            .setApiProperties(apiProperties);

    }

//    private void prepareMetricsComponent() {
//        getCamelContext().addRoutePolicyFactory(new MicrometerRoutePolicyFactory());
//    }
//
//    private void prepareTracer() {
//
//        //todo check after migrating to camel 4.3.0
//        if (Boolean.parseBoolean(tracingEnabled)) {
//
//            CamelContext camelContext = getCamelContext();
//            camelContext.setTracing(true);
//            camelContext.setUseBreadcrumb(true);
//            camelContext.setUseMDCLogging(true);
//
//            if (!camelContext.isStarted()) {
//                camelContext.start();
//            }
//
//        }
//    }
//
//    private void preparePropertiesComponent() {
//        PropertiesComponent propertiesComponent = (PropertiesComponent) getContext().getComponent(camelRestComponent);
//        getPropertiesLocations().stream()
//                .forEach(location ->
//                        getCamelContext().getPropertiesComponent().addLocation(location));
//    }
//
//    private Collection<String> getPropertiesLocations() {
//        return Stream.of(
//              "camel-props/epm-gateway-camel-props.properties")
//              .collect(Collectors.toCollection(HashSet::new));
//    }

}
