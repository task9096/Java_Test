package com.rs.hospital.service;

import com.rs.hospital.dto.OperationDTO;

import java.util.List;
import java.util.Map;

public interface OperationService {

	public OperationDTO save(OperationDTO operation);
    public OperationDTO update(OperationDTO operation,  long oid)  throws Exception;
	public OperationDTO getById(long oid) throws Exception;
	public List<OperationDTO> getAll();
	public Map<String, Boolean> delete(long oid) throws Exception;
}
