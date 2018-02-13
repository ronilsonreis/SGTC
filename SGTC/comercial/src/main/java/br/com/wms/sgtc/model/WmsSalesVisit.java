package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_salesvisit")
public class WmsSalesVisit implements Serializable{
	
	private static final long serialVersionUID = 3177110527678394366L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="salesvisit_id")
	private int id;
	
	@Column(name="salesvisit_date", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="salesvisit_status", nullable=false)
	private char status;
	
	@Column(name="salesvisit_datenote")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datenote;
	
	@Column(name="salesvisit_dateeffec")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateeffec;
	
	@OneToOne(mappedBy="tb_salesvisit", fetch = FetchType.LAZY)
	@JoinColumn(name="salesvisit_id")
	private WmsLocalVisit localvisit;
	
	public WmsLocalVisit getLocalvisit() {
		return localvisit;
	}
	public void setLocalvisit(WmsLocalVisit localvisit) {
		this.localvisit = localvisit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getDatenote() {
		return datenote;
	}
	public void setDatenote(Date datenote) {
		this.datenote = datenote;
	}
	public Date getDateeffec() {
		return dateeffec;
	}
	public void setDateeffec(Date dateeffec) {
		this.dateeffec = dateeffec;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((dateeffec == null) ? 0 : dateeffec.hashCode());
		result = prime * result
				+ ((datenote == null) ? 0 : datenote.hashCode());
		result = prime * result + id;
		result = prime * result + status;
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
		WmsSalesVisit other = (WmsSalesVisit) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateeffec == null) {
			if (other.dateeffec != null)
				return false;
		} else if (!dateeffec.equals(other.dateeffec))
			return false;
		if (datenote == null) {
			if (other.datenote != null)
				return false;
		} else if (!datenote.equals(other.datenote))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
}
