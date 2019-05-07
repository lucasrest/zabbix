package anotacoes;

import config.ZabbixAlertaConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({ZabbixAlertaConfig.class})
public @interface EnableZabbixAlerta {
}
