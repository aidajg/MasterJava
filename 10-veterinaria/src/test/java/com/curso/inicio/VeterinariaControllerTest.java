package com.curso.inicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.service.VeterinariaService;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Application.class)
class VeterinariaControllerTest {

	/**
	 * Inyección de dependencias
	 * (Test mockito)
	 */
	@Autowired
	private MockMvc mockito;
	
	@MockBean
	private VeterinariaService service;
	
	@BeforeEach
	public void setup() {
	}
	
	/**
	 * GET - Obtener todas las veterinarias pasando como parámetro
	 * su disponibilidad (booleana)
	 * @throws Exception
	 */
	@Test 
	public void getVeterinariasTest() throws Exception{
		mockito.perform(get("/veterinarias/true"))
		.andExpect(status().isOk());
	}
	
	/**
	 * GET - Obtener todas las veterinarias que no sobrepasen
	 * el precio indicado (parámetro)
	 * @throws Exception
	 */
	@Test 
	public void getPrecioLimiteTest() throws Exception{
		mockito.perform(get("/precio/50"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
}
