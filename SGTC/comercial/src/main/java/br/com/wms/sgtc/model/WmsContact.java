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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_contact")
public class WmsContact implements Serializable {
	
	private static final long serialVersionUID = 4677909450059379354L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_id")
	private int id;
	
	@Column(name="contact_name", nullable=false, length=20)
	private String name;
	
	@Column(name="contact_depart", nullable=false, length=20)
	private String depart;
	
	@Column(name="contact_email", nullable=false, length=30)
	private String email;
	
	@Column(name="contact_jobrole", nullable=false, length=20)
	private String jobrole;
	
	@Column(name="contact_status", nullable=false)
	private char status;
	
	@Column(name="contact_date", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar date;
	
	@OneToMany(targetEntity = WmsApproval.class, fetch = FetchType.LAZY)
	@JoinColumn(name="contact_id")
	private WmsApproval approvals;

	public WmsApproval getApprovals() {
		return approvals;
	}
	public void setApprovals(WmsApproval approvals) {
		this.approvals = approvals;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
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
		result = prime * result + ((depart == null) ? 0 : depart.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((jobrole == null) ? 0 : jobrole.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		WmsContact other = (WmsContact) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (depart == null) {
			if (other.depart != null)
				return false;
		} else if (!depart.equals(other.depart))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (jobrole == null) {
			if (other.jobrole != null)
				return false;
		} else if (!jobrole.equals(other.jobrole))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
