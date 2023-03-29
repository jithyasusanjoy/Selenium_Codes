package com.project.Utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzer implements IRetryAnalyzer,IAnnotationTransformer  { 

	  private int count = 0; 

	  private int maxCount =1;

	  public boolean retry(ITestResult result) { 

	    if(count < maxCount) {  

	       count++;

	       return true;        

	    }        

	    return false; 

	 }
	  public void transform(ITestAnnotation annotation,Class testclass,Constructor testconstructor,Method testmethod)
		{
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
		}

	}
