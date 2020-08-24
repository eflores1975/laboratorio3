package com.swordcode.laboratorio3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;


@Entity
@Data
public class Cliente implements Serializable {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int             CLnumero;

	@Column(unique = true)
	private int	 			CLid;    
    private String          CLnombre;
    private String          CLapellido;
    private String          CLdireccion;
    private String          CLtelefono;
	private String          CLactividad;

	@Transient
	private int CLtotalFacturas;

	public Cliente() {
	}

	public Cliente(int cLid, String cLnombre, String cLapellido, String cLdireccion, String cLtelefono,
			String cLactividad) {
		CLid = cLid;
		CLnombre = cLnombre;
		CLapellido = cLapellido;
		CLdireccion = cLdireccion;
		CLtelefono = cLtelefono;
		CLactividad = cLactividad;
    }

    // there is no need to generate getters/setters with Lombok on it, but JSP does not read this?
    // we need to generate them anyway

	public int getCLid() {
		return CLid;
	}

	public void setCLid(int cLid) {
		CLid = cLid;
	}

	public int getCLnumero() {
		return CLnumero;
	}

	public void setCLnumero(int cLnumero) {
		CLnumero = cLnumero;
	}

	public String getCLnombre() {
		return CLnombre;
	}

	public void setCLnombre(String cLnombre) {
		CLnombre = cLnombre;
	}

	public String getCLapellido() {
		return CLapellido;
	}

	public void setCLapellido(String cLapellido) {
		CLapellido = cLapellido;
	}

	public String getCLdireccion() {
		return CLdireccion;
	}

	public void setCLdireccion(String cLdireccion) {
		CLdireccion = cLdireccion;
	}

	public String getCLtelefono() {
		return CLtelefono;
	}

	public void setCLtelefono(String cLtelefono) {
		CLtelefono = cLtelefono;
	}

	public String getCLactividad() {
		return CLactividad;
	}

	public void setCLactividad(String cLactividad) {
		CLactividad = cLactividad;
	}

	public int getCLtotalFacturas() {
		return CLtotalFacturas;
	}

	public void setCLtotalFacturas(int cLtotalFacturas) {
		CLtotalFacturas = cLtotalFacturas;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Cliente) {
			Cliente c = (Cliente)o;
			if (c == this) return true;
			return (c.CLnumero == CLnumero);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return CLnumero;
	}
}