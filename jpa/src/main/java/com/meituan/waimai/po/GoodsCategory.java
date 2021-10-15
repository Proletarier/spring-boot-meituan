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
@Table(name="sms_goods_category")
public class GoodsCategory {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cateId")
	private Integer cateId;

	@Column(name="parentId")
	private Integer parentId;

	@Column(name="all")
	private Integer all;

	@Column(name="level")
	private Integer level;

	@Column(name="name")
	private String name;

	@Column(name="icon")
	private String icon;

	@Column(name="priority")
	private Integer priority;

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
