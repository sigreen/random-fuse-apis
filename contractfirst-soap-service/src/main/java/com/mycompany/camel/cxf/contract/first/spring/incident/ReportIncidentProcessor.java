/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.camel.cxf.contract.first.spring.incident;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.example.reportincident.InputReportIncident;

/**
 * Processor for processing the report incident.
 */
public class ReportIncidentProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // get the id of the input
    		String familyName = (String) exchange.getIn().getHeader("familyName");
    		String givenName = (String) exchange.getIn().getHeader("givenName");
    		String details = (String) exchange.getIn().getHeader("details");
    		String reportId = String.valueOf(exchange.getIn().getHeader("reportId"));
    		
    		InputReportIncident input = new InputReportIncident();
    		input.setFamilyName(familyName);
    		input.setGivenName(givenName);
    		input.setDetails(details);
    		input.setIncidentId(reportId);


        exchange.getOut().setBody(input);
    }

}
