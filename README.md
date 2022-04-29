[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 

# TourGuide
TourGuide is a Spring Boot application that has been a centerpiece in TripMasters app portfolio. It allows users to see tourist attractions and to get package deals on hotel stays and admission to various attractions.
***
## ms_gps
## Modules complémentaires
- [Module User](https://github.com/gwnll/ms_user)
- [Module Rewards](https://github.com/gwnll/ms_rewards)
## Architectural Diagram
![alt text](https://github.com/gwnll/ms_user/blob/main/diagramme_architecture.png?raw=true)
## Technologies
- Java
- Gradle
- Spring 
- Docker
## Endpoints
#### POST http://localhost:82/getAttractions
> get a list of all the attractions.
#### GET http://localhost:82/getVisitedLocation/{id}
> ``String userID``
#### GET http://localhost:82/getDistance
>  ``@RequestParam double lat1, @RequestParam double long1, @RequestParam double lat2, @RequestParam double long2``
#### GET http://localhost:82/near
>  ``@RequestParam double lat1, @RequestParam double long1, @RequestParam double lat2, @RequestParam double long2, @RequestParam int proximityBuffer``
