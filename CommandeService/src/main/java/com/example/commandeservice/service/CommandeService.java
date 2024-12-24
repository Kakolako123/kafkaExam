package com.example.commandeservice.service;

import com.example.commandeservice.entity.Commande;
import com.example.commandeservice.repository.CommandeRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommandeService {

    private final CommandeRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CommandeService(CommandeRepository repository, KafkaTemplate<String, String> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Commande saveCommande(Commande commande) {
        Commande savedCommande = repository.save(commande);
        kafkaTemplate.send("commandes", savedCommande.toString());
        return savedCommande;
    }
}
