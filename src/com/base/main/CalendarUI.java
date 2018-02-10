package com.base.main;

import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CalendarUI extends Application
{
	@FXML private Label lblCurrentMonth;
	@FXML private Label lblCurrentDate;
	private Image arrow = new Image(getClass().getResourceAsStream("Arrow.png"));
	@FXML private ImageView btnMonthLeft;
	@FXML private ImageView btnMonthRight;

	private Label[][] calendarDateLabels = new Label[6][7];
	@FXML private Label lblDay56;
	@FXML private Label lblDay55;
	@FXML private Label lblDay54;
	@FXML private Label lblDay53;
	@FXML private Label lblDay52;
	@FXML private Label lblDay51;
	@FXML private Label lblDay50;
	@FXML private Label lblDay46;
	@FXML private Label lblDay45;
	@FXML private Label lblDay44;
	@FXML private Label lblDay43;
	@FXML private Label lblDay42;
	@FXML private Label lblDay41;
	@FXML private Label lblDay40;
	@FXML private Label lblDay36;
	@FXML private Label lblDay35;
	@FXML private Label lblDay34;
	@FXML private Label lblDay33;
	@FXML private Label lblDay32;
	@FXML private Label lblDay31;
	@FXML private Label lblDay30;
	@FXML private Label lblDay26;
	@FXML private Label lblDay25;
	@FXML private Label lblDay24;
	@FXML private Label lblDay23;
	@FXML private Label lblDay22;
	@FXML private Label lblDay21;
	@FXML private Label lblDay20;
	@FXML private Label lblDay16;
	@FXML private Label lblDay15;
	@FXML private Label lblDay14;
	@FXML private Label lblDay13;
	@FXML private Label lblDay12;
	@FXML private Label lblDay11;
	@FXML private Label lblDay10;
	@FXML private Label lblDay06;
	@FXML private Label lblDay05;
	@FXML private Label lblDay04;
	@FXML private Label lblDay03;
	@FXML private Label lblDay02;
	@FXML private Label lblDay01;
	@FXML private Label lblDay00;

	private Rectangle[][] calendarDateBoxes = new Rectangle[6][7];
	@FXML private Rectangle boxDay56;
	@FXML private Rectangle boxDay55;
	@FXML private Rectangle boxDay54;
	@FXML private Rectangle boxDay53;
	@FXML private Rectangle boxDay52;
	@FXML private Rectangle boxDay51;
	@FXML private Rectangle boxDay50;
	@FXML private Rectangle boxDay46;
	@FXML private Rectangle boxDay45;
	@FXML private Rectangle boxDay44;
	@FXML private Rectangle boxDay43;
	@FXML private Rectangle boxDay42;
	@FXML private Rectangle boxDay41;
	@FXML private Rectangle boxDay40;
	@FXML private Rectangle boxDay36;
	@FXML private Rectangle boxDay35;
	@FXML private Rectangle boxDay34;
	@FXML private Rectangle boxDay33;
	@FXML private Rectangle boxDay32;
	@FXML private Rectangle boxDay31;
	@FXML private Rectangle boxDay30;
	@FXML private Rectangle boxDay26;
	@FXML private Rectangle boxDay25;
	@FXML private Rectangle boxDay24;
	@FXML private Rectangle boxDay23;
	@FXML private Rectangle boxDay22;
	@FXML private Rectangle boxDay21;
	@FXML private Rectangle boxDay20;
	@FXML private Rectangle boxDay16;
	@FXML private Rectangle boxDay15;
	@FXML private Rectangle boxDay14;
	@FXML private Rectangle boxDay13;
	@FXML private Rectangle boxDay12;
	@FXML private Rectangle boxDay11;
	@FXML private Rectangle boxDay10;
	@FXML private Rectangle boxDay06;
	@FXML private Rectangle boxDay05;
	@FXML private Rectangle boxDay04;
	@FXML private Rectangle boxDay03;
	@FXML private Rectangle boxDay02;
	@FXML private Rectangle boxDay01;
	@FXML private Rectangle boxDay00;

	@FXML private ListView<String> listView;

	private String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	private String[] days = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

	private int[] currentDate = {0, 0, 0}; // (Month/Day/Year)
	private int[] selectedDate = {0, 0, 0};

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("/CalendarUI.fxml")); // You might have to change this to "\\Calendar.fxml"
		load.setController(this);
		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		btnMonthLeft.setImage(arrow);
		btnMonthRight.setImage(arrow);

		stage.setTitle("Calendar");
		stage.setScene(scene);
		stage.show();
		setupCalendarBoxes();
		setCurrDate();
		changeMonth();
		initializeListeners();
	}

	private void setupCalendarBoxes()
	{
		calendarDateLabels[0][0] = lblDay00;
		calendarDateLabels[0][1] = lblDay01;
		calendarDateLabels[0][2] = lblDay02;
		calendarDateLabels[0][3] = lblDay03;
		calendarDateLabels[0][4] = lblDay04;
		calendarDateLabels[0][5] = lblDay05;
		calendarDateLabels[0][6] = lblDay06;
		calendarDateLabels[1][0] = lblDay10;
		calendarDateLabels[1][1] = lblDay11;
		calendarDateLabels[1][2] = lblDay12;
		calendarDateLabels[1][3] = lblDay13;
		calendarDateLabels[1][4] = lblDay14;
		calendarDateLabels[1][5] = lblDay15;
		calendarDateLabels[1][6] = lblDay16;
		calendarDateLabels[2][0] = lblDay20;
		calendarDateLabels[2][1] = lblDay21;
		calendarDateLabels[2][2] = lblDay22;
		calendarDateLabels[2][3] = lblDay23;
		calendarDateLabels[2][4] = lblDay24;
		calendarDateLabels[2][5] = lblDay25;
		calendarDateLabels[2][6] = lblDay26;
		calendarDateLabels[3][0] = lblDay30;
		calendarDateLabels[3][1] = lblDay31;
		calendarDateLabels[3][2] = lblDay32;
		calendarDateLabels[3][3] = lblDay33;
		calendarDateLabels[3][4] = lblDay34;
		calendarDateLabels[3][5] = lblDay35;
		calendarDateLabels[3][6] = lblDay36;
		calendarDateLabels[4][0] = lblDay40;
		calendarDateLabels[4][1] = lblDay41;
		calendarDateLabels[4][2] = lblDay42;
		calendarDateLabels[4][3] = lblDay43;
		calendarDateLabels[4][4] = lblDay44;
		calendarDateLabels[4][5] = lblDay45;
		calendarDateLabels[4][6] = lblDay46;
		calendarDateLabels[5][0] = lblDay50;
		calendarDateLabels[5][1] = lblDay51;
		calendarDateLabels[5][2] = lblDay52;
		calendarDateLabels[5][3] = lblDay53;
		calendarDateLabels[5][4] = lblDay54;
		calendarDateLabels[5][5] = lblDay55;
		calendarDateLabels[5][6] = lblDay56;

		calendarDateBoxes[0][0] = boxDay00;
		calendarDateBoxes[0][1] = boxDay01;
		calendarDateBoxes[0][2] = boxDay02;
		calendarDateBoxes[0][3] = boxDay03;
		calendarDateBoxes[0][4] = boxDay04;
		calendarDateBoxes[0][5] = boxDay05;
		calendarDateBoxes[0][6] = boxDay06;
		calendarDateBoxes[1][0] = boxDay10;
		calendarDateBoxes[1][1] = boxDay11;
		calendarDateBoxes[1][2] = boxDay12;
		calendarDateBoxes[1][3] = boxDay13;
		calendarDateBoxes[1][4] = boxDay14;
		calendarDateBoxes[1][5] = boxDay15;
		calendarDateBoxes[1][6] = boxDay16;
		calendarDateBoxes[2][0] = boxDay20;
		calendarDateBoxes[2][1] = boxDay21;
		calendarDateBoxes[2][2] = boxDay22;
		calendarDateBoxes[2][3] = boxDay23;
		calendarDateBoxes[2][4] = boxDay24;
		calendarDateBoxes[2][5] = boxDay25;
		calendarDateBoxes[2][6] = boxDay26;
		calendarDateBoxes[3][0] = boxDay30;
		calendarDateBoxes[3][1] = boxDay31;
		calendarDateBoxes[3][2] = boxDay32;
		calendarDateBoxes[3][3] = boxDay33;
		calendarDateBoxes[3][4] = boxDay34;
		calendarDateBoxes[3][5] = boxDay35;
		calendarDateBoxes[3][6] = boxDay36;
		calendarDateBoxes[4][0] = boxDay40;
		calendarDateBoxes[4][1] = boxDay41;
		calendarDateBoxes[4][2] = boxDay42;
		calendarDateBoxes[4][3] = boxDay43;
		calendarDateBoxes[4][4] = boxDay44;
		calendarDateBoxes[4][5] = boxDay45;
		calendarDateBoxes[4][6] = boxDay46;
		calendarDateBoxes[5][0] = boxDay50;
		calendarDateBoxes[5][1] = boxDay51;
		calendarDateBoxes[5][2] = boxDay52;
		calendarDateBoxes[5][3] = boxDay53;
		calendarDateBoxes[5][4] = boxDay54;
		calendarDateBoxes[5][5] = boxDay55;
		calendarDateBoxes[5][6] = boxDay56;
	}

	private void initializeListeners()
	{
		// TODO Add button functionality
	}

	private void setCurrDate()
	{
		String temp = LocalDateTime.now().toString();
		System.out.println(temp);
		currentDate[2] = Integer.parseInt(temp.substring(0, 4)); // Year
		currentDate[1] = Integer.parseInt(temp.substring(8, 10)); // Day
		currentDate[0] = Integer.parseInt(temp.substring(5, 7)); // Month
		for(int i = 0; i < 3; i++)
		{
			selectedDate[i] = currentDate[i];
		}
	}

	private void changeMonth()
	{
		int day = selectedDate[1];
		int month = selectedDate[0] - 2;
		if(month <= 0)
			month += 12;
		int year = selectedDate[2] % 100;
		if(month >= 11)
			year--;
		int century = selectedDate[2] / 100;

		int dayOfTheWeek = (day + (int) Math.floor((2.6 * month) - 0.2) + year + (year / 4) + (century / 4) - (2 * century)) % 7;
		System.out.println(days[dayOfTheWeek]);

		int[][] calendarDates = new int[6][7];
		int prevMonthDays;
		if(currentDate[0] == 1)
			prevMonthDays = getAmtOfDays(12);
		else
			prevMonthDays = getAmtOfDays(currentDate[0] - 1);
		for(int dayCal = 0; dayCal < 7; dayCal++) // Do first row
		{
			calendarDates[0][dayCal] = (prevMonthDays - dayOfTheWeek + dayCal) % prevMonthDays + 1;
		}
		int dayIndex = (prevMonthDays - dayOfTheWeek + 7) % prevMonthDays;
		int currMonthDays = getAmtOfDays(currentDate[0]);
		for(int rowCal = 1; rowCal < 6; rowCal++)
		{
			for(int dayCal = 0; dayCal < 7; dayCal++)
			{
				calendarDates[rowCal][dayCal] = (dayIndex) % currMonthDays + 1;
				dayIndex++;
			}
		}
		populateCalendar(calendarDates);
	}

	private int getAmtOfDays(int m)
	{
		if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			return 31;
		else if(m == 2)
		{
			if(currentDate[2] % 4 == 0 && currentDate[2] % 100 == 0 && currentDate[2] % 400 == 0)
				return 29;
			else
				return 28;
		}
		else
			return 30;
	}

	private void populateCalendar(int[][] calendarDates)
	{
		Platform.runLater(() -> {
			String currMonthLabel = months[currentDate[0]-1];
			lblCurrentMonth.setText(currMonthLabel);

			String currDateLabel = months[currentDate[0]-1] + " " + currentDate[1] + ", " + currentDate[2];
			lblCurrentDate.setText(currDateLabel);

			boolean hitFirst = false;
			for(int rowCal = 0; rowCal < 6; rowCal++)
			{
				for(int dayCal = 0; dayCal < 7; dayCal++)
				{
					if(calendarDates[rowCal][dayCal] == 1)
						hitFirst = !hitFirst;
					if(!hitFirst)
						calendarDateBoxes[rowCal][dayCal].setFill(Color.web("#5a5a5a"));
					else if(calendarDates[rowCal][dayCal] == currentDate[1])
						calendarDateBoxes[rowCal][dayCal].setFill(Color.BLUE);
					else
						calendarDateBoxes[rowCal][dayCal].setFill(Color.web("#d9d9d9"));
					System.out.println(calendarDates[rowCal][dayCal]);
					calendarDateLabels[rowCal][dayCal].setText("" + calendarDates[rowCal][dayCal]);
				}
			}
		});
	}
}
