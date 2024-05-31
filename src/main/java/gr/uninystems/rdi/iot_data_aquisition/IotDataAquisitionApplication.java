package gr.uninystems.rdi.iot_data_aquisition;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotDataAquisitionApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(IotDataAquisitionApplication.class, args);


	}
}


