package dominio;

import dominio.comum.EntidadeZabbix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ZabbixAlerta extends EntidadeZabbix {

    public static final long INTERVALO_PADRAO = 5000L;
    private ZabbixServer server;
    private ZabbixData data;
    private Long intervalo;

    public ZabbixAlerta(ZabbixServer server, ZabbixData data) {
        this.server = server;
        this.data = data;
        this.intervalo = INTERVALO_PADRAO;
    }
}
