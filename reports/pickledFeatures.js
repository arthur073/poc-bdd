jsonPWrapper ({
  "Features": [
    {
      "RelativeFolder": "AUTO\\002_Carambolage_PP.feature",
      "Feature": {
        "Name": "UC#002 - Carambolage PP",
        "Description": "",
        "FeatureElements": [
          {
            "Name": "Déclaration",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Etant donné ",
                "Name": "que je déclare un sinistre dont les caractéristiques sont les suivantes:",
                "TableArgument": {
                  "HeaderRow": [
                    "Caractéristique",
                    "Valeur"
                  ],
                  "DataRows": [
                    [
                      "Marché",
                      "PP"
                    ],
                    [
                      "Contrat",
                      "AUTO 4 roues"
                    ],
                    [
                      "Type sinistre",
                      "Carambolage"
                    ],
                    [
                      "Corporel",
                      "Non"
                    ],
                    [
                      "Déclarant",
                      "Gestionnaire Rabat"
                    ],
                    [
                      "Recours",
                      "Non"
                    ]
                  ]
                }
              },
              {
                "Keyword": "Given",
                "NativeKeyword": "Quand ",
                "Name": "la déclaration est terminée"
              },
              {
                "Keyword": "Given",
                "NativeKeyword": "Alors ",
                "Name": "le sinistre est routé de la manière suivante:",
                "TableArgument": {
                  "HeaderRow": [
                    "Entité à affecter",
                    "Groupe d'affectation"
                  ],
                  "DataRows": [
                    [
                      "Sinistre",
                      "Transit Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 1",
                      "Transit Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 2",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 1",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 2",
                      ""
                    ],
                    [
                      "GRecours",
                      ""
                    ]
                  ]
                }
              },
              {
                "Keyword": "Given",
                "NativeKeyword": "Et ",
                "Name": "les activités doivent être routées de la manière suivante:",
                "TableArgument": {
                  "HeaderRow": [
                    "Entité à affecter",
                    "Groupe d'affectation"
                  ],
                  "DataRows": [
                    [
                      "Volet Sinistre",
                      "Transit Auto"
                    ],
                    [
                      "Volet MAT",
                      "Transit Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 1",
                      "Transit Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 2",
                      ""
                    ],
                    [
                      "Volet CORPO",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 1",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 2",
                      ""
                    ],
                    [
                      "Activités recours MAT",
                      ""
                    ],
                    [
                      "Activités recours CORPO",
                      ""
                    ]
                  ]
                }
              }
            ],
            "Tags": [],
            "Result": {
              "WasExecuted": true,
              "WasSuccessful": true
            }
          }
        ],
        "Result": {
          "WasExecuted": true,
          "WasSuccessful": true
        },
        "Tags": [
          "@carambolage",
          "@pp",
          "@rabat"
        ]
      },
      "Result": {
        "WasExecuted": true,
        "WasSuccessful": true
      }
    },
    {
      "RelativeFolder": "AUTO\\001_Incendie_PP.feature",
      "Feature": {
        "Name": "UC#001 - Incendie PP",
        "Description": "",
        "FeatureElements": [
          {
            "Name": "Déclaration",
            "Description": "",
            "Steps": [
              {
                "Keyword": "Given",
                "NativeKeyword": "Etant donné ",
                "Name": "que je déclare un sinistre dont les caractéristiques sont les suivantes:",
                "TableArgument": {
                  "HeaderRow": [
                    "Caractéristique",
                    "Valeur"
                  ],
                  "DataRows": [
                    [
                      "Marché",
                      "PP"
                    ],
                    [
                      "Contrat",
                      "AUTO 4 roues"
                    ],
                    [
                      "Type sinistre",
                      "Incendie"
                    ],
                    [
                      "Corporel",
                      "Non"
                    ],
                    [
                      "Déclarant",
                      "Gestionnaire Rabat"
                    ],
                    [
                      "Recours",
                      "Non"
                    ]
                  ]
                }
              },
              {
                "Keyword": "Given",
                "NativeKeyword": "Quand ",
                "Name": "la déclaration est terminée"
              },
              {
                "Keyword": "Given",
                "NativeKeyword": "Alors ",
                "Name": "le sinistre est routé de la manière suivante:",
                "TableArgument": {
                  "HeaderRow": [
                    "Entité à affecter",
                    "Groupe d'affectation"
                  ],
                  "DataRows": [
                    [
                      "Sinistre",
                      "Transit Rabat Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 1",
                      "Transit Rabat Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 2",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 1",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 2",
                      ""
                    ],
                    [
                      "GRecours",
                      ""
                    ]
                  ]
                }
              },
              {
                "Keyword": "Given",
                "NativeKeyword": "Et ",
                "Name": "les activités doivent être routées de la manière suivante:",
                "TableArgument": {
                  "HeaderRow": [
                    "Entité à affecter",
                    "Groupe d'affectation"
                  ],
                  "DataRows": [
                    [
                      "Volet Sinistre",
                      "Transit Rabat Auto"
                    ],
                    [
                      "Volet MAT",
                      "Transit Rabat Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 1",
                      "Transit Rabat Auto"
                    ],
                    [
                      "Garantie sinistrée MAT 2",
                      ""
                    ],
                    [
                      "Volet CORPO",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 1",
                      ""
                    ],
                    [
                      "Garantie sinistrée CORPO 2",
                      ""
                    ],
                    [
                      "Activités recours MAT",
                      ""
                    ],
                    [
                      "Activités recours CORPO",
                      ""
                    ]
                  ]
                }
              }
            ],
            "Tags": [],
            "Result": {
              "WasExecuted": true,
              "WasSuccessful": true
            }
          }
        ],
        "Result": {
          "WasExecuted": true,
          "WasSuccessful": true
        },
        "Tags": [
          "@incendie",
          "@pp",
          "@rabat"
        ]
      },
      "Result": {
        "WasExecuted": true,
        "WasSuccessful": true
      }
    }
  ],
  "Configuration": {
    "SutName": "PIF-SAM",
    "SutVersion": "0.1",
    "GeneratedOn": "3 mars 2015 10:26:43"
  }
});