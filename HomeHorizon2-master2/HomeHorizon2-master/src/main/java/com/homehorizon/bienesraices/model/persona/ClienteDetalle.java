package com.homehorizon.bienesraices.model.persona;

public class ClienteDetalle {

    Cliente cliente;

    Preferencia preferencia;

    public ClienteDetalle(Cliente cliente, Preferencia preferencia) {
        this.cliente = cliente;
        this.preferencia = preferencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }

}
