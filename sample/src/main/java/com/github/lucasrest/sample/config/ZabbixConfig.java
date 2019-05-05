package com.github.lucasrest.sample.config;

import config.ZabbixAlertaConfig;
import dominio.ZabbixAlerta;
import dominio.ZabbixData;
import dominio.ZabbixServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZabbixConfig {

    @Value("${zabbix.server.host}")
    private String serverHost;

    @Value("${zabbix.server.port}")
    private Integer serverPort;

    @Value("${zabbix.data.host}")
    private String dataHost;

    @Value("${zabbix.data.key}")
    private String dataKey;

    @Value("${zabbix.data.value}")
    private String dataValue;

    @Bean
    public ZabbixAlertaConfig zabbixAlertaConfig(ZabbixAlerta alerta) {
        return new ZabbixAlertaConfig(alerta);
    }

    @Bean
    public ZabbixAlerta zabbixAlerta(ZabbixServer server, ZabbixData data) {
        return new ZabbixAlerta(server, data);
    }

    @Bean
    public ZabbixData zabbixData() {
        return new ZabbixData(dataHost, dataKey, dataValue);
    }

    @Bean
    public ZabbixServer zabbixServer() {
        return new ZabbixServer(serverHost, serverPort);
    }
}
