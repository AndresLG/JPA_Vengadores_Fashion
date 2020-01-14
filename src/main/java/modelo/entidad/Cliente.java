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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodcli", query = "SELECT c FROM Cliente c WHERE c.codcli = :codcli")
    , @NamedQuery(name = "Cliente.findByNomcli", query = "SELECT c FROM Cliente c WHERE c.nomcli = :nomcli")
    , @NamedQuery(name = "Cliente.findByEstcli", query = "SELECT c FROM Cliente c WHERE c.estcli = :estcli")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODCLI")
    private BigDecimal codcli;
    @Size(max = 100)
    @Pattern(regexp = "[A-Z a-z]+",message = "Sólo se permiten letras")
    @Column(name = "NOMCLI")
    private String nomcli;
    @Size(max = 1)
    @Basic(optional = false)
    @Column(name = "ESTCLI")
    private char estcli='A';
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcli")
    private List<Servicio> servicioList;

    public Cliente() {
    }

    public Cliente(BigDecimal codcli) {
        this.codcli = codcli;
    }

    public BigDecimal getCodcli() {
        return codcli;
    }

    public void setCodcli(BigDecimal codcli) {
        this.codcli = codcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public char getEstcli() {
        return estcli;
    }

    public void setEstcli(char estcli) {
        this.estcli = estcli;
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
        hash += (codcli != null ? codcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codcli == null && other.codcli != null) || (this.codcli != null && !this.codcli.equals(other.codcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codcli=" + codcli + ", nomcli=" + nomcli + ", estcli=" + estcli + ", servicioList=" + servicioList + '}';
    }

    
    
}
