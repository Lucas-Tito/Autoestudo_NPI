package com.titolucas.autoestudo.service;

import com.titolucas.autoestudo.model.User;
import com.titolucas.autoestudo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public Optional<User> buscarPorId(Long id) {
        return userRepository.findById(id);
    }

    public User salvar(User user) {
        return userRepository.save(user);
    }

    public void deletar(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> atualizar(Long id, User novoUsuario) {
        return userRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNome(novoUsuario.getNome());
            usuarioExistente.setEmail(novoUsuario.getEmail());
            return userRepository.save(usuarioExistente);
        });
    }
}
