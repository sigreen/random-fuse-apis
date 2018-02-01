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
import org.apache.camel.example.initialincident.InputInitialIncident;
import org.apache.camel.example.initialincident.OutputInitialIncident;

/**
 * Processor for processing the report incident.
 */
public class InitialIncidentResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // get the id of the input
    		InputInitialIncident inputReport = exchange.getIn().getBody(InputInitialIncident.class);
        
        int id = (int) (Math.round(Math.random() * 1000) % 10);
        
        // set reply including the id
        OutputInitialIncident output = new OutputInitialIncident();
        output.setCode("OK;" + id);
        exchange.getOut().setBody(output);
        exchange.getOut().setHeader("origRequest", inputReport);
        exchange.getOut().setHeader("familyName", inputReport.getFamilyName());
        exchange.getOut().setHeader("givenName", inputReport.getGivenName());
        exchange.getOut().setHeader("details", inputReport.getDetails());
        exchange.getOut().setHeader("incidentDate", inputReport.getIncidentDate());
        exchange.getOut().setHeader("email", inputReport.getEmail());
        exchange.getOut().setHeader("phone", inputReport.getPhone());
        exchange.getOut().setHeader("reportId", id);
    }

}
