Event Volunteer Scheduling System:
📌 Project Overview

This is a console-based Java application developed using JDBC and Oracle Database to manage event volunteers, shifts, and attendance tracking.
The system maintains clear separation between:
Master Data (Volunteers & Shifts)
Transactional Data (Assignments & Attendance)
It enforces real-world business rules such as preventing overlapping shift assignments and restricting deletion when active assignments exist.

🚀 Key Features

Register new volunteers
View volunteer details and history
Create and manage event shifts
Assign volunteers to shifts (transactional operation)
Prevent overlapping shift assignments
Mark attendance (PRESENT / ABSENT)
Prevent deletion of volunteers/shifts with active assignments
Transaction management using JDBC (commit / rollback)

🛠️ Tech Stack

Java (Core Java)
JDBC
Oracle Database
SQL*Plus
Console-based User Interface
Layered Architecture (DAO + Service + Bean + Util)

🗄️ Database Design
The system consists of three main tables:

1️⃣ VOLUNTEER_TBL

Stores volunteer details including:
Volunteer ID (Primary Key)
Name
Skill Category
Phone
Email
Status (ACTIVE / INACTIVE)

2️⃣ SHIFT_TBL

Stores shift configuration:
Shift ID (Primary Key)
Shift Date
Start & End Time
Location
Required Headcount
Status (OPEN_FOR_ASSIGNMENT, CLOSED, etc.)

3️⃣ ASSIGNMENT_TBL

Stores volunteer-shift relationships:
Assignment ID (Primary Key)
Volunteer ID (Foreign Key)
Shift ID (Foreign Key)
Assigned Role
Attendance Status (PENDING / PRESENT / ABSENT)
Check-in & Check-out Time
Relational integrity is maintained using foreign key constraints.

Output Console:
Database Output Example:

<img width="940" height="193" alt="image" src="https://github.com/user-attachments/assets/b25774c9-37f1-470a-8320-802524b7af94" />

1.	Volunteer Table created:
   <img width="940" height="193" alt="image" src="https://github.com/user-attachments/assets/dfb879da-223a-4847-910c-6cd79b060bb5" />

 
2.	Shit_table updated:
   <img width="940" height="147" alt="image" src="https://github.com/user-attachments/assets/639c942d-07c7-4b6e-9095-b2bfe652872a" />

 
3.	Assignment table updated:
   <img width="940" height="146" alt="image" src="https://github.com/user-attachments/assets/29e399a8-9ba9-4bb4-8dd6-67299f1fc5ad" />

 






















.

Volunteers cannot be deleted if they have active assignments.

Shifts cannot be removed if assignments are pending.

All multi-step operations are handled using JDBC transactions.
