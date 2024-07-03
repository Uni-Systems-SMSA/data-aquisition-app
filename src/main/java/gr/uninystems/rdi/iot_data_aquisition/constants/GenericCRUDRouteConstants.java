package gr.uninystems.rdi.iot_data_aquisition.constants;

public class GenericCRUDRouteConstants {

    public static final String CAMEL_EXCHANGE_GENERIC_INTERNAL_PATH_HEADER_NAME = "X-Backend-InternalPath";
    public static final String CAMEL_EXCHANGE_GENERIC_BASE_URL = "Application";
    public static final String CAMEL_EXCHANGE_SHOULD_FILTER_EXCHANGE_PROPERTY = "GenericRouteShouldFilter";
    public static final String CAMEL_EXCHANGE_GENERIC_CRUD_GENERIC_REST_PATH_PROPERTY = "genericCRUDRestPath";
    public static final String CAMEL_EXCHANGE_GENERIC_CRUD_GENERIC_ROUTE_SERVICE_HEADER_ID_PROPERTY = "genericCRUDRouteServiceHeaderID";
    public static final String CAMEL_EXCHANGE_GENERIC_CRUD_GENERIC_ROUTE_SERVICE_PAYLOAD_PROPERTY = "genericCRUDRouteServicePayloadBody";
    
    private GenericCRUDRouteConstants() {
        // Default private constructor
    }
}
