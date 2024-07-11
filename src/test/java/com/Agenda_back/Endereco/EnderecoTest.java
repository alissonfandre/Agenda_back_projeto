package com.Agenda_back.Endereco;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.servlet.MockMvc;

import com.Agenda_back.endereco.Endereco;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EnderecoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("verificar se a rota de endereco esta respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/enderecos")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    }

    @Test
    @DisplayName("verificar se esta criando endereco")
  
  
    void create() throws Exception{
       Endereco enderecoExemplo = new Endereco();
        enderecoExemplo.setEndereco_rua("bananeira");
        enderecoExemplo.setEndereco_cep("88801-200");
        enderecoExemplo.setEndereco_numero(89);
        enderecoExemplo.setEndereco_complemento("em frente a fruteira");
        enderecoExemplo.setEndereco_cidade("bananas");
        enderecoExemplo.setEndereco_estado("BN");
        enderecoExemplo.setEndereco_cep("88801-200");


        String jsonRequest = objectMapper.writeValueAsString(enderecoExemplo);

        mockMvc.perform(post("/enderecos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest)).andExpect(status().isCreated());

     


    }

    @Test
    @DisplayName("verifica se esta alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{
       Endereco enderecoExemplo = new Endereco();
        enderecoExemplo.setEndereco_rua("Pintora");
        enderecoExemplo.setEndereco_cep("servico de pintura");

        String jsonRequest = objectMapper.writeValueAsString(enderecoExemplo);

        String response = mockMvc.perform(post("/endereco")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest)).andExpect(status().isCreated())
        .andReturn()
        .getResponse()
        .getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(response);
        Long id = jsonNode.get("endereco_id").asLong();

       Endereco enderecoUpdate = new Endereco();
        enderecoUpdate.setEndereco_rua("Pintura");
        enderecoUpdate.setEndereco_cep("Servico de Pintura");
        enderecoExemplo.setEndereco_id(id);

        String jsonUpdateRequest = objectMapper.writeValueAsString(enderecoUpdate);


        mockMvc.perform(put("/endereco/" + id)
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.endereco_nome").value("Pintura"));

        TestTransaction.end();

    }
    
}
