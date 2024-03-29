package com.poc.contract.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.cloud.contract.wiremock.WireMockSpring.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.poc.contract.AbstractTest;
import com.poc.contract.model.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.cloud.contract.verifier.util.ContentType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
public class HelloControllerTest extends AbstractTest {

  @Autowired
  private MockMvc mockMvc;

  @Value("${foo}")
  public String foo;

  public JacksonTester<User> json;

  @Rule
  public WireMockRule wireMockRule = new WireMockRule(options().port(9999));

  @Test
  public void successGetHello() throws Exception {

    mockMvc.perform(get("/hello")
        .param("name", "Teste")
        .contentType(ContentType.JSON.getMimeType()))
        .andExpect(status().isOk())
        .andExpect(content().json("{'name':'Teste'}"));


    final MvcResult mvcResult = mockMvc.perform(get("/hello")
        .param("name", "Teste")
        .contentType(ContentType.JSON.getMimeType()))
        .andReturn();

    final User user = this.convertJsonToObject(mvcResult.getResponse().getContentAsString(), User.class);

    assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
    assertThat(user.getName(), containsString("Teste"));
    assertThat(foo, equalTo("bar"));
  }

  @Test
  public void successPostHello() throws Exception {

    final MvcResult mvcResult =   mockMvc.perform(post("/hello")
        .contentType(ContentType.JSON.getMimeType())
        .content(json.write(User.builder()
            .id(1)
            .name("Michel")
            .email("michel.tds@gmail.com")
            .build()).getJson()))
        .andReturn();

    assertThat(mvcResult.getResponse().getStatus(), equalTo(200));
    assertThat(mvcResult.getResponse().getContentAsString(), containsString("Michel"));
  }

}
