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
@Table(name="sms_shop")
public class Shop {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer shopId;

	@Column(name="shop_sn")
	private String shopSn;

	@Column(name="shop_name")
	private String shopName;

	@Column(name="pic_url")
	private String picUrl;

	@Column(name="city")
	private String city;

	@Column(name="county")
	private String county;

	@Column(name="address")
	private String address;

	@Column(name="status")
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
