/**
 * 
 */
package beans;

/**
 * @author stefanuskj
 *
 */
public class Properties {
	private String  _inputPath;
	private String _outputPath;
	/**
	 * @return the _inputPath
	 */
	public String get_inputPath() {
		return _inputPath;
	}
	/**
	 * @param inputPath the _inputPath to set
	 */
	public void set_inputPath(String inputPath) {
		this._inputPath = inputPath;
	}
	/**
	 * @return the _outputPath
	 */
	public String get_outputPath() {
		return _outputPath;
	}
	/**
	 * @param outputPath the _outputPath to set
	 */
	public void set_outputPath(String outputPath) {
		this._outputPath = outputPath;
	}
	@Override
	public String toString() {
		return "Properties [_inputPath=" + _inputPath + ", _outputPath=" + _outputPath + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_inputPath == null) ? 0 : _inputPath.hashCode());
		result = prime * result + ((_outputPath == null) ? 0 : _outputPath.hashCode());
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
		Properties other = (Properties) obj;
		if (_inputPath == null) {
			if (other._inputPath != null)
				return false;
		} else if (!_inputPath.equals(other._inputPath))
			return false;
		if (_outputPath == null) {
			if (other._outputPath != null)
				return false;
		} else if (!_outputPath.equals(other._outputPath))
			return false;
		return true;
	}
	
}
