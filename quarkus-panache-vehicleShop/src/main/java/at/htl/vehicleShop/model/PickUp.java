package at.htl.vehicleShop.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "PickUp.findAll", query = "select s from PickUp s")
public class PickUp extends Vehicle {
    public int maxLoad;    //in Kilogramm
    public int maxTraction; //in NM

    //region Constructor
    public PickUp() {
    }

    public PickUp(String manufacturer, String modelName, int maxLoad, int maxTraction) {
        super(manufacturer, modelName);
        this.maxLoad = maxLoad;
        this.maxTraction = maxTraction;
    }
    //endregion

    //region Getter and Setter
    /*public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxTraction() {
        return maxTraction;
    }

    public void setMaxTraction(int maxTraction) {
        this.maxTraction = maxTraction;
    }*/
    //endregion

    @Override
    public String toString() {
        return super.toString()+", max. Ladegut:"+maxLoad+", Zugkraft:"+maxTraction;
    }
}
