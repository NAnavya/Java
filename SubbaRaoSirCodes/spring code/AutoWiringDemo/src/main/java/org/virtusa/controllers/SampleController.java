package org.virtusa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.virtusa.service.SampleService;
@Component
public class SampleController {
	private SampleService sampleService;
	
	public SampleController() {
		// TODO Auto-generated constructor stub
	}
	public SampleController(SampleService sampleService) {
		super();
		this.sampleService = sampleService;
	}

	public SampleService getSampleService() {
		return sampleService;
	}
	@Autowired
	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	public void controller() {
		sampleService.service();
	}

}
