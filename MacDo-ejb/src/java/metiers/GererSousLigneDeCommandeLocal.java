/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metiers;

import entites.Commande;
import entites.LigneDeCommande;
import entites.SousLigneDeCommande;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GererSousLigneDeCommandeLocal {

    public List<SousLigneDeCommande> listSsLigne();

    public void creationSsLigne(ArrayList<LigneDeCommande> ligne, Commande com);

    public void listSsLigne(long id);
    
}
