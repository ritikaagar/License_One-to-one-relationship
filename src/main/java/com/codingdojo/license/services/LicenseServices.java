package com.codingdojo.license.services;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.License;
import com.codingdojo.license.repositories.LicenseRepository;

@Service
public class LicenseServices {
	private LicenseRepository licenseRepository;
	
	public LicenseServices (LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public void addLicense(License license) {
		licenseRepository.save(license);
	}
	
	
	
}
