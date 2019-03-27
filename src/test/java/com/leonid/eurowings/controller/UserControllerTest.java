package com.leonid.eurowings.controller;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testThisThing() throws Exception {

        this.mockMvc.perform(get("/allusers")).andExpect(status().isOk());
        MvcResult result = this.mockMvc.perform(get("/allusers")).andReturn();
        Assert.assertEquals(result.getResponse().getContentType(), "application/json;charset=UTF-8");

        this.mockMvc.perform(get("/singleuser/100")).andExpect(status().isOk());
        this.mockMvc.perform(delete("/deleteuser/100")).andExpect(status().isOk());
        this.mockMvc.perform(get("/getfromdate/2013-08-01")).andExpect(status().isOk());
        this.mockMvc.perform(get("/getbeforedate/2013-08-01")).andExpect(status().isOk());

        JSONObject testUser = new JSONObject();
        testUser.put("userid", "900");
        testUser.put("username", "Karl");
        testUser.put("status", true);
        testUser.put("subscriptiondate", "2019-03-27");
        this.mockMvc.perform(put("/saveuser").contentType(MediaType.APPLICATION_JSON).content(testUser.toString())).andExpect(status().isOk());

    }

    @Test
    public void testException() throws Exception {

        this.mockMvc.perform(get("/getfromdate/notadate")).andExpect(status().isBadRequest());

    }

}
