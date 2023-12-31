package com.rs.hospital.service;

import com.rs.hospital.dto.MedicosDTO;

import java.util.List;
import java.util.Map;

public interface MedicosService {

	public MedicosDTO save(MedicosDTO medicos);
    public MedicosDTO update(MedicosDTO medicos, long mId) throws Exception;
	public MedicosDTO getById(long mId) throws Exception;
	public List<MedicosDTO> getAll();
	public Map<String, Boolean> delete(long mId) throws Exception;
	public List<MedicosDTO> getAllByPatientId(long pid);
	public long getTotal(long id);
}
