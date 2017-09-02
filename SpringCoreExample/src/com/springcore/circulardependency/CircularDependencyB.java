package com.springcore.circulardependency;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.springcore.ResourceAndAutowired.ResourceCheck;


/*WorkAround
 * Use @Lazy
 */
/*@Component
public class CircularDependencyB implements ApplicationContextAware,InitializingBean,BeanNameAware,BeanPostProcessor{
	 
	 
    private CircularDependencyA circA;
 
    @Autowired
    public CircularDependencyB(@Lazy CircularDependencyA circA) {
    	System.out.println("in B const");
        this.circA = circA;
    }
    
    //User Setter Injection
    @Autowired
    public void setCircA(CircularDependencyA circA) {
    	System.out.println("in B setter ");
        this.circA = circA;
    }
 
    public CircularDependencyA getCircA() {
        return circA;
    }
	
	//using @PostConstruct
	public CircularDependencyB(){
		System.out.println("in const of B");
	}
	@Autowired 
	private CircularDependencyA circA;
	@PostConstruct
	public void init(){
		System.out.println("in B init");
		this.circA.setCircB(this);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterPropertiesSet of B");
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("in setApplicationContext of  B");
		
	}
	@Override
	public void setBeanName(String arg0) {
		
		
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {
		System.out.print("in postProcessAfterInitialization of B=>");
		System.out.println(bean.getClass().getName()+ "--"+arg1);

		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		System.out.print("in postProcessBeforeInitialization of B=>");
		System.out.println(bean.getClass().getName()+ "--"+arg1);
		return bean;
	}
}*/


@Component
public class CircularDependencyB{
	
}