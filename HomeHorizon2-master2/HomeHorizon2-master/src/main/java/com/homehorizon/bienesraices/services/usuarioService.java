package com.homehorizon.bienesraices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.persona.usuario;
import com.homehorizon.bienesraices.repository.usuarioRepository;

@Service
public class usuarioService {

    @Autowired
    private usuarioRepository userRepository;

    public usuario login(String email, String password) {
        usuario user = userRepository.findByUsuario(email);
        if (user != null) {
            if (user.getContraseña().equals(password) && user.isEstado()) {
                return user;
            }
        }
        return null;
    }

    public usuario guardar(usuario user) {
        return userRepository.save(user);
    }

    public boolean verificarContra(int usuarioId, String contraIngresada){
        usuario usuario = userRepository.findById(usuarioId).orElse(null);
        if(usuario == null){
            return false;
        }
        return usuario.getContraseña().equals(contraIngresada);
    }

    public boolean cambiarContra(int usuarioId, String nuevaContra){
        usuario usuario = userRepository.findById(usuarioId).orElse(null);
        if(usuario == null){
            return false;
        }

        usuario.setContraseña(nuevaContra);
        userRepository.save(usuario);
        return true;
    }
}
