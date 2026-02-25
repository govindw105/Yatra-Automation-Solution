✈️ Yatra Calendar Price Automation

📌 Project Overview

This project automates the departure date calendar functionality of the Yatra flight booking website using Selenium WebDriver with Java.

The automation script:

Opens Yatra website

Handles notification popup

Clicks on Departure Date calendar

Extracts lowest flight price from:

Current month

Next month

Compares the lowest price between the two months

Prints which month has the cheaper flight option

The entire automation logic is implemented using Selenium WebDriver with explicit waits and dynamic element handling.

🛠️ Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Browser: ChromeDriver

Browser Options: ChromeOptions (notifications disabled)

Synchronization: WebDriverWait (Explicit Waits)

Build Tool: Maven

Version Control: Git & GitHub

🧪 Functional Flow Automated

Launch Yatra website

Close notification popup

Click on Departure Date input field

Capture calendar months (Current & Next)

Extract all visible prices for each month

Identify the lowest price in each month

Compare both months’ lowest prices

Display which month offers the cheapest flight

⚙️ Key Automation Concepts Implemented
✅ Explicit Waits

Used WebDriverWait with ExpectedConditions to synchronize dynamic elements.

✅ Handling Calendar Components

Captured multiple month containers using index-based selection.

✅ Dynamic Price Extraction

Extracted price values dynamically from calendar

Removed currency symbol (₹) and commas

Converted string values to integers for comparison

✅ Data Processing & Comparison Logic

Used loop to find minimum value

Implemented custom method to compare prices

Printed meaningful comparison result

✅ Modular Method Structure

Separated logic into reusable methods:

clickOnPopup()

clickOnDepartureButton()

selectTheMonthFromCalendar()

getMeLowestPrice()

compareTwoMonthPrice()

This improves readability and maintainability.

📂 Project Structure
src/main/java → Contains automation class
pom.xml       → Maven dependencies
▶️ How to Run

Clone the repository

Open in IntelliJ / Eclipse

Install Maven dependencies

Run the main class

🎯 Learning Outcomes

Handling dynamic calendar UI components

Extracting and transforming UI text data

Implementing minimum value logic

Writing modular Selenium automation methods

Working with dynamic XPath and WebElements

Performing real-time price comparison using Java
