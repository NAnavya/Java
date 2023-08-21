package org.virtusa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.virtusa.dao.SampleDao;

@Component
public class SampleService {
	private SampleDao sampleDao;
	
	public SampleDao getSampleDao() {
		return sampleDao;
	}
	@Autowired
	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	public void service() {
		sampleDao.dao();
	}
}
