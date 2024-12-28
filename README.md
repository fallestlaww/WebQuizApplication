# Web Quiz

This project is a backend for website with quiz. How to work with this project on side of the backend and values from database will be described below. 

## Attention!
Since this repository contains a backend part of this project, you can not find here any files of frontend part, but you can create your own, I will only be glad for this :)  
This repo includes all the project files, along with Maven files, so that readers have an understanding of what I worked with when creating this project.    
All explanation of this code provided in the code comments for each function and each class. 

## How to work 
To work with this project you must have a Postman, to get and post your data and one of various types of SQL-databases.

### For what this project need Postman?
This project requires this application for methods which requires API request, as [addQuestion](https://github.com/fallestlaww/WebQuizApplication/blob/main/src/main/java/com/projects/quizapplication/controller/QuestionController.java#L47),
[updateQuestionById](https://github.com/fallestlaww/WebQuizApplication/blob/main/src/main/java/com/projects/quizapplication/controller/QuestionController.java#L59),
[deleteQuestionById](https://github.com/fallestlaww/WebQuizApplication/blob/main/src/main/java/com/projects/quizapplication/controller/QuestionController.java#L70),
[createQuiz](https://github.com/fallestlaww/WebQuizApplication/blob/main/src/main/java/com/projects/quizapplication/controller/QuizController.java#L30),
[submitQuiz](https://github.com/fallestlaww/WebQuizApplication/blob/main/src/main/java/com/projects/quizapplication/controller/QuizController.java#L53).
So, first of all open "Postman" and choose an option "New request" just like in the example below
![image](https://github.com/user-attachments/assets/f0f2c871-bee2-44d3-ae4e-24fccb4cfcd5)
After that, input in an URL(URL for each of those 5 methods you can find in the annotation above the method declaration) and choose HTTP method for a request(HTTP method for each of those 5 methods you can find in the annotation above the method declaration)
#### Attention! Check if the method have a @RequestParam or @RequestBody in parameters
If the method has @RequestParam, you must to add your values for this parameters in the key=value format, just like in the example
![image](https://github.com/user-attachments/assets/385480dd-e905-4afe-bde9-7bc9258d0529)
If the method has @RequestBody, you must to add your values in the body of the request in Postman
If everything was correct, you will see a notification about it, but if not, you will see another notification  
![image](https://github.com/user-attachments/assets/af73a49e-e4df-4bfa-a7ed-bc7028e87fc6)
![image](https://github.com/user-attachments/assets/7da3b25f-9840-4ee7-86f7-d76ed0cde229)


## Ending

As for me, there is no point in adding more code, but if you want - you have every right to do so, if you find bugs - let me know, I will be happy to fix everything.  

My telegram: [@keepmewhoiam](https://t.me/keepmewhoiam),    
Link for this repository: https://github.com/fallestlaww/Readability_Hyperskill.git,      
My LinkedIn: [click](https://www.linkedin.com/in/pavlo-svitenko-a167152bb/).    
