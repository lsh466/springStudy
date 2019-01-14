package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean{

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
	}
	
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
//	init-method는 주로 의존성이 제대로 주입되었는지 검사(내부 property가 맞게 주입되었는지)하는 경우 사용된다.
//	만약 init-method가 아니라 의존성 주입에 대한 검사로직을 생성자에서 하는 경우 문제가 발생한다.
//	왜냐하면 생성하는 시점에는 property주입을 수행하지 않기 때문이다.
//	대신 init-method는 spring에서 모든 의존성 주입을 완료한 이후에 호출하기 때문에 init-method에서 의존성 주입 유효성 검사를 체크하여야 한다.
//
//	 
//
//	destroy는 주로 자원의 반납을 하는 경우 사용된다.
//	만약 File 처리와 관련된 Class가 존재하고 필요 기능을 전부 사용한 후에 close를 수행하고자 할 때 가장 적절한 위치는 bean이 소멸되기 직전인 destory다.
//	흔희 io관련된 자원을 close 하는 부분을 destroy에 작성하곤 한다.
//	별도로 bean 소멸 시 수행할 작업이 있는 경우에 추가 코드를 작성하면 된다.



	
}