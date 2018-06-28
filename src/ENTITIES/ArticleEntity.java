package ENTITIES;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "article", schema = "vide_dressing", catalog = "")
public class ArticleEntity {
    private String codeArticle;
    private String codeVendeur;
    private Integer prix;
    private String taille;
    private String description;
    private Integer vendu;

    @Id
    @Column(name = "code_article")
    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
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
    @Column(name = "prix")
    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "taille")
    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "vendu")
    public Integer getVendu() {
        return vendu;
    }

    public void setVendu(Integer vendu) {
        this.vendu = vendu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity that = (ArticleEntity) o;
        return Objects.equals(codeArticle, that.codeArticle) &&
                Objects.equals(codeVendeur, that.codeVendeur) &&
                Objects.equals(prix, that.prix) &&
                Objects.equals(taille, that.taille) &&
                Objects.equals(description, that.description) &&
                Objects.equals(vendu, that.vendu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeArticle, codeVendeur, prix, taille, description, vendu);
    }
}
