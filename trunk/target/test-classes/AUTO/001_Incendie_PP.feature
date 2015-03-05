# language: fr

  @incendie @pp @rabat
  Fonctionnalité: UC#001 - Incendie PP
    Scénario: Déclaration
      Etant donné que je déclare un sinistre dont les caractéristiques sont les suivantes:
        | Caractéristique             | Valeur                  |
        | Marché                      | PP                      |
        | Contrat                     | Auto 4 Roues            |
        | Type sinistre               | Incendie criminel       |
        | Corporel                    | Non                     |
        | Déclarant                   | Gestionnaire Rabat      |
        | Recours                     | Non                     |
      Quand la déclaration est terminée
      Alors le sinistre est routé de la manière suivante:
        | Entité à affecter           | Groupe d'affectation    |
        | Sinistre                    | TRANSIT RABAT AUTO      |
        | Garantie sinistrée MAT 1    | TRANSIT RABAT AUTO      |
        | Garantie sinistrée MAT 2    |                         |
        | Garantie sinistrée CORPO 1  |                         |
        | Garantie sinistrée CORPO 2  |                         |
        | GRecours                    |                         |
      Et les activités doivent être routées de la manière suivante:
        | Entité à affecter           | Groupe d'affectation    |
        | Volet Sinistre              | TRANSIT RABAT AUTO      |
        | Volet MAT                   | TRANSIT RABAT AUTO      |
        | Garantie sinistrée MAT 1    | TRANSIT RABAT AUTO      |
        | Garantie sinistrée MAT 2    |                         |
        | Volet CORPO                 |                         |
        | Garantie sinistrée CORPO 1  |                         |
        | Garantie sinistrée CORPO 2  |                         |
        | Activités recours MAT       |                         |
        | Activités recours CORPO     |                         |