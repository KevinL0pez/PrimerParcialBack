package org.primerparcial.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResponseDto {
    private String message;
    private Boolean error;
    private Integer statusCode;
}
