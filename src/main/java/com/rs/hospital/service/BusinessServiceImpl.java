package com.rs.hospital.service;

import com.rs.hospital.dto.BusinessDTO;
import com.rs.hospital.model.Business;
import com.rs.hospital.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository repo;

    /**
     *
     * @param businessDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Business DTO class to Business Model Class
     */
    private Business convertDTOtoModel(BusinessDTO businessDTO) {

        Business business = new Business();

        business.setId(businessDTO.getId());
        business.setEmail(businessDTO.getEmail());
        business.setMobileNo(businessDTO.getMobileNo());
        business.setAccountRelationship(businessDTO.getAccountRelationship());
        business.setBusinessName(businessDTO.getBusinessName());
        business.setComments(businessDTO.getComments());
        business.setIndustry(businessDTO.getIndustry());
        business.setMemberOf(businessDTO.getMemberOf());
        business.setCustId(businessDTO.getCustId());

        return business;
    }

    /*
     * Convert Model To DTO
     */
    private BusinessDTO convertModelToDTO(Business business) {
        return new BusinessDTO(business);
    }

    @Override
    public BusinessDTO save(BusinessDTO businessDTO) {
        Business business = convertDTOtoModel(businessDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(business)); // return DTO
    }

    @Override
    public BusinessDTO update(BusinessDTO businessDTO, long bid) throws Exception {

        BusinessDTO copyBusiness = getById(bid);

        copyBusiness.setId(businessDTO.getId());
        copyBusiness.setEmail(businessDTO.getEmail());
        copyBusiness.setMobileNo(businessDTO.getMobileNo());
        copyBusiness.setAccountRelationship(businessDTO.getAccountRelationship());
        copyBusiness.setBusinessName(businessDTO.getBusinessName());
        copyBusiness.setComments(businessDTO.getComments());
        copyBusiness.setIndustry(businessDTO.getIndustry());
        copyBusiness.setMemberOf(businessDTO.getMemberOf());
        copyBusiness.setCustId(businessDTO.getCustId());


        // step 1 
        Business business = convertDTOtoModel(copyBusiness);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(business));
    }

    @Override
    public BusinessDTO getById(long bid) throws Exception {
        Business business = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(business);
    }

    @Override
    public List<BusinessDTO> getAll() {
        List<Business> businessList = repo.findAll();
        List<BusinessDTO> businessDTOList = new ArrayList<>();

        for(Business Business : businessList) {
            businessDTOList.add(convertModelToDTO(Business));
        }

        return businessDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Business business = convertDTOtoModel(getById(bid));
        repo.delete(business);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(BusinessDTO businessDTO) {
        Business emp = repo.existsBusinessByEmail(businessDTO.getEmail());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
