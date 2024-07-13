# Dans Android App

This repository contains the source code for the Dans Android App, following the MVVM architecture principles.

## Overview App

[![Overview](https://github.com/user-attachments/assets/52a72698-a287-49e2-90a0-b6a694222f6a)](https://drive.google.com/file/d/1mLZ-kFPKrtZtrYzVTlwUUKA4TxbvPJcZ/view?usp=sharing)

[Watch video](https://drive.google.com/file/d/1mLZ-kFPKrtZtrYzVTlwUUKA4TxbvPJcZ/view?usp=sharing)

## MVVM Architecture

This project is structured using the MVVM (Model-View-ViewModel) architecture pattern, which separates the user interface logic from the business logic. I use this pattern for simple API calls

[MVVM base patter](https://github.com/emedinaa/kotlin-mvvm)
### Requirements

To run the Dans Android App, you need the following:

- Android Studio
- Android SDK
- Kotlin
- Internet connection for API calls

## Get Started

### Clone the Project

To get started with the Dans Android App, clone the repository to your local machine using the following command:

```
git clone https://github.com/Ahmadyogaw/danstestapp.git
```
### Open the project in Android Studio
Open Android Studio and select File -> Open and navigate to the directory where you cloned the repository. Select the Dans_android folder to open the project.

## Setup

### Firebase Setup

1. **Add Firebase to your Android project:**
   - Go to the [Firebase Console](https://console.firebase.google.com/).
   - Click on `Add project` and follow the setup steps.
   - Register your app with the package name.

2. **Download `google-services.json`:**
   - Download the `google-services.json` file provided by Firebase.
   - Place the `google-services.json` file in the `app` directory of your Android project.

### Setup Project
- **Setup JKS File** : create your jks file then add the credentials to `gradle.properties`
- **Setup properties** : add properties `googleClentID` from `firebase` and `baseUrl` on `gradle.properties` file 

### Build the project
Once the project is open, let Android Studio download the necessary dependencies. You can do this by clicking on File -> Sync Project with Gradle Files.

### Run the app
Connect an Android device or use an emulator to run the app. Click on the Run button in Android Studio to build and run the app.

### Features
- **Sign in with Google**
- **Job List**: Displays a list of jobs with details such as title, company, and location.
- **Job Detail**: View detailed information about a specific job, including a detailed description.
