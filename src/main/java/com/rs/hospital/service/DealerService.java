package com.rs.hospital.service;

import com.rs.hospital.dto.DealerDTO;

import java.util.List;
import java.util.Map;

public interface DealerService {
    public DealerDTO save(DealerDTO dealer);
    public DealerDTO update(DealerDTO dealer, long bid) throws Exception;
    public DealerDTO getById(long bid) throws Exception;
    public List<DealerDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(DealerDTO dealerDto);

}
