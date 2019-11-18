package at.htl.vehicleShop.business;

import at.htl.vehicleShop.model.PickUp;
import at.htl.vehicleShop.model.Roadster;
import at.htl.vehicleShop.model.Sedan;
import at.htl.vehicleShop.model.Vehicle;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev) {
        System.err.println("------init------");


        System.err.println("------ROADSTERS Erstellen und Persistieren------");
        for (int i = 1; i < 6; i++) {
            em.persist(new Roadster("BMW", "Z" + i, i * 120, 250, 2000));
        }

        System.err.println("------SEDANS Erstellen und Persistieren------");
        for (int i = 120; i < 830; i += 100) {
            em.persist(new Sedan("BMW", i + "D", 5, i));
        }

        System.err.println("------PICKUPS Erstellen und Persistieren------");
        for (int i = 1; i < 8; i++) {
            em.persist(new PickUp("FORD", "Raptor", i * 500, 5000));
        }


        /*//Alle Sedans ausgeben
        System.err.println("------Print SEDANS------");
        TypedQuery<Sedan> sedanQuery =
                em.createNamedQuery("Sedan.findAll", Sedan.class);
        List<Sedan> sedanQueryResultList = sedanQuery.getResultList();
        sedanQueryResultList.forEach(sedan -> System.err.println(sedan.toString()));

        //Alle Roadsters ausgeben
        System.err.println("------Print ROADSTERS------");
        TypedQuery<Roadster> roadsterQuery =
                em.createNamedQuery("Roadster.findAll", Roadster.class);
        List<Roadster> roadsterQueryResultList = roadsterQuery.getResultList();
        roadsterQueryResultList.forEach(roadster -> System.err.println(roadster.toString()));

        //Alle PickUps ausgeben
        System.err.println("------Print PICKUPS------");
        TypedQuery<PickUp> pickupQuery =
                em.createNamedQuery("PickUp.findAll", PickUp.class);
        List<PickUp> pickupQueryResultList = pickupQuery.getResultList();
        pickupQueryResultList.forEach(pickUp -> System.err.println(pickUp.toString()));*/

        //Alle Vehicle ausgeben
        System.err.println("------Print VEHICLES------");
        TypedQuery<Vehicle> vehicleQuery =
                em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        List<Vehicle> vehicleQueryResultList = vehicleQuery.getResultList();
        vehicleQueryResultList.forEach(vehicle -> System.err.println(vehicle.toString()));


    }

}
