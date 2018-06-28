package ENTITIES;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "commentaire", schema = "vide_dressing", catalog = "")
public class CommentaireEntity {
    private int id;
    private String codeVendeur;
    private String codeArticle;
    private String contenu;

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
    @Column(name = "code_article")
    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    @Basic
    @Column(name = "contenu")
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentaireEntity that = (CommentaireEntity) o;
        return id == that.id &&
                Objects.equals(codeVendeur, that.codeVendeur) &&
                Objects.equals(codeArticle, that.codeArticle) &&
                Objects.equals(contenu, that.contenu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, codeVendeur, codeArticle, contenu);
    }
}
