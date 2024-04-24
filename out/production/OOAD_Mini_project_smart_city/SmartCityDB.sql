CREATE DATABASES SmartCityDB;
-- DROP DATABASE SmartCityDB;
USE SmartCityDB;

CREATE TABLE AccountDetails (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50),
    email_id VARCHAR(100),
    phone_number VARCHAR(20)
);

CREATE TABLE Student (
    location VARCHAR(100),
    field_of_interest VARCHAR(100),
    college_name VARCHAR(100),
    libraries_name VARCHAR(100)
);

CREATE TABLE Transport (
    transport_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25),
    pick_up_location VARCHAR(100),
    drop_off_location VARCHAR(100),
    car_number_plate VARCHAR(20)
);

CREATE TABLE Jobs (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(100),
    field_of_interest VARCHAR(100),
    job_opportunity VARCHAR(100),
    employer VARCHAR(100),
    description TEXT,
    salary DECIMAL(10, 2)
);

SHOW TABLES;
DROP TABLE Student;

INSERT INTO AccountDetails (username, password, email_id, phone_number) 
VALUES 
('john_doe', 'password1', 'john.doe@gmail.com', '1234567890'),
('jane_smith', 'password2', 'jane.smith@gmail.com', '0987654321'),
('michael_jackson', 'password3', 'michael.jackson@gmail.com', '1112223333'),
('sarah_connor', 'password4', 'sarah.connor@gmail.com', '4445556666'),
('elon_musk', 'password5', 'elon.musk@gmail.com', '7778889999'),
('marie_curie', 'password6', 'marie.curie@gmail.com', '1231231234'),
('albert_einstein', 'password7', 'albert.einstein@gmail.com', '4564564567'),
('ada_lovelace', 'password8', 'ada.lovelace@gmail.com', '9876543210'),
('charles_darwin', 'password9', 'charles.darwin@gmail.com', '3216549870'),
('nikola_tesla', 'password10', 'nikola.tesla@gmail.com', '5555555555'),
('maria_mitchell', 'password11', 'maria.mitchell@gmail.com', '6666666666'),
('alan_turing', 'password12', 'alan.turing@gmail.com', '7777777777'),
('grace_hopper', 'password13', 'grace.hopper@gmail.com', '8888888888'),
('roberta_bondar', 'password14', 'roberta.bondar@gmail.com', '9999999999'),
('neil_armstrong', 'password15', 'neil.armstrong@gmail.com', '1010101010'),
('amelia_earhart', 'password16', 'amelia.earhart@gmail.com', '2020202020'),
('steve_jobs', 'password17', 'steve.jobs@gmail.com', '3030303030'),
('bill_gates', 'password18', 'bill.gates@gmail.com', '4040404040'),
('mark_zuckerberg', 'password19', 'mark.zuckerberg@gmail.com', '5050505050'),
('tim_cook', 'password20', 'tim.cook@gmail.com', '6060606060');

INSERT INTO Student (location, field_of_interest, college_name, libraries_name) 
VALUES 
('New York', 'Computer Science', 'NYU', 'NYU Library'),
('Los Angeles', 'Engineering', 'UCLA', 'UCLA Library'),
('Chicago', 'Biology', 'University of Chicago', 'UChicago Library'),
('Boston', 'Business Administration', 'Harvard University', 'Harvard Library'),
('Seattle', 'Environmental Science', 'University of Washington', 'UW Library'),
('New York', 'Computer Science', 'Columbia University', 'Columbia Library'),
('Los Angeles', 'Engineering', 'California Institute of Technology', 'Caltech Library'),
('Chicago', 'Biology', 'Northwestern University', 'NU Library'),
('Boston', 'Business Administration', 'Boston University', 'BU Library'),
('Seattle', 'Environmental Science', 'Seattle University', 'SU Library'),
('San Francisco', 'Art History', 'San Francisco State University', 'SFSU Library'),
('Miami', 'Psychology', 'University of Miami', 'UM Library'),
('Austin', 'Sociology', 'University of Texas at Austin', 'UT Library'),
('Philadelphia', 'History', 'University of Pennsylvania', 'UPenn Library'),
('Houston', 'Political Science', 'Rice University', 'Rice Library'),
('Denver', 'Physics', 'University of Denver', 'UDenver Library'),
('Atlanta', 'Mathematics', 'Georgia Institute of Technology', 'Georgia Tech Library'),
('Phoenix', 'Chemistry', 'Arizona State University', 'ASU Library'),
('Portland', 'English Literature', 'Portland State University', 'PSU Library'),
('San Diego', 'Nursing', 'University of California, San Diego', 'UCSD Library'),
('Detroit', 'Communications', 'Wayne State University', 'Wayne State Library'),
('Minneapolis', 'Public Health', 'University of Minnesota', 'UMN Library'),
('Charlotte', 'Music', 'University of North Carolina at Charlotte', 'UNC Charlotte Library'),
('Las Vegas', 'Criminal Justice', 'University of Nevada, Las Vegas', 'UNLV Library'),
('Salt Lake City', 'Economics', 'University of Utah', 'UUtah Library'),
('New York', 'Computer Science', 'Fordham University', 'Fordham Library'),
('Los Angeles', 'Engineering', 'University of Southern California', 'USC Library'),
('Chicago', 'Biology', 'Loyola University Chicago', 'Loyola Library'),
('Boston', 'Business Administration', 'Northeastern University', 'Northeastern Library'),
('Seattle', 'Environmental Science', 'University of Puget Sound', 'UPS Library');

-- Dummy data for Transport table
INSERT INTO Transport (name, pick_up_location, drop_off_location, car_number_plate) 
VALUES 
('John', '123 Main St', '456 Oak Ave', 'ABC123'),
('Alice', '789 Elm St', '321 Pine Ave', 'XYZ789'),
('Bob', '111 Maple St', '222 Cedar Ave', 'LMN456'),
('Eva', '333 Walnut St', '444 Birch Ave', 'PQR789'),
('Mike', '555 Pine St', '666 Elm Ave', 'STU123'),
('Sarah', '777 Oak St', '888 Maple Ave', 'VWX456'),
('David', '999 Cedar St', '000 Walnut Ave', 'YZA789'),
('Emily', '101112 Birch St', '131415 Pine Ave', 'BCD123'),
('James', '161718 Elm St', '192021 Oak Ave', 'EFG456'),
('Lily', '222324 Maple St', '252627 Cedar Ave', 'HIJ789'),
('Tom', '282930 Walnut St', '313233 Birch Ave', 'KLM123'),
('Grace', '343536 Pine St', '373839 Elm Ave', 'NOP456'),
('Chris', '404142 Oak St', '434445 Maple Ave', 'QRS789'),
('Emma', '464748 Cedar St', '495051 Walnut Ave', 'TUV123'),
('Daniel', '525354 Birch St', '555657 Pine Ave', 'WXY456'),
('Sophia', '565758 Elm St', '596061 Oak Ave', 'ZAB789'),
('Michael', '626364 Maple St', '656667 Cedar Ave', 'CDE123'),
('Olivia', '686970 Walnut St', '717273 Birch Ave', 'FGH456'),
('Jacob', '747576 Pine St', '777879 Elm Ave', 'IJK123'),
('Ava', '808182 Oak St', '838485 Maple Ave', 'LMN789');

-- Dummy data for Jobs table
INSERT INTO Jobs (location, field_of_interest, job_opportunity, employer, description, salary) 
VALUES 
('San Francisco', 'Software Development', 'Software Engineer', 'Google', 'Exciting opportunity to work on cutting-edge projects.', 100000.00),
('Seattle', 'Data Science', 'Data Analyst', 'Microsoft', 'Join our team and make an impact with data-driven insights.', 90000.00),
('New York', 'Marketing', 'Marketing Manager', 'Facebook', 'Lead marketing campaigns and drive brand awareness.', 95000.00),
('Los Angeles', 'Graphic Design', 'Graphic Designer', 'Apple', 'Design stunning visuals for our products and marketing materials.', 85000.00),
('Chicago', 'Human Resources', 'HR Specialist', 'Amazon', 'Support HR functions and foster a positive work environment.', 80000.00),
('Boston', 'Finance', 'Financial Analyst', 'IBM', 'Analyze financial data and contribute to strategic decision-making.', 85000.00),
('Houston', 'Healthcare', 'Nurse Practitioner', 'Kaiser Permanente', 'Provide compassionate care to patients and support healthcare teams.', 90000.00),
('Denver', 'Architecture', 'Architect', 'Tesla', 'Design innovative and sustainable architectural solutions.', 110000.00),
('Atlanta', 'Customer Service', 'Customer Support Specialist', 'Netflix', 'Deliver exceptional customer service and resolve inquiries.', 75000.00),
('Miami', 'Hospitality', 'Hotel Manager', 'Marriott International', 'Oversee hotel operations and ensure guest satisfaction.', 95000.00),
('Phoenix', 'Education', 'Teacher', 'K12 Inc.', 'Inspire and educate students in a dynamic online learning environment.', 70000.00),
('Portland', 'Public Relations', 'PR Coordinator', 'Twitter', 'Manage media relations and promote positive brand image.', 80000.00),
('Dallas', 'Sales', 'Sales Representative', 'Salesforce', 'Drive revenue growth and cultivate client relationships.', 90000.00),
('San Diego', 'Biotechnology', 'Research Scientist', 'Genentech', 'Conduct groundbreaking research to advance medical science.', 120000.00),
('Detroit', 'Manufacturing', 'Production Supervisor', 'General Motors', 'Oversee production processes and ensure quality standards.', 85000.00),
('Minneapolis', 'Supply Chain', 'Logistics Coordinator', 'UPS', 'Coordinate transportation and distribution operations.', 75000.00),
('Charlotte', 'Law', 'Attorney', 'Wells Fargo', 'Provide legal counsel and support corporate legal initiatives.', 110000.00),
('Las Vegas', 'Entertainment', 'Event Coordinator', 'Disney', 'Plan and execute memorable events and experiences.', 80000.00),
('Salt Lake City', 'Engineering', 'Civil Engineer', 'Boeing', 'Design infrastructure projects and ensure compliance with regulations.', 100000.00),
('Philadelphia', 'Research', 'Research Assistant', 'Johnson & Johnson', 'Assist in research projects and data analysis.', 70000.00);

-- SELECT * FROM AccountDetails;