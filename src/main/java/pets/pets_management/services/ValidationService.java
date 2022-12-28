package pets.pets_management.services;

import org.springframework.stereotype.Service;
import pets.pets_management.infrastructure.exception.DataNotFoundException;

@Service
public class ValidationService {

    public static final String INVALID_LOGIN_CREDENTIALS = "Wrong username or password";
    public static final String INVALID_INPUT = "Wrong input";

    public static void validatePasswordUserExists(Boolean userExists) {
        if (!userExists) {
            throw new DataNotFoundException(INVALID_LOGIN_CREDENTIALS, "Wrong username or password. Please try again.");
        }
    }

    public static void validateUserCreation(boolean emptyUsername, boolean emptyPassword) {
        if (emptyUsername || emptyPassword) {
            throw new DataNotFoundException(INVALID_INPUT, "Username either password cannot be blank");
        }
    }

    public static void validateUserExists(boolean userExists) {
        if (userExists) {
            throw new DataNotFoundException(INVALID_INPUT, "This username already exists. Please try again.");
        }
    }

    public static void validateSelectionExists(boolean selectionExists, String name, String tableName) {
        if (selectionExists) {
            throw new DataNotFoundException(INVALID_INPUT, name + " is already created " + tableName + ". Please try again.");
        }
    }
}
