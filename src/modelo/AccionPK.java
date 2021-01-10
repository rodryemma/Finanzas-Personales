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
public class AccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idAccion")
    private int idAccion;
    @Basic(optional = false)
    @Column(name = "idinversor")
    private int idinversor;

    public AccionPK() {
    }

    public AccionPK(int idAccion, int idinversor) {
        this.idAccion = idAccion;
        this.idinversor = idinversor;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public int getIdinversor() {
        return idinversor;
    }

    public void setIdinversor(int idinversor) {
        this.idinversor = idinversor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAccion;
        hash += (int) idinversor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionPK)) {
            return false;
        }
        AccionPK other = (AccionPK) object;
        if (this.idAccion != other.idAccion) {
            return false;
        }
        if (this.idinversor != other.idinversor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AccionPK[ idAccion=" + idAccion + ", idinversor=" + idinversor + " ]";
    }
    
}
