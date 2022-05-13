package com.userregistration.controllers;

import com.userregistration.dtos.request.NewUserRequest;

import com.userregistration.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new-user")
    @Operation(summary="Add a new user", description ="Service to add a new user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Request format",
            required = true,
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject("{\n" +
                            "\"name\": \"Juan Rodriguez\",\n" +
                            "\"email\": \"juan@rodriguez.org\",\n" +
                            "\"password\": \"hunter2\",\n" +
                            "\"phones\": [\n" +
                            "{\n" +
                            "\"number\": \"1234567\",\n" +
                            "\"citycode\": \"1\",\n" +
                            "\"countrycode\": \"57\"\n" +
                            "}\n" +
                            "]\n" +
                            "}\n")))
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Insert successfully",
                                    value = "")
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "No transactions found",
                                    value =  "")
                    )
            ),
    })
    public ResponseEntity registerNewUser(@RequestBody NewUserRequest newUser){
        return userService.registerNewUser(newUser);
    }

}
