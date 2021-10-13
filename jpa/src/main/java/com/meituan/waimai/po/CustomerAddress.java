package com.meituan.waimai.po;

import lombok.Data;

import javax.persistence.*;

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

}
