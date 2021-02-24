package com.rupesh.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
public class ProductDAO {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="proId_generator")
	@SequenceGenerator(name = "proId_generator",initialValue=1,allocationSize=1,sequenceName="product_id_seq")
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
	private Date mfDate = new Date();

	@Column(name = "expiry_date")
	private Date expiryDate = new Date();

	@ManyToOne(targetEntity = CategoryDAO.class)
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryDAO category;

}
