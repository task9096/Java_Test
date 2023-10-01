package com.rs.hospital.service;

import com.rs.hospital.dto.SpecializationDTO;

import java.util.List;
import java.util.Map;

public interface SpecializationService {

	public SpecializationDTO save(SpecializationDTO specialization);

	public SpecializationDTO update(SpecializationDTO specialization, long specId) throws Exception;

	public SpecializationDTO getById(long specId) throws Exception;

	public List<SpecializationDTO> getAll();

	public Map<String, Boolean> delete(long specId) throws Exception;
}
