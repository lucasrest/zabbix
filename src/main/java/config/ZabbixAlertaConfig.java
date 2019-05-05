package config;

import dominio.ZabbixAlerta;
import servico.ZabbixAlertaServico;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ZabbixAlertaConfig {

    private static final String ZABBIX_ALERTA = "Zabbix Alerta";

    private ZabbixAlertaServico alertaServico;

    public ZabbixAlertaConfig(ZabbixAlerta alerta) {
        alertaServico = ZabbixAlertaServico.getInstance();
        enviarAlerta(alerta);
    }

    private void enviarAlerta(ZabbixAlerta alerta) {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                try {
                    alertaServico.enviar(alerta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer alertaTimer = new Timer(ZABBIX_ALERTA);
        alertaTimer.scheduleAtFixedRate(repeatedTask, 0, alerta.getIntervalo());
    }
}
