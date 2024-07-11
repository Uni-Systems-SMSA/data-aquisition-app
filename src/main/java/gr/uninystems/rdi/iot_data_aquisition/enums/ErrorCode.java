package gr.uninystems.rdi.iot_data_aquisition.enums;

//import javassist.NotFoundException;
import lombok.Getter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.client.ResourceAccessException;

import java.net.BindException;
import java.sql.BatchUpdateException;


@Getter
public enum ErrorCode {
    OK("EPM-0000", "exception.ok", HttpStatus.OK, ""),
    NOK("EPM-0001", "exception.notOk", HttpStatus.NOT_ACCEPTABLE, ""),
    SYSTEM_EXCEPTION("EPM-0002", "exception.systemException", HttpStatus.UNPROCESSABLE_ENTITY, Exception.class.getCanonicalName()),
    PERSISTENCE_EXCEPTION("EPM-0003", "exception.persistenceException", HttpStatus.UNPROCESSABLE_ENTITY, "javax.persistence.PersistenceException"),
    NOT_VALID_INPUT_DATA("EPM-0004", "exception.notValidInputData", HttpStatus.BAD_REQUEST, BindException.class.getCanonicalName()),
    //NOT_FOUND_ENTITY("EPM-0005", "exception.notFoundEntity", HttpStatus.NOT_FOUND, NotFoundException.class.getCanonicalName()),
    INTEGRITY_VIOLATION("EPM-0006", "exception.integrityViolation", HttpStatus.UNPROCESSABLE_ENTITY, DataIntegrityViolationException.class.getCanonicalName()),
    USER_NOT_EXIST_OR_NOT_ACTIVE("EPM-0007", "exception.userNotExistOrNotActive", HttpStatus.NOT_FOUND, ""),
    NOT_VALID_AUTHORIZATION_INPUT_DATA("EPM-0008", "exception.notValidAuthorizationInputData", HttpStatus.UNAUTHORIZED, ""),
    AUTHORIZATION_ERROR("EPM-0009", "exception.authorizationError", HttpStatus.UNAUTHORIZED, ""),
    NOT_AUTHORIZED("EPM-0010", "exception.notAuthorized", HttpStatus.UNAUTHORIZED, ""),
    SEND_EMAIL_ERROR("EPM-0011", "exception.sendEmailError", HttpStatus.BAD_REQUEST, ""),
    MULTIPLE_ACTS("EPM-0012", "exception.multipleActs", HttpStatus.MULTIPLE_CHOICES, ""),
    UNKNOWN("EPM-0013", "exception.unknown", HttpStatus.INTERNAL_SERVER_ERROR, Exception.class.getCanonicalName()),
    ILLEGAL_ARG("EPM-0014", "exception.illegalArg", HttpStatus.INTERNAL_SERVER_ERROR, IllegalArgumentException.class.getCanonicalName()),
    RUNTIME("EPM-0015", "exception.runtime", HttpStatus.INTERNAL_SERVER_ERROR, RuntimeException.class.getCanonicalName()),
    METHOD_NOT_SUPPORTED("EPM-0016", "exception.methodNotSupported", HttpStatus.INTERNAL_SERVER_ERROR, HttpRequestMethodNotSupportedException.class.getCanonicalName()),
    SPRING_BIND("EPM-0017", "exception.springBind", HttpStatus.INTERNAL_SERVER_ERROR, BindException.class.getCanonicalName()),
    SPRING_SEC_REQUEST_REJECTED("EPM-0018", "exception.springSecReqRejected", HttpStatus.INTERNAL_SERVER_ERROR, "org.springframework.security.web.firewall.RequestRejectedException"),
    SPRING_CANNOT_CREATE_TX("EPM-0019", "exception.springCannotCreateTx", HttpStatus.INTERNAL_SERVER_ERROR, CannotCreateTransactionException.class.getCanonicalName()),
    SPRING_BOOT_CLIENT_ABORT("EPM-0020", "exception.springBootClientAbort", HttpStatus.INTERNAL_SERVER_ERROR, ""),
    SPRING_BOOT_MALFORMED_STREAM("EPM-00421", "exception.springBootMalformedStream", HttpStatus.INTERNAL_SERVER_ERROR, ""),
    SPRING_BOOT_NO_RESPONSE("EPM-0022", "exception.springBootNoResponse", HttpStatus.INTERNAL_SERVER_ERROR, "org.apache.http.NoHttpResponseException"),
    DB_PSQL("EPM-0023", "exception.dbPsql", HttpStatus.INTERNAL_SERVER_ERROR, "org.postgresql.util.PSQLException"),
    DB_PERSISTENCE("EPM-0024", "exception.dbPersistence", HttpStatus.INTERNAL_SERVER_ERROR, "javax.persistence.PersistenceException"),
    DB_BATCH_UPDATE("EPM-0025", "exception.dbBatchUpdate", HttpStatus.INTERNAL_SERVER_ERROR, BatchUpdateException.class.getCanonicalName()),
    JWT_TOKEN_EXPIRED("EPM-0026", "exception.jwtTokenExpired", HttpStatus.INTERNAL_SERVER_ERROR, "com.auth0.jwt.exceptions.TokenExpiredException"),
    SPRING_WEB_RESOURCE_ACCESS("EPM-0027", "exception.springWebResourceExpired", HttpStatus.INTERNAL_SERVER_ERROR, ResourceAccessException.class.getCanonicalName()),
    SPRING_TX_DATA_INTEGRITY_VIOLATION("EPM-0028", "exception.springTxDataIntegrityViolation", HttpStatus.INTERNAL_SERVER_ERROR, DataIntegrityViolationException.class.getCanonicalName()),
    CUSTOM_QUERY("EPM-0029", "exception.customQuery", HttpStatus.INTERNAL_SERVER_ERROR, ""),
    DATA_NOT_FOUND("EPM-0030", "exception.dataNotFound", HttpStatus.NOT_FOUND, ""),
    NPE("EPM-0031", "exception.npe", HttpStatus.INTERNAL_SERVER_ERROR, NullPointerException.class.getCanonicalName()),
    ELASTIC("EPM-0032", "exception.elastic", HttpStatus.INTERNAL_SERVER_ERROR, ""),
    ELASTIC_JPA_INCONSISTENCY("EPM-0033", "exception.inconsistency", HttpStatus.INTERNAL_SERVER_ERROR, "");

    private final String code;

    private final String messageProperty;

    private final HttpStatus httpStatus;

    private final String classCanonicalName;

    ErrorCode(String code, String messageProperty, HttpStatus httpStatus, String classCanonicalName) {
        this.code = code;
        this.messageProperty = messageProperty;
        this.httpStatus = httpStatus;
        this.classCanonicalName = classCanonicalName;
    }

    public static ErrorCode findByException(Throwable e) {
        for (ErrorCode value : values()) {
            if (value.getClassCanonicalName().equals(e.getClass().getCanonicalName())) {
                return value;
            }
        }
        return UNKNOWN;
    }

    public static String retrieveErrorCodeForException(Throwable e) {
        Throwable exceptionToEvaluate = e.getCause() != null ? e.getCause() : e;
        return ErrorCode.findByException(exceptionToEvaluate).getCode();
    }
}
