package com.flowershop.service.impl;

import com.flowershop.model.User;
import com.flowershop.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    private static User user=null;

    @BeforeAll
    public static void init(){
        System.out.println("Starting init UserServiceImpl Tests...");
        user = new User();
        user.setId("1");
        user.setFirstName("karun");
        user.setMobile("1234567890");
    }

    @BeforeEach
    public void initEachTest(){
        System.out.println("Starting init UserServiceImpl Tests...");
    }


    @Test
    void createUserShouldCreateSuccessfully() {
          when(userRepository.save(user)).thenReturn(user);
         var creatUser = userService.registerUser(user);

        assertNotNull(creatUser);
        assertEquals(user.getId(),creatUser.getId());
    }

    @Test
    void createUserShouldCreateException() {
            user.setFirstName("");
          var runtime =  assertThrows(RuntimeException.class,()->{
              userService.registerUser(user);
           });

          assertEquals("Invalid user data",runtime.getMessage());
    }

    @Test
    void testPrivateMethodValidateUserData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       var validateUserName = UserServiceImpl.class.getDeclaredMethod("validateUserData",String.class);
         validateUserName.setAccessible(true);
         var result = (Boolean) validateUserName.invoke(userService,"John Doe");
         assertTrue(result);
    }

    @Test
    void testPrivateMethodValidateUserDataIfNameInvalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       var validateUserName = UserServiceImpl.class.getDeclaredMethod("validateUserData",String.class);
         validateUserName.setAccessible(true);
         var result = (Boolean) validateUserName.invoke(userService,"");
         assertFalse(result);
    }


    @Test
    public void deleteUserShouldDeleteSuccessfully() {
        doNothing().when(userRepository).deleteById("1");
        userService.deleteUser("1");
        verify(userRepository,times(1)).deleteById("1");
    }


    @Test
    void getUserById() {
    }

    @Test
    void getAllUsers() {
    }
}
