package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_approval")
public class WmsApproval implements Serializable {
	
	private static final long serialVersionUID = -403880262511879995L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="approval_id")
	private int id;
	
	@Column(name="approval_date", nullable = false)
	private Calendar date;

	@OneToOne(mappedBy="tb_approval", targetEntity = WmsProposal.class, fetch = FetchType.LAZY)
	@JoinColumn(name="approval_id")
	private WmsProposal proprosal;
		
	public WmsProposal getProprosal() {
		return proprosal;
	}
	public void setProprosal(WmsProposal proprosal) {
		this.proprosal = proprosal;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
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
		WmsApproval other = (WmsApproval) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
