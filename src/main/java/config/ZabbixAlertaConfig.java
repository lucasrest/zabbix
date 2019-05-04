package config;

import dominio.ZabbixAlerta;
import servico.ZabbixAlertaServico;

public class ZabbixAlertaConfig {

    public ZabbixAlertaConfig(ZabbixAlerta alerta) throws Exception {
        ZabbixAlertaServico alertaServico = ZabbixAlertaServico.getInstance();
        do {
            alertaServico.enviar(alerta);
            Thread.sleep(alerta.getIntervalo());
        } while (true);
    }
}
