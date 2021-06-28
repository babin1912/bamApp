package com.example.bam.controllers;

import com.example.bam.controllers.services.PersonGetter;
import com.example.bam.repositories.CreditCardRepository;
import com.example.bam.repositories.PersonRepository;
import com.example.bam.types.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PersonGetter.class, PersonRepository.class, CreditCardRepository.class})
class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    @MockBean
    private PersonGetter personGetter;

    @MockBean
    private PersonController personController;

    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void getAllPeople() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/list");
        var result = mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    void getPersonById() throws Exception {
        var result = mvc.perform(
                MockMvcRequestBuilders.get("/find/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewPerson() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mvc.perform( MockMvcRequestBuilders
                .post("/save")
                .content(ow.writeValueAsString(
                        new Person(1000L, "adam", "adamovid", 'M', 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
