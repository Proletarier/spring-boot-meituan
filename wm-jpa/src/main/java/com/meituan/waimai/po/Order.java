package com.meituan.waimai.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="oms_order")
public class Order {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
}
