/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodry-Asus
 */
@Entity
@Table(name = "inversor", catalog = "finanzapersonal", schema = "")
@NamedQueries({
    @NamedQuery(name = "Inversor.findAll", query = "SELECT i FROM Inversor i"),
    @NamedQuery(name = "Inversor.findByIdinversor", query = "SELECT i FROM Inversor i WHERE i.idinversor = :idinversor"),
    @NamedQuery(name = "Inversor.findByNombre", query = "SELECT i FROM Inversor i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Inversor.findByMontoInvertido", query = "SELECT i FROM Inversor i WHERE i.montoInvertido = :montoInvertido"),
    @NamedQuery(name = "Inversor.findByMontoTotal", query = "SELECT i FROM Inversor i WHERE i.montoTotal = :montoTotal")})
public class Inversor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinversor")
    private Integer idinversor;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montoInvertido")
    private Double montoInvertido;
    @Column(name = "montoTotal")
    private Double montoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inversor", fetch = FetchType.LAZY)
    private List<Accion> accionList;

    public Inversor() {
    }

    public Inversor(Integer idinversor) {
        this.idinversor = idinversor;
    }

    public Integer getIdinversor() {
        return idinversor;
    }

    public void setIdinversor(Integer idinversor) {
        this.idinversor = idinversor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMontoInvertido() {
        return montoInvertido;
    }

    public void setMontoInvertido(Double montoInvertido) {
        this.montoInvertido = montoInvertido;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<Accion> getAccionList() {
        return accionList;
    }

    public void setAccionList(List<Accion> accionList) {
        this.accionList = accionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinversor != null ? idinversor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inversor)) {
            return false;
        }
        Inversor other = (Inversor) object;
        if ((this.idinversor == null && other.idinversor != null) || (this.idinversor != null && !this.idinversor.equals(other.idinversor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inversor[ idinversor=" + idinversor + " ]";
    }
    
}
