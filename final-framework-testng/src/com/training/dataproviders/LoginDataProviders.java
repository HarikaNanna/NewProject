package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.RealEstateDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new RealEstateDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
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
		int count = 0;
		for(List<Object> temp : retVal) {
			if(temp!=null) {
				Object[] obj = new Object[2];
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				
				obj[0]= temp.get(0);
				obj[0]= temp.get(1);
				
				result[count ++]=obj;
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
