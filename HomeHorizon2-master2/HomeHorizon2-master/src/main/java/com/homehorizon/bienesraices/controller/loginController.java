package com.homehorizon.bienesraices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.persona.usuario;
import com.homehorizon.bienesraices.services.usuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    private usuarioService userService;

    @GetMapping("/login")
    public String loginform(){
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,Model model){
        usuario user = userService.login(email, password);
        if (user !=null) {
            session.setAttribute("usuario", user);
            return "redirect:/index";
        }else{
            model.addAttribute("error", "Credenciales invalidas o cuenta desactivada");
            return "login";
        }
    }

    @GetMapping("/index")
    public String home(HttpSession session, Model model){
        usuario user = (usuario) session.getAttribute("usuario");
        if(user != null){
            model.addAttribute("user", user);
            int tipoUsuarioId = user.getTipoUsuario().getTipoUserID();

            switch (tipoUsuarioId) {
                case 1:
                    return  "index";
                case 2:
                    return "indexGerente";
                case 3:
                    return "indexAgente";
            }
            return "index";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
