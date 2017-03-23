package us.hyalen.soapconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import consumer.wsdl.GetQuoteResponse;
import us.hyalen.soapconsumer.client.QuoteClient;

@SpringBootApplication
public class SoapConsumerApp {
	public static void main(String[] args) {
		SpringApplication.run(SoapConsumerApp.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(QuoteClient quoteClient) {
		return args -> {
			String ticker = "MSFT";

			if (args.length > 0) {
				ticker = args[0];
			}
			
			GetQuoteResponse response = quoteClient.getQuote(ticker);
			System.err.println(response.getGetQuoteResult());
		};
	}
}
