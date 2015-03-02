import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Quand;

/**
 * Created by averger on 26/02/2015.
 */
public class AUTOStepDefinitions {
    @Etantdonné("^que je déclare un sinistre dont les caractéristiques sont les suivantes:$")
    public void que_je_déclare_un_sinistre_dont_les_caractéristiques_sont_les_suivantes(DataTable claimDescription) throws Throwable {
        SeleniumSteps.ClaimIntake(claimDescription.toString());
    }

    @Quand("^la déclaration est terminée$")
    public void la_déclaration_est_terminée() throws Throwable {
    }

    @Alors("^le sinistre est routé de la manière suivante:$")
    public void le_sinistre_est_routé_de_la_manière_suivante(DataTable results) throws Throwable {

    }

    @Et("^les activités doivent être routées de la manière suivante:$")
    public void les_activités_doivent_être_routées_de_la_manière_suivante(DataTable results) throws Throwable {

    }
}
