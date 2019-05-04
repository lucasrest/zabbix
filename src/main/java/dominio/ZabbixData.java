package dominio;

import dominio.comum.EntidadeZabbix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ZabbixData extends EntidadeZabbix {

    private String host;
    private String key;
    private String value;
    private Long clock;

    public ZabbixData(String host, String key, String value) {
        this.host = host;
        this.key = key;
        this.value = value;
        this.clock = System.currentTimeMillis() / 1000;
    }
}
