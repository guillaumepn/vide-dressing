package ENTITIES;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vendeur", schema = "vide_dressing", catalog = "")
public class VendeurEntity {
    private int id;
    private String codeVendeur;
    private String password;
    private String nom;
    private String prenom;
    private Integer organisateur;
    private Integer blocked;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code_vendeur")
    public String getCodeVendeur() {
        return codeVendeur;
    }

    public void setCodeVendeur(String codeVendeur) {
        this.codeVendeur = codeVendeur;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "organisateur")
    public Integer getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Integer organisateur) {
        this.organisateur = organisateur;
    }

    public Boolean isOrga(){
        if(organisateur.equals(1)){
            return true;
        }
        return false;
    }

    @Basic
    @Column(name = "blocked")
    public Integer getBlocked() {
        return blocked;
    }

    public void setBlocked(Integer blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendeurEntity that = (VendeurEntity) o;
        return id == that.id &&
                Objects.equals(codeVendeur, that.codeVendeur) &&
                Objects.equals(password, that.password) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(organisateur, that.organisateur);
    }

    public Boolean isActive(){
        if(!password.isEmpty()){
            return true;
        }
        return false;
    }

    public Boolean isBlocked(){
        if(blocked == 1){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeVendeur, password, nom, prenom, organisateur);
    }
}
