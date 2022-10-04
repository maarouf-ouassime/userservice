package ma.maarouf.userservice.service;

import ma.maarouf.userservice.domain.AppRole;
import ma.maarouf.userservice.domain.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    AppRole saveRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

}
