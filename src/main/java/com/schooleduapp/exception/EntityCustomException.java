package com.schooleduapp.exception;

import com.schooleduapp.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.text.MessageFormat;
import java.util.Optional;

/**
 * Created by Gustavo Rodrigues.
 */
@Component
public class EntityCustomException extends RuntimeException {

    private static PropertiesConfig propertiesConfig;

    @Autowired
    public EntityCustomException(PropertiesConfig propertiesConfig) {
        EntityCustomException.propertiesConfig = propertiesConfig;
    }

    public static RuntimeException throwCustomException(EntityType entityType, ExceptionType exceptionType, Long id) {
        return throwCustomException(entityType, exceptionType, String.valueOf(id));
    }

    public static RuntimeException throwCustomException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        }
        return new RuntimeException(format(messageTemplate, args));
    }

    private static String format(String template, String... args) {
        Optional<String> templateContent = Optional.ofNullable(propertiesConfig.getConfigValue(template));
        if (templateContent.isPresent()) {
            return MessageFormat.format(templateContent.get(), args);
        }
        return String.format(template, args);
    }

    private static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue()).toLowerCase();
    }

    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }
}
