package com.jonathan.portfolio.order_management_system.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void shouldGenerateIdWhenObjectIsCreated() {
        //Arrange
        User user = new User("David", new Email("jdtl@gmail.com"), new Password("hashedValue"), Role.CUSTOMER);

        //Act & Assert
        Assertions.assertNotNull(user.getPassword());
    }

    @Test
    void shouldBeActiveWhenCreated() {
        //Arrange
        User user = new User("David", new Email("jdtl@gmail.com"), new Password("hashedValue"), Role.CUSTOMER);

        //Act
        boolean expectedStatus = true;

        //Assert
        Assertions.assertEquals(expectedStatus, user.isActive(), "User is not active");
    }

    @Test
    void shouldThrowExceptionWhenIsActiveTryingToActivate() {
        //Arrange
        User user = new User("David", new Email("jdtl@gmail.com"), new Password("hashedValue"), Role.CUSTOMER);

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, user::activate, "Doesn't throw exception");
    }

    @Test
    void shouldThrowExceptionWhenIsNotActiveTryingToDesactivate() {
        //Arrange
        User user = new User("David", new Email("jdtl@gmail.com"), new Password("hashedValue"), Role.CUSTOMER);

        //Act
        user.deactivate();

        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, user::deactivate, "Doesn't throw exception");
    }

    @Test
    void shouldReturnTrueWhenCheckingSameRole() {
        //Arrange
        User user = new User("David", new Email("jdtl@gmail.com"), new Password("hashedValue"), Role.CUSTOMER);

        //Act
        boolean expectedOutput = true;
        boolean currentOutput = user.hasRole(Role.CUSTOMER);

        //Assert
        Assertions.assertEquals(expectedOutput, currentOutput, "Role doesn't match");
    }

    @Test
    void shouldReturnFalseWhenCheckingDifferentRole() {
        //Arrange
        User user = new User("David", new Email("jdtl@gmail.com"), new Password("hashedValue"), Role.CUSTOMER);

        //Act
        boolean expectedOutput = false;
        boolean currentOutput = user.hasRole(Role.ADMIN);

        //Assert
        Assertions.assertEquals(expectedOutput, currentOutput, "Role doesn't match");
    }
}
