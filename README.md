# Mobile Phone Masts

This repository contains the source code for the Mobile Phone Mast Android app. The latest code can be found on the release/v1.0.x branch.

When launching the application for the first time the app will load Mobile Mast data from a CSV file inside the Asset resource directory and save to a database using Room. The next time the application is launched the data will be retrieved from the database instead of the CSV file (this is handled by the repository layer)

Clicking the Toggle Order button will toggle the table view between ascending and descending order based on the current rent column. Pressing the + floating button will take the user to an add mobile mast page where the user can add a new mobile mast to the database.

Throughout the project I was using GitFlow as a Git Strategy following TDD as a development process whilst architecting the project based on Google's recommended architecture - https://developer.android.com/jetpack/docs/guide

Unfortunately I did not have enough time to complete requirements 3, 4 and 5 but hopefully you will still see from this that I code to a high standard.

## Assumptions
I made the following assumptions:

 1. There was no requirement to retrieve the CSV file online. The CSV can be bundled with the app as an Asset file
 2. All data in the CSV should be displayed in the table view
 3. Ordering of the table view was based on current rent

## Testing
Unit and Android Instrumental tests can be found in the usual place. These tests cover the following areas:

 - CSV reader
 - Repository Layer
 - DAO Layer