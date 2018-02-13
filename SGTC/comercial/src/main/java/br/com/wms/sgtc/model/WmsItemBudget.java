package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_itembudget")
public class WmsItemBudget implements Serializable {
	
	private static final long serialVersionUID = 8921641908217074754L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="itembudget_id")
	private int id;
		
	@Column(name="itembudget_date", nullable = false)
	private Calendar date;
	
	@Column(name="itembudget_quantity", nullable = false)
	private Double quantity;
	
	@Column(name="itembudget_type", nullable = false, length = 2)
	private char type;
	
	@OneToOne(mappedBy = "tb_itembudget", targetEntity = WmsCatalog.class, fetch = FetchType.LAZY)
	private WmsCatalog catalog;
		
	public WmsCatalog getCatalog() {
		return catalog;
	}
	public void setCatalog(WmsCatalog catalog) {
		this.catalog = catalog;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + type;
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
		WmsItemBudget other = (WmsItemBudget) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
