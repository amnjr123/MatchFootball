/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Equipe;
import entities.Joueur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Grind-Machine
 */
@Stateless
public class JoueurFacade extends AbstractFacade<Joueur> implements JoueurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatchFootball-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoueurFacade() {
        super(Joueur.class);
    }
    
    @Override
    public void creerJoueur(String nom, String prenom) {
        Joueur j = new Joueur();
        j.setNom(nom);
        j.setPrenom(prenom);
        em.persist(j);
    }
    
    
    @Override
    public void affecterEquipe(Joueur j, Equipe e) {
        j.getHistoriqueEquipes().add(e);
        e.addJoueurEffectif(j);
        em.merge(j);
        em.merge(e);
    }
    
    @Override
    public List listJoueurs() {
        Query requete = getEntityManager().createQuery("select j from Joueur as j"); 
        return requete.getResultList();  
    }  

    @Override
    public List listJoueursEquipe(Equipe equipe) {
       Query requete = getEntityManager().createQuery("select j from Joueur as j where j.equipe=:equipe"); 
        requete.setParameter("equipe", equipe);
        return requete.getResultList();  
    }    

   

}
