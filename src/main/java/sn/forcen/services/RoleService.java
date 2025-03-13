package sn.forcen.services;

import org.springframework.stereotype.Service;
import sn.forcen.entities.Role;
import sn.forcen.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> AllRoles(){
        return roleRepository.findAll();
    }

    public Role createRole(Role role){
       return roleRepository.save(role);
    }
}
