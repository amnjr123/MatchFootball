/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entraineur;
import entities.Equipe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Anas
 */
@Local
public interface SessionFederationLocal {

    
    Boolean authentification(String mdp);
    
    void creerEntraineur(String nom, String prenom, String login, String mdp);

    void creerEquipe(String nom, Entraineur entraineur);

    void creerArbitre(String nom, String prenom, String login, String mdp);

    void creerJoueur(String nom, String prenom);

    Entraineur rechercheEntraineur(long id);

    List listEntraineur();

    List listEquipes();

    Equipe rechercheEquipe(long id);

    List listJoueurs();

    
}
