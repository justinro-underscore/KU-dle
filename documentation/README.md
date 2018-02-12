# <a name="Title"><a/>KU-dle

Dependencies:
[gson](https://github.com/google/gson) __|__
[gson-javatime-serialisers](https://github.com/gkopff/gson-javatime-serialisers) __|__
[e(fx)clipse by eclipse](https://www.eclipse.org/efxclipse/install.html) __|__
[scenebuilder by gluon](http://gluonhq.com/products/scene-builder/)

EECS 448 Project 1 by Team 4
Team Memebers:
  * Justin Roderman
  * Varun Chada
  * Harrison Luo
  * Alex Kuntz
  * Noah Brabec

## <a name="Overview"><a/>Project Overview
KU-dle is a scheduling program, similar to Doodle poll. It allows User's to view upcoming events and vote on the times that they are available.
## Installation
You can run KU-dle one of two ways, either from an IDE, or from the jar file.
###Running From the Jar
To run KU-dle from a jar, first you must download the jar. You can do so by clicking [here](#https://www.dropbox.com/s/qok4ch3s5raarmv/KU_dle_jar.zip?dl=0). After downloading all you need to do is unzip the folder and click on the .jar file and voila! KU-dle should be running.
>If this is the first time you are running KU-dle please see [Creating Users](#CreatingUser)

 You might also notice that within the zip file there is a folder called "data". This folder is essential to program functionality and must be in the same folder as the .jar file.
###Running From an IDE
If you want to run KU-dle from an IDE first you will need an IDE. We like to use intelliJ which can be found [here](#https://www.jetbrains.com/idea/). After you download and setup your IDE of choice you will need to clone or import the project from our [github](#https://github.com/justinro-underscore/KU-dle). You will also need to download and add two dependencies to your IDE to make sure the project can run. The first one is the [gson jar](#https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.2) and the second one is the [gson serializer jar](#https://mvnrepository.com/artifact/com.fatboyindustrial.gson-javatime-serialisers/gson-javatime-serialisers/1.1.1). For both of these you'll want to download the .jar file and add it to your IDE.
>Adding dependencies to an IDE varies. If you are having trouble, try looking at the documentation of the IDE you are using.

## <a name="NormUser"><a/>Functionality for Normal Users
A Normal User is anyone using this program. They can view all of the events available on The Calendar gui and select what times they are available to attend. They will also be able to see how many people are available at the times open for an event. Normal Users do not have any admin privileges and therefore can not create or delete users and events.
### <a name="Login"><a/>Logging In
>Before logging in, you will need to obtain login credentials from your administrator. If you are an administrator and need to create a user, see [Creating Users](#CreatingUser).

When you open KU-dle you will be prompted with a login screen. Enter your provided username into the box marked "Username: <Your Username>" and your password marked "Password: <Your Password>". If you enter incorrect login information you will be prompted to try again. On a successful login attempt you will be presented with The Calendar.   
### <a name="TheCalendar"><a/>The Calendar
The calendar is the main interface and contains all of the information you will need about events on selected days. The current month is displayed at the very top of the screen. If you want to navigate to a different month there are arrows on either side of the months name. Clicking the arrow on the right will take you to the next month, and the arrow to the left will take you to the previous month. Below the name is the day by day breakdown of the month. To view any events on a given day simply click on that day and the events will appear on the left side of the screen. The day selected in delineated by that day being highlighted. After selecting a day and an event you will be able to select the times that you are available. Days apart of the current month are white, days outside of the current month are grayed out. If you click on one of the days that are grayed out it will take you to that days month.
### <a name="Voting"><a/>Voting for Events
Now that you have successfully navigated to a day and event that you want to vote on, its time to select the times that you're available. To do so first you need to select the event from the left side of the screen.
>If there are no events on the left side of the screen see [The Calendar](#TheCalendar) on how to navigate the gui.

After selecting the event you will be prompted will a list of times that the event is being held over. Simply check the times that you are available and click the "Accept Event" box and you're done. You can then either view other events to and vote on those or just log out.
## <a name="AdminUser"><a/>Functionality for Admin Users
Admin Users can do anything that a normal user can do plus Creating a new User, Deleting an existing user, Creating a new event, Creating a new Event, and Deleting an existing Event.
### <a name="CreatingUser"><a/>Creating Users
>To make the first admin user, you will have to login via the root user. The username is "root" and the password is "pass". After logging in and making an admin, you can logout and start using the program from that admin user.

To create a new user click the "Create User" button on the bottom left of the screen. A Screen will pop up with fields for a user name and a password. There is also a check box to select if the new user should be granted admin privileges or not. Usernames are unique, so if the username you selected is already taken it will not allow you add it and you'll have to pick another name.
### <a name="CreateEvent"><a/>Creating Events
To create a new event click the "Create Event" button. It will prompt you with a box to enter the name of the event, a description of the event, and the times that you want the event to be available on. Similar to usernames, event names are unique so if you enter a name that is already taken it will tell you to pick a different name.
