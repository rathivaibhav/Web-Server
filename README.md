Java Web Server and Client
📌 Overview
This project implements a multi-threaded Web Server and Client system in Java. It provides several architectural variants, 
each demonstrating different concepts like basic socket programming, multi-threading, functional interfaces (Consumer),
and thread pools using ExecutorService.

The server listens on a specific port (default: 8010) and responds with a greeting message upon establishing a connection.
The client connects to the server, sends a message, and receives a response.

The aim is to showcase how Java's networking, threading, and functional programming features can be combined to build 
scalable and efficient server-client applications.

📂 Project Structure
The project consists of several implementations of the Server and Client, categorized by complexity and technique:

arduino
Copy
Edit
📦 java-web-server
 ┣ 📄 Server.java (Multiple versions)
 ┣ 📄 Client.java (Multiple versions)
 ┗ 📄 README.md
You will find multiple Server and Client class definitions in the same file (for this example), but they demonstrate distinct approaches:

1. Basic Server and Client
Server uses ServerSocket and handles one client at a time.
Client connects to the server and sends a greeting message.
No concurrency; each connection is handled sequentially.

2. Multi-threaded Server with Thread per Client
Server uses Thread to handle each client request.
Client can run in multiple threads to simulate concurrent connections.

3. Server Using ExecutorService
Uses a thread pool (FixedThreadPool) to manage client threads efficiently.
Helps avoid thread exhaustion during heavy loads.

5. Server with Functional Interface (Consumer<Socket>)
Demonstrates the use of functional programming with Consumer interface.
Server passes client socket to a lambda function that processes the request.
6. Client with Runnable Threads
Implements Runnable for each client to run 100 simultaneous client threads.

Simulates real-world load testing by connecting multiple clients to the server.

🧪 Features
✅ Basic socket communication (TCP)
✅ Handles multiple client connections
✅ Demonstrates Java I/O streams (PrintWriter, BufferedReader)
✅ Uses multi-threading with Thread, Runnable, and ExecutorService
✅ Showcases functional interfaces (Consumer)
✅ Timeout control using setSoTimeout()
✅ Portable and simple to run

📈 Use Cases
1. This project can be a great starting point for:
2. Learning core networking in Java
3. Simulating client-server interaction
4. Load testing small-scale socket servers
5. Implementing backend for multiplayer games or chat apps
6. Academic assignments related to computer networks

Tools like Jmeter were Leveraged to check for the Tolerance of the three Types of Server MultiThreaded ,SingleThreaded, and Thread Pool 
