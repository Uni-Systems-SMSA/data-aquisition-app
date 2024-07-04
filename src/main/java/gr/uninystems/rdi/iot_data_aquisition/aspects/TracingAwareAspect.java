package gr.uninystems.rdi.iot_data_aquisition.aspects;

import gr.uninystems.rdi.iot_data_aquisition.constants.Constants;
import gr.uninystems.rdi.iot_data_aquisition.constants.MDCConstants;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.noop.NoopSpan;
import org.apache.camel.CamelContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;

import java.util.Optional;
import java.util.Set;

@Aspect
public class TracingAwareAspect {
    
    private final CamelContext camelContext;
    
    public TracingAwareAspect(CamelContext camelContext) {
        this.camelContext = camelContext;
    }
    
    @Around("@annotation(gr.uninystems.rdi.iot_data_aquisition.aspects.TracingAware)")
    public Object aroundInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        Span span = null;
        Set<Tracer> tracers = camelContext.getRegistry().findByType(Tracer.class);
        Optional<Tracer> currentTracer = tracers.stream().findFirst();
        if (currentTracer.isPresent()) {
            span = currentTracer.get()
                    .buildSpan(getCallingClassName(joinPoint))
                    .asChildOf(currentTracer.get().activeSpan())
                    .withTag("component", "webflux-client")
                    .start();
            if (!(span instanceof NoopSpan)) {
                MDC.put(MDCConstants.MDC_SPANID_PROPERTY_NAME, span.context().toSpanId());
                MDC.put(MDCConstants.MDC_UBERTRACEID_PROPERTY_NAME, span.context().toString());
            }
        }
        try {
            return joinPoint.proceed();
        } finally {
            if (span != null) {
                span.finish();
            }
        }
    }
    
    private String getCallingClassName(ProceedingJoinPoint joinPoint) {
        Optional<Object> target = Optional.ofNullable(joinPoint.getTarget());
        if (target.isPresent()) {
            return target.get().getClass().getSimpleName() + Constants.TILDE_STRING + joinPoint.getSignature().getName();
        } else {
            return joinPoint.getSignature().getDeclaringType().getSimpleName() + Constants.TILDE_STRING + joinPoint.getSignature().getName();
        }
    }
    
}
