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
@Table(name="cms_customer_address")
public class CustomerAddress {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer addressId;

	@Column(name="customerId")
	private Integer customerId;

	@Column(name="name")
	private String name;

	@Column(name="gender")
	private Integer gender;

	@Column(name="phone")
	private String phone;

	@Column(name="houseNumber")
	private String houseNumber;

	@Column(name="poi")
	private String poi;

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
