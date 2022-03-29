package com.car.application.carapp.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.car.application.carapp.beans.Car;




@Service("carService")
public class CarServiceImpl implements ICarService {

	
	  private List<Car> carList;
	
	  
	  public CarServiceImpl(){
		  carList = new ArrayList<Car>();
		  carList = getCarsFromExcel();		
		  
		  	
		  
	  }
	
	private List<Car> getCarsFromExcel() {
		// TODO Auto-generated method stub
		List<Car> list = new ArrayList<Car>();
		try {
		    File file = ResourceUtils.getFile("classpath:exl/car.xlsx");
		    FileInputStream fis = null;
		    fis = new FileInputStream(file.getAbsolutePath());
		    @SuppressWarnings("resources")
		    Workbook workbook = new XSSFWorkbook(fis);
		    int numberOfSheets = workbook.getNumberOfSheets();
		    for(int i=0;i<numberOfSheets;i++) {
		    	Sheet sheet = workbook.getSheetAt(i);
		    	Iterator<Row> rowIterator =sheet.iterator();
		    	while (rowIterator.hasNext()) {
					Car car= new Car();
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							car.setCarId((int) cell.getNumericCellValue());
						} else if (cell.getColumnIndex() == 1) {
							car.setCarName(cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 2) {
							car.setCarLaunchedYear(cell.getNumericCellValue());
						}else if(cell.getColumnIndex()==3) {
							car.setCost(cell.getNumericCellValue());
						}
						
					}
					list.add(car);
		    }
		    }
		    fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Car getCarbyId(int id) {
		// TODO Auto-generated method stub
		Car ccar = null;
		for (Car car : carList) {
			if (id == car.getCarId()) {
				ccar= car;
				break;
			}
		}
		return ccar;
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carList;
	}

	
	
}
