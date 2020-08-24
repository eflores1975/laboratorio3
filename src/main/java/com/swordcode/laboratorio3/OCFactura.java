package com.swordcode.laboratorio3;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity
@Data
// @IdClass(OCFacturaPK.class)
public class OCFactura implements Serializable {
	// @Id
	// // @Column(name = "CLnumero", nullable = false, insertable = false, updatable = false)
	// private int CLnumero;

	// @Id
	// // @Column(name = "FAnumero", nullable = false, insertable = false, updatable = false)
	// private int FAnumero;

	@EmbeddedId
	private OCFacturaPK		id;

	// @Id
    @JoinColumn(name = "CLnumero", nullable = false, insertable = false, updatable = false)
    @ManyToOne                   private Cliente cliente;

	// @Id
    @JoinColumn(name = "FAnumero", nullable = false, insertable = false, updatable = false)
    @ManyToOne                   private Factura factura;

    public OCFactura() {
    }

	public OCFactura(Cliente cliente, Factura factura) {
		this.cliente = cliente;
		this.factura = factura;
		this.id = new OCFacturaPK(cliente.getCLnumero(), factura.getFAnumero());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public int hashCode() {
		return (cliente.getCLnumero() ^ factura.getFAnumero());
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof OCFactura) {
			OCFactura oc = (OCFactura)o;
			return (
				oc.cliente.equals(cliente) && oc.factura.equals(factura)
			);
		}

		return false;
	}

	public int getCLnumero() {
		return id.getCLnumero();
	}

	public void setCLnumero(int cLnumero) {
		id.setCLnumero(cLnumero);
		// CLnumero = cLnumero;
	}

	public int getFAnumero() {
		return id.getFAnumero();
	}

	public void setFAnumero(int fAnumero) {
		// FAnumero = fAnumero;
		id.setFAnumero(fAnumero);
	}

	public OCFacturaPK getId() {
		return id;
	}

	public void setId(OCFacturaPK id) {
		this.id = id;
	}
}