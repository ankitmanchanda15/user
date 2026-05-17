package com.client.app.controller;

import com.client.app.dto.UserRegistrationRequest;
import com.client.app.dto.UserResponse;
import com.client.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser_Success() throws Exception {
        UserRegistrationRequest request = new UserRegistrationRequest("John", "Doe", "john@example.com", "password123", "1234567890");
        UserResponse response = new UserResponse(1L, "John", "Doe", "john@example.com", "1234567890");

        Mockito.when(userService.registerUser(Mockito.any())).thenReturn(response);

        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john@example.com\",\"password\":\"password123\",\"phoneNumber\":\"1234567890\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    public void testRegisterUser_EmailAlreadyTaken() throws Exception {
        Mockito.when(userService.registerUser(Mockito.any())).thenThrow(new IllegalArgumentException("Email is already taken"));

        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john@example.com\",\"password\":\"password123\",\"phoneNumber\":\"1234567890\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertThat(result.getResolvedException().getMessage()).isEqualTo("Email is already taken");
                });
    }
}