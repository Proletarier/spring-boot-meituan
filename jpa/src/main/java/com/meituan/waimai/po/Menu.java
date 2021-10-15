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
@Table(name="bms_menu")
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="type")
	private Integer type;

	@Column(name="title")
	private String title;

	@Column(name="level")
	private Integer level;

	@Column(name="sort")
	private Integer sort;

	@Column(name="name")
	private String name;

	@Column(name="icon")
	private String icon;

	@Column(name="position")
	private Integer position;

	@Column(name="hidden")
	private Integer hidden;

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
