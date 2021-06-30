package com.callor.woo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {
	
	private String POP; //	강수확률
	private String PTY; //	강수형태
	private String R06; //	6시간 강수량
	private String REH; //	습도
	private String S06; //	6시간 신적설
	private String SKY; //	하늘상태
	private String T3H; //	3시간 기온
	private String TMN; //	아침 최저기온
	private String TMX; //	낮 최고기온
	private String UUU; //	풍속(동서성분)
	private String VVV; //	풍속(남북성분)
	private String WAV; //	파고
	private String VEC; //	풍향
	private String WSD; //	풍속
 
	
}
