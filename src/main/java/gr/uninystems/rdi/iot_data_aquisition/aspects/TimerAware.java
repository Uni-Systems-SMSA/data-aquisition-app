package gr.uninystems.rdi.iot_data_aquisition.aspects;
import gr.uninystems.rdi.iot_data_aquisition.constants.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimerAware {
    String timerName() default Constants.EMPTY_STRING;

    String[] tags() default {Constants.EMPTY_STRING};
}