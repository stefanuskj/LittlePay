/**
 * 
 */
package beans;


/**
 * @author stefanuskj
 *
 */
public class Trips {
	private String _started;
	private String _finished;
	private long _durationSecs;
	private String _fromStopId;
	private String _toStopId;
	private String _chargeAmount;
	private String _companyId;
	private String _busId;
	private String _pan;
	private String _status;
	
	/**
	 * @return the _started
	 */
	public String get_started() {
		return _started;
	}
	/**
	 * @param _started the _started to set
	 */
	public void set_started(String started) {
		this._started = started;
	}
	/**
	 * @return the _finished
	 */
	public String get_finished() {
		return _finished;
	}
	/**
	 * @param _finished the _finished to set
	 */
	public void set_finished(String finished) {
		this._finished = finished;
	}
	/**
	 * @return the _durationSecs
	 */
	public long get_durationSecs() {
		return _durationSecs;
	}
	/**
	 * @param _durationSecs the _durationSecs to set
	 */
	public void set_durationSecs(long durationSecs) {
		this._durationSecs = durationSecs;
	}
	/**
	 * @return the _fromStopId
	 */
	public String get_fromStopId() {
		return _fromStopId;
	}
	/**
	 * @param _fromStopId the _fromStopId to set
	 */
	public void set_fromStopId(String fromStopId) {
		this._fromStopId = fromStopId;
	}
	/**
	 * @return the _toStopId
	 */
	public String get_toStopId() {
		return _toStopId;
	}
	/**
	 * @param _toStopId the _toStopId to set
	 */
	public void set_toStopId(String toStopId) {
		this._toStopId = toStopId;
	}
	/**
	 * @return the _chargeAmount
	 */
	public String get_chargeAmount() {
		return _chargeAmount;
	}
	/**
	 * @param _chargeAmount the _chargeAmount to set
	 */
	public void set_chargeAmount(String chargeAmount) {
		this._chargeAmount = chargeAmount;
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
	/**
	 * @return the _status
	 */
	public String get_status() {
		return _status;
	}
	/**
	 * @param _status the _status to set
	 */
	public void set_status(String status) {
		this._status = status;
	}
	@Override
	public String toString() {
		return "Trips [_started=" + _started + ", _finished=" + _finished + ", _durationSecs=" + _durationSecs
				+ ", _fromStopId=" + _fromStopId + ", _toStopId=" + _toStopId + ", _chargeAmount=" + _chargeAmount
				+ ", _companyId=" + _companyId + ", _busId=" + _busId + ", _pan=" + _pan + ", _status=" + _status + "]";
	}
	public String getCsvFormat() {
		return _started + "," + _finished + "," + _durationSecs
				+ "," + _fromStopId + "," + _toStopId + "," + _chargeAmount
				+ "," + _companyId + "," + _busId + "," + _pan + "," + _status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_busId == null) ? 0 : _busId.hashCode());
		result = prime * result + ((_chargeAmount == null) ? 0 : _chargeAmount.hashCode());
		result = prime * result + ((_companyId == null) ? 0 : _companyId.hashCode());
		result = prime * result + (int) (_durationSecs ^ (_durationSecs >>> 32));
		result = prime * result + ((_finished == null) ? 0 : _finished.hashCode());
		result = prime * result + ((_fromStopId == null) ? 0 : _fromStopId.hashCode());
		result = prime * result + ((_pan == null) ? 0 : _pan.hashCode());
		result = prime * result + ((_started == null) ? 0 : _started.hashCode());
		result = prime * result + ((_status == null) ? 0 : _status.hashCode());
		result = prime * result + ((_toStopId == null) ? 0 : _toStopId.hashCode());
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
		Trips other = (Trips) obj;
		if (_busId == null) {
			if (other._busId != null)
				return false;
		} else if (!_busId.equals(other._busId))
			return false;
		if (_chargeAmount == null) {
			if (other._chargeAmount != null)
				return false;
		} else if (!_chargeAmount.equals(other._chargeAmount))
			return false;
		if (_companyId == null) {
			if (other._companyId != null)
				return false;
		} else if (!_companyId.equals(other._companyId))
			return false;
		if (_durationSecs != other._durationSecs)
			return false;
		if (_finished == null) {
			if (other._finished != null)
				return false;
		} else if (!_finished.equals(other._finished))
			return false;
		if (_fromStopId == null) {
			if (other._fromStopId != null)
				return false;
		} else if (!_fromStopId.equals(other._fromStopId))
			return false;
		if (_pan == null) {
			if (other._pan != null)
				return false;
		} else if (!_pan.equals(other._pan))
			return false;
		if (_started == null) {
			if (other._started != null)
				return false;
		} else if (!_started.equals(other._started))
			return false;
		if (_status == null) {
			if (other._status != null)
				return false;
		} else if (!_status.equals(other._status))
			return false;
		if (_toStopId == null) {
			if (other._toStopId != null)
				return false;
		} else if (!_toStopId.equals(other._toStopId))
			return false;
		return true;
	}
	
	
	
}
