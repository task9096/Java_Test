package com.rs.hospital.dto;

import com.rs.hospital.model.OpportunityActivity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpportunityActivityDTO {

    private Long id;

    private Long opportunityId;

    private String customerName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    private String activityType;

    private String followupBy;

    protected Long duration;

    protected Long executedTime;

    private String comment;

    public OpportunityActivityDTO(OpportunityActivity opportunityActivity) {

        this.id = opportunityActivity.getId();
        this.activityType = opportunityActivity.getActivityType();
        this.opportunityId = opportunityActivity.getOpportunityId();
        this.comment = opportunityActivity.getComment();
        this.customerName = opportunityActivity.getCustomerName();
        this.duration = opportunityActivity.getDuration();
        this.endDate = opportunityActivity.getEndDate();
        this.executedTime = opportunityActivity.getExecutedTime();
        this.followupBy = opportunityActivity.getFollowupBy();
        this.startDate = opportunityActivity.getStartDate();
        this.status = opportunityActivity.getStatus();
    }

}
