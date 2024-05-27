package org.ohara.maVraiDep.data.security.services;


import org.ohara.maVraiDep.data.security.data.entities.AppRole;
import org.ohara.maVraiDep.data.security.data.entities.AppUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {
    AppUser getUser(String username);
    AppUser saveUser(String username, String password);
    AppRole saveRole(String roleName);
    void addRoleToUser(String username,String roleName);
    void removeRoleToUser(String username,String roleName);
    UserDetails loadUserByUsername(String username);

}
