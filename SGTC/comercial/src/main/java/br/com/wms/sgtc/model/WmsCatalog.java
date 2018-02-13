package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_catalog")
public class WmsCatalog implements Serializable {
	
	private static final long serialVersionUID = -6151028492310233998L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="catalog_id")
	private int id;
	
	@Column(name="catalog_description", nullable = false, length = 40)
	private String description;
	
	@Column(name="catalog_type", nullable = false, length = 1)
	private String type;
	
	@Column(name="catalog_category", nullable = false, length = 40)
	private String category;
	
	@Column(name="catalog_value", nullable = false)
	private double valueItem;
	
	@Column(name="catalog_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getValueItem() {
		return valueItem;
	}
	public void setValueItem(double valueItem) {
		this.valueItem = valueItem;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valueItem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WmsCatalog other = (WmsCatalog) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (Double.doubleToLongBits(valueItem) != Double
				.doubleToLongBits(other.valueItem))
			return false;
		return true;
	}
	
	
		

}
