package gr.uninystems.rdi.iot_data_aquisition.constants;

public class Constants {

    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";
    public static final String TILDE_STRING = "~";
    public static final String DASH_STRING = "-";
    public static final String FORWARD_SLASH_STRING = "/";
    public static final String NOT_APPLICABLE_STRING = "N/A";
    public static final String DOUBLE_QUOTE_STRING = "\"";
    public static final String COMMA_STRING = ",";
    public static final String COLON_STRING = ":";
    public static final String PIPE_STRING = "|";
    public static final String REGEX_PIPE_STRING = "\\|";
    public static final String DOT_STRING = ".";
    public static final String AMPERSAND_STRING = "&";
    public static final String QUESTIONMARK_STRING = "?";
    public static final String EQUALS_STRING = "=";
    
    public static final String CAMEL_DIRECT_ROUTE_PREFIX = "direct:";
    public static final String CAMEL_FILE_ROUTE_PREFIX = "file://";
    
    public static final String X_REQUEST_ID_PROPERTY_NAME = "X-REQUEST-ID";
    
    public static final String AN_EXCEPTION_OCCURED_MSG = "An exception occured";

    //pspi rest client
    public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    public static final String AUTHORIZATION_HEADER_BEARER_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER_BASIC_PREFIX = "Basic ";
    public static final String TRACING_X_B3_TRACEID_HEADER_NAME = "X-B3-TraceId";
    public static final String TRACING_X_B3_SPANID_HEADER_NAME = "X-B3-SpanId";
    public static final String TRACING_UBER_TRACE_ID_HEADER_NAME = "Uber-Trace-Id";

    //pspi Alfresco
    public static final String MDC_TRACEID_PROPERTY_NAME = "traceId";
    public static final String MDC_SPANID_PROPERTY_NAME = "spanId";
    public static final String MDC_UBERTRACEID_PROPERTY_NAME = "uberTraceID";

    public static final String ALFRESCO_TICKET_VALUE_HEADER_NAME = "X-Alfresco-Auth-Ticket";

    public static final String ALFRESCO_FOLDER_NODE_TYPE = "cm:folder";
    public static final String ALFRESCO_CONTENT_NODE_TYPE = "cm:content";
    public static final String ALFRESCO_OPS_DOCUMENT_NODE_TYPE = "mts:OPSDocument";

    public static final String ALFRESCO_CONTENT_PROP_TITLE_NAME = "cm:title";
    public static final String ALFRESCO_CONTENT_PROP_VERSION_TYPE_NAME = "cm:versionType";
    public static final String ALFRESCO_CONTENT_PROP_VERSION_LABEL_NAME = "cm:versionLabel";
    public static final String ALFRESCO_CONTENT_PROP_DESCRIPTION_NAME = "cm:description";
    public static final String ALFRESCO_ROOT_NODE_ALIAS = "-root-";
    public static final String VERSION_ID_PATH_PARAM = "versionID";
    public static final String FOLDER_NODE_ID_PATH_PARAM = "folderNodeID";
    public static final String DOCUMENT_NODE_ID_PATH_PARAM = "documentNodeID";
    public static final String NODE_ID_PATH_PARAM = "nodeID";
    public static final String ROOT_NODE_ID_QUERY_PARAM = "rootNodeId";
    public static final String NODE_TYPE_QUERY_PARAM = "nodeType";
    public static final String SEARCH_TERM_QUERY_PARAM = "term";
    public static final String FIELDS_TO_RETURN_QUERY_PARAM = "fields";

    public static final String NODE_ID_QUERY_PARAM = "nodeId";
    public static final String WHERE_QUERY_PARAM = "where";
    private Constants() {
        // Default no-args private constructor
    }
}
