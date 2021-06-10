package com.callor.jdbc.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompanyVO;
import com.callor.jdbc.persistance.CompDao;

import lombok.extern.slf4j.Slf4j;

/*
 * @Component
 * 모든 Component를 대표하는 Annotation
 * 컴파일과정에서 다소 비용이 많이 소요된다
 * 
 * Component Annotation
 * @Controller, @Service, @Repository 이러한 Annotation을 사용한다
 * Spring Container 에게 이 표식이 부착된 클래스를 bean으로 생성하여
 * 보관해 달라는 지시어
 * 
 * CompanyVO c = new CompanyVO()
 * Object o = new CompanyVO()
 * 
 * CompServiceImplV1 cs = new ComServiceImplV1();
 * CompService cs1 = new CompServiceImplV2();
 * 
 * 
 */
@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao{

	protected final JdbcTemplate jdbcTemplate;

	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public List<CompanyVO> selectAll() {

		String sql = "select * from tbl_company";
		List<CompanyVO> compList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		//log.debug("Comp Select {} ", compList.toString());
		return null;
	}

	@Override
	public CompanyVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_company ";
		sql += "where cp_code = ? ";
		Object[] params = new Object[] {pk};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		return null;
	}

	@Override
	public int insert(CompanyVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into tbl_company ";
		sql += " (cp_code, cp_title, cp_ceo, cp_addr, cp_tel) ";
		sql += " values(?,?,?,?,?) ";
		
		Object[] params = new Object[] {vo.getCp_code(), vo.getCp_title(), vo.getCp_ceo(),vo.getCp_addr(),vo.getCp_tel()};
		
		return jdbcTemplate.update(sql, params);
		
		
		
		
	}

	@Override
	public int update(CompanyVO vo) {
		// TODO Auto-generated method stub
		String sql = "update tbl_company set ";
		sql += " cp_title = ? , cp_ceo = ? , cp_addr = ? , cp_tel = ?  ";
		sql += " where cp_code = ? ";
		
		Object[] params = new Object[] {vo.getCp_title(), vo.getCp_ceo(), vo.getCp_addr(), vo.getCp_tel(),vo.getCp_code()};
		
		return jdbcTemplate.update(sql, params);
	}

	/*
	 * jdbcTemplate을 사용하여 QUERY를 실행할 때
	 * 각 method에서 매개벼수를 받아
	 * Query에 전달할텐데
	 * 이때 매개변수는 primitive로 받으면 값을 
	 * 변환시키는 어려움이 있다
	 * 권장사항으로 매개변수는 wrapper class type으로 설정하는 것이 좋다
	 * 즉 숫자형일 경우 int, long 보다는 integer, Long 형으로 선언
	 * 
	 * vo에 담겨서 전달된 값은 Object[] 배열로 변환한 후
	 * jdbcTemplate에 전달해 줘야 한다
	 * 
	 * 하지만 1~ 2개 정도의 값을 전달할 때 Object[] 배여로 변환 후
	 * 전달을 하면 Object 객체 저장소가 생성되고 메모리를 사용한다
	 * 이때 전달되는 변수가 wrapper class type 이면
	 * Object[] 배열로 만들지 않고 바로 주입할 수 있다
	 */
	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		String sql = "delete from tbl_company ";
		sql += " where cp_code = ? ";
		
		// Object[] params = new Object[] {pk};
		jdbcTemplate.update(sql, pk);
		
		return 0;
	}

	@Override
	public List<CompanyVO> findByCName(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_company ";
		sql += "where cp_title = ? ";
		Object[] params = new Object[] {name};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		
		return null;
	}


	@Override
	public List<CompanyVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_company ";
		sql += "where cp_tel = ? ";
		Object[] params = new Object[] {tel};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		
		return null;
	}


	@Override
	public List<CompanyVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_company ";
		sql += "where cp_ceo = ? ";
		Object[] params = new Object[] {ceo};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		return null;
	}


	/*
	 * tbl_company table에서 cpcode(출판사코드) 중
	 * 가장 큰 값을 추출하기
	 */
	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		
		String sql = "select max(cp_code) from tbl_company ";
		
		String cpCode = jdbcTemplate.queryForObject(sql, String.class);
		
		return cpCode;
	}

}
