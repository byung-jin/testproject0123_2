package com.hk.board.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExecute {

	/*
	 * JoinPoint 에서 지원되는 메서드 
	 * - getArgs(): 메서드의 아규먼트를 반환
	 * - getTarget(): 대상 객체를 반환
	 * - getSignature(): 호출되는 메서드에 대한 정보
	 *      --> getName(): 메서드의 이름구함
	 *      --> toLongName(): 메서드를 완전하게 표현한 문장을 구함(메서드의 리턴 타입, 
	 *                                                  파라미터 타입 모두 표시)
	 *      --> toShortName(): 메서드를 축약해서 표현한 문장을 구함(메서드의 이름만 구함)
	 * - getThis(): 포록시 객체를 반환                                            
	 */
	public void before(JoinPoint join) {
		Logger log=LoggerFactory.getLogger(join.getTarget()+"");
		log.debug("시작");
		log.info("-----시작-----"+join.getSignature().getName());
	}
	
	public void afterReturning(JoinPoint join) {
		Logger log=LoggerFactory.getLogger(join.getTarget()+"");
		log.debug("끝");
		log.info("-----끝-----"+join.getArgs());
	}
	
	public void daoError(JoinPoint join) {
		Logger log=LoggerFactory.getLogger(join.getTarget()+"");
		log.debug("에러"+join.getArgs()+":"+join.getSignature().getName());
		log.info("-----끝-----"+join.toString());
	}
	
	
}




