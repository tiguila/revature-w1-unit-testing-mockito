import org.example.User;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserName() {

        // Arrange
        User user = new User(1, "John");

        when(userRepository.findById(1))
                .thenReturn(user);

        // Act
        String result = userService.getUserName(1);

        // Assert
        assertEquals("John", result);

        verify(userRepository).findById(1);
    }
}