package com.springRestGuide.demo;

import com.springRestGuide.demo.models.Employee;
import com.springRestGuide.demo.models.Order;
import com.springRestGuide.demo.models.Status;
import com.springRestGuide.demo.repository.EmployeeRepository;
import com.springRestGuide.demo.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class LoadDatabase {


    private static final  Logger log =  LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository){
        return args -> {
        employeeRepository.save(new Employee("Bilbo", "Baggins", "Bulgar"));
        employeeRepository.save(new Employee("Frodo", "Baggins", "Thief"));

        employeeRepository.findAll().forEach(employee -> {log.info("Preloaded " + employee );});

        orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
        orderRepository.save(new Order("Iphone", Status.IN_PROGRESS));

        orderRepository.findAll().forEach(order -> {log.info("Preloaded " + order);});
        };
    }
}
