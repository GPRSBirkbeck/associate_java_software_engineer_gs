# associate_java_software_engineer_gs
My application for online recruitment test

## Installation
Download these files, and then run in the IDE of your choice (Intellij in my case).

## Approach to the problem
to tackle this problem, I started by setting up a URLstream to bring in data from two Get requests;
first, I brought in all users registered in London: https://bpdts-test-app.herokuapp.com/city/London/users 
Then I brought in all users, https://bpdts-test-app.herokuapp.com/users

I then filtered through all users, comparing the distance between their latitude and longitudes 
against the following coordinates: 51.5074° N, 0.1278° W
These coordinates are the first search engine result for London's latitude and longitude, and represent Trafalgar Square (often considered the heart of London).
To compare the distance, I used the Haversine formula (although for short distances this isnt entirely necessary).
I removed duplicates, and returned that list in my API.

## Alternative approaches
another way of tackling the distance problem could have been by using IP addresses, however I imagined people travel and also use VPNs, so I didnt consider these as robust as latitudes and longitudes.
That said, I believe using IP addresses is an interesting alternative.

## API spec
Insert information on the API spec I used here

## UI information
Insert information on the UI I used here
