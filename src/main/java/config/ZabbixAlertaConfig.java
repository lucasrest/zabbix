package config;

import dominio.ZabbixAlerta;
import dominio.ZabbixData;
import dominio.ZabbixServer;
import org.springframework.core.env.Environment;
import servico.ZabbixAlertaServico;
import util.PropertyUtil;

import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static util.PropertyUtil.*;

public class ZabbixAlertaConfig {

    private static final String ZABBIX_ALERTA = "Zabbix Alerta";

    private ZabbixAlertaServico alertaServico;

    private Map<String, String> properties;

    public ZabbixAlertaConfig(Environment environment) {
        properties = PropertyUtil.getProperties(environment);
        alertaServico = ZabbixAlertaServico.getInstance();
        enviarAlerta(alerta());
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

    public ZabbixAlerta alerta() {
        return new ZabbixAlerta(server(), data());
    }

    public ZabbixData data() {
        return new ZabbixData(
                properties.get(ZABBIX_DATA_HOST),
                properties.get(ZABBIX_DATA_KEY),
                properties.get(ZABBIX_DATA_VALUE)
        );
    }

    public ZabbixServer server() {
        return new ZabbixServer(
                properties.get(ZABBIX_DATA_HOST),
                Integer.parseInt(properties.get(ZABBIX_SERVER_PORT))
        );
    }
}
