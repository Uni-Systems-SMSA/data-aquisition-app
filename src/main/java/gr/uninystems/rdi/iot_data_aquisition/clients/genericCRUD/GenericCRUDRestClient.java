//package gr.uninystems.rdi.iot_data_aquisition.clients.genericCRUD;
//
//import gr.uninystems.rdi.iot_data_aquisition.aspects.TimerAware;
//import gr.uninystems.rdi.iot_data_aquisition.aspects.TracingAware;
//import gr.uninystems.rdi.iot_data_aquisition.clients.BaseRestClient;
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
//
//@Service
//public class GenericCRUDRestClient extends BaseRestClient {
//
//    @Value("${client.genericCRUD.performCallsWithoutAuthorizationHeader:false}")
//    private boolean performCallsWithoutAuthorizationHeader;
//    private Builder clientBuilder;
//
//    public GenericCRUDRestClient() {
//        this.clientBuilder = getWebClientBuilder(Optional.empty(), Optional.of(MediaType.APPLICATION_JSON));
//    }
//
//    @TimerAware
//    @TracingAware
//    public GenericWSResponseDTO getAll(String authToken, String backendRestPath, String baseUrl, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath)
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
//    public GenericWSResponseDTO getAllFiltered(String authToken, String backendRestPath, String baseUrl, String queryParams, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath)
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
//    public GenericWSResponseDTO getSingle(String authToken, String backendRestPath, String baseUrl, long id, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
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
//    public GenericWSResponseDTO getCount(String authToken, String backendRestPath, String baseUrl, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath + RestClientConstants.COUNT_PATH)
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
//    public GenericWSResponseDTO getCountFiltered(String authToken, String backendRestPath, String baseUrl, String queryParams, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .get()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath + RestClientConstants.COUNT_PATH)
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
//    public GenericWSResponseDTO create(String authToken, String backendRestPath, String baseUrl, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .post()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath)
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
//    public GenericWSResponseDTO update(String authToken, String backendRestPath, String baseUrl, long id, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .put()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
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
//    public GenericWSResponseDTO partialUpdate(String authToken, String backendRestPath, String baseUrl, long id, Object payload, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .patch()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
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
//    public GenericWSResponseDTO delete(String authToken, String backendRestPath,String baseUrl, long id, Map<String, Object> customHeaders) {
//        try {
//            ResponseEntity<String> response = clientBuilder.baseUrl(baseUrl).build()
//                    .delete()
//                    .uri(uriBuilder -> uriBuilder.path(backendRestPath + CustomRestClientsConstants.ID_PATH_PARAMETER)
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
//}
