package com.meituan.waimai.po;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="bms_dictionary_detail")
public class DictionaryDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer detailId;

    @Column(name="dic_id")
    private String dicId;

    @Column(name="detail_key")
    private String detailKey;

    @Column(name="detail_value")
    private String detailValue;

    @Column(name="detail_desc")
    private String detailDesc;

    @Column(name="is_lock")
    private Integer isLock;

    @Column(name="icon")
    private String icon;

    @Column(name="status",columnDefinition="int(1) COMMENT '帐号启用状态:0->禁用；1->启用'")
    private Integer status;

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
