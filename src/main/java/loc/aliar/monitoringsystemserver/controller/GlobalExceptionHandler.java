package loc.aliar.monitoringsystemserver.controller;

import loc.aliar.monitoringsystemserver.util.ReflectionUtils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String GLOBAL_VALID_FIELD = "errorFieldName";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ValidationError validationError = new ValidationError();
        BindingResult br = ex.getBindingResult();
        validationError.setObjectName(br.getObjectName());
        validationError.setTarget(br.getTarget());
        List<ObjectError> errors = br.getAllErrors();
        List<ValidationError.Error> errs = new ArrayList<>(errors.size());
        for (ObjectError e : errors) {
            ValidationError.Error error = new ValidationError.Error();
            ConstraintViolationImpl source = getSource(e);
            if (e instanceof FieldError) {
                FieldError fe = (FieldError) e;
                error.setFieldName(fe.getField());
            } else {
                String fieldName = getFieldName(source);
                error.setFieldName(fieldName);
            }
            error.setMessageTemplate(source.getMessageTemplate());
            error.setDefaultMessage(e.getDefaultMessage());
            if (e.getArguments() != null) {
                error.setArguments(Arrays.copyOfRange(e.getArguments(), 1, e.getArguments().length - 1));
            }
            errs.add(error);
        }
        validationError.setErrors(errs);
        return ResponseEntity.badRequest().body(validationError);
    }

    private ConstraintViolationImpl getSource(ObjectError error) {
        return ReflectionUtils.getFieldValue(error, "source", ConstraintViolationImpl.class);
    }

    private String getFieldName(ConstraintViolation source) {
        return source.getConstraintDescriptor().getAttributes().get(GLOBAL_VALID_FIELD).toString();
    }

    @Getter
    @Setter
    private static class ValidationError {
        private String objectName;
        private Object target;
        private List<Error> errors;

        @Getter
        @Setter
        private static class Error {
            private String fieldName;
            private String messageTemplate;
            private String defaultMessage;
            private Object[] arguments;
        }
    }
//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<?> f(Throwable throwable) {
//        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(throwable);
//    }
//     TODO: 11/8/2019 everything
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleMethodArgumentNotValidException(Exception e, WebRequest request) {
//        return ResponseEntity.ok(null);
//    }
//
//    @ExceptionHandler({EntityNotFoundException.class, EmptyResultDataAccessException.class})
//    public ResponseEntity<?> handleEntityNotFoundException(Exception e, WebRequest request, NativeWebRequest reques) {
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
//    }
//
//    @ExceptionHandler({TestValidationException.class})
//    public ResponseEntity<?> handleTestValidationException(Exception e) {
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
//    }
//
//    @Builder
//    private static class Error {
//
//    }
}
