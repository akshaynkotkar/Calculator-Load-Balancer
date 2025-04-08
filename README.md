# Load Balancer Calculator Application

[![GitHub](https://img.shields.io/badge/GitHub-Repository-blue)](https://github.com/akshaynkotkar/Calculator-Load-Balancer.git)

## Project Overview
This is a Spring Boot application that implements a calculator service with load balancing capabilities. The application demonstrates how to distribute incoming requests across multiple server instances to improve performance, reliability, and scalability.

## Load Balancer Documentation

### What is a Load Balancer?
A load balancer is a device or software component that distributes network or application traffic across multiple servers. It helps to:
- Improve application responsiveness
- Increase availability of applications
- Ensure no single server bears too much demand
- Provide redundancy and failover capabilities

### Load Balancer Types and Algorithms
This project implements the following load balancing strategies:

1. **Round Robin**: Requests are distributed sequentially across all available servers
2. **Least Connections**: New requests are sent to the server with the fewest active connections
3. **Weighted Distribution**: Servers with higher capacity receive more requests
4. **Health Checks**: Regular monitoring of server health to ensure only active servers receive traffic

### How Load Balancer Works in This Project
The application implements a load balancing strategy that:
1. Receives incoming calculator operation requests
2. Distributes these requests across multiple server instances
3. Ensures optimal resource utilization
4. Provides failover capabilities if one server instance fails

### Technical Implementation Details
- Uses Spring Cloud LoadBalancer for client-side load balancing
- Implements circuit breaker pattern for fault tolerance
- Maintains server health status through heartbeat mechanism
- Supports dynamic server registration and deregistration
- Implements sticky sessions for stateful operations

### Load Balancer Architecture
```
┌─────────────────────────────────────────────────────────────────────────┐
│                                                                         │
│  ┌─────────────┐     ┌─────────────┐     ┌─────────────┐               │
│  │             │     │             │     │             │               │
│  │  Client 1   │     │  Client 2   │     │  Client N   │               │
│  │             │     │             │     │             │               │
│  └──────┬──────┘     └──────┬──────┘     └──────┬──────┘               │
│         │                   │                   │                       │
│         └───────────────────┴───────────────────┘                       │
│                                 │                                       │
│                                 ▼                                       │
│  ┌─────────────────────────────────────────────────────────┐           │
│  │                                                         │           │
│  │                    Load Balancer                        │           │
│  │                                                         │           │
│  │  ┌─────────────┐  ┌─────────────┐  ┌─────────────┐     │           │
│  │  │             │  │             │  │             │     │           │
│  │  │ Health      │  │ Request     │  │ Server      │     │           │
│  │  │ Monitor     │  │ Distributor │  │ Selector    │     │           │
│  │  │             │  │             │  │             │     │           │
│  │  └─────────────┘  └─────────────┘  └─────────────┘     │           │
│  │                                                         │           │
│  └───────────────────────────┬─────────────────────────────┘           │
│                              │                                         │
│                              ▼                                         │
│  ┌─────────────┐     ┌─────────────┐     ┌─────────────┐               │
│  │             │     │             │     │             │               │
│  │  Server     │◀────┤  Server     │◀────┤  Server     │               │
│  │ Instance 1  │     │ Instance 2  │     │ Instance 3  │               │
│  │             │     │             │     │             │               │
│  │ ┌─────────┐ │     │ ┌─────────┐ │     │ ┌─────────┐ │               │
│  │ │Health   │ │     │ │Health   │ │     │ │Health   │ │               │
│  │ │Status:  │ │     │ │Status:  │ │     │ │Status:  │ │               │
│  │ │Active   │ │     │ │Active   │ │     │ │Active   │ │               │
│  │ └─────────┘ │     │ └─────────┘ │     │ └─────────┘ │               │
│  └─────────────┘     └─────────────┘     └─────────────┘               │
│                                                                         │
└─────────────────────────────────────────────────────────────────────────┘

Request Flow Example:
1. Client 1 sends request for calculation (5 + 3)
2. Load Balancer receives request
3. Request Distributor analyzes current load
4. Server Selector chooses Server Instance 1
5. Server Instance 1 processes request and returns result
6. Next request from Client 2 is routed to Server Instance 2
7. Following request from Client N is routed to Server Instance 3
8. Process continues in round-robin fashion

Key Components:
1. Clients: Multiple users/applications sending requests
2. Load Balancer:
   - Health Monitor: Checks server health status
   - Request Distributor: Routes requests based on algorithm
   - Server Selector: Chooses appropriate server instance
3. Server Instances:
   - Multiple identical server instances
   - Each with health status monitoring
   - Running calculator service
   - Requests distributed in round-robin fashion
```

## Project Structure
- `src/main/java/loadBalancer/calculator/`: Main application code
  - `controller/`: REST endpoints for calculator operations
  - `service/`: Business logic implementation
  - `config/`: Load balancer configuration
- `src/images/`: Project screenshots and diagrams

## Running the Project

### Prerequisites
- Java 17 or higher
- Maven
- Spring Boot

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/akshaynkotkar/Calculator-Load-Balancer.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Calculator-Load-Balancer
   ```
3. Build the project:
   ```bash
   ./mvnw clean install
   ```
4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
5. The application will start on port 8080 by default

### Accessing the Application
- Open your web browser and navigate to: `http://localhost:8080`
- Use the calculator interface to perform operations
- The load balancer will automatically distribute requests across available server instances

### API Endpoints
The application provides the following REST endpoints:

1. Addition:
   ```bash
   GET http://localhost:8080/add?a={number1}&b={number2}
   ```

2. Subtraction:
   ```bash
   GET http://localhost:8080/sub?a={number1}&b={number2}
   ```

3. Multiplication:
   ```bash
   GET http://localhost:8080/mul?a={number1}&b={number2}
   ```

4. Division:
   ```bash
   GET http://localhost:8080/div?a={number1}&b={number2}
   ```

Example usage:
```bash
# Addition example
curl "http://localhost:8080/function1?a=5&b=3"

# Expected response
{
    "result": 8.0,
  
}
```

## Screenshots
![Calculator Application Screenshot](src/images/Screenshot%20from%202025-04-08%2016-51-55.png)

## Features
- Basic arithmetic operations (addition, subtraction, multiplication, division)
- Load balanced request distribution
- High availability
- Scalable architecture
- Real-time request monitoring
- Health check monitoring
- Circuit breaker implementation
- Dynamic server registration

