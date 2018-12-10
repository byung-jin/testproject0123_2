package com.hk.util;

public class Util {
// Util클래스에서 화살표 출력 기능 구현 --->usebean활용
// usebean은 객체를 저장하고 꺼내는 객체에 사용
// &nbsp;&nbsp;&nbsp;&nbsp;+ -> + 글제목(제목은 화면에서 더해줄거임)
	private String arrowNbsp;

	public String getArrowNbsp() { //<jsp:getProperty>가 호출해줌 
		return arrowNbsp;
	}

	public void setArrowNbsp(String depth) {//<jsp:setProperty>가 호출해줌 
		String nbsp="";
		int depthInt=Integer.parseInt(depth);
		for (int i = 0; i < depthInt; i++) {
			nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;";//depth의 크기만큼 출력
		}
		//depth가 0이면 새글이기때문에 0보다 큰경우만 출력
		this.arrowNbsp=
		(depthInt>0?nbsp+"<img src='img/arrow.png' alt='답글'/>":"");
	}
	
	
}



