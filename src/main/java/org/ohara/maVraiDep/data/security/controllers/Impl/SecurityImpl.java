package org.ohara.maVraiDep.data.security.controllers.Impl;



import org.ohara.maVraiDep.data.security.controllers.Security;
import org.ohara.maVraiDep.data.security.data.entities.AppUser;
import org.ohara.maVraiDep.data.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SecurityImpl implements Security {
    private final SecurityService securityService;

    @Override
    public String login(@AuthenticationPrincipal UserDetails user) {
        System.out.println(user.getUsername() + " est connecté !");
        // anyMatch dès qu'il trouve un critere valid …
        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("PROFESSEUR") == 0) ){
            return "redirect:/api/professeurs";
        }

        if(user.getAuthorities().stream().anyMatch(role -> role.getAuthority().compareTo("ETUDIANT") == 0) ){
            return "redirect:/api/etudiants";

        }
        return "redirect:/login";
    }


}
