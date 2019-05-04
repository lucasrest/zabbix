package dominio;

import dominio.comum.EntidadeZabbix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ZabbixAlerta extends EntidadeZabbix {

    private ZabbixServer server;
    private ZabbixData data;
    private Long intervalo;

}
