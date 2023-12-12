package br.com.ifomeadaf1rst.dto.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiValidationErrorDTO extends ApiSubErrorDTO {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;
}
