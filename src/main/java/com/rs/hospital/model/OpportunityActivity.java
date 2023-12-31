package com.rs.hospital.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "T_OPPORTUNITY_ACTIVITY")
public class OpportunityActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACTIVITY_ID")
    protected Long id;

    @Column(name="OPPORTUNITY_ID")
    protected Long opportunityId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "START_DATE")
    private LocalDate startDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ACTIVITY_TYPE")
    private String activityType;

    @Column(name = "FOLLOWUP_BY")
    private String followupBy;

    @Column(name="DURATION")
    protected Long duration;

    @Column(name="EXECUTED_TIME")
    protected Long executedTime;

    @Lob
    @Column(name = "COMMENT")
    private String comment;

}
