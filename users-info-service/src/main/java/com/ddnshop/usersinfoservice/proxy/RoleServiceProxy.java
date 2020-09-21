package com.ddnshop.usersinfoservice.proxy;
import com.ddnshop.usersinfoservice.models.UserRoles;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "roles-service")
public interface RoleServiceProxy {
    @GetMapping("/roles-service/v1/roles/{user_Id}")
    UserRoles getRoleService(@PathVariable("user_Id") int user_Id);
}
