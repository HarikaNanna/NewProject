package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.RegistrationBean;
import com.training.dao.RealEstateDAO1;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RegistrationDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RegistrationBean> list = new RealEstateDAO1().getRegister(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RegistrationBean temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getEmail(); 
			obj[1] = temp.getFirstName(); 
			obj[2] = temp.getLastName();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\project\\Testing.xlsx"; 
		//return new ApachePOIExcelRead().getExcelContent(fileName); 
		String sheetName="Sheet1";
		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName,sheetName);
		System.out.println("size "+ retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()];
		int count = 0,i=0;
		
		for(List<Object> temp : retVal) {
			if(temp!=null) {
		
				Object[] obj = new Object[3];
				
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				
				obj[0]= temp.get(0);
				obj[1]= temp.get(1);
				obj[2]= temp.get(2);
				
				result[count ++]=obj;
				System.out.println("**************");
			}
		}
		return result;
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\project\\Testing.xlsx"; 
		//return new ApachePOIExcelRead().getExcelContent(fileName); 
		String sheetName="Sheet2";
		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName,sheetName);
		System.out.println("size "+ retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()];
		int count = 0,i=0;
		
		for(List<Object> temp : retVal) {
			if(temp!=null) {
		
				Object[] obj = new Object[3];
				
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				
				obj[0]= temp.get(0);
				obj[1]= temp.get(1);
				obj[2]= temp.get(2);
				
				result[count ++]=obj;
				System.out.println("**************");
			}
		}
		return result;
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\selenium\\project\\Testing.xlsx"; 
		//return new ApachePOIExcelRead().getExcelContent(fileName); 
		String sheetName="Sheet3";
		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName,sheetName);
		System.out.println("size "+ retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()];
		int count = 0,i=0;
		
		for(List<Object> temp : retVal) {
			if(temp!=null) {
		
				Object[] obj = new Object[4];
				
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				
				obj[0]= temp.get(0);
				obj[1]= temp.get(1);
				obj[2]= temp.get(2);
				obj[3]= temp.get(3);
				
				result[count ++]=obj;
				System.out.println("**************");
			}
		}
		return result;
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/IBM_ADMIN/Desktop/selenium/project/Testing.xls", "Sheet1"); 
	}
}
