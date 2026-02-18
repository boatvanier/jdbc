package org.example.lab.forTestLab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GreetingServiceTest {

    @Test
    void testGreet_validName() {

        // Mock creation
        MessageProvider mockProvider = mock(MessageProvider.class);

        // Define behavior
        when(mockProvider.getMessage()).thenReturn("Hello");

        GreetingService service = new GreetingService(mockProvider);

        String result = service.greet("Alice");

        // Verify result
        assertEquals("Hello, Alice", result);

        // Verify interaction
        verify(mockProvider).getMessage();
    }

    @Test
    void testGreet_emptyName_shouldThrowException() {

        MessageProvider mockProvider = mock(MessageProvider.class);

        GreetingService service = new GreetingService(mockProvider);

        // Expect exception
        assertThrows(IllegalArgumentException.class,
                () -> service.greet(""));

        // Verify getMessage() was NOT called
        verify(mockProvider, never()).getMessage();
    }
}

