import config.ZabbixAlertaConfig;
import dominio.ZabbixAlerta;
import dominio.ZabbixData;
import dominio.ZabbixServer;

public class ZabbixApplication {

    public static void main(String[] args) {
        try {
            ZabbixServer zabbixServer = new ZabbixServer("zabbix-homolog.hml1.stelo.local", 10051);
            ZabbixData zabbixData = new ZabbixData("credenciamento", "credenciamento.email", "sucesso");
            ZabbixAlerta zabbixAlerta = new ZabbixAlerta(zabbixServer, zabbixData, 5000L);
            new ZabbixAlertaConfig(zabbixAlerta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

