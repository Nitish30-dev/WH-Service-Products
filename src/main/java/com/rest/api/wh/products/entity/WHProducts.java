package com.rest.api.wh.products.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "Warehouse_Products")
public class WHProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "S_No")
	@NotNull
	private int id;

	@NotNull
	@Column(name = "Warehouse_P_ID")
	private long wPId;

	@NotNull
	@NotEmpty
	@Column(name = "Warehouse_P_Name")
	private String wPName;

	@NotNull
	@Column(name = "Warehouse_P_Price")
	private long wPPrice;

	@NotNull
	@Column(name = "Warehouse_P_Date_of_Entry")
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	private Date wPDoE;

	public WHProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WHProducts(@NotNull int id, @NotNull long wPId, @NotNull @NotEmpty String wPName, @NotNull long wPPrice,
			@NotNull Date wPDoE) {
		super();
		this.id = id;
		this.wPId = wPId;
		this.wPName = wPName;
		this.wPPrice = wPPrice;
		this.wPDoE = wPDoE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getwPId() {
		return wPId;
	}

	public void setwPId(long wPId) {
		this.wPId = wPId;
	}

	public String getwPName() {
		return wPName;
	}

	public void setwPName(String wPName) {
		this.wPName = wPName;
	}

	public long getwPPrice() {
		return wPPrice;
	}

	public void setwPPrice(long wPPrice) {
		this.wPPrice = wPPrice;
	}

	public Date getwPDoE() {
		return wPDoE;
	}

	public void setwPDoE(Date wPDoE) {
		this.wPDoE = wPDoE;
	}

	@Override
	public String toString() {
		return "WHProducts [id=" + id + ", wPId=" + wPId + ", wPName=" + wPName + ", wPPrice=" + wPPrice + ", wPDoE="
				+ wPDoE + "]";
	}

}
