package com.meituan.waimai.po;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="oms_order_comment")
public class OrderComment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="shop_id")
    private Integer shopId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="content")
    private String content;

    @Column(name="comment_time")
    private Date commentTime;

    @Column(name="pictures")
    private String pictures;

    @Column(name="pictures")
    private BigDecimal score;

    @Column(name="pack_score")
    private BigDecimal packScore;

    @Column(name="quality_score")
    private BigDecimal qualityScore;

    @Column(name="delivery_score")
    private BigDecimal deliveryScore;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 64)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by", length = 64)
    private String updatedBy;

}
