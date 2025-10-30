package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	
	/*
	 * Spring mvc 에서 빈으로 등록할 때는 어떻게 했더라??
	 * 
	 * root-context.xml에가서
	 * 
	 * <bean class="풀클래스명" id="식별자">
	 * 		<property 필드값/>
	 * </bean>
	 * ---------------------------------------------------
	 * 
	 * @Configuration
	 * 
	 * 스프링에서 설정클래스를 정의할 때 사용
	 * 
	 * 하나 이상의 @Bean이 달린 메소드를 포함해 스프링 컨테이너에 빈으로 등록함
	 * 
	 * @Bean
	 * 
	 * @Configuration 클래스 내에서 메소드에 달려서 스프링 빈을 생성함
	 * 
	 * 메서드의 반환값이 스프링 컨테이너에 빈으로 등록됨
	 * 
	 * XML으로 설정하는 것보다 빠른시점에 오류를 발견할 수 있고,
	 * 코드 기반이기 때문에 자동완성 / 수정이 용이하고 
	 * 서정 클래스내에서 빈의 생성과정을 명확하게 정의할 수 있음
	 * 
	 * 
	 * 
	 * 
	 */
	// 빈등록 에노테이션
	@Bean
	public StudyBean studyBean() {
		return new StudyBean();
	}
}
