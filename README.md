# Cybersecuritybase-application

## Description
This application has some serious security vulnerabilities. Can you find them?

### How to run?
1. Clone the repo to your local machine
2. Download the dependencies `mvn dependency:resolve`
3. Run the project `mvn spring-boot:run`

Or open in NetBeans.

### Vulnerabilities
The vulnerabilities implemented are selected according to the [OWASP Top 10 Most Critical Web Application Security Risks 2017](https://www.owasp.org/images/7/72/OWASP_Top_10-2017_%28en%29.pdf.pdf)

The following vulnerabilities have been detected:
*A2:2017 - Broken Authentication
*A3:2017 - Sensitive Data Exposure
*A5:2017 - Broken Access Control
*A7:2017 - Cross-Site Scripting (XSS)
*A9:2017 - Using Components with Known
Vulnerabilities
*A10:2017 - Insufficient Logging & Monitoring

_This project is part of Part III of Cyber Security Base course set organized by University of Helsinki._
