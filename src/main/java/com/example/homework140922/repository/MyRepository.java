package com.example.homework140922.repository;

import com.example.homework140922.model.Customer;
import com.example.homework140922.model.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Repository
public class MyRepository implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var random = new Random();
        var customers = Stream.of("Георгий Савченко","Григорий Москаленко","Адам Юсупов")
                .map(n-> n.split(" "))
                .map(val -> Customer.builder()
                        .name(val[0])
                        .lastname(val[1])
                        .age(random.nextInt(25))
                        .phoneNumber(23).build())
                .toList();

        for (Customer customer: customers) {
         entityManager.persist(customer);
        }

        var nameProducts = List.of("продукт1 1","продукт2 2","продукт3 3");
        IntStream.range(0,5).forEach(i -> {
            var j = nameProducts.get(random.nextInt(nameProducts.size())).split(" ");
            var order = Order.builder()
                    .productName(j[0])
                    .amount(random.nextInt(10))
                    .price(Integer.parseInt(j[1]))
                    .date(new Date())
                    .customer(customers.get(random.nextInt(customers.size())))
                    .build();
            entityManager.persist(order);
        });
    }

    public List<String> get(String name){
        return entityManager.createQuery("SELECT p FROM Order p WHERE LOWER(p.customer.name) LIKE LOWER(CONCAT('%', :name, '%'))")
                .setParameter("name", name)
                .getResultList();
    }
}
