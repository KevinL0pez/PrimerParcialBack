package org.primerparcial.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.primerparcial.dto.ResponseDto;
import org.primerparcial.dto.UserDto;
import org.primerparcial.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {

    private final IUserService iUserService;


    @PostMapping("/create")
    private ResponseDto createUser(@RequestBody @Valid UserDto userDto) {
        return iUserService.createNewUser(userDto);
    }

}
