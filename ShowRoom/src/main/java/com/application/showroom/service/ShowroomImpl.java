package com.application.showroom.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.application.showroom.beans.Car;
import com.application.showroom.beans.Showroom;
import com.application.showroom.resttemplate.RestServices;

@Service("Showroom")
public class ShowroomImpl implements IShowroom {

	private List<Showroom> showroomList;
	  
	@Autowired
	RestServices restService;
	
	  public ShowroomImpl(){
		  showroomList = new ArrayList<Showroom>();
		  showroomList = getShowroomFromExcel();
	  }
		  
		  private List<Showroom> getShowroomFromExcel() {
				// TODO Auto-generated method stub
				List<Showroom> list = new ArrayList<Showroom>();
				try {
				    File file = ResourceUtils.getFile("classpath:exl/Book2.xlsx");
				    FileInputStream fis = null;
				    fis = new FileInputStream(file.getAbsolutePath());
				    @SuppressWarnings("resources")
				    Workbook workbook = new XSSFWorkbook(fis);
				    int numberOfSheets = workbook.getNumberOfSheets();
				    for(int i=0;i<numberOfSheets;i++) {
				    	Sheet sheet = workbook.getSheetAt(i);
				    	Iterator<Row> rowIterator =sheet.iterator();
				    	while (rowIterator.hasNext()) {
							 Showroom showroom= new Showroom();
							Row row = rowIterator.next();
							Iterator<Cell> cellIterator = row.cellIterator();
							// Iterating over each cell (column wise) in a particular row.
							while (cellIterator.hasNext()) {

								Cell cell = cellIterator.next();
								if (cell.getColumnIndex() == 0) {
									showroom.setShowroomId((int) cell.getNumericCellValue());
								} else if (cell.getColumnIndex() == 1) {
									showroom.setShowroomName(cell.getStringCellValue());
								}
								
							}
							list.add(showroom);
				    }
				    }
				    fis.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				return list;
			}

	
	@Override
	public List<Showroom> getAllShowroom() {
		// TODO Auto-generated method stub
		return showroomList;
	}

	@Override
	public Showroom getById(int id,int carId) {
		// TODO Auto-generated method stub
		Showroom SS = null;
		for (Showroom s : showroomList) {
			if (id == s.getShowroomId()) {
				SS= s;
				break;
			}
			
		}
		Car carnew = new Car();
		carnew = restService.getCarByid(carId);
		System.out.println(carnew.getCarId());
		SS.setCar(carnew);
		return SS;
	}

	
}
