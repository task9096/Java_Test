package com.rs.hospital.service;

import com.rs.hospital.dto.ContactDTO;

import java.util.List;
import java.util.Map;

public interface ContactService {
    public ContactDTO save(ContactDTO contact);
    public ContactDTO update(ContactDTO contact, long bid) throws Exception;
    public ContactDTO getById(long bid) throws Exception;
    public List<ContactDTO> getAll();
    public Map<String, Boolean> delete(long bid) throws Exception;
    public boolean isExists(ContactDTO contactDto);

}
