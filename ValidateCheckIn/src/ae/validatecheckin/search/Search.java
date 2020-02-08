package ae.validatecheckin.search;

import ae.mscJdbcUtility.data.IData;

public class Search implements IData{

	private String dDocType;
	private String dClassification;
	private String xfields;
	private String xfieldValues;
	
	private String ucmdDocType;
	private String ucmdClassification;
	
	private String dbdDocTypeTitle;
	private String dbdClassificationTitle;
	private String dbxFieldTitle;
	
	private String dbTableTitle;

	// WCC fields
	private String jndi;
	private String idcURL;
	private String  user;
	
	
	public String getdDocType() {
		return dDocType;
	}
	public void setdDocType(String dDocType) {
		this.dDocType = dDocType;
	}
	public String getdClassification() {
		return dClassification;
	}
	public void setdClassification(String dClassification) {
		this.dClassification = dClassification;
	}
	public String getXfields() {
		return xfields;
	}
	public void setXfields(String xfields) {
		this.xfields = xfields;
	}
	public String getDbdDocTypeTitle() {
		return dbdDocTypeTitle;
	}
	public void setDbdDocTypeTitle(String dbdDocTypeTitle) {
		this.dbdDocTypeTitle = dbdDocTypeTitle;
	}
	public String getDbdClassificationTitle() {
		return dbdClassificationTitle;
	}
	public void setDbdClassificationTitle(String dbdClassificationTitle) {
		this.dbdClassificationTitle = dbdClassificationTitle;
	}
	public String getDbxFieldTitle() {
		return dbxFieldTitle;
	}
	public void setDbxFieldTitle(String dbxFieldTitle) {
		this.dbxFieldTitle = dbxFieldTitle;
	}
	public String getDbTableTitle() {
		return dbTableTitle;
	}
	public void setDbTableTitle(String dbTableTitle) {
		this.dbTableTitle = dbTableTitle;
	}
	public String getJndi() {
		return jndi;
	}
	public void setJndi(String jndi) {
		this.jndi = jndi;
	}
	public String getIdcURL() {
		return idcURL;
	}
	public void setIdcURL(String idcURL) {
		this.idcURL = idcURL;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getXfieldValues() {
		return xfieldValues;
	}
	public void setXfieldValues(String xfieldValues) {
		this.xfieldValues = xfieldValues;
	}
	public String getUcmdDocType() {
		return ucmdDocType;
	}
	public void setUcmdDocType(String ucmdDocType) {
		this.ucmdDocType = ucmdDocType;
	}
	public String getUcmdClassification() {
		return ucmdClassification;
	}
	public void setUcmdClassification(String ucmdClassification) {
		this.ucmdClassification = ucmdClassification;
	}
	
	@Override
	public String toString() {
		return "Search [dDocType=" + dDocType + ", dClassification="
				+ dClassification + ", xfields=" + xfields + ", xfieldValues="
				+ xfieldValues + ", ucmdDocType=" + ucmdDocType
				+ ", ucmdClassification=" + ucmdClassification
				+ ", dbdDocTypeTitle=" + dbdDocTypeTitle
				+ ", dbdClassificationTitle=" + dbdClassificationTitle
				+ ", dbxFieldTitle=" + dbxFieldTitle + ", dbTableTitle="
				+ dbTableTitle + ", jndi=" + jndi + ", idcURL=" + idcURL
				+ ", user=" + user + "]";
	}
	
	
	
}
