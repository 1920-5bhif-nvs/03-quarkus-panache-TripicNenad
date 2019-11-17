package at.htl.vehicleShop.business;

import at.htl.vehicleShop.model.PickUp;
import at.htl.vehicleShop.model.Roadster;
import at.htl.vehicleShop.model.Sedan;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    EntityManager em;

    @Transactional
    void init(@Observes StartupEvent ev) {
        System.err.println("------init------");


        System.err.println("------ROADSTERS Erstellen und Persistieren------");
        for (int i = 1; i <6 ; i++) {
            em.persist(new Roadster("BMW","Z"+i,i*120,250,2000));
        }

        System.err.println("------SEDANS Erstellen und Persistieren------");
        for (int i = 120; i < 830; i += 100) {
            em.persist(new Sedan("BMW", i + "D",5,i));
        }

        System.err.println("------PICKUPS Erstellen und Persistieren------");
        for (int i = 1; i < 8; i++) {
            em.persist(new PickUp("FORD", "Raptor",i*500,5000));
        }


        //Alle Sedans ausgeben
        System.err.println("------Print SEDANS------");
        PanacheQuery<Sedan> sedanQuery = Sedan.findAll();
        sedanQuery.list().forEach(sedan -> System.err.println(sedan.toString()));

        //Alle Roadsters ausgeben
        System.err.println("------Print ROADSTERS------");
        PanacheQuery<Roadster> roadsterQuery = Roadster.findAll();
        roadsterQuery.list().forEach(roadster -> System.err.println(roadster.toString()));

        //Alle PICKUPS ausgeben
        System.err.println("------Print PICKUPS------");
        PanacheQuery<PickUp> pickUpQuery = PickUp.findAll();
        pickUpQuery.list().forEach(pickUp -> System.err.println(pickUp.toString()));

    }

}
