package com.rupesh.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DynamicUpdate
@Table(name = "tbl_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name", nullable = false)
	private String name;

	@Column(name = "product_desc", nullable = false, length = 500)
	private String desc;

	@Column(name = "product_unit_price")
	private double unitPrice;

	@Column(name = "available")
	private boolean available;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name = "mf_date")
	private Date mfDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

}
