package com.example.payment_gateway_app.controler;

import com.example.payment_gateway_app.controller.AccountController;
import com.example.payment_gateway_app.entity.Account;
import com.example.payment_gateway_app.service.AccountService;
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

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(AccountControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private AccountService accountService;

    @Test
    public void testCreateAccount() throws Exception{
        Account account = Account.builder().accountType("savings")
                .accountNumber("123").balance(BigDecimal.valueOf(1000.00))
                .build();
        Account savedAccount = Account.builder()
                .id(1L).accountType("savings")
                .accountNumber("123").balance(BigDecimal.valueOf(1000.00))
                .build();
        when(accountService.saveAccount(any(Account.class))).thenReturn(savedAccount);

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk());
        logger.info("***** Account creation API - tested successfully ***");
    }

}
