package org.primerparcial.service.implementation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.primerparcial.dto.ResponseDto;
import org.primerparcial.dto.UserDto;
import org.primerparcial.jpa.entities.RolEntity;
import org.primerparcial.jpa.entities.UserEntity;
import org.primerparcial.jpa.repositories.RolRepository;
import org.primerparcial.jpa.repositories.UserRepository;
import org.primerparcial.service.IUserService;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final RolRepository rolRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseDto createNewUser(UserDto userDto) {
        ResponseDto responseDto = new ResponseDto();

        if (userDto.getIdRol() == null) {
            responseDto.setError(Boolean.TRUE);
            responseDto.setMessage("El ID del rol no puede ser nulo.");
            responseDto.setStatusCode(400);
            return responseDto;
        }

        try {
            // Buscar el rol por su ID
            RolEntity rol = rolRepository.getRolById(userDto.getIdRol());
            if (rol == null) {
                responseDto.setError(Boolean.TRUE);
                responseDto.setMessage("No se encontró el Rol proporcionado.");
                responseDto.setStatusCode(404); // Código de estado 404 (Not Found)
                return responseDto;
            }

            // Crear un nuevo usuario

            UserEntity user = new UserEntity();
            user.setNames(userDto.getNames());
            user.setLastnames(userDto.getLastnames());
            user.setAge(userDto.getAge());
            user.setAddress(userDto.getAddress());
            user.setState(Boolean.TRUE);
            user.setRol(rol);
            userRepository.save(user);

            responseDto.setError(Boolean.FALSE);
            responseDto.setMessage("Se creó el usuario correctamente.");
            responseDto.setStatusCode(201); // Código de estado 201 (Created)
        } catch (Exception exc) {
            log.error("Ocurrió un error al crear el usuario: {}", exc.getMessage());
            responseDto.setError(Boolean.TRUE);
            responseDto.setMessage("Ocurrió un error al crear el usuario.");
            responseDto.setStatusCode(500); // Código de estado 500 (Internal Server Error)
        }

        return responseDto;
    }


}
