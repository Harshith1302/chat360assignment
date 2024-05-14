# chat360assignment

Install Java 17 version SDK and run using Maven.

Please use the following curls for the APIs present for addition, subtraction, multiplication and division logs will be generated accordingly

curl --location 'http://localhost:8080/calculator/add?num1=1&num2=2'

curl --location 'http://localhost:8080/calculator/subtract?num1=1&num2=2'

curl --location 'http://localhost:8080/calculator/multiply?num1=1&num2=2'

curl --location 'http://localhost:8080/calculator/divide?num1=1&num2=2'


Use the following API for executing log queries with source and  level

curl --location 'http://localhost:8080/logs?source=Calculator%20Controller&level=ERROR'

Sample log response :


    {
        "timestamp": "2024-05-14T19:29:05.1113945",
        "level": "ERROR",
        "source": "Calculator Controller",
        "message": "Required request parameter 'num1' for method parameter type double is not present"
    }
