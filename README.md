# Hospital Management Spring Boot App

This is a simple Spring Boot application that simulates a basic hospital management system. It demonstrates the use of JPA for entity relationships, service layers, and repository access in a real-world scenario.

## Features

- Patient registration  
- Doctor (Medecin) registration  
- Appointment (Rendez-vous) management  
- Consultation recording  
- Sample data initialization with CommandLineRunner

## Technologies Used

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- H2 In-Memory Database  
- Maven  
- IntelliJ IDEA

## How to Run

### 1. Clone the Project


git clone https://github.com/your-username/hospital-app.git
cd hospital-app


### 2. Open in IntelliJ IDEA

* Open IntelliJ
* Choose "Open" and select the project folder
* Wait for Maven to download dependencies

### 3. Run the Application

* Navigate to `HospitalApplication.java`
* Right-click and choose **Run 'HospitalApplication'**

## Access H2 Console

* URL: [http://localhost:8083/h2-console]

Use the following credentials:

* JDBC URL: `jdbc:h2:mem:testdb`
* User: `sa`
* Password: *(leave it blank)*

## Database Structure

### Tables in H2 Console:

**1. PATIENT**
Contains basic patient data such as name, birth date, and illness status.

**2. MEDECIN**
Holds doctors' information including name, email, and specialty.

**3. RENDEZ\_VOUS**
Represents appointments connecting patients and doctors.

**4. CONSULTATION**
Stores consultation details linked to a specific appointment.

## Screenshots of the Database

Place the following images in a folder named `screenshots/`:

* `screenshots/patient-table.png`
* `screenshots/medecin-table.png`
* `screenshots/rendezvous-table.png`
* `screenshots/consultation-table.png`

Example:


![Patient Table](screenshots/patient-table.png)


## Sample Data Inserted at Startup

* Patients: Fatima, Med, Zineb
* Doctors: Aziz, Dania, Khadija
* One appointment created between Aziz and Fatima
* One consultation created for the appointment

## Domain Model Overview

| Entity       | Fields                                    |
| ------------ | ----------------------------------------- |
| Patient      | id, nom, dateNaissance, malade            |
| Medecin      | id, nom, email, specialite                |
| RendezVous   | id, date, status, patient, medecin        |
| Consultation | id, dateConsultation, rapport, rendezVous |

## Author

Fatima
[LinkedIn Profile](https://www.linkedin.com/in/fatima-al-b11039263/)
