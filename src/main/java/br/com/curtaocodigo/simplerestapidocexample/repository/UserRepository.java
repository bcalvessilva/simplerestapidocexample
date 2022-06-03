package br.com.curtaocodigo.simplerestapidocexample.repository;


import br.com.curtaocodigo.simplerestapidocexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
