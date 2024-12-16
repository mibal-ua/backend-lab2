package ua.mibal.controller.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
@Getter
public class ConstraintViolationProblemDetails extends ProblemDetail {
    private final List<ParamsViolationDetails> fieldDetails;

    private ConstraintViolationProblemDetails(List<ParamsViolationDetails> fieldDetails) {
        super(forStatusAndDetail(HttpStatus.BAD_REQUEST, "Constraint violation"));
        this.fieldDetails = fieldDetails;
    }

    public static ConstraintViolationProblemDetails of(MethodArgumentNotValidException e) {
        List<ParamsViolationDetails> fieldDetails = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> ParamsViolationDetails.builder()
                        .fieldName(err.getField())
                        .reason(err.getDefaultMessage())
                        .build()
                )
                .toList();
        return new ConstraintViolationProblemDetails(fieldDetails);
    }

    @Builder
    public record ParamsViolationDetails(String fieldName, String reason) {
    }
}
