package ru.pirozhkov.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pirozhkov.config.AppConfig;
import ru.pirozhkov.entities.Role;
import ru.pirozhkov.entities.User;
import ru.pirozhkov.repositories.RoleRepository;
import ru.pirozhkov.repositories.UserRepository;


public class MainData {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        RoleRepository roleRepository = applicationContext.getBean("roleRepository", RoleRepository.class);



//        Role role1 = new Role("ROLE_ADMIN");
//        Role role2 = new Role("ROLE_USER");
//        Role role3 = new Role("ROLE_MANAGER");


//        User user1 = new User("Ron","ron@gmail.com");
//        user1.setUsername("admin");
//        user1.setPassword("$2y$12$kppL/79H63sx3NoXlZhY/uDW2EiB18ByX8YeENyFwyxAnHjrCT4pK"); //11
//        user1.getRoles().add(role1);
//        user1.getRoles().add(role2);
//        user1.getRoles().add(role3);
//
//        User user2 = new User("Ann", "ann@gmail.com");
//        user2.setUsername("manager");
//        user2.setPassword("$2y$12$sEUvtSyWJ/kW8gPUBnjVoeK.HZNrJqV12OE64WgLQWDSyqyqr4Vwu");
//        user2.getRoles().add(role4);


//          User user = new User("Tom", "tom@gmail.com");
//          user.setUsername("tom");
//          user.setPassword("11");
//          user.getRoles().add(role1);
////
////
//        roleRepository.save(role1);
//        roleRepository.save(role2);
//        roleRepository.save(role3);


//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user);
    }
}
