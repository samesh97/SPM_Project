package views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import database.DatabaseHandler_Connections;
import database.DatabaseHandler_Lecturers;
import database.DatabaseHandler_NotAvailbleTime;
import database.QueriesOfWorkingDays;
import enums.Cell;
import enums.Day;
import enums.Program;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;

public class TimeTableMainController implements Initializable
{
	
	@FXML
	private AnchorPane root;
	@FXML
	private GridPane timetablegrid;
	@FXML
	private ComboBox search_Lecturer;
	@FXML
	private ComboBox search_Group;
	@FXML
	private ComboBox search_location;
	
	
	@FXML
	private ComboBox<Object> combo_working_days_type;
	
	private int programType = Program.WEEK_DAY;
	
	private int size;
	private VBox progressDialogVBox;
	
	private ArrayList<String> studentGroupList = new ArrayList<>();
	private ArrayList<Cell> allCells = new ArrayList<>();
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		
		//set weekday weekend combobox
		ObservableList<Object> data = FXCollections.observableArrayList();
		data.add("Weekday");
		data.add("Weekend");
		
		combo_working_days_type.setItems(null);
		combo_working_days_type.setItems(data);
		
		combo_working_days_type.getSelectionModel().selectFirst();
		
		
		//set lecturer combo
		ObservableList<String> lecturer_data = FXCollections.observableArrayList();

		try
		{
			ResultSet rs= DatabaseHandler_Lecturers.getDropDownLecturers();
		
			while(rs.next())
			{
				lecturer_data.add(rs.getString("LecturerName"));
			}
		
			search_Lecturer.setItems(null);
			search_Lecturer.setItems(lecturer_data);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//set subgroup combo
		//Student group combo box
		ObservableList<String> group_data = FXCollections.observableArrayList();
		
		try {
		ResultSet rs= DatabaseHandler_Lecturers.getDropDownGroups();
				
		while(rs.next())
		{
			
			group_data.add(rs.getString("groupId"));
			studentGroupList.add(rs.getString("groupId"));
//			group_data.add(rs.getString("subGroupId"));
			
		}
				
		search_Group.setItems(null);
		search_Group.setItems(group_data);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//location combo box
		//Location combo box
		ObservableList<String> location = FXCollections.observableArrayList();
		
		try
		{
			ResultSet rs= DatabaseHandler_Connections.getAllLocations();
							
			while(rs.next())
			{
				String text = rs.getString("roomId");
				int locId = rs.getInt("LID");
				location.add(text);
						
			}
							
			search_location.setItems(null);
			search_location.setItems(location);
							
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		recreatePane();
		
		//listeners
				combo_working_days_type.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
			         
					if(newValue.equals("Weekend"))
					{
						programType = Program.WEEK_END;
					}
					else if(newValue.equals("Weekday"))
					{
						programType = Program.WEEK_DAY;
					}
					
					recreatePane();
			    }
			    ); 
				
				search_Lecturer.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
			         
			
					
					recreatePane();
					loadToGrid("Le",newValue.toString());
			    }
			    ); 
				
				search_Group.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
			         
					recreatePane();
					loadToGrid("Gr",newValue.toString());
					
			    }
			    ); 
				
				search_location.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
			         
			
					
					recreatePane();
					loadToGrid("Lo",newValue.toString());
			    }
			    ); 
		
	}
	public void loadToGrid(String type,String name)
	{
		if(type.equals("Le"))
		{
			ResultSet set = QueriesOfWorkingDays.getLecturerTimeTable(name);
			try
			{
				while(set.next())
				{
					String SubjectCode = set.getString("SubjectCode");
					String Tag = set.getString("Tag");
					String StudentGroup = set.getString("StudentGroup");
					String venue = set.getString("venue");
					
					int cellH = set.getInt("cellH");
					int cellV = set.getInt("cellV");
					
					
					Label label = new Label(SubjectCode + "\n" + "(" + Tag + ")" + "\n" + StudentGroup + "\n" + venue);
	        		label.setAlignment(Pos.CENTER);
	    			label.setMaxWidth(Double.MAX_VALUE);
	    			label.setStyle("-fx-font-weight: bold");
	    			
	    			
	    			timetablegrid.add(label, cellH, cellV);
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("Lo"))
		{
			
			ResultSet set = QueriesOfWorkingDays.getVenueTimeTable(name);
			try
			{
				while(set.next())
				{
					String SubjectCode = set.getString("SubjectCode");
					String Tag = set.getString("Tag");
					String LecturerName = set.getString("LecturerName");
					String StudentGroup = set.getString("StudentGroup");
					
					
					int cellH = set.getInt("cellH");
					int cellV = set.getInt("cellV");
					
					
					Label label = new Label(SubjectCode + "\n" +"(" + Tag + ")" + "\n" + LecturerName + "\n" + StudentGroup);
	        		label.setAlignment(Pos.CENTER);
	    			label.setMaxWidth(Double.MAX_VALUE);
	    			label.setStyle("-fx-font-weight: bold");
	    			
	    			
	    			timetablegrid.add(label, cellH, cellV);
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("Gr"))
		{
			ResultSet set = QueriesOfWorkingDays.getStudentGroupTimeTable(name);
			try
			{
				while(set.next())
				{
				
					String SubjectCode = set.getString("SubjectCode");
					String Tag = set.getString("Tag");
					String LecturerName = set.getString("LecturerName");
					String venue = set.getString("venue");
					
					int cellH = set.getInt("cellH");
					int cellV = set.getInt("cellV");
					
					
					Label label = new Label(SubjectCode + "\n" + Tag + "\n" + LecturerName + "\n" + venue);
	        		label.setAlignment(Pos.CENTER);
	    			label.setMaxWidth(Double.MAX_VALUE);
	    			label.setStyle("-fx-font-weight: bold");
	    			
	    			
	    			timetablegrid.add(label, cellH, cellV);
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void recreatePane()
	{
			timetablegrid.setGridLinesVisible(false);
			timetablegrid.getColumnConstraints().clear();
			timetablegrid.getRowConstraints().clear();
			timetablegrid.getChildren().clear();
			timetablegrid.setGridLinesVisible(true);

			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(100 / 7);
			
			 size = QueriesOfWorkingDays.getSlotsCountByProgram(programType) + 1;
			 
			 if(programType == Program.WEEK_DAY)
			 {
				 setAllCells(1,5);
			 }
			 else
			 {
				 setAllCells(6,8);
			 }
			 
			
			for (int i = 0; i < 8; i++)
			{
		         
			       timetablegrid.getColumnConstraints().add(column);
			       
			       Label label = new Label(Day.getString(i));
			       label.setAlignment(Pos.CENTER);
			       label.setMaxWidth(Double.MAX_VALUE);
			       label.setStyle("-fx-font-weight: bold");
			       
			       timetablegrid.add(label, i, 0);
			       
			       removeCell(i,0);
			    
		     }
			
	       
	        
	        ResultSet set = QueriesOfWorkingDays.getSlotsByProgram(programType);
	       
	        
	        
	        RowConstraints row = new RowConstraints();
	        //first row is for the days
	        row.setPercentHeight(100);	  

			if(size > 0)
			{
				row.setPercentHeight(100 / size);	  
				for(int i = 0; i < size; i++)
				{
					timetablegrid.getRowConstraints().add(row);
				}
			}
	      
	        
	        
	        
	        try 
	        {
	        	int i = 0;
	        	while(set.next())
	        	{
	        		i++;
	        		String sHours,sMinutes,eHours,eMinutes;
	        		int startHours = set.getInt(4);
	        		int startMinutes = set.getInt(5);
	        		int endHours = set.getInt(6);
	        		int endMinutes = set.getInt(7);
	        		
	        		if(startHours < 10)
	        		{
	        			sHours = "0" + startHours;
	        		}
	        		else
	        		{
	        			sHours = "" + startHours;
	        		}
	        		
	        		if(startMinutes < 10)
	        		{
	        			sMinutes = "0" + startMinutes;
	        		}
	        		else
	        		{
	        			sMinutes = "" + startMinutes;
	        		}
	        		
	        		if(endHours < 10)
	        		{
	        			eHours = "0" + endHours;
	        		}
	        		else
	        		{
	        			eHours = "" + endHours;
	        		}
	        		
	        		if(endMinutes < 10)
	        		{
	        			eMinutes = "0" + endMinutes;
	        		}
	        		else
	        		{
	        			eMinutes = "" + endMinutes;
	        		}
	        		
	        		
	        		
	        		String text = "" + sHours + ":" + sMinutes + " - " + eHours + ":" + eMinutes;
	        		
	        		
	        		Label label = new Label(text);
	        		label.setAlignment(Pos.CENTER);
	    			label.setMaxWidth(Double.MAX_VALUE);
	    			label.setStyle("-fx-font-weight: bold");
	    			
	    			

	    			
	    			timetablegrid.add(label, 0, i);
	    			removeCell(0,i);
	        		
	        		
	        	
	        	}
	        	
			
			} 
	        catch (SQLException e)
	        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	}


	private void removeCell(int cellH, int cellV)
	{
		
		for(int i = 0; i < allCells.size(); i++)
		{
			Cell cell = allCells.get(i);
			if(cell.getCellH() == cellH && cell.getCellV() == cellV)
			{
				allCells.remove(i);
//				System.out.println("" + cell.getCellH() + " - " + cell.getCellV());
			}
		}

	}


	private void setAllCells(int hStart,int hEnd)
	{
		allCells.clear();
		
		
		for(int i = hStart; i <= hEnd; i++)
		{
			for(int j = 0; j < size; j++)
			{
				Cell cell = new Cell();
				cell.setCellH(i);
				cell.setCellV(j);
				
				allCells.add(cell);
				System.out.println(cell.getCellH() + " --- " + cell.getCellV() + "--- " + allCells.size());
				
				
			}
		}
		
//		for(int i = 0; i < cellH; i++)
//		{
//			for(int j = 0; j < cellV; j++)
//			{
//				Cell cell = new Cell();
//				cell.setCellH(i);
//				cell.setCellV(j);
//				allCells.add(cell);
//			}
//		}
//		
//		for(Cell cell : allCells)
//		{
//			System.out.println("CellH - " + cell.getCellH() + " CellV - " + cell.getCellV() + " Size - " + allCells.size());
//		}
	}


	public void onGenerateButtonWasClicked(ActionEvent event)
	{
		
		showProgressDialog(root);
		
		 Runnable r = new Runnable() 
		 {
	         public void run()
	         {
	        	 QueriesOfWorkingDays.DeleteAllTimeTables();
	     		for(String group : studentGroupList)
	     		{
	     		
	     			Platform.runLater(new Runnable()
					{

						@Override
						public void run() {
							recreatePane();
							
						}
						  
					});
	     			
	     			ResultSet set = DatabaseHandler_Lecturers.getAllSessionsFilterByGroup(group);
	     			try
	     			{
	     				while(set.next())
	     				{
	     					int sessionId = set.getInt("sessionId");
	     					String lecturerName = set.getString("LecturerName");
	     					int duration = set.getInt("Duration");
	     					String SubjectCode = set.getString("SubjectCode");
	     					String Tag = set.getString("Tag");
	     					String StudentGroup = set.getString("StudentGroup");
	     					int StuCount = set.getInt("StuCount");
	     					
	     					ResultSet res = DatabaseHandler_NotAvailbleTime.findByLecturerName(lecturerName);
	     					int count = 0;
	     					ArrayList<Integer> notAvaiableDays = new ArrayList<>();
	     					while(res.next())
	     					{
	     						int day = res.getInt("day");
	     						notAvaiableDays.add(day);
	     						count++;
	     					}
	     					
	     					
	     					if(count > 0)
	     					{
	     						//there are available days
	     						String venue = QueriesOfWorkingDays.getLocationName(sessionId);
	     						
	     						Cell cell = getACellWithoutTheseDays(notAvaiableDays);
	     						boolean ress = QueriesOfWorkingDays.addTimeTableRow(programType,
	     							lecturerName,
	     							SubjectCode,
	     							Tag,
	     							StudentGroup,
	     							StuCount,
	     							duration,
	     							venue,
	     							cell.getCellH(),
	     							cell.getCellV());
	     					
	     		
	     					}
	     					else
	     					{
	     						
	     						//there are no not available days
	     						Cell cell = getACellRandomly(duration);
	     						String venue = QueriesOfWorkingDays.getLocationName(sessionId);
	     						boolean ress = QueriesOfWorkingDays.addTimeTableRow(programType,
	     								lecturerName,
	     								SubjectCode,
	     								Tag,
	     								StudentGroup,
	     								StuCount,
	     								duration,
	     								venue,
	     								cell.getCellH(),
	     								cell.getCellV());
	     							
	     		    			
	     					}

	     				}
	     			} 
	     			catch (SQLException e)
	     			{
	     				e.printStackTrace();
	     			}
	     		}
	     		
	     		Platform.runLater(new Runnable()
				{

					@Override
					public void run() {
						progressDialogVBox.setVisible(false);
						showAlert("Time tables were successfully Generated");
						
					}
					  
				});
	     		
	     		
	         }
	     };
	     new Thread(r).start();
	
		
		
	}
	public Cell getACellRandomly(int duration)
	{
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, allCells.size());
		
		for(int i = 0; i < allCells.size(); i++)
		{
			if(i == randomNum)
			{
				Cell cell = allCells.get(i);
				allCells.remove(i);
				return cell;
			}
		}
		
		return null;
	}
//	public ArrayList<Cell> getRandomNearSlotsByDuration(int duration)
//	{
//		for(int i = 0; i < allCells.size(); i++)
//		{
//			Cell cell = allCells.get(i);
//			int j = (i + 1);
//			if(j < allCells.size()) 
//			{
//				Cell cell2 = allCells.get(j);
//				int firstCellV = cell.getCellV();
//				int secondcellV = cell2.getCellV();
//			
//				if(secondcellV == (firstCellV + 1))
//				{
//					ArrayList<Cell> list = new ArrayList<>();
//					list.add(cell);
//					list.add(cell2);
//					return list;
//				}
//			}
//		}
//		return null;
//	}
	public Cell getACellWithoutTheseDays(ArrayList<Integer> list)
	{
		
		ArrayList<Cell> newList = new ArrayList<>(allCells);
		for(int i = 0; i < newList.size(); i++)
		{
			Cell cell = newList.get(i);
			for(int j = 0; j < list.size(); j++)
			{
				int day = list.get(j);
				if(cell.getCellH() == day)
				{
					newList.remove(i);
				}
			}
		}
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, newList.size());
		
		for(int i = 0; i < newList.size(); i++)
		{
			if(i == randomNum)
			{
				Cell cell = newList.get(i);
				//remove cell
				
				for(int x = 0; x < allCells.size(); x++)
				{
					Cell cell2 = allCells.get(x);
					if(cell.getCellH() == cell2.getCellH() && cell.getCellV() == cell2.getCellV())
					{
						allCells.remove(x);
					}
				}
				
				return cell;
			}
		}
		
		
		
		
		
//		for(int i = 0; i < allCells.size(); i++)
//		{
//			Cell cell = allCells.get(i);
//			int count = 0;
//			for(int j = 0; j < list.size(); j++)
//			{
//				int day = list.get(j);
//				if(cell.getCellH() != day)
//				{
//					count++;
//				}
//				
//				if(j == list.size() - 1)
//				{
//					if(count == list.size())
//					{
//						allCells.remove(i);
//						return cell;
//					}
//				}
//			}
//			
//		}
		return null;
	}
	public void onPrintButtonWasClicked(ActionEvent event)
	{
		WritableImage image = timetablegrid.snapshot(new SnapshotParameters(), null);

		File file = new File("Time_Table.png");

		try
		{
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
			showAlert("Successfully printed the timetable");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			showAlert("Something went wrong!");
		}

	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.show();
	}
	public void showProgressDialog(AnchorPane pane)
	{
	
		 ProgressIndicator pi = new ProgressIndicator();
		 progressDialogVBox = new VBox(pi);
		 progressDialogVBox.setAlignment(Pos.CENTER);
         
		 AnchorPane.setTopAnchor(progressDialogVBox, 0.0);
		 AnchorPane.setRightAnchor(progressDialogVBox, 0.0);
		 AnchorPane.setLeftAnchor(progressDialogVBox, 0.0);
		 AnchorPane.setBottomAnchor(progressDialogVBox, 0.0);
         pane.getChildren().add(progressDialogVBox);
         
	}

}
