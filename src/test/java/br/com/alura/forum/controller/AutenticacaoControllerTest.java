package br.com.alura.forum.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.fail;

//AutoConfigureMockMvc p conseguir fazer a injecao do mock
//@WebMvcTest quando vai testar um controller
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class AutenticacaoControllerTest {
//URI endereco da classe "na internet"
//p testar um controller MockMvc simula uma requisiçao mvc
    // andExpect faz o acert por bauxo dos panos, fala oq esta sendo esperado como resposta

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
//postpassa qual a URI que vai ser disparada
        //.content qual o conteudo da requisicao
        //contentType o spring precisa p conseguuir chamar o controller
//is qual status esta sendo esperado
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect (MockMvcResultMatchers
                .status()
                .is(400));


    }


}
