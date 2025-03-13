package sn.forcen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.forcen.dtos.RoleDTO;
import sn.forcen.entities.Role;
import sn.forcen.services.RoleService;

import java.util.List;

@RequestMapping("/roles")
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles =  roleService.AllRoles();
        return ResponseEntity.ok(roles); //HTTP 200 ok
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role role1 = roleService.createRole(role);
        return ResponseEntity.status(201).body(role1);
    }
}
