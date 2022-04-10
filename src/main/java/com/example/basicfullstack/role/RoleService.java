package com.example.basicfullstack.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> getRoleByName(ERole name) {
        return roleRepository.getRoleByName(name);
    }

}