package com.example.commandeservice.controller;

import com.example.commandeservice.entity.Commande;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public CommandeController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<String> createCommande(@RequestBody Commande commande) {
        // Sauvegarde dans la base de données (non montrée ici)

        // Envoie le message à Kafka
        kafkaTemplate.send("commandes", commande.toString());
        return ResponseEntity.ok("Commande créée et envoyée à Kafka.");
    }
}
