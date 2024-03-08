package org.primerparcial.service;

import org.primerparcial.dto.ResponseDto;
import org.primerparcial.dto.UserDto;

public interface IUserService {
    ResponseDto createNewUser(UserDto userDto);
}
