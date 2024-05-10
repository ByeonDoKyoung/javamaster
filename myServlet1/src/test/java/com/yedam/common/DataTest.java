package com.yedam.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.EmpMapper;

public class DataTest {

	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession();

		EmpMapper mapper = session.getMapper(EmpMapper.class);
		int r = mapper.deleteEmp(204);
		System.out.println(r + "건 처리.");

	}

}
