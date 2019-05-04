package dominio;

import dominio.comum.EntidadeZabbix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ZabbixServer extends EntidadeZabbix {

    private String host;
    private Integer port;

}
