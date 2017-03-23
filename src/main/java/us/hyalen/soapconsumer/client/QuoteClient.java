package us.hyalen.soapconsumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import consumer.wsdl.GetQuote;
import consumer.wsdl.GetQuoteResponse;

public class QuoteClient extends WebServiceGatewaySupport {
	private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);

	// In this method, both the GetQuote and the GetQuoteResponse classes are derived from 
	// the WSDL and were generated in the JAXB generation process 
	public GetQuoteResponse getQuote(String ticker) {
		GetQuote request = new GetQuote();
		request.setSymbol(ticker);

		log.info("Requesting quote for " + ticker);

		GetQuoteResponse response = 
			(GetQuoteResponse) getWebServiceTemplate()
			.marshalSendAndReceive(
				"http://www.webservicex.com/stockquote.asmx",
				request,
				new SoapActionCallback("http://www.webserviceX.NET/GetQuote"));

		return response;
	}
}
