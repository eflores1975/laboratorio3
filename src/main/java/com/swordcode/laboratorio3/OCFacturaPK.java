package com.swordcode.laboratorio3;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class OCFacturaPK implements Serializable {

	@Column(name = "CLnumero")
	private int CLnumero;
	@Column(name = "FAnumero")
    private int FAnumero;

    public OCFacturaPK() {
    }

	

	public int getCLnumero() {
		return CLnumero;
	}

	public void setCLnumero(int cLnumero) {
		CLnumero = cLnumero;
	}

	public int getFAnumero() {
		return FAnumero;
	}

	public void setFAnumero(int fAnumero) {
		FAnumero = fAnumero;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof OCFactura) {
			OCFacturaPK pk = (OCFacturaPK)o;
			if (pk == this) return true;
			return (pk.CLnumero == CLnumero && pk.FAnumero == FAnumero);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CLnumero, FAnumero);
		// return CLnumero ^ FAnumero;
	}

	public OCFacturaPK(int cLnumero, int fAnumero) {
		CLnumero = cLnumero;
		FAnumero = fAnumero;
	}
	
}