# drones-ms

## Project Background
- In this project, the SpringBoot framework is utilized alongside an in-memory database known as H2.
- The essential data has been pre-populated into the project.
- Launch the project by executing `./mvnw spring-boot:run` command at the root directory of the project.
- Some of the use cases in this project have been covered by unit tests.


## Assumptions
- When medications are added, they are associated with a drone.
- As soon as a drone is added to the database, it is assigned an initial state of IDLE.
- When medications are added to a drone, the drone's weight limit is diminished, and once it reaches zero, the drone's state is altered to LOADED.
- If the weight limit exceeds 0, then the drone transitions into the LOADING state after the addition of medications.