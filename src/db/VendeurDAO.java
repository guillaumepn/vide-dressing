package db;

import ENTITIES.VendeurEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class VendeurDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public VendeurEntity create(String prenom, String nom) {

        VendeurEntity vendeur = new VendeurEntity();
        String codeVendeur = prenom.substring(0, 1) + nom.substring(0, 2);
        vendeur.setCodeVendeur(codeVendeur.toUpperCase());
        vendeur.setNom(nom);
        vendeur.setPrenom(prenom);
        vendeur.setOrganisateur(0);

        this.em.getTransaction().begin();
        this.em.persist(vendeur);
        this.em.getTransaction().commit();
        return vendeur;

    }

    public VendeurEntity find(String codeVendeur, String password) {
        VendeurEntity vendeur = new VendeurEntity();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM VendeurEntity v WHERE v.codeVendeur = :code AND v.password = :pass", VendeurEntity.class).setParameter("code", codeVendeur).setParameter("pass", password);
        try {
            vendeur = (VendeurEntity) q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();
        return vendeur;
    }

    public VendeurEntity findByCode(String codeVendeur) {
        VendeurEntity vendeur = new VendeurEntity();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM VendeurEntity v WHERE v.codeVendeur = :code", VendeurEntity.class).setParameter("code", codeVendeur);
        try {
            vendeur = (VendeurEntity) q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();
        return vendeur;
    }

    public List<VendeurEntity> all(){
        List<VendeurEntity> ListOfVendeur = new ArrayList<VendeurEntity>();
        this.em.getTransaction().begin();
        try {
            ListOfVendeur = em.createQuery("SELECT e FROM VendeurEntity e").getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ListOfVendeur);
        return ListOfVendeur;
    }

    public void block(String code){
        try {
            VendeurEntity vendeur = new VendeurEntity();
            vendeur = this.findByCode(code);
            this.em.getTransaction().begin();
            vendeur.setBlocked(1);
            em.getTransaction().commit();
            System.out.println("Blocked");
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unblock(String code){
        try {
            VendeurEntity vendeur = new VendeurEntity();
            vendeur = this.findByCode(code);
            this.em.getTransaction().begin();
            vendeur.setBlocked(0);
            em.getTransaction().commit();
            System.out.println("Unblocked");
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
    }
}