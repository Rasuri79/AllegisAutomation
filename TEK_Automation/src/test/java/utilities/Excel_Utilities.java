package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utilities {
	
	public static FileInputStream fi;
	public static FileOutputStream  fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	private static String path;
	
	public Excel_Utilities(String path) {
		this.path=path;
	}
	
	public static int getRowCount(String Xlsheet) throws IOException {
		
		fi =new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws =wb.getSheet(Xlsheet);
		int rowcount =ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
      public static int getCellCount(String Xfile,String Xlsheet,int rownum) throws IOException {
		
		fi =new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws =wb.getSheet(Xlsheet);
		row = ws.getRow(rownum);
		int cellcount =row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
      
      public static String getCellData(String Xfile,String Xlsheet,int rownum,int colnum) throws IOException {
  		
  		fi =new FileInputStream(path);
  		wb = new XSSFWorkbook(fi);
  		ws =wb.getSheet(Xlsheet);
  		row = ws.getRow(rownum);
  		cell = row.getCell(colnum);
      
        String data;
        try
        		{
        	data =cell.toString();
        	//DataFormatter formater =new DataFormatter();
        	//data =formater.formatCellValue(cell);  //return data in string
        		}
        catch(Exception e)
        {
        	
        	data ="";
        }
        	
          wb.close();
          fi.close();
          
          
          return data;
        		}
      
      
      public static void setCellData(String Xfile,String Xlsheet,int rownum,int colnum,String data) throws IOException {	
        		
    	    fi =new FileInputStream(path);
    		wb = new XSSFWorkbook(fi);
    		ws =wb.getSheet(Xlsheet);
    		row = ws.getRow(rownum);
    		cell = row.createCell(colnum);
    		cell.setCellValue(data);
    		fo =new FileOutputStream(Xfile);
    		wb.write(fo);
    		wb.close();
            fi.close();
            fo.close();
      }
      
      public static void fillGreenColor(String Xfile,String Xlsheet,int rownum,int colnum) throws IOException {
    	  fi =new FileInputStream(path);
    		wb = new XSSFWorkbook(fi);
    		ws =wb.getSheet(Xlsheet);
    		row = ws.getRow(rownum);
    		cell = row.getCell(colnum);
    		style =wb.createCellStyle();
    		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
    		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		
    		cell.setCellStyle(style);
    		fo =new FileOutputStream(Xfile);
    		wb.write(fo);
    		wb.close();
            fi.close();
            fo.close();
    	  
    	  
    	  
      }
      public static void fillRedColor(String Xfile,String Xlsheet,int rownum,int colnum) throws IOException {
    	  fi =new FileInputStream(path);
    		wb = new XSSFWorkbook(fi);
    		ws =wb.getSheet(Xlsheet);
    		row = ws.getRow(rownum);
    		cell = row.getCell(colnum);
    		style =wb.createCellStyle();
    		style.setFillForegroundColor(IndexedColors.RED.getIndex());
    		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    		
    		cell.setCellStyle(style);
    		fo =new FileOutputStream(Xfile);
    		wb.write(fo);
    		wb.close();
            fi.close();
            fo.close();
    	  
    	  
    	  
      }
	
	
}

