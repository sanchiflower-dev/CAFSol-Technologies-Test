# CAFSol ASSIGNMENT

## ASSIGNMENT 1- Config-Reader-Service

### Overview
This Spring Boot application reads a custom configuration file
containing multiple sections and key–value pairs.
The data is stored in memory for fast access and is exposed
through REST APIs in JSON format.

### Problem Statement
- Read a configuration file with multiple sections
- Store section-wise configuration in memory
- Provide an API to fetch configuration by section name

### Configuration File Example

Save the below content in a file

    '''' START '''''

    Gateway
    endpoint = https://xyz.in
    certurl = https://cloud.internalportal.com
    download loc =  /home/user/temp

    CXO
    endpont = http://internal.cxo.com
    redirect url = 
    broker = http://cxobroker.in
    topic = test_cxo_topic, test_cxo_topic_1 

    Order Service
    broker = https://orbroker.in
    topic = test_os_topic_1, test_os_topic_2

    '''' END ''''

## Features
- Custom text file parsing
- Section-wise configuration mapping
- In-memory storage using HashMap
- REST API response in JSON format
- Unit tests using Spring Boot Test


## ASSIGNMENT 2 - PriceService

### Overview
This Spring Boot application reads pricing information from a TSV file
and provides price details based on SKU ID and time.
It supports overlapping offers and returns the correct price
based on business rules.

### Problem Statement
- Read pricing data from TSV file
- Store offers in memory for fast lookup
- Return price based on SKU ID and optional time parameter

### TSV File Format
Save the below content as a TSV file

    SkuID | StartTime | EndTime | Price
    u00006541|10:00|10:15|101
    i00006111|10:02| 10:05|100
    u09099000 | 10:00|10:08|5000
    t12182868| 10:00| 20:00|87
    b98989000| 00:30| 7:00|9128
    u00006541|10:05|10:10|99
    t12182868| 14:00| 15:00|92

## Features
- TSV file parsing
- In-memory caching using HashMap
- Time-based price selection
- Handles overlapping price ranges
- REST APIs with query parameters
- Unit testing support

### Sample Outputs
    - time = 09:55 → NOT SET
    - time = 10:03 → 101
    - time = 10:05 → 99

## Technology Stack
- Java 17
- Spring Boot
- Maven
- JUnit

## Author
Name:- SANCHITA BHAKTA
