package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="tb_salesman")
public class WmsSalesMan implements Serializable{
	
	private static final long serialVersionUID = 136696988809823471L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salesman_id")
	private int id;
	
	@Column(name="salesman_name", nullable=false, length=40)
	private String name;
	
	@Column(name="salesman_document", nullable=false, length=14)
	private String document;
	
	@Column(name="salesman_typedoc", nullable=false)
	private char typedoc;
	
	@Column(name="salesman_status", nullable=false)
	private char status;
	
	@Column(name="salesman_date")
	private Date date;
	
	@OneToMany(mappedBy = "tb_salesman", targetEntity = WmsSalesVisit.class, fetch = FetchType.LAZY)
	@JoinColumn(name="salesman_id")
	private List<WmsSalesVisit> salesvisit;
	
	@OneToMany(mappedBy = "tb_salesman", targetEntity = WmsProposal.class, fetch = FetchType.LAZY)
	@JoinColumn(name="salesman_id")
	private List<WmsProposal> proposals;

	public List<WmsSalesVisit> getSalesvisit() {
		return salesvisit;
	}
	public void setSalesvisit(List<WmsSalesVisit> salesvisit) {
		this.salesvisit = salesvisit;
	}
	public List<WmsProposal> getProposals() {
		return proposals;
	}
	public void setProposals(List<WmsProposal> proposals) {
		this.proposals = proposals;
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
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public char getTypedoc() {
		return typedoc;
	}
	public void setTypedoc(char typedoc) {
		this.typedoc = typedoc;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((document == null) ? 0 : document.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + status;
		result = prime * result + typedoc;
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
		WmsSalesMan other = (WmsSalesMan) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		if (typedoc != other.typedoc)
			return false;
		return true;
	} 
	
	

}
