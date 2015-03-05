/**
 * Created by s819578 on 04/03/2015.
 */
public class Affectation {
    private String group;
    private String managementType;

    public Affectation(String group, String managementType) {
        this.group = group;
        this.managementType = managementType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getManagementType() {
        return managementType;
    }

    public void setManagementType(String managementType) {
        this.managementType = managementType;
    }
}
