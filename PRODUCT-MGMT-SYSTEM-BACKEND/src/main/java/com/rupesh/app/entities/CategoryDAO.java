package com.rupesh.app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_category")
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDAO {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="cataId_generator")
	@SequenceGenerator(name = "cataId_generator",initialValue=1,allocationSize=1,sequenceName="cata_id_seq")
	private Long categoryId;

	@Column(name = "category_name", nullable = false, length = 255, unique = true)
	private String categoryName;

	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER,targetEntity = ProductDAO.class,cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProductDAO> products;

}
