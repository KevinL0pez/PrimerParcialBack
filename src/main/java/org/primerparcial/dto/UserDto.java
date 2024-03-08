package org.primerparcial.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {
    @NotNull(message = "El campo 'names' no puede ser nulo")
    private String names;
    @NotNull(message = "El campo 'lastnames' no puede ser nulo")
    private String lastnames;
    private Integer age;
    private String address;
    private Long idRol;
}
