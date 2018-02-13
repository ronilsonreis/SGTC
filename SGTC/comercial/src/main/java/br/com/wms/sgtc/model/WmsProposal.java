package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_proposal")
public class WmsProposal implements Serializable {
	
	private static final long serialVersionUID = 1323640014035937703L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proposal_id")
	private int id;
	
	@Column(name="proposal_date", nullable = false)
	private Calendar date;
	
	@Column(name="proposal_dateapproval")
	private Calendar approvaldate;
	
	@Column(name="proposal_state", nullable = false, length = 1)
	private char state;
	
	@OneToMany(mappedBy="tb_proposal", targetEntity = WmsItemBudget.class, fetch = FetchType.LAZY)
	@JoinColumn(name="proposal_id")
	private List<WmsItemBudget> budget;

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
	public Calendar getApprovaldate() {
		return approvaldate;
	}
	public void setApprovaldate(Calendar approvaldate) {
		this.approvaldate = approvaldate;
	}
	public char getState() {
		return state;
	}
	public void setState(char state) {
		this.state = state;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approvaldate == null) ? 0 : approvaldate.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + state;
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
		WmsProposal other = (WmsProposal) obj;
		if (approvaldate == null) {
			if (other.approvaldate != null)
				return false;
		} else if (!approvaldate.equals(other.approvaldate))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	
	
	

}
