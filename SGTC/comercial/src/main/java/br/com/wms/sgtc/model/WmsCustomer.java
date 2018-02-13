package br.com.wms.sgtc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="tb_customer")
public class WmsCustomer implements Serializable {
	
	private static final long serialVersionUID = 124086887502700531L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int id;
	
	@Column(name="customer_name", nullable=false, length=40)
	private String name;
	
	@Column(name="customer_typedoc", nullable=false, length=1)
	private char typedoc;
	
	@Column(name="customer_type", nullable=false, length=1)
	private char type;
	
	@Column(name="customer_document", nullable=false, length=20)
	private String document;
	
		
	@OneToMany(mappedBy = "tb_customer", targetEntity = WmsTelefone.class, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private List<WmsTelefone> telefones;
	
	@OneToMany(mappedBy = "tb_customer", targetEntity = WmsAddress.class, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private List<WmsAddress> addresses;

	@OneToMany(mappedBy = "tb_customer", targetEntity = WmsContact.class, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private List<WmsContact> contacts;
	
	@OneToMany(mappedBy = "tb_customer", targetEntity = WmsSalesVisit.class, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private List<WmsSalesVisit> salesvisits;
	
	@OneToMany(mappedBy = "tb_customer", targetEntity = WmsProposal.class, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private List<WmsProposal> proposals;
	
	
	public List<WmsTelefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<WmsTelefone> telefones) {
		this.telefones = telefones;
	}
	public List<WmsSalesVisit> getSalesvisits() {
		return salesvisits;
	}
	public void setSalesvisits(List<WmsSalesVisit> salesvisits) {
		this.salesvisits = salesvisits;
	}
	public List<WmsProposal> getProposals() {
		return proposals;
	}
	public void setProposals(List<WmsProposal> proposals) {
		this.proposals = proposals;
	}
	public List<WmsTelefone> getTelefone() {
		return telefones;
	}
	public void setTelefone(List<WmsTelefone> telefones) {
		this.telefones = telefones;
	}	
	public List<WmsAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<WmsAddress> addresses) {
		this.addresses = addresses;
	}
	public List<WmsContact> getContacts() {
		return contacts;
	}
	public void setContacts(List<WmsContact> contacts) {
		this.contacts = contacts;
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
	public char getTypedoc() {
		return typedoc;
	}
	public void setTypedoc(char typedoc) {
		this.typedoc = typedoc;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((document == null) ? 0 : document.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + type;
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
		WmsCustomer other = (WmsCustomer) obj;
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
		if (type != other.type)
			return false;
		if (typedoc != other.typedoc)
			return false;
		return true;
	}

	

}
