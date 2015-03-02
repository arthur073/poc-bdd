# language: fr

  @Incendie @PP @Rabat
  Fonctionnalité: UC#001 - Incendie PP
    Scénario: Déclaration
      Etant donné que je déclare un sinistre dont les caractéristiques sont les suivantes:
        | Marché                      | PP                      |
        | Contrat                     | AUTO 4 roues            |
        | Type sinistre               | Incendie                |
        | Corporel                    | Non                     |
        | Déclarant                   | Gestionnaire Rabat      |
        | Recours                     | Non                     |
      Quand la déclaration est terminée
      Alors le sinistre est routé de la manière suivante:
        | Sinistre                    | Transit Rabat Auto      |
        | Garantie sinistrée MAT 1    | Transit Rabat Auto      |
        | Garantie sinistrée MAT 2    |                         |
        | Garantie sinistrée CORPO 1  |                         |
        | Garantie sinistrée CORPO 2  |                         |
        | GRecours                    |                         |
      Et les activités doivent être routées de la manière suivante:
        | Volet Sinistre              | Transit Rabat Auto      |
        | Volet MAT                   | Transit Rabat Auto      |
        | Garantie sinistrée MAT 1    | Transit Rabat Auto      |
        | Garantie sinistrée MAT 2    |                         |
        | Volet CORPO                 |                         |
        | Garantie sinistrée CORPO 1  |                         |
        | Garantie sinistrée CORPO 2  |                         |
        | Activités recours MAT       |                         |
        | Activités recours CORPO     |                         |

