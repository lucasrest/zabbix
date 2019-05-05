package dominio;

import dominio.comum.EntidadeZabbix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ZabbixServer extends EntidadeZabbix {

    public static final int PORT_PADRAO = 80;
    private String host;
    private Integer port;

    public ZabbixServer(String host) {
        this.host = host;
        this.port = PORT_PADRAO;
    }
}
