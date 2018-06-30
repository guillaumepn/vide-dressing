package db;

import ENTITIES.VendeurEntity;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

}