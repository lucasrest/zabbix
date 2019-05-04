package util;

import dominio.ZabbixData;
import dominio.ZabbixServer;
import io.github.hengyunabc.zabbix.sender.DataObject;
import io.github.hengyunabc.zabbix.sender.ZabbixSender;

public class ZabbixSenderUtil {

    public static ZabbixSender criarSender(ZabbixServer server) {
        return new ZabbixSender(
                server.getHost(),
                server.getPort()
        );
    }

    public static DataObject criarDataObject(ZabbixData data) {
        return DataObject.builder()
                .clock(data.getClock())
                .host(data.getHost())
                .key(data.getKey())
                .value(data.getValue())
                .build();
    }
}
