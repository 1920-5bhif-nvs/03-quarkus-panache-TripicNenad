package at.htl.vehicleShop.business;

import at.htl.vehicleShop.model.PickUp;
import at.htl.vehicleShop.model.Roadster;
import at.htl.vehicleShop.model.Sedan;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Transactional
    void init(@Observes StartupEvent ev) {
        System.err.println("------init------");


        System.err.println("------ROADSTERS Erstellen und Persistieren------");
        for (int i = 1; i < 6; i++) {
            Roadster roadster = new Roadster("BMW", "Z" + i, i * 120, 250, 2000);
            roadster.persist();
        }

        System.err.println("------SEDANS Erstellen und Persistieren------");
        for (int i = 120; i < 830; i += 100) {
            Sedan sedan = new Sedan("BMW", i + "D", 5, i);
            sedan.persist();
        }

        System.err.println("------PICKUPS Erstellen und Persistieren------");
        for (int i = 1; i < 8; i++) {
            PickUp pickUp = new PickUp("FORD", "Raptor", i * 500, 5000);
            pickUp.persist();
        }


        //Alle Sedans ausgeben
        System.err.println("------Print SEDANS------");
        PanacheQuery<Sedan> sedanQuery = Sedan.findAll();
        sedanQuery.list().forEach(s -> System.err.println(s.toString()));

        //Alle Roadsters ausgeben
        System.err.println("------Print ROADSTERS------");
        PanacheQuery<Roadster> roadsterQuery = Roadster.findAll();
        roadsterQuery.list().forEach(r -> System.err.println(r.toString()));

        //Alle PICKUPS ausgeben
        System.err.println("------Print PICKUPS------");
        PanacheQuery<PickUp> pickUpQuery = PickUp.findAll();
        pickUpQuery.list().forEach(p -> System.err.println(p.toString()));

    }

}
