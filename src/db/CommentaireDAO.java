package db;

import ENTITIES.ArticleEntity;
import ENTITIES.CommentaireEntity;

import javax.persistence.*;
import java.util.*;

public class CommentaireDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public CommentaireEntity create(String codeVendeur, String codeArticle, String contenu) {

        CommentaireEntity commentaire = new CommentaireEntity();
        commentaire.setCodeVendeur(codeVendeur);
        commentaire.setCodeArticle(codeArticle);
        commentaire.setContenu(contenu);

        this.em.getTransaction().begin();
        this.em.persist(commentaire);
        this.em.getTransaction().commit();
        return commentaire;
    }

    public List<CommentaireEntity> allOfArticle(String codeArticle){
        List<CommentaireEntity> ListOfCommentaire = new ArrayList<CommentaireEntity>();
        this.em.getTransaction().begin();
        try {
            ListOfCommentaire = em.createQuery("SELECT e FROM CommentaireEntity e WHERE e.codeArticle = :code", CommentaireEntity.class).setParameter("code", codeArticle).getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return ListOfCommentaire;
    }

}