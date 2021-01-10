/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodry-Asus
 */
@Entity
@Table(name = "accion", catalog = "finanzapersonal", schema = "")
@NamedQueries({
    @NamedQuery(name = "Accion.findAll", query = "SELECT a FROM Accion a"),
    @NamedQuery(name = "Accion.findByIdAccion", query = "SELECT a FROM Accion a WHERE a.accionPK.idAccion = :idAccion"),
    @NamedQuery(name = "Accion.findByNombre", query = "SELECT a FROM Accion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Accion.findByUnidades", query = "SELECT a FROM Accion a WHERE a.unidades = :unidades"),
    @NamedQuery(name = "Accion.findByUltimoPrecio", query = "SELECT a FROM Accion a WHERE a.ultimoPrecio = :ultimoPrecio"),
    @NamedQuery(name = "Accion.findByTipo", query = "SELECT a FROM Accion a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Accion.findByIdinversor", query = "SELECT a FROM Accion a WHERE a.accionPK.idinversor = :idinversor")})
public class Accion implements Serializable {

    @Column(name = "simbolo")
    private String simbolo;

    @Column(name = "ppcompra")
    private Double ppcompra;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccionPK accionPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "unidades")
    private Integer unidades;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ultimoPrecio")
    private Double ultimoPrecio;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idinversor", referencedColumnName = "idinversor", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inversor inversor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accion", fetch = FetchType.LAZY)
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accion", fetch = FetchType.LAZY)
    private List<Venta> ventaList;

    public Accion() {
    }

    public Accion(AccionPK accionPK) {
        this.accionPK = accionPK;
    }

    public Accion(int idAccion, int idinversor) {
        this.accionPK = new AccionPK(idAccion, idinversor);
    }

    public AccionPK getAccionPK() {
        return accionPK;
    }

    public void setAccionPK(AccionPK accionPK) {
        this.accionPK = accionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getUltimoPrecio() {
        return ultimoPrecio;
    }

    public void setUltimoPrecio(Double ultimoPrecio) {
        this.ultimoPrecio = ultimoPrecio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }
    
     public Double getPpcompra() {
        return ppcompra;
    }

    public void setPpcompra(Double ppcompra) {
        this.ppcompra = ppcompra;
    }
    
     public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accionPK != null ? accionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accion)) {
            return false;
        }
        Accion other = (Accion) object;
        if ((this.accionPK == null && other.accionPK != null) || (this.accionPK != null && !this.accionPK.equals(other.accionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Accion[ accionPK=" + accionPK + " ]";
    }

   

   
    
}
