package com.ddnshop.usersinfoservice.services;

import com.ddnshop.usersinfoservice.proxy.RoleServiceProxy;
import com.ddnshop.usersinfoservice.dao.UserRepository;
import com.ddnshop.usersinfoservice.dto.UserDTO;
import com.ddnshop.usersinfoservice.dto.UserDTOs;
import com.ddnshop.usersinfoservice.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Collectors;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceProxy proxy;

    public UserDTOs findAll(){
        return new UserDTOs(
                userRepository.findAll().stream()
                        .map(this::convertToDTO)
                        .collect(Collectors.toList())
        );
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_Id(user.getUser_Id());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreated_Date(user.getCreated_Date());
        userDTO.setLastModified_Date(user.getModified_Date());
        userDTO.setActive(user.isActive());
        userDTO.setRoles(proxy.getRoleService(user.getUser_Id()).getRoles());
        return userDTO;
    }

//    @HystrixCommand(fallbackMethod = "getFallbackUserRoles",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),//thời gian chờ response
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),//load số lần requset gần nhất cuối cùng
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),//phần trăm số request bị fail trong n lần request gần nhất
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")// thời gian chờ để bắt đầu lại circuit
//            },
//            threadPoolKey = "userRatingInfoPool",
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize",value = "20"),//số thread được cho phép cùng lúc vào 1 API
//                    @HystrixProperty(name = "maxQueueSize",value = "10")//số request muốn execute
//            })
//    public UserRoles getFallbackUserRoles(@PathVariable("user_Id") int user_Id){
//        UserRoles userRoles = new UserRoles();
//        userRoles.setRoles(Collections.singletonList(
//                new Role(0, "Not found policy")
//        ));
//        return userRoles;
//    }
}
