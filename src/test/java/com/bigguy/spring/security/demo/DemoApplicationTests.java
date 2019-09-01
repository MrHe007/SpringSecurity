package com.bigguy.spring.security.demo;

import com.bigguy.spring.security.demo.dto.UserPermissionDto;
import com.bigguy.spring.security.demo.dto.UserRoleDto;
import com.bigguy.spring.security.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    IUserService userService;

	@Test
	public void contextLoads() {

	    String username = "zhangsan";

        List<UserPermissionDto> userPermList = userService.getUserPermList(username);

        userPermList.forEach(System.out::println);

        List<UserRoleDto> userRoleList = userService.getUserRoleList(username);
        userRoleList.forEach(System.out::println);

    }

}
