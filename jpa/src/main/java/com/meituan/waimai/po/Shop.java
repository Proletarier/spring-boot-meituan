package com.meituan.waimai.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="sms_shop")
public class Shop {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer shopId;

	@Column(name="shopSn")
	private String shopSn;

	@Column(name="shopName")
	private String shopName;

	@Column(name="picUrl")
	private String picUrl;

	@Column(name="city")
	private String city;

	@Column(name="county")
	private String county;

	@Column(name="address")
	private String address;

	@Column(name="status")
	private Integer status;

}
