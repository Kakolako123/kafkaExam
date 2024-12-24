package com.example.commandeservice.grapheQl;

import com.example.commandeservice.service.CommandeService;
import org.springframework.stereotype.Component;
import com.example.commandeservice.entity.Commande;

import java.util.List;

@Component
public class CommandeGraphQL {

    private final CommandeService service;

    public CommandeGraphQL(CommandeService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Commande> allCommandes() {
        return service.findAllCommandes();
    }

    @QueryMapping
    public Commande getCommandeById(@Argument Long id) {
        return service.findCommandeById(id);
    }

    @MutationMapping
    public Commande createCommande(@Argument String produit, @Argument int quantite, @Argument double prix) {
        Commande commande = new Commande();
        commande.setProduit(produit);
        commande.setQuantite(quantite);
        commande.setPrix(prix);
        return service.saveCommande(commande);
    }
}
