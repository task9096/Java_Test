package com.rs.hospital.service;

import com.rs.hospital.dto.ContactDTO;
import com.rs.hospital.model.Contact;
import com.rs.hospital.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ContactServiceImpl  implements ContactService {

    @Autowired
    private ContactRepository repo;

    /**
     *
     * @param contactDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Contact DTO class to Contact Model Class
     */
    private Contact convertDTOtoModel(ContactDTO contactDTO) {

        Contact contact = new Contact();

        contact.setId(contactDTO.getId());
        contact.setAccountName(contactDTO.getAccountName());
        contact.setAccountRelationship(contactDTO.getAccountRelationship());
        contact.setCreateDate(contactDTO.getCreateDate());
        contact.setEmail(contactDTO.getEmail());
        contact.setDepartment(contactDTO.getDepartment());
        contact.setMobileNo(contactDTO.getMobileNo());
        contact.setDesignation(contactDTO.getDesignation());
        contact.setFirstName(contactDTO.getFirstName());
        contact.setFollowupType(contactDTO.getFollowupType());
        contact.setLastName(contactDTO.getLastName());
        contact.setSummary(contactDTO.getSummary());
        contact.setUpdatedDate(contactDTO.getUpdatedDate());

        return contact;
    }

    /*
     * Convert Model To DTO
     */
    private ContactDTO convertModelToDTO(Contact contact) {
        return new ContactDTO(contact);
    }

    @Override
    public ContactDTO save(ContactDTO contactDTO) {
        Contact contact = convertDTOtoModel(contactDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(contact)); // return DTO
    }

    @Override
    public ContactDTO update(ContactDTO contactDTO, long bid) throws Exception {

        ContactDTO copyContact = getById(bid);

        copyContact.setId(contactDTO.getId());
        copyContact.setAccountName(contactDTO.getAccountName());
        copyContact.setAccountRelationship(contactDTO.getAccountRelationship());
        copyContact.setCreateDate(contactDTO.getCreateDate());
        copyContact.setEmail(contactDTO.getEmail());
        copyContact.setDepartment(contactDTO.getDepartment());
        copyContact.setMobileNo(contactDTO.getMobileNo());
        copyContact.setDesignation(contactDTO.getDesignation());
        copyContact.setFirstName(contactDTO.getFirstName());
        copyContact.setFollowupType(contactDTO.getFollowupType());
        copyContact.setLastName(contactDTO.getLastName());
        copyContact.setSummary(contactDTO.getSummary());
        copyContact.setUpdatedDate(contactDTO.getUpdatedDate());


        // step 1 
        Contact contact = convertDTOtoModel(copyContact);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(contact));
    }

    @Override
    public ContactDTO getById(long bid) throws Exception {
        Contact contact = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(contact);
    }

    @Override
    public List<ContactDTO> getAll() {
        List<Contact> contactList = repo.findAll();
        List<ContactDTO> contactDTOList = new ArrayList<>();

        for(Contact contact : contactList) {
            contactDTOList.add(convertModelToDTO(contact));
        }

        return contactDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Contact contact = convertDTOtoModel(getById(bid));
        repo.delete(contact);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(ContactDTO contactDTO) {
        Contact contact = repo.existsContactByEmail(contactDTO.getEmail());
        if(contact != null) {
            return true;
        }else {
            return false;
        }
    }


}
