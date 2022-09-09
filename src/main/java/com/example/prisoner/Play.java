package com.example.prisoner;

import com.example.prisoner.models.Prisoner;
import com.example.prisoner.models.PrisonerStuff;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class Play implements ApplicationRunner {
    private final EntityManager em;
    private final TransactionTemplate transactionTemplate;

    public Play(EntityManager em, TransactionTemplate transactionTemplate) {
        this.em = em;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transactionTemplate.execute(status -> {


            this.em.persist(new Prisoner(  "kamaa", LocalDate.now(),save()));

            EntityGraph<?> graph = this.em.createEntityGraph(Prisoner.class);
            graph.addSubgraph("sid", Prisoner.class).addAttributeNodes("name");
            Map<String, Object> properties = new HashMap<>();
            properties.put("jax", graph);
            Long id = 2L;
            Prisoner prisoner = em.find(Prisoner.class, id, properties);

            System.out.println(prisoner);

            return null;
        });
    }

    public PrisonerStuff save() {
        var m = new PrisonerStuff("iphone 13");
        this.transactionTemplate.execute(status -> {
        this.em.persist(m);
        return m;
        });
        return m;
    }



}