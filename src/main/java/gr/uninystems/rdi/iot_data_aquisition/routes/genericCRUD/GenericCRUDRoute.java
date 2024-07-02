//package gr.uninystems.rdi.iot_data_aquisition.routes.genericCRUD;
//
//import gr.unisystems.epm.gateway.model.routes.genericCRUD.GenericCRUDRouteOperationType;
//import gr.unisystems.epm.gateway.processors.GenericCRUDDirectRoutePreparationProcessor;
//import gr.unisystems.epm.gateway.processors.core.GenericWSResponseServiceProcessor;
//import gr.unisystems.epm.gateway.processors.genericCRUD.*;
//import gr.unisystems.epm.gateway.routes.core.ExceptionAwareRoute;
//import gr.unisystems.epm.gateway.services.genericCRUD.GenericCRUDService;
//import gr.unisystems.epm.gateway.utils.CamelUtils;
//import org.apache.camel.model.dataformat.JsonLibrary;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GenericCRUDRoute extends ExceptionAwareRoute {
//
//    public static final String GENERIC_CRUD_ROUTE_ID_PREFIX = "generic-crud-";
//
//    public static final String CAMEL_EXCHANGE_GENERIC_CRUD_REQUEST_TYPE_PROPERTY = "genericCRUDRouteRequestType";
//    public static final String CAMEL_EXCHANGE_GENERIC_CRUD_DIRECT_ROUTE_ID_PROPERTY = "genericCRUDDirectRouteID";
//
//    private final String routeBasePath;
//
//    private final GenericCRUDGetRestRoutePreparationProcessor getRestRoutePreparationProcessor;
//    private final GenericCRUDPostRestRoutePreparationProcessor postRestRoutePreparationProcessor;
//    private final GenericCRUDPutRestRoutePreparationProcessor putRestRoutePreparationProcessor;
//    private final GenericCRUDPatchRestRoutePreparationProcessor patchRestRoutePreparationProcessor;
//    private final GenericCRUDDeleteRestRoutePreparationProcessor deleteRestRoutePreparationProcessor;
//
//    private final GenericCRUDDirectRoutePreparationProcessor directRoutePreparationProcessor;
//
//    private final GenericWSResponseServiceProcessor genericWSServiceResponseProcessor;
//    private final GenericCRUDService service;
//
//    public GenericCRUDRoute(
//            GenericCRUDService service,
//            GenericCRUDGetRestRoutePreparationProcessor getRestRoutePreparationProcessor,
//            GenericCRUDPostRestRoutePreparationProcessor postRestRoutePreparationProcessor,
//            GenericCRUDPutRestRoutePreparationProcessor putRestRoutePreparationProcessor,
//            GenericCRUDPatchRestRoutePreparationProcessor patchRestRoutePreparationProcessor,
//            GenericCRUDDeleteRestRoutePreparationProcessor deleteRestRoutePreparationProcessor,
//            GenericCRUDDirectRoutePreparationProcessor directRoutePreparationProcessor,
//            GenericWSResponseServiceProcessor genericWSServiceResponseProcessor,
//            @Value("${routes.genericCRUDRestPath:/genericcrud}") String routeBasePath) {
//        this.service = service;
//        this.directRoutePreparationProcessor = directRoutePreparationProcessor;
//        this.getRestRoutePreparationProcessor = getRestRoutePreparationProcessor;
//        this.postRestRoutePreparationProcessor = postRestRoutePreparationProcessor;
//        this.putRestRoutePreparationProcessor = putRestRoutePreparationProcessor;
//        this.patchRestRoutePreparationProcessor = patchRestRoutePreparationProcessor;
//        this.deleteRestRoutePreparationProcessor = deleteRestRoutePreparationProcessor;
//        this.genericWSServiceResponseProcessor = genericWSServiceResponseProcessor;
//        this.routeBasePath = routeBasePath;
//    }
//
//    @Override
//    public void configure() throws Exception {
//        super.configure();
//        configureGetRoutes();
//        configurePostRoutes();
//        configurePutRoutes();
//        configurePatchRoutes();
//        configureDeleteRoutes();
//    }
//
//    private void configureGetRoutes() {
//        String restRouteID = getRestRouteID(GenericCRUDRouteOperationType.GET_REST);
//
//        rest(routeBasePath)
//            .get()
//            .id("GET base generic route")
//            .routeId(restRouteID)
//            .produces(MediaType.APPLICATION_JSON_VALUE)
//            .to(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL));
//
//        from(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL))
//            .id(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL))
//            .process(getRestRoutePreparationProcessor)
//            .process(directRoutePreparationProcessor)
//            .toD(CamelUtils.getValueBuilderCompatibleExchangePropertyIdentifier(CAMEL_EXCHANGE_GENERIC_CRUD_DIRECT_ROUTE_ID_PROPERTY));
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL))
//            .bean(service, GenericCRUDRouteOperationType.GET_ALL.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL_FILTERED))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_ALL_FILTERED))
//            .bean(service, GenericCRUDRouteOperationType.GET_ALL_FILTERED.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_SINGLE))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_SINGLE))
//            .bean(service, GenericCRUDRouteOperationType.GET_SINGLE.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_COUNT))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_COUNT))
//            .bean(service, GenericCRUDRouteOperationType.GET_COUNT.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_COUNT_FILTERED))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.GET_COUNT_FILTERED))
//            .bean(service, GenericCRUDRouteOperationType.GET_COUNT_FILTERED.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//
//    }
//
//    private void configurePostRoutes() {
//        String restRouteID = getRestRouteID(GenericCRUDRouteOperationType.POST_REST);
//
//        rest(routeBasePath)
//            .post()
//            .id("POST base generic route")
//            .routeId(restRouteID)
//            .produces(MediaType.APPLICATION_JSON_VALUE)
//            .to(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.POST_CREATE));
//
//        from(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.POST_CREATE))
//            .id(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.POST_CREATE))
//            .process(postRestRoutePreparationProcessor)
//            .process(directRoutePreparationProcessor)
//            .toD(CamelUtils.getValueBuilderCompatibleExchangePropertyIdentifier(CAMEL_EXCHANGE_GENERIC_CRUD_DIRECT_ROUTE_ID_PROPERTY));
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.POST_CREATE))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.POST_CREATE))
//            .bean(service, GenericCRUDRouteOperationType.POST_CREATE.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//
//    }
//
//    private void configurePutRoutes() {
//        String restRouteID = getRestRouteID(GenericCRUDRouteOperationType.PUT_REST);
//
//        rest(routeBasePath)
//            .put()
//            .id("PUT base generic route")
//            .routeId(restRouteID)
//            .produces(MediaType.APPLICATION_JSON_VALUE)
//            .to(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.PUT));
//
//        from(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.PUT))
//            .id(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.PUT))
//            .process(putRestRoutePreparationProcessor)
//            .process(directRoutePreparationProcessor)
//            .toD(CamelUtils.getValueBuilderCompatibleExchangePropertyIdentifier(CAMEL_EXCHANGE_GENERIC_CRUD_DIRECT_ROUTE_ID_PROPERTY));
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.PUT))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.PUT))
//            .bean(service, GenericCRUDRouteOperationType.PUT.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//    }
//
//    private void configurePatchRoutes() {
//        String restRouteID = getRestRouteID(GenericCRUDRouteOperationType.PATCH_REST);
//
//        rest(routeBasePath)
//            .patch()
//            .id("PATCH base generic route")
//            .routeId(restRouteID)
//            .produces(MediaType.APPLICATION_JSON_VALUE)
//            .to(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.PATCH));
//
//        from(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.PATCH))
//            .id(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.PATCH))
//            .process(patchRestRoutePreparationProcessor)
//            .process(directRoutePreparationProcessor)
//            .toD(CamelUtils.getValueBuilderCompatibleExchangePropertyIdentifier(CAMEL_EXCHANGE_GENERIC_CRUD_DIRECT_ROUTE_ID_PROPERTY));
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.PATCH))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.PATCH))
//            .bean(service, GenericCRUDRouteOperationType.PATCH.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//    }
//
//    private void configureDeleteRoutes() {
//        String restRouteID = getRestRouteID(GenericCRUDRouteOperationType.DELETE_REST);
//
//        rest(routeBasePath)
//            .delete()
//            .id("DELETE base generic route")
//            .routeId(restRouteID)
//            .produces(MediaType.APPLICATION_JSON_VALUE)
//            .to(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.DELETE));
//
//        from(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.DELETE))
//            .id(getRestDirectRouteIdentifier(GenericCRUDRouteOperationType.DELETE))
//            .process(deleteRestRoutePreparationProcessor)
//            .process(directRoutePreparationProcessor)
//            .toD(CamelUtils.getValueBuilderCompatibleExchangePropertyIdentifier(CAMEL_EXCHANGE_GENERIC_CRUD_DIRECT_ROUTE_ID_PROPERTY));
//
//        from(getDirectRouteIdentifier(GenericCRUDRouteOperationType.DELETE))
//            .id(getDirectRouteIdentifier(GenericCRUDRouteOperationType.DELETE))
//            .bean(service, GenericCRUDRouteOperationType.DELETE.getServiceMethodSignature())
//            .process(genericWSServiceResponseProcessor)
//            .unmarshal().json(JsonLibrary.Jackson, true);
//    }
//
//    private String getRestRouteID(GenericCRUDRouteOperationType operationType) {
//        return GENERIC_CRUD_ROUTE_ID_PREFIX + "rest" + operationType.getRestRouteIDSuffix();
//    }
//
//    public static String getDirectRouteIdentifier(GenericCRUDRouteOperationType operationType) {
//        return "direct:" + GENERIC_CRUD_ROUTE_ID_PREFIX + operationType.getOperationIdentifier() + "-route";
//    }
//
//    public static String getRestDirectRouteIdentifier(GenericCRUDRouteOperationType operationType) {
//        return "direct:rest-direct" + GENERIC_CRUD_ROUTE_ID_PREFIX + operationType.getOperationIdentifier() + "-route";
//    }
//}
