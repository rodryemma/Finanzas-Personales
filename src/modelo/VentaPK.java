/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Rodry-Asus
 */
@Embeddable
public class VentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idventa")
    private int idventa;
    @Basic(optional = false)
    @Column(name = "idAccion")
    private int idAccion;

    public VentaPK() {
    }

    public VentaPK(int idventa, int idAccion) {
        this.idventa = idventa;
        this.idAccion = idAccion;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idventa;
        hash += (int) idAccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaPK)) {
            return false;
        }
        VentaPK other = (VentaPK) object;
        if (this.idventa != other.idventa) {
            return false;
        }
        if (this.idAccion != other.idAccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VentaPK[ idventa=" + idventa + ", idAccion=" + idAccion + " ]";
    }
    
}
