package br.com.fiaplanchesproduct.test.glue;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseScenario {

    @Autowired
    protected CucumberContextHolder cucumberContextHolder;
}
