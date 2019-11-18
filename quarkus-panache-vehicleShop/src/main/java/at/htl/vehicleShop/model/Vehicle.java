package at.htl.vehicleShop.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NamedQuery(name = "Vehicle.findAll",query = "select v from Vehicle v")
public abstract class Vehicle extends PanacheEntity {

    public String manufacturer;
    public String modelName;

    //region Constructor
    public Vehicle() {
    }

    public Vehicle(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }
    //endregion


    @Override
    public String toString() {
        return manufacturer+" "+modelName;
    }
}
