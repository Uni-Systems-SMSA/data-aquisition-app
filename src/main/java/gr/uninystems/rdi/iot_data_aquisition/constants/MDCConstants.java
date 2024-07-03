package gr.uninystems.rdi.iot_data_aquisition.constants;

public class MDCConstants {

    public static final String MDC_TRACEID_PROPERTY_NAME = "traceId";
    public static final String MDC_SPANID_PROPERTY_NAME = "spanId";
    public static final String MDC_UBERTRACEID_PROPERTY_NAME = "uberTraceID";
    
    public static final String MDC_X_REQUEST_ID_PROPERTY_NAME = "X-Gateway-RequestID";
    public static final String MDC_X_REQUEST_USER_ID_PROPERTY_NAME = "X-Gateway-RequestUserID";
    public static final String MDC_X_REQUEST_USER_NAME_PROPERTY_NAME = "X-Gateway-RequestUserName";
    public static final String MDC_X_REQUEST_METHOD_PROPERTY_NAME = "X-Gateway-RequestMethod";
    public static final String MDC_X_REQUEST_ENTRYPOINT_PROPERTY_NAME = "X-Gateway-RequestEntryPoint";
    public static final String MDC_X_REQUEST_APP_SERVER_PROPERTY_NAME = "X-Gateway-RequestAppServer";
    public static final String MDC_X_REQUEST_PROTOCOL_PROPERTY_NAME = "X-Gateway-RequestProtocol";
    
    private MDCConstants() {
        // Use in a static manner
    }
}
