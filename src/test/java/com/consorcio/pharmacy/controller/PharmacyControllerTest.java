package com.consorcio.pharmacy.controller;


import com.consorcio.pharmacy.PharmacyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = PharmacyApplication.class)
@AutoConfigureMockMvc
@WebMvcTest
public class PharmacyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDOW() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/pharmaciesOnDuty")
                .queryParam("comuna","SANTIAGO")
                .queryParam("localNombre","CRUZ VERDE")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultDOW = result.getResponse().getContentAsString();
        assertNotNull(resultDOW);
    }
}
