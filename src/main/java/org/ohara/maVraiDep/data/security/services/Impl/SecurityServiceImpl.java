package org.ohara.maVraiDep.data.security.services.Impl;


import lombok.RequiredArgsConstructor;

import org.ohara.maVraiDep.data.security.data.entities.AppRole;
import org.ohara.maVraiDep.data.security.data.entities.AppUser;
import org.ohara.maVraiDep.data.security.repositories.AppRoleRepository;
import org.ohara.maVraiDep.data.security.repositories.AppUserRepository;
import org.ohara.maVraiDep.data.security.services.SecurityService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService, UserDetailsService {
    private final AppRoleRepository roleRepository;
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser saveUser(String username, String password) {
        AppUser user = userRepository.findByUsername(username);
        if (user!=null) throw new RuntimeException("User already exist");
        user=new AppUser(username,passwordEncoder.encode(password));
        user.setIsActive(true);
        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role!=null) throw new RuntimeException("Role already exist");
        role = new AppRole(roleName,null);
        role.setIsActive(true);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username,String roleName) {
        AppUser user = userRepository.findByUsername(username);
        if (user==null) throw new RuntimeException("User not found");
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role==null) throw new RuntimeException("Role not found");
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public void removeRoleToUser(String username,String roleName) {
        // Recherche de l'utilisateur
        AppUser user = userRepository.findByUsername(username);
        if (user==null) throw new RuntimeException("User not found");
        // Recherche de son role
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role==null) throw new RuntimeException("Role not found");
        // suppression
        user.getRoles().remove(role);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username);
        if (appUser == null) throw new RuntimeException("User not found ");
        List<SimpleGrantedAuthority> authorities = appUser.getRoles()
                .stream()
                .map(appRole -> new SimpleGrantedAuthority(appRole.getRoleName())).toList();
        return new User(appUser.getUsername(), appUser.getPassword(),authorities);
    }
}
