package com.ribbon.ribbon;

import com.ribbon.ribbon.dto.Adres;
import com.ribbon.ribbon.dto.Bank;
import com.ribbon.ribbon.dto.Many;
import com.ribbon.ribbon.dto.Peoples;
import com.ribbon.ribbon.repo.RepoAddressBr;
import com.ribbon.ribbon.repo.RepoPeoplesBr;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.spi.Manageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.SearchResult;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RibbonApplicationServer implements CommandLineRunner {

    @Autowired
    private RepoPeoplesBr repoPeoplesBr;
    @Autowired
    private RepoAddressBr repoAddressBr;
    //    private String data;
    @Autowired
    private EntityManager em;




    public static void main(String[] args) {
        SpringApplication.run(RibbonApplicationServer.class, args);
    }

    @Override
    @Transactional(timeout = 6000, isolation = Isolation.SERIALIZABLE, noRollbackFor = TransactionException.class,
            propagation = Propagation.REQUIRES_NEW)
    public void run(String... args) throws Exception {


        SpringContext springContext = new SpringContext();
        String data = null;


        Bank bank = new Bank();
        bank.setId(2);
        bank.setName("Sber");

        Adres adres = new Adres();
        bank.setId(3);
        adres.setNameadress("Moscow");

        Adres adres2 = new Adres();
        bank.setId(4);
        adres.setNameadress("New-York");

        Many many = new Many();
        bank.setId(5);
        many.setName("EVRO");

        Peoples bro = new Peoples(6, "Bro", bank, adres, Collections.singleton(many));
        Peoples ti = new Peoples(7, "Ti", bank, adres2, Collections.singleton(many));
        Peoples ma = new Peoples(8, "Ma", bank, adres2, Collections.singleton(many));

        repoAddressBr.save(Arrays.asList(adres, adres2));
        repoPeoplesBr.save(Arrays.asList(bro, ti, ma));


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Peoples> cq = cb.createQuery(Peoples.class);



//        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
//        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
//        cq.where(authorNamePredicate, titlePredicate);

        TypedQuery<Peoples> query = em.createQuery(cq);
         query.getResultList();

    }

    @Data
    static class SpringContext {
        String data;
    }

}
