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

    public VendeurEntity find(String nom, String prenom) {

        VendeurEntity vendeur = new VendeurEntity();

        return vendeur;

    }

}