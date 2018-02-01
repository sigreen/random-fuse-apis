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
package com.example.pojo;

/**
 * Input report message
 */
public class RandomIncidentDataResponse {

	private String incidentId;
	private String incidentStatus;

	public RandomIncidentDataResponse() {
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public String getStatus() {
		return incidentStatus;
	}

	public void setStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}
	
	public RandomIncidentDataResponse createResponse(String incidentId) {
		this.setIncidentId(incidentId);
		this.setStatus("Received");
		return this;
	}
}
