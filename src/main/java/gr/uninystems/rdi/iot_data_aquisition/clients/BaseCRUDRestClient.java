//package gr.uninystems.rdi.iot_data_aquisition.clients;
//
//import gr.uninystems.rdi.iot_data_aquisition.aspects.TimerAware;
//import gr.uninystems.rdi.iot_data_aquisition.aspects.TracingAware;
//import gr.uninystems.rdi.iot_data_aquisition.constants.Constants;
//import gr.uninystems.rdi.iot_data_aquisition.constants.CustomRestClientsConstants;
//import gr.uninystems.rdi.iot_data_aquisition.constants.RestClientConstants;
//import gr.uninystems.rdi.iot_data_aquisition.model.pspiRestClient.GenericWSResponseDTO;
//import gr.uninystems.rdi.iot_data_aquisition.model.pspiRestClient.WSClientException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient.Builder;
//import org.springframework.web.reactive.function.client.WebClientResponseException;
//
//import java.util.Collections;
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//public abstract class BaseCRUDRestClient extends BaseRestClient {
//
//    @Value("${client.genericCRUD.performCallsWithoutAuthorizationHeader:false}")
//    private boolean performCallsWithoutAuthorizationHeader;
//
//    private final Builder clientBuilder;
//    private final String apiRestPath;
//
//    protected BaseCRUDRestClient(String baseRestURL, String apiRestPath) {
//        this.apiRestPath = apiRestPath;
//        this.clientBuilder = getWebClientBuilder(baseRestURL, Optional.empty(), Optional.of(MediaType.APPLICATION_JSON));
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO create(String authToken, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .post()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath)
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                        .bodyValue(payload)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO postForm(String authToken, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .post()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + RestClientConstants.POST_FORM_PATH)
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                        .bodyValue(payload)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO update(String authToken, long id, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .put()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
//                            .build(id))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                        .bodyValue(payload)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO partialUpdate(String authToken, long id, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .patch()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
//                            .build(id))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                        .bodyValue(payload)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getAll(String authToken, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath)
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getAll(String authToken, String queryParams, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath)
//                            .query(Optional.ofNullable(queryParams).orElse(Constants.EMPTY_STRING))
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO count(String authToken, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + "/count")
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO count(String authToken, String queryParams, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + "/count")
//                            .query(Optional.ofNullable(queryParams).orElse(Constants.EMPTY_STRING))
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO get(String authToken, long id, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
//                            .build(id))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO delete(String authToken, long id, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .delete()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
//                            .build(id))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getTreeView(String authToken, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + "/tree")
//                            .build())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getAuditData(String authToken,long entityId,String queryParams, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + "/audit" +"/{entityId}")
//                            .query(Optional.ofNullable(queryParams).orElse(Constants.EMPTY_STRING))
//                            .build(entityId))
//                    .accept(MediaType.APPLICATION_JSON)
//                    .headers(httpHeaders -> {
//                        if (!performCallsWithoutAuthorizationHeader) {
//                            httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                        }
//                    })
//                    .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                    .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getChildrenOfEntity(String authToken, long id, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER +"/children")
//                            .build(id))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry -> httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getParentWithChildrenOfEntity(String authToken, long id, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(apiRestPath  +"/parent" + CustomRestClientsConstants.ID_PATH_PARAMETER)
//                            .build(id))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .headers(httpHeaders -> {
//                            if (!performCallsWithoutAuthorizationHeader) {
//                                httpHeaders.addIfAbsent(Constants.AUTHORIZATION_HEADER_NAME, authToken);
//                            }
//                        })
//                        .headers(httpHeaders -> Optional.ofNullable(customHeaders).orElse(Collections.emptyMap()).entrySet().stream().forEach(entry ->  httpHeaders.addIfAbsent(entry.getKey(), (String) entry.getValue())))
//                        .headers(this::addTracingHeaders)
//                    .retrieve()
//                    .toEntity(String.class)
//                    .filter(entity -> entity.getStatusCode().is2xxSuccessful())
//                    .block();
//
//            return toGenericWSResponse(response);
//        } catch (WebClientResponseException ex) {
//            throw new WSClientException(ex.getResponseBodyAsString(), ex.getRawStatusCode());
//        }
//    }
//
//    protected Builder getClientBuilder() {
//        return this.clientBuilder;
//    }
//
//    protected String getAPIRestPath() {
//        return this.apiRestPath;
//    }
//}
