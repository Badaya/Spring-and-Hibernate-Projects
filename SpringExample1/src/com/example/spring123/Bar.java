package com.example.spring123;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
     
	public class Bar {
		@Autowired
		//@Qualifier(value="secondaryFoo")
		 private Foo foo;
		
		@Resource(name="anotherFoo")
		 private Foo foo2;
		 
		 public void setFoo(Foo foo) {
		  this.foo = foo;
		 }
		 public void  printFooName(){
		  System.out.println(foo.getName());
		  System.out.println(foo2.getName());
		 }
}
