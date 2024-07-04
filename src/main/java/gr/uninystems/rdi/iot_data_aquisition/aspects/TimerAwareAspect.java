package gr.uninystems.rdi.iot_data_aquisition.aspects;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Aspect
public class TimerAwareAspect {
    private final MeterRegistry registry;

    public TimerAwareAspect(MeterRegistry registry) {
        this.registry = registry;
    }

    @Around("@annotation(gr.uninystems.rdi.iot_data_aquisition.aspects.TimerAware)")
    public Object aroundInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        Timer timer = this.getTimer(joinPoint);
        Instant start = Instant.now();
        boolean var9 = false;

        Object var4;
        try {
            var9 = true;
            var4 = joinPoint.proceed();
            var9 = false;
        } finally {
            if (var9) {
                Instant end = Instant.now();
                timer.record(Duration.between(start, end).toMillis(), TimeUnit.MILLISECONDS);
            }
        }

        Instant end = Instant.now();
        timer.record(Duration.between(start, end).toMillis(), TimeUnit.MILLISECONDS);
        return var4;
    }

    private Timer getTimer(ProceedingJoinPoint joinPoint) {
        String var10000 = this.getCallingClassName(joinPoint);
        String timerName = "app_" + var10000 + "_timer";
        return Timer.builder(timerName).register(this.registry);
    }

    private String getCallingClassName(ProceedingJoinPoint joinPoint) {
        Optional<Object> target = Optional.ofNullable(joinPoint.getTarget());
        return target.isPresent() ? target.get().getClass().getSimpleName() : joinPoint.getSignature().getDeclaringType().getSimpleName();
    }
}