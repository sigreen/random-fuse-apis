package com.mycompany.camel.cxf.contract.first.spring.incident;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.example.initialincident.OutputInitialIncident;
import org.apache.camel.example.reportincident.OutputReportIncident;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.pojo.RandomIncidentDataResponse;

public class CompositeServiceAggregationStrategy implements AggregationStrategy, CamelContextAware {

	private final Logger log = LoggerFactory.getLogger(CompositeServiceAggregationStrategy.class);

	private CamelContext camelContext;

	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@Override
	public CamelContext getCamelContext() {
		return camelContext;
	}

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			oldExchange = new DefaultExchange(camelContext);
		}

		OutputInitialIncident response = (OutputInitialIncident) oldExchange.getIn().getBody();
		if (response == null) {
			response = new OutputInitialIncident();
			oldExchange.getIn().setBody(response);
		}

		Object serviceResponse = newExchange.getIn().getBody();
		if (serviceResponse == null) {
			log.warn(String.format("Got a null response back from '%s'.",
					newExchange.getIn().getHeader(Exchange.HTTP_URI)));
		} else if (serviceResponse instanceof OutputReportIncident) {
			OutputReportIncident typedServiceResponse = (OutputReportIncident) serviceResponse;
			String[] result = typedServiceResponse.getCode().split(";");
			response.setSoapServiceOneStatus(result[0]);
			response.setCode(result[1]);
		} else if (serviceResponse instanceof RandomIncidentDataResponse) {
			RandomIncidentDataResponse typedServiceResponse = ((RandomIncidentDataResponse) serviceResponse);
			response.setJsonServiceTwoStatus(typedServiceResponse.getStatus());
		} else {
			throw new IllegalArgumentException(
					String.format("I don't know how to merge a '%s'.", serviceResponse.getClass().getName()));
		}

		return oldExchange;
	}
}