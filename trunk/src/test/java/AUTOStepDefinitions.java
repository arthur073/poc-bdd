import cucumber.api.DataTable;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Quand;
import junit.framework.TestCase;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by averger on 26/02/2015.
 */
public class AUTOStepDefinitions {

    @Etantdonné("^que je déclare un sinistre dont les caractéristiques sont les suivantes:$")
    public void que_je_déclare_un_sinistre_dont_les_caractéristiques_sont_les_suivantes(DataTable claimDescription) throws Throwable {
        SeleniumSteps.ClaimIntake(new ClaimUC(claimDescription));
    }

    @Quand("^la déclaration est terminée$")
    public void la_déclaration_est_terminée() throws Throwable {
    }

    @Alors("^le sinistre est routé de la manière suivante:$")
    public void le_sinistre_est_routé_de_la_manière_suivante(DataTable results) throws Throwable {
        // Claim Affectation
        Affectation claimAffectation = SeleniumSteps.getClaimAffectation();
        String expectedClaimGroup = results.getGherkinRows().get(1).getCells().get(1);
        assertEquals(claimAffectation.getGroup(), expectedClaimGroup);

        // Exposures Affectations
        // TODO cas BI, gestion //, ...
        List<Affectation> exposuresAffectations = SeleniumSteps.getExposuresAffectations();
        String expectedMatExposureGroup = results.getGherkinRows().get(2).getCells().get(1);
        String expectedBIExposureGroup = results.getGherkinRows().get(4).getCells().get(1);
        for (Affectation exposureAffectation : exposuresAffectations) {
            assertEquals(exposureAffectation.getGroup(), expectedMatExposureGroup);
        }
    }

    @Et("^les activités doivent être routées de la manière suivante:$")
    public void les_activités_doivent_être_routées_de_la_manière_suivante(DataTable results) throws Throwable {
        List<Affectation> activitiesAffectations = SeleniumSteps.getActivitiesAffectations();
        String expectedClaimActivitiesGroup = results.getGherkinRows().get(1).getCells().get(1);

        for (Affectation activityAffectation : activitiesAffectations) {
            assertEquals(activityAffectation.getGroup(), expectedClaimActivitiesGroup);
        }
    }
}
