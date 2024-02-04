package br.com.fiaplanchesproduct;

import br.com.fiaplanchesproduct.generated.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiapLanchesProductApplication {

    @Generated
    public static void main(String[] args) {
        SpringApplication.run(FiapLanchesProductApplication.class, args);
    }

}
