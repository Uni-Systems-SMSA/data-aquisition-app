package gr.uninystems.rdi.iot_data_aquisition.constants;

public class CamelExchangeConstants {
    
    public static final String CAMEL_EXCHANGE_REST_REQUEST_HEADERS_PROPERTY = "RestRequestHeaders";
    public static final String CAMEL_EXCHANGE_REST_REQUEST_QUERY_PARAMS_PROPERTY = "RestRequestQueryParams";
    public static final String CAMEL_EXCHANGE_REST_REQUEST_ID_HEADER_PROPERTY = "id";
    public static final String CAMEL_EXCHANGE_PSPI_REMOTE_IP_ADDRESS_PROPERTY = "pspi-remote-ip-address";
    public static final String CAMEL_EXCHANGE_JWT_PROPERTY = "jwt";

    public static final String CAMEL_EXCHANGE_UPLOAD_FOLDER_STRUCTURE_PROPERTY = "uploadFolderStructure";
    public static final String CAMEL_EXCHANGE_DMS_DOCUMENT_INFORMATION_PROPERTY = "dmsDocumentInformation";
    public static final String CAMEL_EXCHANGE_CREATED_DMS_DOCUMENT_ID_PROPERTY = "dmsDocumentID";
    public static final String CAMEL_EXCHANGE_UPLOAD_DOCUMENT_ROUTE_RESPONSE_PROPERTY = "dmsUploadDocumentResponse";
    public static final String CAMEL_EXCHANGE_MULTIPLE_CREATED_DMS_DOCUMENT_IDS_PROPERTY = "dmsMultiUploadDocumentResponse";
    public static final String CAMEL_EXCHANGE_MULTI_UPLOAD_DOCUMENT_ROUTE_RESPONSE_PROPERTY = "dmsDocumentIDs";
    
    private CamelExchangeConstants() {
        // Default no-args private constructor
    }
    
}
