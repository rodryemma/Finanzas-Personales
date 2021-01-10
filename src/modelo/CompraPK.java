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
public class CompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idCompra")
    private int idCompra;
    @Basic(optional = false)
    @Column(name = "idAccion")
    private int idAccion;

    public CompraPK() {
    }

    public CompraPK(int idCompra, int idAccion) {
        this.idCompra = idCompra;
        this.idAccion = idAccion;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
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
        hash += (int) idCompra;
        hash += (int) idAccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPK)) {
            return false;
        }
        CompraPK other = (CompraPK) object;
        if (this.idCompra != other.idCompra) {
            return false;
        }
        if (this.idAccion != other.idAccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CompraPK[ idCompra=" + idCompra + ", idAccion=" + idAccion + " ]";
    }
    
}
