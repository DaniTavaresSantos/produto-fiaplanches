package br.com.fiaplanchesproduct.test.glue;

import io.cucumber.java.pt.Entao;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CommonSteps {

    @Autowired
    private CucumberContextHolder cucumberContext;

    @Entao("Eu recebo uma resposta correta")
    public void i_receive_a_correct_response() {
        System.out.println(cucumberContext.getResponse().asPrettyString());
        assertEquals(200, cucumberContext.getResponse().getStatusCode());
    }

    @Entao("Eu recebo um erro")
    public void i_receive_an_error() {
        System.out.println(cucumberContext.getResponse().asPrettyString());
        assertNotEquals(200, cucumberContext.getResponse().getStatusCode());
    }
}
