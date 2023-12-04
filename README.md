# Learning Management System (LMS)
This project is a ___learning management system (LMS)___ that allows users to create, enroll, and complete online courses. The LMS is built with ___JavaFX___ for FrontEnd and ___MySQL___ for DataBase. The LMS has the following features:

- User authentication and authorization with different roles (admin, instructor, student)
- Course creation and management with various content types (text, video, quiz, etc.)
- Course enrollment and progress tracking with certificates
- Course rating and feedback system
- Dashboard and analytics for users and admins

## Software Requirements Specification (SRS)

<details>
  <summary> 1. User Privilages </summary>
  
  <br/>There are 3 types of users in the LMS: 
    <br/> - Admins (University | Colleges | Schools) :
            - Has an Admin account
            - Can issue courses to students 
            - Has the access to accounts of Instructors
            - Has the access to accounts of Students
            - Manage the courses in each of the categories
    <br/> - Super Users (Instructors | Faculties) :
            - Can have super user account
            - An Instructor will be able to create courses
            - Can view all the category of courses
            - Can view the no.of courses in each category
            - Can view the reviews of their courses
            - Can edit their courses
            - Can post some quiz and assignments
    <br/> - Users (Students) :
            - Can have a user account
            - Can get lifetime access to any courses
            - Have access to their dashboards
            - Can add ratings and reviews to the courses after completion
            - Receive a Certificate of completion
            - Can search for a required course
            - Can attend the quiz and complete the assesments
</details>
<details>
  <summary> 2. Operating Environment </summary>

  <br/> ___Software Configurations___
  - The product will be operating in windows environment. 
  - The Learning Management System is a website and shall operate in all famous browsers like Microsoft Internet Explorer,Google Chrome,and Mozilla Firefox.
  - Also it will be compatible with the IE 6.0. Most of the features will be compatible with the Mozilla Firefox & Opera 7.0 or higher version.
  - The only requirement to use this online product would be the internet connection.  
  
  ___The hardware configuration___
  - _Storage :_ Hard Disk: 40 GB .
  - _Input Devices :_ Keyboard: 122 keys, mouse ...
  - _Output Devices:_ Monitor: 15” Color monitor, printer ...

</details>
<details>
  <summary> 3. Assumptions and Dependencies </summary>

<br/>Assumptions : 
- The coding should be error free
- The system should be user-friendly so that it is easy to use for the users
- The information of all users, courses and certifications must be stored in a database that is 
accessible by the website
- The system should have more storage capacity and provide fast access to the database
- The system should provide search facility and support quick transactions
- Users may access from any computer that has Internet browsing capabilities and an 
Internet connection
- Users must have their correct usernames and passwords to enter into their online accounts 
and do actions

Dependencies : 
- The specific hardware and software due to which the product will be run
- On the basis of listing requirements and specification the project will be developed and 
run
- The admins should have proper understanding of the product
- The information of all the users must be stored in a database that is accessible by the 
LMS
- Any update regarding the Certificates from the courses is to be recorded to the database and the
data entered should be correct
</details>
