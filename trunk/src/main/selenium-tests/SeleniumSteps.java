import cucumber.api.DataTable;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by averger on 26/02/2015.
 */
public class SeleniumSteps {
    private static SharedDriver driver;
    //static WebDriver driver;
    //static String baseURL;
    //String nodeURL;

    @Before
    public void initiateWebBrowser() {
        driver = new SharedDriver();
    }

    private static void logIntoGuidewire(String loginType) {
        System.out.println("Login (" + loginType + ") [Start]");

        driver.get(FileUtil.getProperty("claimCenterURL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String login;
        String pwd;

        if (loginType.equals("Gestionnaire Rabat")) {
            login = FileUtil.getProperty("claimCenterLoginRabat");
            pwd = FileUtil.getProperty("claimCenterPwdRabat");
        } else if (loginType.equals("Gestionnaire Siège")) {
            login = FileUtil.getProperty("claimCenterLoginSiege");
            pwd = FileUtil.getProperty("claimCenterPwdSiege");
        } else if (loginType.equals("Agent non ambition")) {
            login = FileUtil.getProperty("claimCenterLoginNAmbition");
            pwd = FileUtil.getProperty("claimCenterPwdNAmbition");
        } else if (loginType.equals("Agent ambition")) {
            login = FileUtil.getProperty("claimCenterLoginAmbition");
            pwd = FileUtil.getProperty("claimCenterPwdAmbition");
        } else {
            // This case must never happen
            throw new NotImplementedException();
        }

        driver.findElement(By.id("Login:LoginScreen:LoginDV:username-inputEl")).sendKeys(login);
        driver.findElement(By.id("Login:LoginScreen:LoginDV:remember-inputEl")).click();
        driver.findElement(By.id("Login:LoginScreen:LoginDV:password-inputEl")).sendKeys(pwd + Keys.ENTER);

        System.out.println("Login (" + loginType + ") [End]");
    }


    public static boolean ClaimIntake(ClaimUC claim) throws InterruptedException {
        logIntoGuidewire(claim.getClaimantType());

        System.out.println("ClaimIntake [Start]");

        // Navigating to screen new Claim
        driver.findElement(By.cssSelector("#QuickJump-inputEl")).sendKeys("Nouveau_sinistre" + Keys.ENTER);
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a policyNumber-inputEl"))
                .sendKeys(claim.getPolicyNumber() + Keys.TAB);
        shortPause();
        // TODO add branch in claimDescription
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a newLossTypeField-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a newLossTypeField-inputEl")).sendKeys("Auto" + Keys.TAB);
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a IdPolicyTypeChoice-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a IdPolicyTypeChoice-inputEl")).sendKeys(claim.getPolicyType() + Keys.TAB);
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a Ext_FindPolicySiebelInputSet\\3a LossDateField-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a FNOLWizardFindPolicyPanelSet\\3a Ext_FindPolicySiebelInputSet\\3a LossDateField-inputEl")).sendKeys("03/03/2015" + Keys.TAB);
        driver.findElement(By.cssSelector("#FNOLWizard\\3a FNOLWizard_FindPolicyScreen\\3a NextButton-btnEl")).click();
        longPause();

        System.out.println("ClaimIntake [Customer context]");
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a BasicInfoDetailViewPanelDV\\3a Claim_PersonTypeBasics-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a BasicInfoDetailViewPanelDV\\3a Claim_PersonTypeBasics-inputEl")).sendKeys("Assuré" + Keys.TAB);
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a RightPanel\\3a FNOLWizard_BasicInfoRightPanelSet\\3a 0\\3a Ext_VerifyAutoPolicyDV\\3a Registration_true-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a RightPanel\\3a FNOLWizard_BasicInfoRightPanelSet\\3a 0\\3a Ext_VerifyAutoPolicyDV\\3a Model_true-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a RightPanel\\3a FNOLWizard_BasicInfoRightPanelSet\\3a 0\\3a Ext_VerifyAutoPolicyDV\\3a TravelReason-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a RightPanel\\3a FNOLWizard_BasicInfoRightPanelSet\\3a 0\\3a Ext_VerifyAutoPolicyDV\\3a TravelReason-inputEl")).sendKeys("Privé uniquement" + Keys.TAB);
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a RightPanel\\3a FNOLWizard_BasicInfoRightPanelSet\\3a 0\\3a Ext_VerifyAutoPolicyDV\\3a GaragePlaceVerification_true-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a PanelRow\\3a Ext_InternationalClaimInputSet\\3a IsInternationalClaim_false-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a NextButton-btnInnerEl")).click();
        shortPause();
        if (driver.findElement(By.id("southPanel-splitter")).isDisplayed()) {
            // Duplicate claim found
            driver.findElement(By.id("NewClaimDuplicatesWorksheet:NewClaimDuplicatesScreen:NewClaimDuplicatesWorksheet_CloseButton-btnInnerEl")).click();
            shortPause();
            driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_BasicInfoScreen\\3a NextButton-btnInnerEl")).click();
        }

        System.out.println("ClaimIntake [Claim context]");
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a ExtLossDetailsDescriptionInputSet\\3a Claim_LossCause-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a ExtLossDetailsDescriptionInputSet\\3a Claim_LossCause-inputEl")).sendKeys(claim.getEventType() + Keys.TAB);
        longPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a AddressDetailInputSetRef\\3a Ext_AddressAutoInputSet\\3a AddressInseeDepartment-inputEl")).sendKeys("95" + Keys.TAB);
        longPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a LossCauseDamageQuestionsPanelSet\\3a ExtLossCauseQuestionPanelSet\\3a Claim_LossCause_Detail-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a LossCauseDamageQuestionsPanelSet\\3a ExtLossCauseQuestionPanelSet\\3a Claim_LossCause_Detail-inputEl")).sendKeys(claim.getClaimType() + Keys.TAB);
        longPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a LossCauseDamageQuestionsPanelSet\\3a ExtLossCauseQuestionPanelSet\\3a FireAuto\\3a Vehicle_Situation-inputEl")).clear();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a LossCauseDamageQuestionsPanelSet\\3a ExtLossCauseQuestionPanelSet\\3a FireAuto\\3a Vehicle_Situation-inputEl")).sendKeys("En circulation" + Keys.TAB);
        shortPause();

        if (claim.hasBodilyInjury()) {
            driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a Ext_CorporealQuestionnaireInputSet\\3a IsInjuredField_true-inputEl")).click();
            shortPause();
            // TODO nombre de victimes
        } else {
            driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a Ext_CorporealQuestionnaireInputSet\\3a IsInjuredField_false-inputEl")).click();
            shortPause();
        }
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a WitnessesPresence_false-inputEl")).click();
        veryLongPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a PoliceIntervention_false-inputEl")).click();
        veryLongPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a FNOLWizard_NewLossDetailsScreen\\3a NextButton-btnInnerEl")).click();

        System.out.println("ClaimIntake [Insured damage]");
        driver.findElement(By.cssSelector("#FNOLVehicleIncidentPopup\\3a FNOLVehicleIncidentScreen\\3a Ext_EditVehiclePanelSet\\3a VIPS3\\3a Ext_VehicleDamageDescriptionDV\\3a Ext_ComplementaryVehicleDamageInputSet\\3a 0\\3a damagePoint-inputEl")).click();
        driver.findElement(By.cssSelector("#FNOLVehicleIncidentPopup\\3a FNOLVehicleIncidentScreen\\3a Ext_EditVehiclePanelSet\\3a VehicleDriveable_true-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLVehicleIncidentPopup\\3a FNOLVehicleIncidentScreen\\3a Ext_EditVehiclePanelSet\\3a VehicleTowed_false-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLVehicleIncidentPopup\\3a FNOLVehicleIncidentScreen\\3a Update-btnInnerEl")).click();

        System.out.println("ClaimIntake [Third Party AUTO]");
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a ExtFNOLWizardDamageEstimateOtherAutoScreen\\3a NextButton-btnInnerEl")).click();

        System.out.println("ClaimIntake [Technical Decision]");
        driver.findElement(By.cssSelector("#FNOLWizard\\3a AutoWorkersCompWizardStepSet\\3a ExtFNOLWizardClaimValidationScreen\\3a ExtTechnicalDecisionPanelSet\\3a insuredVehicles\\3a 0\\3a VehicleValue_false-inputEl")).click();
        shortPause();
        driver.findElement(By.cssSelector("#FNOLWizard\\3a Finish")).click();
        veryLongPause();
        if (driver.findElement(By.id("southPanel-splitter")).isDisplayed()) {
            // Warning raised
            driver.findElement(By.cssSelector("#FNOLWizard\\3a Finish")).click();
            longPause();
        }

        System.out.println("ClaimIntake [End]");
        driver.findElement(By.id("Ext_AutoServicePopupWizard:Cancel-btnInnerEl")).click();
        longPause();

        return true;
    }



    public static Affectation getClaimAffectation() {

        String claimNumber = driver.findElement(By.cssSelector("#Claim\\3a ClaimInfoBar\\3a idClaim-btnInnerEl")).getText();
        System.out.println("GetClaimAffectation (" + claimNumber + ") [Start]");

        driver.findElement(By.cssSelector("#Claim\\3a MenuLinks\\3a Claim_ClaimSummaryGroup > div")).click();
        shortPause();
        driver.findElement(By.cssSelector("#Claim\\3a MenuLinks\\3a Claim_ClaimSummaryGroup\\3a ClaimSummaryGroup_ClaimStatus > div")).click();
        shortPause();
        String managementType = driver.findElement(By.cssSelector("#ClaimStatus\\3a ManagementType_Ext-inputEl")).getText();
        String group = driver.findElement(By.cssSelector("#ClaimStatus\\3a PrimaryGroup-inputEl")).getText().replaceAll("[0-9]","").trim();

        System.out.println("GetClaimAffectation (" + claimNumber + ") [End]");
        return new Affectation(group, managementType);
    }

    public static List<Affectation> getExposuresAffectations() {

        String claimNumber = driver.findElement(By.cssSelector("#Claim\\3a ClaimInfoBar\\3a idClaim-btnInnerEl")).getText();
        System.out.println("GetExposuresAffectations (" + claimNumber + ")[Start]");
        List<Affectation> affectationList = new ArrayList<Affectation>();

        driver.findElement(By.cssSelector("#Claim\\3a MenuLinks\\3a Claim_ClaimExposuresGroup > div")).click();
        shortPause();
        Integer exposuresCount = driver.findElements(By.cssSelector("#ClaimExposures\\3a ExtclaimExposureScreen\\3a ExposureListDetail\\3a 1-body > div > table > tbody > tr")).size();

        for(Integer i = 0; i < exposuresCount; i++) {
            driver.findElement(By.cssSelector("#ClaimExposures\\3a ExtclaimExposureScreen\\3a ExposureListDetail\\3a " + i + "\\3a Order")).click();
            shortPause();
            String group = driver.findElement(By.cssSelector("#ExposureDetail\\3a ExposureDetailScreen\\3a ExposureDetailDV\\3a VehicleDamageDV\\3a ExposureDetailInputSet\\3a AssignedGroup_Name-inputEl")).getText().replaceAll("[0-9]","").trim();
            String managementType = driver.findElement(By.cssSelector("#ExposureDetail\\3a ExposureDetailScreen\\3a ExposureDetailDV\\3a VehicleDamageDV\\3a ExposureDetailInputSet\\3a ExposureManagementType_Ext-inputEl")).getText();
            affectationList.add(new Affectation(group,managementType));
            // Return to exposures screen
            driver.findElement(By.cssSelector("#Claim\\3a MenuLinks\\3a Claim_ClaimExposuresGroup > div")).click();
            longPause();
        }

        System.out.println("GetExposuresAffectations (" + claimNumber + ") [End]");
        return affectationList;
    }

    public static List<Affectation> getActivitiesAffectations() {
        String claimNumber = driver.findElement(By.cssSelector("#Claim\\3a ClaimInfoBar\\3a idClaim-btnInnerEl")).getText();
        System.out.println("GetActivitiesAffectations (" + claimNumber  + ")[Start]");

        List<Affectation> affectationList = new ArrayList<Affectation>();

        driver.findElement(By.cssSelector("#Claim\\3a MenuLinks\\3a Claim_ClaimWorkplan > div")).click();
        shortPause();
        Integer activitiesCount = driver.findElements(By.cssSelector("#ClaimWorkplan\\3a ClaimWorkplanScreen\\3a WorkplanLV-body > div > table > tbody > tr")).size();

        for(Integer i = 0; i < activitiesCount; i++) {

            driver.findElement(By.cssSelector("#ClaimWorkplan\\3a ClaimWorkplanScreen\\3a WorkplanLV\\3a " + i + "\\3a Subject")).click();
            longPause();



            String group;
            if (driver.findElement(By.id("southPanel-splitter")).isDisplayed()) {
                group = driver.findElement(By.cssSelector("#ActivityDetailWorksheet\\3a ActivityDetailScreen\\3a ActivityDV\\3a ActivityOwnerInputSet\\3a AssignedGroup-inputEl")).getText().replaceAll("[0-9]","").trim();
                affectationList.add(new Affectation(group, ""));
                driver.findElement(By.cssSelector("#ActivityDetailWorksheet\\3a ActivityDetailScreen\\3a ActivityDetailScreen_CancelButton")).click();
                longPause();
            } else {
                group = driver.findElement(By.cssSelector("#x-form-el-ExtMessageActivityNotesPage\\3a ExtMessageNotesSearchScreen\\3a ClaimNotesLV\\3a 0\\3a idGroup")).getText().replaceAll("[0-9]","").trim();

                if (!driver.findElement(By.cssSelector("#ExtMessageActivityNotesPage\\3a ExtMessageNotesSearchScreen\\3a ttlBar")).getText().equals("Messages")) {
                    // Do not check for messages. TODO : implement me
                    affectationList.add(new Affectation(group, ""));
                }

                driver.findElement(By.cssSelector("#Claim\\3a MenuLinks\\3a Claim_ClaimWorkplan > div")).click();
                shortPause();
            }
        }

        System.out.println("GetActivitiesAffectations (" + claimNumber + ") [End]");
        return affectationList;
    }


    private static void shortPause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void longPause() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void veryLongPause() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
