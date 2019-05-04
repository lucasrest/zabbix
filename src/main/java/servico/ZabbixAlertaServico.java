package servico;

import dominio.ZabbixAlerta;
import io.github.hengyunabc.zabbix.sender.DataObject;
import io.github.hengyunabc.zabbix.sender.SenderResult;
import io.github.hengyunabc.zabbix.sender.ZabbixSender;
import util.ZabbixSenderUtil;

import java.io.IOException;

public class ZabbixAlertaServico {

    private static ZabbixAlertaServico servico;

    private ZabbixAlertaServico() {
    }

    public static ZabbixAlertaServico getInstance() {
        if (servico == null)
            servico = new ZabbixAlertaServico();
        return servico;
    }

    public boolean enviar(ZabbixAlerta alerta) throws IOException {
        ZabbixSender zabbixSender = ZabbixSenderUtil.criarSender(alerta.getServer());
        DataObject dataObject = ZabbixSenderUtil.criarDataObject(alerta.getData());
        SenderResult result = zabbixSender.send(dataObject);
        return result.success();
    }

}
