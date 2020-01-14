package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name = "SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByCodser", query = "SELECT s FROM Servicio s WHERE s.codser = :codser")
    , @NamedQuery(name = "Servicio.findByTotpreser", query = "SELECT s FROM Servicio s WHERE s.totpreser = :totpreser")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODSER")
    private BigDecimal codser;
    @Size(max = 10)
    @Column(name = "TOTPRESER")
    private String totpreser;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne(optional = false)
    private Cliente codcli;
    @JoinColumn(name = "CODPRO", referencedColumnName = "CODPRO")
    @ManyToOne(optional = false)
    private Profesional codpro;
    @JoinColumn(name = "CODTIPSER", referencedColumnName = "CODTIPSER")
    @ManyToOne(optional = false)
    private ServicioTipo codtipser;

    @Transient
    private int Subtotal;

    public Servicio() {
    }

    public Servicio(BigDecimal codser) {
        this.codser = codser;
    }

    public BigDecimal getCodser() {
        return codser;
    }

    public void setCodser(BigDecimal codser) {
        this.codser = codser;
    }

    public String getTotpreser() {
        return totpreser;
    }

    public void setTotpreser(String totpreser) {
        this.totpreser = totpreser;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Profesional getCodpro() {
        return codpro;
    }

    public void setCodpro(Profesional codpro) {
        this.codpro = codpro;
    }

    public ServicioTipo getCodtipser() {
        return codtipser;
    }

    public void setCodtipser(ServicioTipo codtipser) {
        this.codtipser = codtipser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codser != null ? codser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.codser == null && other.codser != null) || (this.codser != null && !this.codser.equals(other.codser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codser=" + codser + ", totpreser=" + totpreser + ", codcli=" + codcli + ", codpro=" + codpro + ", codtipser=" + codtipser + '}';
    }

    public int getSubtotal() {
        return Subtotal;
    }

    public void calcular() {
        double total = 0;
        if (codtipser.getInstipser() == "Si") {
            total = ((Double.valueOf(codtipser.getPrectipser()) / Double.valueOf(codpro.getPrepro())) * 100) * 0.15;
        } else {
            total = (Double.valueOf(codtipser.getPrectipser()) / Double.valueOf(codpro.getPrepro())) * 100;

        }
        this.setTotpreser(String.valueOf(total));

    }

}
