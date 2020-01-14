package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name = "PROFESIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p")
    , @NamedQuery(name = "Profesional.findByCodpro", query = "SELECT p FROM Profesional p WHERE p.codpro = :codpro")
    , @NamedQuery(name = "Profesional.findByTippro", query = "SELECT p FROM Profesional p WHERE p.tippro = :tippro")
    , @NamedQuery(name = "Profesional.findByPrepro", query = "SELECT p FROM Profesional p WHERE p.prepro = :prepro")
    , @NamedQuery(name = "Profesional.findByEstpro", query = "SELECT p FROM Profesional p WHERE p.estpro = :estpro")})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPRO")
    private BigDecimal codpro;
    @Size(max = 100)
    @Column(name = "TIPPRO")
    private String tippro;
    @Size(max = 5)
    @Pattern(regexp = "[0-9]+",message = "Sólo se permiten números")
    @Column(name = "PREPRO",length = 5)
    private String prepro;
    @Size(max = 1)
    @Basic(optional = false)
    @Column(name = "ESTPRO")
    private char estpro='A';
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpro")
    private List<Servicio> servicioList;

    public Profesional() {
    }

    public Profesional(BigDecimal codpro) {
        this.codpro = codpro;
    }

    public BigDecimal getCodpro() {
        return codpro;
    }

    public void setCodpro(BigDecimal codpro) {
        this.codpro = codpro;
    }

    public String getTippro() {
        return tippro;
    }

    public void setTippro(String tippro) {
        this.tippro = tippro;
    }

    public String getPrepro() {
        return prepro;
    }

    public void setPrepro(String prepro) {
        this.prepro = prepro;
    }

    public char getEstpro() {
        return estpro;
    }

    public void setEstpro(char estpro) {
        this.estpro = estpro;
    }

    @XmlTransient
    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpro != null ? codpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.codpro == null && other.codpro != null) || (this.codpro != null && !this.codpro.equals(other.codpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesional{" + "codpro=" + codpro + ", tippro=" + tippro + ", prepro=" + prepro + ", estpro=" + estpro + ", servicioList=" + servicioList + '}';
    }

    
    
}
