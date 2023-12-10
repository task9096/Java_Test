package com.rs.hospital.service;

import com.rs.hospital.dto.DealerDTO;
import com.rs.hospital.model.Dealer;
import com.rs.hospital.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



@Service
@Transactional
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository repo;

    /**
     *
     * @param dealerDTO
     * @return
     *
     * Steps
     * 1	Convert DTO to model
     * 2	make all opertions = > CRUD
     * 3	convert model to dto
     */
    /*
     * Convert Dealer DTO class to Dealer Model Class
     */
    private Dealer convertDTOtoModel(DealerDTO dealerDTO) {

        Dealer dealer = new Dealer();

        dealer.setId(dealerDTO.getId());
        dealer.setAddress(dealerDTO.getAddress());
        dealer.setCity(dealerDTO.getCity());
        dealer.setDeliveryAddress(dealerDTO.getDeliveryAddress());
        dealer.setEmail(dealerDTO.getEmail());
        dealer.setFullName(dealerDTO.getFullName());
        dealer.setMobileNo(dealerDTO.getMobileNo());
        dealer.setPincode(dealerDTO.getPinCode());
        dealer.setState(dealerDTO.getState());
        dealer.setTitle(dealerDTO.getTitle());

        return dealer;
    }

    /*
     * Convert Model To DTO
     */
    private DealerDTO convertModelToDTO(Dealer dealer) {
        return new DealerDTO(dealer);
    }

    @Override
    public DealerDTO save(DealerDTO DealerDTO) {
        Dealer dealer = convertDTOtoModel(DealerDTO); // convert dto to model for database interaction

        return convertModelToDTO(repo.save(dealer)); // return DTO
    }

    @Override
    public DealerDTO update(DealerDTO dealerDTO, long bid) throws Exception {

        DealerDTO copyDealer = getById(bid);

        copyDealer.setId(dealerDTO.getId());
        copyDealer.setAddress(dealerDTO.getAddress());
        copyDealer.setCity(dealerDTO.getCity());
        copyDealer.setDeliveryAddress(dealerDTO.getDeliveryAddress());
        copyDealer.setEmail(dealerDTO.getEmail());
        copyDealer.setFullName(dealerDTO.getFullName());
        copyDealer.setMobileNo(dealerDTO.getMobileNo());
        copyDealer.setPinCode(dealerDTO.getPinCode());
        copyDealer.setState(dealerDTO.getState());
        copyDealer.setTitle(dealerDTO.getTitle());


        // step 1 
        Dealer Dealer = convertDTOtoModel(copyDealer);

        //step 2

        // step 3
        return convertModelToDTO(repo.save(Dealer));
    }

    @Override
    public DealerDTO getById(long bid) throws Exception {
        Dealer dealer = repo.findById(bid)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
        return convertModelToDTO(dealer);
    }

    @Override
    public List<DealerDTO> getAll() {
        List<Dealer> dealerList = repo.findAll();
        List<DealerDTO> dealerDTOList = new ArrayList<>();

        for(Dealer Dealer : dealerList) {
            dealerDTOList.add(convertModelToDTO(Dealer));
        }

        return dealerDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long bid) throws Exception {
        Dealer dealer = convertDTOtoModel(getById(bid));
        repo.delete(dealer);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Delete", Boolean.TRUE);

        return response;

    }

    @Override
    public boolean isExists(DealerDTO empDto) {
        Dealer emp = repo.existsDealerByEmail(empDto.getEmail());
        if(emp != null) {
            return true;
        }else {
            return false;
        }
    }


}
