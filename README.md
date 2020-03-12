# associate_java_software_engineer_gs
My application for online recruitment test

## Installation
Download this repository, and then run in the IDE of your choice (Intellij in my case).
Then head over to http://localhost:8080/closeToCity for my API.

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

## Future versions
Although I have built an API which aims to output users within 50 miles of London and those registered in London, below I provide some information on what I would do in the future to improve the system.

### Other London functionality
In the dataset provided, a user was registered to a "London" outside the UK, and in future versions I would build in functionality for finding users near other cities called London.

### API spec
In future iterations, I would make the API a Swaggger Spec API, as was done in the example provided by DWP.

### UI information
In future iterations, I would use Swagger UI, as was used in the example provided by DWP.


### Hosting
In future iterations, I would host the API online, for example on Heroku, as was done in the example provided by DWP.
