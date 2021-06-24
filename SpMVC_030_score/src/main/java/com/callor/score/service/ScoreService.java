package com.callor.score.service;

import java.util.List;
import java.util.Map;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;

public interface ScoreService {
	
	public List<ScoreVO> selectAll();
	public List<ScoreDTO> selectViewAll();
	public Map<String, Object> selectMaps();
}
