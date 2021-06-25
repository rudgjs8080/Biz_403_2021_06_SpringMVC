package com.callor.score.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.dao.ext.StudentDao;
import com.callor.score.dao.ext.SubjectDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreInputVO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.model.SubjectVO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("studentServiceV1")
public class StudentServiceImplV1 implements StudentService{

	protected final StudentDao stDao;
	protected final ScoreDao scDao;
	protected final SubjectDao sbDao;
	 
	
	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		
		List<StudentVO> stList = stDao.selectAll();
		List<ScoreVO> scList = scDao.selectAll();
		List<SubjectVO> sbList = sbDao.selectAll();
		List<ScoreDTO> scViewList = scDao.selectViewAll();
		
		log.debug("Service {} ", stList.toString());
		log.debug("score {} ", scList.toString());
		log.debug("subject {} ", sbList.toString());
		log.debug("view {} ", scViewList.toString());
		return stList;
	}


	@Override
	public Map<String, Object> selectMaps() {
		// TODO Auto-generated method stub
		List<StudentVO> stList = stDao.selectAll();
		List<ScoreVO> scList = scDao.selectAll();
		List<SubjectVO> sbList = sbDao.selectAll();
		List<ScoreDTO> scViewList = scDao.selectViewAll();
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		maps.put("학생", stList);
		maps.put("점수", scList);
		maps.put("과목", sbList);
		maps.put("view", scViewList);
		
		
		return maps;
	}


	@Override
	public String makeStNum(String prefix) {
		// TODO Auto-generated method stub
		
		String stNum = stDao.getMaxStNum();
		/*
		 * prefix만큼의 문자열을 건너뛰고 나머지 부분을 추출하기
		 * stNum = "20210010" 이고
		 * prefix = "2021" dlfkaus
		 * stSeq = stNum.subString(4) 이런 형식의 코드 생성되어
		 * stSeq에는 0010의 문자열만 남게된다 
		 */
		String stSeq = stNum.substring(prefix.length());
		log.debug("학번 seq {}", stSeq);
		Integer intSeq = Integer.valueOf(stSeq)+1;
		
		String newStNum = String.format("%s%04d", prefix,intSeq);
		log.debug("새로 생성된 학번 {} : " , newStNum);
		
		return newStNum;
	}


	@Override
	public String makeStNum() {
		// TODO Auto-generated method stub
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		
		String cuYear = sd.format(date);
		String newStNum = this.makeStNum(cuYear);
		log.debug("현재 연도 {}, 생성된 학번 {}", cuYear, newStNum);
		return newStNum;
	}


	@Override
	public int insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		
		/*
		 * insert를 수행하는 시점에서 학번을 만들고 싶으면
		 */
		// String newStNum = this.makeStNum();
		// stVO.setSt_num(newStNum);
		
		return stDao.insert(stVO);
	}


	@Override
	public String update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String detail(Model model, String st_num) {
		// TODO Auto-generated method stub
		
		String ret = null;
		
		List<SubjectAndScoreDTO> ssList = scDao.selectSubjectAndScore(st_num);
		StudentVO stVO = stDao.findById(st_num);
		
		Integer scoreCount = scDao.scoreCount(st_num);
		Integer scoreSum = scDao.scoreSum(st_num);
		
		ret = ssList != null ? "OK" : "SS_FAIL";
		ret += stVO != null ? "OK" : "ST_FAIL";
		
		model.addAttribute("SC_COUNT", scoreCount);
		model.addAttribute("SC_SUM", scoreSum);
		model.addAttribute("SSLIST", ssList);
		model.addAttribute("STU", stVO);
		return null;
	}


	@Override
	public String scoreInput(ScoreInputVO scInputVO) {

		log.debug("Service RCV {}", scInputVO.toString());
		
		int size = scInputVO.getSubject().size();
		for(int i = 0 ; i < size ; i++) {
			scDao.insertOrUpdate(
					scInputVO.getSt_num(), 
					scInputVO.getSubject().get(i), 
					scInputVO.getScore().get(i)
			);
		}
		return null;
	}
	

}
