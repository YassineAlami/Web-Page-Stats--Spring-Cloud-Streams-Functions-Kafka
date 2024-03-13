
<p align="center"><a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;pause=1000&amp;color=33F72A&amp;random=false&amp;width=435&amp;lines=Architecture&amp;center=true&amp;vCenter=true" alt="Typing SVG"></a></p>


<p align="center">
<img src="https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/c7ca863c-f510-4b0c-a800-c12605259d0b" alt="Screenshot (1685)"></p>


<p align="center">
<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&pause=1000&color=33F72A&random=false&width=435&lines=Steps&amp;center=true&amp;vCenter=true" alt="Typing SVG" /></a>
</p>


The first step is to start Zookeeper. You can do this by running the following command in cmd:
**'start bin\windows\zookeeper-server-start.bat config\zookeeper.properties'**
This command will initiate Zookeeper using the provided configuration file.

![Screenshot (1889)](https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/19964753-a4d4-4b4e-b2b2-4ede292d2bb1)



#

After starting Zookeeper, the next step is to start Kafka. This can be done by executing the following command:
**'start bin\windows\kafka-server-start.bat config\server.properties'**

![Screenshot (1890)](https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/817f63ea-38e6-4a2b-b195-50c2f2c23b34)


#


Now that Kafka is up and running, we can utilize the Kafka clients: 'Kafka-Console-Producer' and 'Kafka-Console-Consumer' for testing purposes.

Let's start by launching the consumer. Use the option '--bootstrap-server' to specify that Kafka is running locally on port 9092. The option '--topic' indicates the topic we want to subscribe to, in this case, 'R1'.
**'start bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic R1'**

This command will set up the consumer to listen for incoming messages on the specified topic. It will continuously wait for messages to be published to the 'R1' topic."

![Screenshot (1891)](https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/07b9246d-7984-4ab9-9552-9bcd8377537f)

#

To produce messages into the previously created topic 'R1', we need to create a Kafka producer. The option '--broker-list' is used to specify the location of the broker, while '--topic' specifies the name of the topic to which we want to send messages.

**'start bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic R1'**
This command will launch the Kafka console producer, allowing you to input messages that will be sent to the 'R1' topic.

![Screenshot (1892)](https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/e189f676-b663-4986-97de-84e3974c6ddc)

#

This is the first test for our two clients, consumer and producer, which both are refering to the topic R1.

https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/19131841-f356-454e-85ad-cc049d129575

#

Now that our consumer and producer are set up, let's proceed with the creation of our Spring Boot application. This application will attempt to produce messages to a topic, and we'll observe this topic using the Kafka consumer. <br>

In the following video, you'll see a demonstration of a message being published from the controller of our application to a topic. The target topic is 'R1', and the message being sent is named 'testMessage'. By default, the result is in JSON format.<br>


https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/e6fb91dd-05f8-4c19-a3ee-bd54a4919d03


#


Our next step is to create a consumer within our application that simulates the role of a Kafka client consumer. Essentially, this consumer will listen to the 'R1' topic and display the messages it receives.<br>

As demonstrated, once we send a GET HTTP request from the browser URL, specifying the topic and the message, it automatically appears in both our application's consumer and the Kafka client consumer.<br>


https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/61e2f41a-a171-401e-b593-c8eda60ab76b

#

Great! Let's move on to our next objective, which is creating a 'Producer Poller' for our application.<br>
We will utilize this poller to send messages to a Kafka topic named 'R2' at regular intervals, such as every second. <br>


https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/4b6bc680-b8b6-4fc8-ac43-cf8eeccd075d

#

Let's implement another functionality that receives a stream of data from a topic named 'R1'. <br>
This function will process the incoming messages before sending them to another topic, 'R3'. <br>

This function will have two channels: one for input, which consumes messages from 'R1', and another for output. <br>
The output channel will modify the initial message by replacing the name with its length and setting the user to the fixed value 'User Y'.<br>



https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/0b3f4b41-3b4f-4abd-9b4e-824758c61233

#



The next step involves simulating stream processing using 'Kafka Streams'. We will aim to retrieve the data records (key | value) produced by the Producer Poller (Supplier) in the 'R2' topic. <br>
Using Kafka Streams, we will read this topic and generate statistics regarding these data records.<br>

As observed earlier, the 'R2' topic receives information about events related to web pages 'P1' and 'P2' every 100ms.<br>
The 'R4' topic will display statistics for both pages 'P1' and 'P2', showing the name of the page followed by the number of visits each one receives.<br>


https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/67100af8-6b43-4e5b-baa1-c3df7d0dc9a1

#

Let's update our code to ensure that the 'R4' topic displays, every 5 seconds for each page (P1 and P2), the number of visits, along with the start time and the end time.


https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/ad64875b-9cff-44f3-bacd-3eb37a859318

#

Now let's create an endpoint that can display and manipulate the content of the 'R4' topic in real-time. <br>
This endpoint will return an object every second, providing information about each of our pages, P1 and P2, along with the number of visits for each one.


https://github.com/YassineAlami/Web-Page-Stats--Spring-Cloud-Streams-Functions-Kafka/assets/40896739/1b6256d5-6f90-4c83-ab9a-983f9da1a2ab


