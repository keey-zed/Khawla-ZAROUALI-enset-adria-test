# Project Name: Proof of Concept (POC) - Microservices-based Currency Wallet Application

## Table of Contents
1. [Problem](#problem)
2. [Description](#description)
3. [Technologies Used](#technologies-used)
4. [Project Structure](#project-structure)
5. [Getting Started](#getting-started)
6. [Documentation](#documentation)
7. [Frontend](#frontend)
8. [Security](#security)
9. [Screenshots](#screenshots)

## Problem

We aim to develop a Proof of Concept (POC) in the form of a web application based on a microservices architecture, utilizing the Spring Boot and Spring Cloud ecosystem on the backend and a framework such as Angular or React on the frontend. The application's primary purpose is to manage currency wallets and transfers between wallets. In simpler terms, this application comprises two functional microservices:

1. A microservice for managing "Wallets." Each Wallet belongs to a client, defined by a unique numeric ID (auto-incremented), a name, and an email. A Wallet is defined by a UUID string ID, balance, creation date, and currency.

2. A microservice for managing transfers between Wallets. Each transfer is defined by an ID, date, source Wallet, destination Wallet, amount, and status (PENDING, VALIDATED, REJECTED).

The technical microservices to be implemented include:

- A Gateway service based on Spring Cloud Gateway.
- A Discovery service based on Eureka Server or Consul Discovery (choose one).
- A Configuration service based on Spring Cloud Config or Consul Config (choose one).

The RESTful web services documentation should be generated using the OpenAPI (Swagger) specification.

## Description

This Proof of Concept (POC) project aims to create a microservices-based currency wallet application. It consists of several microservices for managing wallets, transfers, gateway, discovery, and configuration. The project involves developing both the backend and a simple frontend for the application.

## Technologies Used

- Backend:
  - Spring Boot
  - Spring Cloud
  - OpenAPI (Swagger)
  - Eureka Server or Consul Discovery (Choose one)
  - Spring Cloud Config or Consul Config (Choose one)

- Frontend :
  - Angular

## Project Structure

The project is organized into the following microservices:

- `wallet-service`: Manages Wallets.
- `transfer-service`: Manages transfers between Wallets.
- `gateway-service`: Acts as a gateway using Spring Cloud Gateway.
- `discovery-service`: Provides service discovery with Eureka Server or Consul Discovery (Choose one).
- `config-service`: Handles configuration with Spring Cloud Config or Consul Config (Choose one).



## Getting Started

To run the project locally, follow these steps:



## Documentation

You can access the documentation of the RESTful APIs using OpenAPI (Swagger) at the following URL: [Insert Swagger URL here]



## Frontend

To run the frontend (Angular or React), use the following commands:




## Security



## Screenshots

#### Screenshot 1: 
![Screenshot 1](screenshot1.png)

#### Screenshot 2:
![Screenshot 2](screenshot2.png)



