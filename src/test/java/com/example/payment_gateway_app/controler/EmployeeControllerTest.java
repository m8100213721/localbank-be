package com.example.payment_gateway_app.controler;

import com.example.payment_gateway_app.controller.EmployeeController;
import com.example.payment_gateway_app.entity.Employee;
import com.example.payment_gateway_app.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EmployeeService employeeService;

    @Test
    public void testCreateEmployee() throws Exception{
        Employee employee = Employee.builder()
                .name("Test").role("admin").build();
        Employee savedEmployee = Employee.builder().id(1L)
                .name("Test").role("admin").build();

        when(employeeService.saveEmployee((any(Employee.class)))).thenReturn(savedEmployee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk());
        logger.info("***** Employee creation API - tested successfully ***");
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        Long employeeId = 1L;
        mockMvc.perform(get("/employees/{id}", employeeId))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
    }
}
