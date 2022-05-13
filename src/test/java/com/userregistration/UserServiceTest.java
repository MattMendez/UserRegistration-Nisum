package com.userregistration;

import com.userregistration.dtos.request.NewUserPhonesRequest;
import com.userregistration.dtos.request.NewUserRequest;
import com.userregistration.dtos.response.NewUserResponse;
import com.userregistration.entities.User;
import com.userregistration.exceptions.EmailException;
import com.userregistration.exceptions.PasswordException;
import com.userregistration.exceptions.UserAlreadyExistException;
import com.userregistration.repositories.UserRepository;
import com.userregistration.services.UserService;
import com.userregistration.utils.JwtUtil;
import org.apache.tomcat.util.buf.Ascii;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@TestPropertySource(properties = { "user.password.regex=^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$" })
@TestPropertySource(properties = { "user.email.regex=^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" })
public class UserServiceTest {

    @Autowired
    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void registerNewUser_Test_CREATED(){

        NewUserPhonesRequest newUserPhonesRequest = NewUserPhonesRequest.builder()
                .number("123456")
                .cityCode("1")
                .countryCode("5")
                .build();

        NewUserRequest newUserRequest = NewUserRequest.builder()
                .email("abc@email.com")
                .name("name")
                .password("password")
                .phones(List.of(newUserPhonesRequest))
                .build();

        UUID uuid = UUID.randomUUID();

        User user = newUserRequest.toEntity();

        User savedUser = user;

        savedUser.setUuid(uuid);

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoiaHR0cDovL25pc3VtLmNvbSIsIm5hbWUiOiJKdWFuIFJvZHJpZ3VleiIsImVtYWlsIjoianVhbkByb2RyaWd1ZXoub3JnIiwiaWF0IjoxNDY2Nzk2ODIyLCJleHAiOjQ2MjI0NzA0MjJ9.mX_xp5sN1b1Cw8khS0t6TTxO0vCP_hdhz4TbrZUvjzY";

        JwtUtil jwtUtil = Mockito.mock(JwtUtil.class);
        when(jwtUtil.generateToken(user)).thenReturn(token);

        user.setToken(token);
        savedUser.setToken(token);

        when(userRepository.save(Mockito.any())).thenReturn(savedUser);

        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(new NewUserResponse().toResponse(savedUser));

        Assert.assertEquals( responseEntity, userService.registerNewUser(newUserRequest));

    }

    @Test(expected = EmailException.class)
    public void registerNewUser_Test_400_EmailException(){

        NewUserPhonesRequest newUserPhonesRequest = NewUserPhonesRequest.builder()
                .number("123456")
                .cityCode("1")
                .countryCode("5")
                .build();

        NewUserRequest newUserRequest = NewUserRequest.builder()
                .email("abcemail.com")
                .name("name")
                .password("1234")
                .phones(List.of(newUserPhonesRequest))
                .build();

        userService.registerNewUser(newUserRequest);
    }

    @Test(expected = PasswordException.class)
    public void registerNewUser_Test_400_PasswordException(){

        NewUserPhonesRequest newUserPhonesRequest = NewUserPhonesRequest.builder()
                .number("123456")
                .cityCode("1")
                .countryCode("5")
                .build();

        NewUserRequest newUserRequest = NewUserRequest.builder()
                .email("abc@email.com")
                .name("name")
                .password("|132146576897568\ts\tS")
                .phones(List.of(newUserPhonesRequest))
                .build();

        userService.registerNewUser(newUserRequest);
    }

    @Test(expected = UserAlreadyExistException.class)
    public void registerNewUser_Test_400_UserAlreadyExistException(){

        NewUserPhonesRequest newUserPhonesRequest = NewUserPhonesRequest.builder()
                .number("123456")
                .cityCode("1")
                .countryCode("5")
                .build();

        NewUserRequest newUserRequest = NewUserRequest.builder()
                .email("abcemail.com")
                .name("name")
                .password("1234")
                .phones(List.of(newUserPhonesRequest))
                .build();

        Optional<User> user = Optional.ofNullable(newUserRequest.toEntity());

        Mockito.when(userRepository.findByEmail(newUserRequest.getEmail())).thenReturn(user);

        userService.registerNewUser(newUserRequest);
    }


}
