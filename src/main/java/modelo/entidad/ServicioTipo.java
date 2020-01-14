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
@Table(name = "SERVICIO_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioTipo.findAll", query = "SELECT s FROM ServicioTipo s")
    , @NamedQuery(name = "ServicioTipo.findByCodtipser", query = "SELECT s FROM ServicioTipo s WHERE s.codtipser = :codtipser")
    , @NamedQuery(name = "ServicioTipo.findByNomtipser", query = "SELECT s FROM ServicioTipo s WHERE s.nomtipser = :nomtipser")
    , @NamedQuery(name = "ServicioTipo.findBySubtipser", query = "SELECT s FROM ServicioTipo s WHERE s.subtipser = :subtipser")
    , @NamedQuery(name = "ServicioTipo.findByPrectipser", query = "SELECT s FROM ServicioTipo s WHERE s.prectipser = :prectipser")
    , @NamedQuery(name = "ServicioTipo.findByEsttipser", query = "SELECT s FROM ServicioTipo s WHERE s.esttipser = :esttipser")
    , @NamedQuery(name = "ServicioTipo.findByBartipser", query = "SELECT s FROM ServicioTipo s WHERE s.bartipser = :bartipser")
    , @NamedQuery(name = "ServicioTipo.findByInstipser", query = "SELECT s FROM ServicioTipo s WHERE s.instipser = :instipser")})
public class ServicioTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODTIPSER")
    private BigDecimal codtipser;
    @Size(max = 100)
    @Pattern(regexp = "[A-Z a-z]+",message = "Sólo se permiten letras")
    @Column(name = "NOMTIPSER")
    private String nomtipser;
    @Size(max = 50)
    @Pattern(regexp = "[A-Z a-z]+",message = "Sólo se permiten letras")
    @Column(name = "SUBTIPSER")
    private String subtipser;
    @Size(max = 5)
    @Pattern(regexp = "[0-9]+",message = "Sólo se permiten números")
    @Column(name = "PRECTIPSER",length = 5)
    private String prectipser;
    @Size(max = 7)
    @Column(name = "ESTTIPSER",length = 7)
    private String esttipser;
    @Size(max = 2)
    @Column(name = "BARTIPSER",length = 2)
    private String bartipser;
    @Size(max = 2)
    @Column(name = "INSTIPSER",length = 2)
    private String instipser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipser")
    private List<Servicio> servicioList;

    public ServicioTipo() {
    }

    public ServicioTipo(BigDecimal codtipser) {
        this.codtipser = codtipser;
    }

    public BigDecimal getCodtipser() {
        return codtipser;
    }

    public void setCodtipser(BigDecimal codtipser) {
        this.codtipser = codtipser;
    }

    public String getNomtipser() {
        return nomtipser;
    }

    public void setNomtipser(String nomtipser) {
        this.nomtipser = nomtipser;
    }

    public String getSubtipser() {
        return subtipser;
    }

    public void setSubtipser(String subtipser) {
        this.subtipser = subtipser;
    }

    public String getPrectipser() {
        return prectipser;
    }

    public void setPrectipser(String prectipser) {
        this.prectipser = prectipser;
    }

    public String getEsttipser() {
        return esttipser;
    }

    public void setEsttipser(String esttipser) {
        this.esttipser = esttipser;
    }

    public String getBartipser() {
        return bartipser;
    }

    public void setBartipser(String bartipser) {
        this.bartipser = bartipser;
    }

    public String getInstipser() {
        return instipser;
    }

    public void setInstipser(String instipser) {
        this.instipser = instipser;
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
        hash += (codtipser != null ? codtipser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioTipo)) {
            return false;
        }
        ServicioTipo other = (ServicioTipo) object;
        if ((this.codtipser == null && other.codtipser != null) || (this.codtipser != null && !this.codtipser.equals(other.codtipser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServicioTipo{" + "codtipser=" + codtipser + ", nomtipser=" + nomtipser + ", subtipser=" + subtipser + ", prectipser=" + prectipser + ", esttipser=" + esttipser + ", bartipser=" + bartipser + ", instipser=" + instipser + ", servicioList=" + servicioList + '}';
    }

    
    
}
