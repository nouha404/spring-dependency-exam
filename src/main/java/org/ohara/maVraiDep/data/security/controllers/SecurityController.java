package org.ohara.maVraiDep.data.security.controllers;

import org.ohara.maVraiDep.data.security.controllers.dto.AuthenticationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface SecurityController {
    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto);
}
