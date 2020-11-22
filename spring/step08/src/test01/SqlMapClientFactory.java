package test01;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClientFactory {
	private static SqlSessionFactory factory = null;
	
	// static 초기화
	// => static 변수들을 초기화 : xml 파일을 읽어와서 초기화 시킴
	static {
		String resource = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
}











