package io.fxbits.assignment2.repository;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@ComponentScan
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByOrderByLastNameDesc();

    List<User> findAllByOrderByFirstNameDesc();

    List<User> findAllByOrderByUsernameDesc();

    List<User> findAllByOrderByLastNameAsc();

    List<User> findAllByOrderByFirstNameAsc();

    List<User> findAllByOrderByUsernameAsc();

}
