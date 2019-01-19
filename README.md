# Toy Robot Simulator

## Problem
See PROBLEM.MD

## Instructions
By default, the application is using console reader to accept input from the user.

### By console 

1. after checking out the project run `mvn clean install` in same directory
2. this will generate `toyrobot.jar` under `/target` folder
3. run the jar via `java -jar target/toyrobot.jar`
4. Further instructions will be prompted as per below:

```
Please enter for the toy robot simulator. Enter one command per line.
   Valid Commands:
    PLACE X,Y,F
       MOVE
       LEFT
       RIGHT
       REPORT
   To run:  'CTRL + D' (Mac/Unix) or 'CTRL + Z' + 'Return' (Windows).
```

### By file input
1. Change Robot Simulator to instantiate FileInputReader instead
2. Pass file location as input string
3. Run application 


##### Assumptions
- Maven, Java are installed in your local machine

