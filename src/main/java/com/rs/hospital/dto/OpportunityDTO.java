package com.rs.hospital.dto;



import com.rs.hospital.model.Opportunity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpportunityDTO {
    private Long id;
    protected Long leadId;
    private String opportunityName;
    private String accountName;
    protected Long productCategory;
    protected Long quantity;
    private BigDecimal expectedAmount;
    private LocalDate expectedCloseDate;
    private String salesStage;
    private LocalDate followupDate;
    private String extQuotationUrl;
    private String comments;
    private String leadSource;
    private String customerName;

    public OpportunityDTO(Opportunity opportunity) {

        this.id = opportunity.getId();
        this.leadId = opportunity.getLeadId();
        this.opportunityName = opportunity.getOpportunityName();
        this.accountName = opportunity.getAccountName();
        this.productCategory = opportunity.getProductCategory();
        this.quantity = opportunity.getQuantity();
        this.expectedAmount = opportunity.getExpectedAmount();
        this.expectedCloseDate = opportunity.getExpectedCloseDate();
        this.salesStage = opportunity.getSalesStage();
        this.followupDate = opportunity.getFollowupDate();
        this.extQuotationUrl = opportunity.getExtQuotationUrl();
        this.comments = opportunity.getComments();
        this.leadSource = opportunity.getLeadSource();

    }

}
