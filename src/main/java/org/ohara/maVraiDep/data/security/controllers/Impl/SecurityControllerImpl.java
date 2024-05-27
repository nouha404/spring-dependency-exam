package org.ohara.maVraiDep.data.security.controllers.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ohara.maVraiDep.data.security.controllers.SecurityController;
import org.ohara.maVraiDep.data.security.controllers.dto.AuthenticationRequestDto;
import org.ohara.maVraiDep.data.security.controllers.dto.RestResponseDto;
import org.ohara.maVraiDep.data.security.controllers.dto.TokenReponseDto;
import org.ohara.maVraiDep.data.security.services.JwtService;
import org.ohara.maVraiDep.data.security.services.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<Map<Object, Object>> login(AuthenticationRequestDto authenticationRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        Map<Object, Object> response;
        if(authenticate.isAuthenticated()){
            // Generer le token
            String token= jwtService.createToken(authenticationRequestDto.getUsername());
            TokenReponseDto tokenDto = TokenReponseDto.builder()
                    .token(token)
                    .username(authenticationRequestDto.getUsername())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response = RestResponseDto.response(tokenDto, HttpStatus.OK);
        } else {
            response = RestResponseDto.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }
}
