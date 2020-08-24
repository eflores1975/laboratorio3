package com.swordcode.laboratorio3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Factura implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int	 			FAnumero;
	private String			FAproveedor;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date			FAfecha;
	private String			FAarticulo;
	private int				FAcantidad;
	private String			FAunidad;
	private BigDecimal		FAitbm;
	private BigDecimal		FAtotal;

	public Factura() {
	}

	public Factura(String fAproveedor, Date fAfecha, String fAarticulo, int fAcantidad, String fAunidad, BigDecimal fAitbm,
			BigDecimal fAtotal) {
		FAproveedor = fAproveedor;
		FAfecha = fAfecha;
		FAarticulo = fAarticulo;
		FAcantidad = fAcantidad;
		FAunidad = fAunidad;
		FAitbm = fAitbm;
		FAtotal = fAtotal;
	}

	public int getFAnumero() {
		return FAnumero;
	}

	public void setFAnumero(int fAnumero) {
		FAnumero = fAnumero;
	}

	public String getFAproveedor() {
		return FAproveedor;
	}

	public void setFAproveedor(String fAproveedor) {
		FAproveedor = fAproveedor;
	}

	public Date getFAfecha() {
		return FAfecha;
	}

	public void setFAfecha(Date fAfecha) {
		FAfecha = fAfecha;
	}

	public String getFAarticulo() {
		return FAarticulo;
	}

	public void setFAarticulo(String fAarticulo) {
		FAarticulo = fAarticulo;
	}

	public int getFAcantidad() {
		return FAcantidad;
	}

	public void setFAcantidad(int fAcantidad) {
		FAcantidad = fAcantidad;
	}

	public String getFAunidad() {
		return FAunidad;
	}

	public void setFAunidad(String fAunidad) {
		FAunidad = fAunidad;
	}

	public BigDecimal getFAitbm() {
		return FAitbm;
	}

	public void setFAitbm(BigDecimal fAitbm) {
		FAitbm = fAitbm;
	}

	public BigDecimal getFAtotal() {
		return FAtotal;
	}

	public void setFAtotal(BigDecimal fAtotal) {
		FAtotal = fAtotal;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Factura) {
			Factura f = (Factura)o;
			if (f == this) return true;
			return (FAnumero == f.FAnumero);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return FAnumero;
	}
}
