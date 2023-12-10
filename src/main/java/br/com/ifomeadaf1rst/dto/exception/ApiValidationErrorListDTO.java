package br.com.ifomeadaf1rst.dto.exception;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiValidationErrorListDTO extends ApiSubErrorDTO {
    private List<ApiSubErrorDTO> errors;
}
