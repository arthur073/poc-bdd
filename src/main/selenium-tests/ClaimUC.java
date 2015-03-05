import cucumber.api.DataTable;

/**
 * Created by s819578 on 04/03/2015.
 */
public class ClaimUC {
    private String market;
    private String policyType;
    private String claimType;
    private String bodilyInjuryIndicator;
    private String claimantType;
    private String subrogationIndicator;

    public ClaimUC(DataTable claimDescription) {
        this.market = claimDescription.getGherkinRows().get(1).getCells().get(1);
        this.policyType = claimDescription.getGherkinRows().get(2).getCells().get(1);
        this.claimType = claimDescription.getGherkinRows().get(3).getCells().get(1);
        this.bodilyInjuryIndicator = claimDescription.getGherkinRows().get(4).getCells().get(1);
        this.claimantType = claimDescription.getGherkinRows().get(5).getCells().get(1);
        this.subrogationIndicator = claimDescription.getGherkinRows().get(6).getCells().get(1);
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getBodilyInjuryIndicator() {
        return bodilyInjuryIndicator;
    }

    public void setBodilyInjuryIndicator(String bodilyInjuryIndicator) {
        this.bodilyInjuryIndicator = bodilyInjuryIndicator;
    }

    public String getClaimantType() {
        return claimantType;
    }

    public void setClaimantType(String claimantType) {
        this.claimantType = claimantType;
    }

    public String getSubrogationIndicator() {
        return subrogationIndicator;
    }

    public void setSubrogationIndicator(String subrogationIndicator) {
        this.subrogationIndicator = subrogationIndicator;
    }

    public String getPolicyNumber() {
        if (this.market.equals("PP") && this.policyType.equals("Auto 4 Roues")) {
            return FileUtil.getProperty("contratAUTO4Roues_PP");
        }

        // This must never happen
        return null;
    }

    public String getEventType() {
        if (this.claimType.equals("Incendie criminel")) {
            return "Incendie et évènements assimilés";
        }

        // This must never happen
        return null;
    }

    public boolean hasBodilyInjury() {
       if (bodilyInjuryIndicator.equals("Oui")) {
           return true;
       } else {
           return false;
       }
    }
}
