/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Grind-Machine
 */
@Entity
public class Joueur implements Serializable {

    @OneToMany
    private List<Equipe> historiqueEquipes;

    public List<Equipe> getHistoriqueEquipes() {
        return historiqueEquipes;
    }
    
    /*Pour garder la synchronisation/relation des listes et BD*/
    public void addFaute(Faute f) {
        fautes.add(f);
        f.setJoueur(this);
    }
    
    public void removeFaute(Faute f) {
        fautes.remove(f);
        f.setJoueur(null);
    }
    /*Pour garder la synchronisation/relation des listes et BD*/
    
    @OneToMany(mappedBy = "joueur")
    private List<Faute> fautes;

    public List<Faute> getFautes() {
        return fautes;
    }

    public void setFautes(List<Faute> fautes) {
        this.fautes = fautes;
    }
    
    @ManyToOne
    private Equipe equipe;

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    
    @Column(unique=false,nullable=false)
    private String prenom;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(unique=false,nullable=false)
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Joueur[ id=" + id + " ]";
    }
    
}
