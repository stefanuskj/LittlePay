/**
 * 
 */
package beans;

import com.opencsv.bean.CsvBindByName;

/**
 * @author stefanuskj
 *
 */
public class Taps {
	@CsvBindByName(column = "ID")
	private int _id;
	
	@CsvBindByName(column="DateTimeUTC")
	private String _dateTimeUTC;
	
	@CsvBindByName(column="TapType")
	private String _tapType;
	
	@CsvBindByName(column="StopId")
	private String _stopId;
	
	@CsvBindByName(column="CompanyId")
	private String _companyId;
	
	@CsvBindByName(column="BusID")
	private String _busId;
	
	@CsvBindByName(column="PAN")
	private String _pan;
	
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(int id) {
		this._id = id;
	}
	/**
	 * @return the _dateTimeUTC
	 */
	public String get_dateTimeUTC() {
		return _dateTimeUTC;
	}
	/**
	 * @param _dateTimeUTC the _dateTimeUTC to set
	 */
	public void set_dateTimeUTC(String dateTimeUTC) {
		this._dateTimeUTC = dateTimeUTC;
	}
	/**
	 * @return the _tapType
	 */
	public String get_tapType() {
		return _tapType;
	}
	/**
	 * @param _tapType the _tapType to set
	 */
	public void set_tapType(String tapType) {
		this._tapType = tapType;
	}
	/**
	 * @return the _stopId
	 */
	public String get_stopId() {
		return _stopId;
	}
	/**
	 * @param _stopId the _stopId to set
	 */
	public void set_stopId(String stopId) {
		this._stopId = stopId;
	}
	/**
	 * @return the _companyId
	 */
	public String get_companyId() {
		return _companyId;
	}
	/**
	 * @param _companyId the _companyId to set
	 */
	public void set_companyId(String companyId) {
		this._companyId = companyId;
	}
	/**
	 * @return the _busId
	 */
	public String get_busId() {
		return _busId;
	}
	/**
	 * @param _busId the _busId to set
	 */
	public void set_busId(String busId) {
		this._busId = busId;
	}
	/**
	 * @return the _pan
	 */
	public String get_pan() {
		return _pan;
	}
	/**
	 * @param _pan the _pan to set
	 */
	public void set_pan(String pan) {
		this._pan = pan;
	}
	@Override
	public String toString() {
		return "Taps [_id=" + _id + ", _dateTimeUTC=" + _dateTimeUTC + ", _tapType=" + _tapType + ", _stopId=" + _stopId
				+ ", _companyId=" + _companyId + ", _busId=" + _busId + ", _pan=" + _pan + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_busId == null) ? 0 : _busId.hashCode());
		result = prime * result + ((_companyId == null) ? 0 : _companyId.hashCode());
		result = prime * result + ((_dateTimeUTC == null) ? 0 : _dateTimeUTC.hashCode());
		result = prime * result + _id;
		result = prime * result + ((_pan == null) ? 0 : _pan.hashCode());
		result = prime * result + ((_stopId == null) ? 0 : _stopId.hashCode());
		result = prime * result + ((_tapType == null) ? 0 : _tapType.hashCode());
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
		Taps other = (Taps) obj;
		if (_busId == null) {
			if (other._busId != null)
				return false;
		} else if (!_busId.equals(other._busId))
			return false;
		if (_companyId == null) {
			if (other._companyId != null)
				return false;
		} else if (!_companyId.equals(other._companyId))
			return false;
		if (_dateTimeUTC == null) {
			if (other._dateTimeUTC != null)
				return false;
		} else if (!_dateTimeUTC.equals(other._dateTimeUTC))
			return false;
		if (_id != other._id)
			return false;
		if (_pan == null) {
			if (other._pan != null)
				return false;
		} else if (!_pan.equals(other._pan))
			return false;
		if (_stopId == null) {
			if (other._stopId != null)
				return false;
		} else if (!_stopId.equals(other._stopId))
			return false;
		if (_tapType == null) {
			if (other._tapType != null)
				return false;
		} else if (!_tapType.equals(other._tapType))
			return false;
		return true;
	}
	
	
}
