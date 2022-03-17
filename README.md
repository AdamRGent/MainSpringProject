# MainSpringProject

Why are we doing this?

We are completeing this project to demonstrate the skills we have learnt throughout the software development course. The skills demonstrated include:

-Agile & Project Management (Git, Jira)
-Databases & Cloud Fundamentals (H2, MySQL)
-Programming Fundamentals (Java)
-API Development (Spring Boot)
-Automated Testing (JUnit, Mockito)

The project showcases every stage of development for a back-end app. Utilising efficient project planning through Scrums on Jira and Agile concepts. This demonstrates the ability to understand and create/follow key planning procedures while adherering to the customer's needs. The customer's needs are identified and then used to create the app's features within Java/Spring Boot by creating working code, thus demonstrating the programming fundamental skills learnt. Databases are then connected to the app so that we can store the neccessary data to fulfil the customer's needs, this demonstrates MySQL knowledge and the ability to create databases/interpret data within MySQL. Postman is also used to ensure our customer's data can be created, read, updated and deleted accordingly, to the database, demonstrating our app/code works. Finally extensive testing is completed throughout our coding with maximum coverage, this demonstrates both our understanding of testing and that our code is fully functional. 

How did I expected the challenge to go?

I expected the challenge to go without any too many problems as the course has been extensive and the teaching to a very high level. Therefore all the skills needed for this challenge had been learnt. However I was slightly apprehensive of completing such a challenge within a set time frame as this course was my first experience of coding.  



What went well? / What didn't go as planned?

The mvp went accordingly and the coding met the standards needed to complete the project. I feel the testing went particularly well without it causing any issues. Overall I feel the each part of the project as set out in Jira, went well and was completed within the timeframes, this helped greatly with time management and development efficiency. 

The only thing that didn't go as planned at the very beginning was Postman, with the create method. Postman would take the data but output "0" to each Integer when that was not the value being inputted. After looking into what the issue could be, it was discovered that when the SQL table was created, the collumn names did  not match the person class exactly in regards to formatting. This was the resolved my making each variable name match the collumn names in the SQL table.  



Possible improvements for future revisions of the project.

I would like to see the app improved in these ways:

- When a customer updates their data, I want a copy of the previous data saved, with both datasets containing the same user ID. So that there is a history of results for the customer to view. 
- I would like to be able to put the entire history of a user's data into a graph to showcase improvements and deterioration in an easy to view output. 
- I would also like to add a feature that takes in all the previous data and gives an ouput of a target improvement. For example, the app can see what the user has achieved over what time scale, then it can evaulate the results and where they will likely go if they continue the same trend; creating a target to achieve. 



Screenshots showing your postman requests and the output from the API.

![image](https://user-images.githubusercontent.com/97948275/158818153-1c471ab8-47f5-445a-a316-bf0a38dd6ef1.png)

The above screenshot shows my create method running and working through Postman.


![image](https://user-images.githubusercontent.com/97948275/158818318-e329c5cc-7510-4238-8a05-2f92a6fdbeb3.png)

The above screenshot shows my readById method running and working through Postman.


![image](https://user-images.githubusercontent.com/97948275/158818386-ed8ad90f-d32b-4ae8-90fe-48c9e69ef7c7.png)

The above screenshot shows my readAll method running and working through Postman. I've shown the results part of the method.


![image](https://user-images.githubusercontent.com/97948275/158818549-9c481f16-810a-45b9-8845-d92ed2f0a844.png)

The above screenshot shows my Update method running and working through Postman. 


![image](https://user-images.githubusercontent.com/97948275/158818452-fc1a5f57-9e0d-4d6a-af38-4904a386d1df.png)

The above screenshot shows my delete method running and working through Postman.


Screenshot of my database to prove that data is being persisted.

![image](https://user-images.githubusercontent.com/97948275/158819325-53363a64-0a6c-4207-b696-2b92ea5971ee.png)

The above shows the data from the Postman create method allocating values to my database. The create screenshot can be seen in the create method validation above. 


Screenshots of my test results, including coverage report.


![image](https://user-images.githubusercontent.com/97948275/158792048-532a9212-cdeb-4f3f-bd3e-2f8a7beee7f7.png)


![image](https://user-images.githubusercontent.com/97948275/158792097-278f8915-b4de-44c6-ac6a-61484cb45f8b.png)


![image](https://user-images.githubusercontent.com/97948275/158792140-a8b2cf6c-bf60-4edd-9e4d-dd7be4d7e9b5.png)

The above screenshots show my  Person service unit tests running and working. 


![image](https://user-images.githubusercontent.com/97948275/158792258-82a6e1f3-a8d8-4dcd-94db-d27a98eeb643.png)


![image](https://user-images.githubusercontent.com/97948275/158792329-da2520f6-bcd5-4ebf-ae09-188e3238de2f.png)


![image](https://user-images.githubusercontent.com/97948275/158792378-5c09d7ee-beac-4426-8bf7-f9fccc754d04.png)


The above screenshots show my Person tests running and working.


![image](https://user-images.githubusercontent.com/97948275/158792706-584049ae-ca7d-4314-9ec6-b2363d254a81.png)


![image](https://user-images.githubusercontent.com/97948275/158792793-486ab6f9-a033-49e3-aa35-f860af722694.png)


![image](https://user-images.githubusercontent.com/97948275/158792832-168c4230-b734-46fa-99a3-ef03e8e6e867.png)


The above screenshots show my Person controller unit tests running and working.


![image](https://user-images.githubusercontent.com/97948275/158793146-0109a76e-9ec6-4739-9ce1-6c0d4247c210.png)


![image](https://user-images.githubusercontent.com/97948275/158793211-99e63d65-48b8-4661-860d-933fd655693a.png)


![image](https://user-images.githubusercontent.com/97948275/158793622-16b8c6fa-aeb8-4685-8b9a-f2cc91671872.png)


The above screenshots show my Person controller integration tests running and working.


![image](https://user-images.githubusercontent.com/97948275/158793926-cc45113a-5f23-44e0-bfbb-e92eeb226396.png)


The above screenshot show my test coverage percentages.


![image](https://user-images.githubusercontent.com/97948275/158822246-7d09e177-2dd2-46c2-be63-f0ec90bfeb1c.png)


The above screenshot shows my network graph for the git repo and the feature branch model.


Link to my Jira Board
https://adamrgent.atlassian.net/jira/software/projects/MP/boards/3

Link to my Jira Roadmap 
https://adamrgent.atlassian.net/jira/software/projects/MP/boards/3/roadmap

Link to my Jira Backlog
https://adamrgent.atlassian.net/jira/software/projects/MP/boards/3/backlog
