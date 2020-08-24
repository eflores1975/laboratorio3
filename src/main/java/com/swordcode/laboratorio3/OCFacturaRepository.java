package com.swordcode.laboratorio3;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface OCFacturaRepository extends CrudRepository<OCFactura, OCFacturaPK> {
    List<OCFactura> findByCliente(Cliente cliente);
    OCFactura findByFactura(Factura factura);
}