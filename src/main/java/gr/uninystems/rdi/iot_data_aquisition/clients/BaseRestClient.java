//package gr.uninystems.rdi.iot_data_aquisition.clients;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import gr.uninystems.rdi.iot_data_aquisition.constants.Constants;
//import gr.uninystems.rdi.iot_data_aquisition.filters.RestClientFilters;
//import gr.uninystems.rdi.iot_data_aquisition.model.pspiRestClient.GenericWSResponseDTO;
//import org.slf4j.MDC;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.codec.json.Jackson2JsonDecoder;
//import org.springframework.http.codec.json.Jackson2JsonEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.ExchangeStrategies;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClient.Builder;
//
//import java.util.Optional;
//
//@Service
//public class BaseRestClient {
//
//    private final ObjectMapper mapper = new ObjectMapper()
//            .findAndRegisterModules()
//            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
//            .disable(SerializationFeature.INDENT_OUTPUT);
//
//    private ObjectMapper wrapperObjectMapper = new ObjectMapper()
//            .findAndRegisterModules()
//            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
//            .disable(SerializationFeature.INDENT_OUTPUT);
//
//    private ObjectMapper noWrapperObjectMapper = new ObjectMapper()
//            .findAndRegisterModules()
//            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
//            .disable(SerializationFeature.INDENT_OUTPUT);
//
//    private final ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
//            .codecs(configurer ->  {
//                configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper));
//                configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(mapper));
//            })
//            .build();
//
//    protected final Builder getWebClientBuilder(String baseURL, Optional<String> authTicket, Optional<MediaType> contentTypeMediaType) {
//        Builder clientBuilder = WebClient.builder()
//                .baseUrl(baseURL)
//                .exchangeStrategies(exchangeStrategies)
//                .filter(RestClientFilters.logRequest())
//                .filter(RestClientFilters.logResponse())
//                .filter(RestClientFilters.handleError())
//                .filter(RestClientFilters.handleMDC());
//
//        if (authTicket.isPresent()) {
//            clientBuilder = clientBuilder.defaultHeader(HttpHeaders.AUTHORIZATION, authTicket.get());
//        }
//
//        if (contentTypeMediaType.isPresent()) {
//            clientBuilder = clientBuilder.defaultHeader(HttpHeaders.CONTENT_TYPE, contentTypeMediaType.get().toString());
//        }
//
//        return clientBuilder;
//    }
//
//    protected final Builder getWebClientBuilder(Optional<String> authTicket, Optional<MediaType> contentTypeMediaType) {
//        Builder clientBuilder = WebClient.builder()
//                .exchangeStrategies(exchangeStrategies)
//                .filter(RestClientFilters.logRequest())
//                .filter(RestClientFilters.logResponse())
//                .filter(RestClientFilters.handleError())
//                .filter(RestClientFilters.handleMDC());
//
//        if (authTicket.isPresent()) {
//            clientBuilder = clientBuilder.defaultHeader(HttpHeaders.AUTHORIZATION, authTicket.get());
//        }
//
//        if (contentTypeMediaType.isPresent()) {
//            clientBuilder = clientBuilder.defaultHeader(HttpHeaders.CONTENT_TYPE, contentTypeMediaType.get().toString());
//        }
//
//        return clientBuilder;
//    }
//
//
//    protected void addTracingHeaders(HttpHeaders httpHeaders) {
//        if (Optional.ofNullable(MDC.get(Constants.MDC_TRACEID_PROPERTY_NAME)).isPresent()) {
//            httpHeaders.addIfAbsent(Constants.TRACING_X_B3_TRACEID_HEADER_NAME, MDC.get(Constants.MDC_TRACEID_PROPERTY_NAME));
//        }
//
//        if (Optional.ofNullable(MDC.get(Constants.MDC_SPANID_PROPERTY_NAME)).isPresent()) {
//            httpHeaders.addIfAbsent(Constants.TRACING_X_B3_SPANID_HEADER_NAME, MDC.get(Constants.MDC_SPANID_PROPERTY_NAME));
//        }
//
//        if (Optional.ofNullable(MDC.get(Constants.MDC_UBERTRACEID_PROPERTY_NAME)).isPresent()) {
//            httpHeaders.addIfAbsent(Constants.TRACING_UBER_TRACE_ID_HEADER_NAME, MDC.get(Constants.MDC_UBERTRACEID_PROPERTY_NAME));
//        }
//    }
//
//    protected ObjectMapper getObjectMapper() {
//        return mapper;
//    }
//
//    protected ObjectMapper getWrapperObjectMapper() {
//        return wrapperObjectMapper;
//    }
//
//    protected ObjectMapper getNoWrapperObjectMapper() {
//        return noWrapperObjectMapper;
//    }
//
//    protected GenericWSResponseDTO toGenericWSResponse(ResponseEntity<String> response) {
//        return GenericWSResponseDTO.GenericWSResponseDTOBuilder.getInstance()
//                .withBodyAsString(response.getBody())
//                .withStatusCode(response.getStatusCode().value())
//                .withHeaders(response.getHeaders())
//            .build();
//    }
//
//}
