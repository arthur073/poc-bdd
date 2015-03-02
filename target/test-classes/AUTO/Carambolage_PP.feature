# language: fr

  @Carambolage @PP @Rabat
  Fonctionnalité: UC#002 - Carambolage PP
    Scénario: Déclaration
      Etant donné que je déclare un sinistre dont les caractéristiques sont les suivantes:
        | Marché                      | PP                      |
        | Contrat                     | AUTO 4 roues            |
        | Type sinistre               | Carambolage             |
        | Corporel                    | Non                     |
        | Déclarant                   | Gestionnaire Rabat      |
        | Recours                     | Non                     |
      Quand la déclaration est terminée
      Alors le sinistre est routé de la manière suivante:
        | Sinistre                    | Transit Auto            |
        | Garantie sinistrée MAT 1    | Transit Auto            |
        | Garantie sinistrée MAT 2    |                         |
        | Garantie sinistrée CORPO 1  |                         |
        | Garantie sinistrée CORPO 2  |                         |
        | GRecours                    |                         |
      Et les activités doivent être routées de la manière suivante:
        | Volet Sinistre              | Transit Auto            |
        | Volet MAT                   | Transit Auto            |
        | Garantie sinistrée MAT 1    | Transit Auto            |
        | Garantie sinistrée MAT 2    |                         |
        | Volet CORPO                 |                         |
        | Garantie sinistrée CORPO 1  |                         |
        | Garantie sinistrée CORPO 2  |                         |
        | Activités recours MAT       |                         |
        | Activités recours CORPO     |                         |

