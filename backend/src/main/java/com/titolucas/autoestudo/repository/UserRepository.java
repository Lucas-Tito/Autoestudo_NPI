package com.titolucas.autoestudo.repository;
import com.titolucas.autoestudo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
