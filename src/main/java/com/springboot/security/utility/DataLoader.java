package com.springboot.security.utility;

import com.springboot.security.model.Role;
import com.springboot.security.model.User;
import com.springboot.security.repository.RoleRepository;
import com.springboot.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save (new Role("GUEST"));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");
        Role guestRole= roleRepository.findByRole("GUEST");

        User user = new User("jim@gmail.com", "password", "jim", "Jimmerson", true, "jim");
        user.setRoles(Arrays.asList(userRole, adminRole));

        userRepository.save(user);

        /*user = new User("admin@admin.com", "password", "Admin", "User", true, "admin");
        user.setRoles(Arrays.asList(adminRole));


        userRepository.save(user);

        user = new User("user@usr.com", "password", "Nora", "Nora", true, "nora");
        user.setRoles(Arrays.asList(userRole));

        userRepository.save(user);

        user = new User("guest@guest.com","password","Guest","Guest",true,"guest");
        user.setRoles(Arrays.asList(guestRole));

        userRepository.save(user);*/

    }
}
