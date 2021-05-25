//package com.example.demo.config;
//
//import com.example.demo.controller.DAOUser;
//import com.example.demo.controller.UserDTO;
//import com.example.demo.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Arrays;
//
//public class CustomUserDetailsService implements UserDetailsService{
//    @Autowired
//    private UserRepository userDao;
//
//    @Autowired
//    private PasswordEncoder bcryptEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<SimpleGrantedAuthority> roles = null;
//        DAOUser user = userDao.findByUsername(username);
//        if (user != null) {
//            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
//            return new User(user.getUsername(), user.getPassword(), roles);
//        }
//        throw new UsernameNotFoundException("User not found with the name " + username);
//    }
//
//    public DAOUser save(UserDTO user) {
//        DAOUser newUser = new DAOUser();
//        newUser.setUsername(user.getUsername());
//        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        newUser.setRole(user.getRole());
//        return userDao.save(newUser);
//    }
//}
