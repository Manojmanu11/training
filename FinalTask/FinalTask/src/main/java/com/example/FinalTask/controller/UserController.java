package com.example.FinalTask.controller;

import com.example.FinalTask.dto.ApiResponse;
import com.example.FinalTask.dto.AuthRequest;
import com.example.FinalTask.dto.AuthResponse;
import com.example.FinalTask.entity.User;
import com.example.FinalTask.service.UserService;
import com.example.FinalTask.utility.JwtUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
//@RequestMapping("/user")

public class UserController {
    private static  final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtUtility jwtUtility;
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        logger.info("added");
        return userService.addUser( user);

    }
    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAll(){
        List<User>usersList=userService.getAll();
        return new ApiResponse<>(usersList.size(),usersList).getResponse();
    }
    @GetMapping("/getAll/{field}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAllBySorting(@PathVariable String field){
        List<User>usersList=userService.getAllBySorting(field);
        logger.info("sorted");
        return new ApiResponse<>(usersList.size(),usersList).getResponse();
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Page<User> getAll(@PathVariable int offset,@PathVariable int pageSize){
        Page<User> usersWithPagination=userService.getUserByPagination(offset, pageSize);
        return new ApiResponse<>(usersWithPagination.getSize(),usersWithPagination).getResponse();
    }
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public Page<User> findUsersWithPaginationAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
    {
        return userService.findUsersWithPaginationAndSorting(offset, pageSize, field);
    }


    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<User> findById(@PathVariable int id)
    {
        return userService.findById(id);
    }

    @PutMapping("/update/{id}")
    public User update(@RequestBody User user,@PathVariable Integer id){
        return userService.update(id, user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
    @PostMapping("/authenticate")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    ));
        }catch (BadCredentialsException e) {
            throw new Exception("INVALID CREDENTIALS", e);
        }
        final UserDetails userDetails= userService.loadUserByUsername(authRequest.getUsername());
        final String token=jwtUtility.generateToken(userDetails);
        return new AuthResponse(token);
    }

}
