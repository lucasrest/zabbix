package util;

import exception.ZabbixException;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyUtil {

    public static final String ZABBIX_SERVER_HOST = "zabbix.server.host";
    public static final String ZABBIX_SERVER_PORT = "zabbix.server.port";
    public static final String ZABBIX_DATA_HOST = "zabbix.data.host";
    public static final String ZABBIX_DATA_KEY = "zabbix.data.key";
    public static final String ZABBIX_DATA_VALUE = "zabbix.data.value";

    public static Map<String, String> getProperties(Environment environment) {
        Map<String, String> properties = new HashMap<>();
        propertiesKey().forEach(property -> {
            if (!environment.containsProperty(property))
                throw new ZabbixException(String.format("Propriedade: %s não foi encontrada no arquivo de configuração.", property));
            String value = environment.getProperty(property);
            properties.put(property, value);
        });
        return properties;
    }

    private static List<String> propertiesKey() {
        return Arrays.asList(
                ZABBIX_SERVER_HOST,
                ZABBIX_SERVER_PORT,
                ZABBIX_DATA_HOST,
                ZABBIX_DATA_KEY,
                ZABBIX_DATA_VALUE
        );
    }
}
