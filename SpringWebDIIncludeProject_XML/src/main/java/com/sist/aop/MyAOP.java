package com.sist.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // @Aspect는 메모리 할당이 안 되는 어노테이션 => 모든 클래스에 공통으로 쓰이는 어노테이션 (공통 모듈) ex) footer,header, ..
@Component // 메모리 할당
public class MyAOP {

}
