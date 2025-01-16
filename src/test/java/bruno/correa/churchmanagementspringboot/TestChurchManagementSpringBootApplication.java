package bruno.correa.churchmanagementspringboot;

import org.springframework.boot.SpringApplication;

public class TestChurchManagementSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.from(ChurchManagementSpringBootApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
