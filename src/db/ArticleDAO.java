package db;

import ENTITIES.ArticleEntity;

import javax.persistence.*;
import java.util.*;

public class ArticleDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public ArticleEntity create(String codeVendeur, int prix, String taille, String description) {

        // Generate article code
        Random random = new Random();
        String codeArticle = "";
        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(9 + 1);
            codeArticle += randomNumber;
        }

        ArticleEntity article = new ArticleEntity();
        article.setCodeArticle(codeArticle);
        article.setCodeVendeur(codeVendeur.toUpperCase());
        article.setPrix(prix);
        article.setTaille(taille);
        article.setDescription(description);
        article.setVendu(0);

        this.em.getTransaction().begin();
        this.em.persist(article);
        this.em.getTransaction().commit();
        return article;

    }

    public List<ArticleEntity> find(String codeVendeur) {

        List<ArticleEntity> articles = new List<ArticleEntity>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<ArticleEntity> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(ArticleEntity articleEntity) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends ArticleEntity> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends ArticleEntity> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public ArticleEntity get(int i) {
                return null;
            }

            @Override
            public ArticleEntity set(int i, ArticleEntity articleEntity) {
                return null;
            }

            @Override
            public void add(int i, ArticleEntity articleEntity) {

            }

            @Override
            public ArticleEntity remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<ArticleEntity> listIterator() {
                return null;
            }

            @Override
            public ListIterator<ArticleEntity> listIterator(int i) {
                return null;
            }

            @Override
            public List<ArticleEntity> subList(int i, int i1) {
                return null;
            }
        };
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM ArticleEntity v WHERE v.codeVendeur = :code", ArticleEntity.class).setParameter("code", codeVendeur);

        try {
            articles = (List<ArticleEntity>) q.getResultList();
        } catch (NoResultException e) {

        }

        this.em.getTransaction().commit();

        return articles;

    }

    public ArticleEntity findOne(String codeArticle) {

        ArticleEntity article = new ArticleEntity();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM ArticleEntity v WHERE v.codeArticle = :code", ArticleEntity.class).setParameter("code", codeArticle);

        try {
            article = (ArticleEntity) q.getResultList();
        } catch (NoResultException e) {

        }

        this.em.getTransaction().commit();

        return article;

    }

}