package ru.clevertec.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.clevertec.domain.Moto;
import ru.clevertec.service.MotoService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MotoController.class)
public class MotoControllerTest {

    @MockBean
    private MotoService motoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAllMoto() throws Exception {
        when(motoService.getAll())
                .thenReturn(List.of(new Moto(), new Moto(), new Moto()));

        mockMvc.perform(get("/api/v1/all_moto"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

}
