package br.com.fiaplanchesproduct.test.glue;

import io.restassured.response.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class CucumberContextHolder {

    private Response response;
}