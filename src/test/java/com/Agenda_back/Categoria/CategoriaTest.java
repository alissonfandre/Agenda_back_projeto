package com.Agenda_back.Categoria;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.servlet.MockMvc;

import com.Agenda_back.categoria.Categoria;
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
public class CategoriaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("verificar se a rota de categoria esta respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/categorias")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    }

    @Test
    @DisplayName("verificar se esta criando categoria")
    @Transactional
    @Rollback
    void create() throws Exception{
        Categoria categoriaExemplo = new Categoria();
        categoriaExemplo.setCategoria_nome("jardinagem");
        categoriaExemplo.setCategoria_descricao("servicos de jardinagem");

        String jsonRequest = objectMapper.writeValueAsString(categoriaExemplo);

        mockMvc.perform(post("/categorias")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest)).andExpect(status().isCreated());

        TestTransaction.end();


    }

    @Test
    @DisplayName("verifica se esta alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{
        Categoria categoriaExemplo = new Categoria();
        categoriaExemplo.setCategoria_nome("Pintora");
        categoriaExemplo.setCategoria_descricao("servico de pintura");

        String jsonRequest = objectMapper.writeValueAsString(categoriaExemplo);

        String response = mockMvc.perform(post("/categorias")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest)).andExpect(status().isCreated())
        .andReturn()
        .getResponse()
        .getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(response);
        Long id = jsonNode.get("categoria_id").asLong();

        Categoria categoriaUpdate = new Categoria();
        categoriaUpdate.setCategoria_nome("Pintura");
        categoriaUpdate.setCategoria_descricao("Servico de Pintura");
        categoriaExemplo.setCategoria_id(id);

        String jsonUpdateRequest = objectMapper.writeValueAsString(categoriaUpdate);


        mockMvc.perform(put("/categorias/" + id)
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.categoria_nome").value("Pintura"));

        TestTransaction.end();

    }
    
}
