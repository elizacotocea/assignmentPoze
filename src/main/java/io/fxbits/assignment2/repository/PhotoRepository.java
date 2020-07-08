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
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@ComponentScan
public interface PhotoRepository extends JpaRepository<Photo,Long>, PagingAndSortingRepository<Photo, Long> {
    List<Photo> findAllByVenue(String venue);

    List<Photo> findAllByUser(User user);

    @Query(value="SELECT * FROM photo p WHERE p.id_user=?1", nativeQuery = true)
    List<Photo> findAllByUsersId(Long idUser);
}
