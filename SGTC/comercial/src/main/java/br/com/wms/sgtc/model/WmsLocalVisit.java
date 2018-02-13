package br.com.wms.sgtc.model;

import java.io.Serializable;

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
@Table(name="tb_localvisit")
public class WmsLocalVisit implements Serializable{

	private static final long serialVersionUID = 5688581789606013150L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="local_id")
	private int id;
	
	@Column(name="local_address", nullable=false, length=40)
	private String address;
	
	@Column(name="local_number", nullable=false, length=6)
	private String number;
	
	@Column(name="local_complement", nullable=false, length=10)
	private String complement;
	
	@Column(name="local_city", nullable=false, length=20)
	private String city;
	
	@Column(name="local_district", nullable=false, length=20)
	private String district;
	
	@Column(name="local_lat",  nullable=true, length=10)
	private String lat;
	
	@Column(name="local_lon", nullable=true, length=10)
	private String lon;
	
	@Column(name="local_pobox", nullable=true, length=9)
	private String pobox;
		
	@OneToOne(mappedBy="tb_localvisit", fetch = FetchType.LAZY)
	@JoinColumn(name="local_id")
	private WmsSalesVisit salesvisit;
		
	public WmsSalesVisit getSalesvisit() {
		return salesvisit;
	}
	public void setSalesvisit(WmsSalesVisit salesvisit) {
		this.salesvisit = salesvisit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getPobox() {
		return pobox;
	}
	public void setPobox(String pobox) {
		this.pobox = pobox;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((complement == null) ? 0 : complement.hashCode());
		result = prime * result
				+ ((district == null) ? 0 : district.hashCode());
		result = prime * result + id;
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((pobox == null) ? 0 : pobox.hashCode());
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
		WmsLocalVisit other = (WmsLocalVisit) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (complement == null) {
			if (other.complement != null)
				return false;
		} else if (!complement.equals(other.complement))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (id != other.id)
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pobox == null) {
			if (other.pobox != null)
				return false;
		} else if (!pobox.equals(other.pobox))
			return false;
		return true;
	}

	
}
