package ae.validatecheckin.jdbc;

import java.sql.SQLException;

import javax.naming.NamingException;

import ae.mscJdbcUtility.base.JdbcFectory;
import ae.validatecheckin.search.Search;

public class ValidateDAO {
	private JdbcFectory factory;
	public ValidateDAO(String jndi)throws NamingException{
		factory = new JdbcFectory(jndi);
	}
	public Search getValidationFields(Search searchParam)throws SQLException{
		String sql =" SELECT "+searchParam.getDbxFieldTitle()+" AS xFields FROM  "+searchParam.getDbTableTitle()+" WHERE "+
				searchParam.getDbdDocTypeTitle()+" = ? ";//AND "+searchParam.getDbdClassificationTitle()+" = ? ";
//		System.out.println(" SQL QUERY : "+sql+", Values : "+searchParam.getDbdDocTypeTitle()+":"+searchParam.getdDocType()+","
//				+searchParam.getDbdClassificationTitle()+":"+searchParam.getdClassification());
		Search search  = factory.getEntity(sql, new Search(), searchParam.getdDocType());
		return search;
	}
}
