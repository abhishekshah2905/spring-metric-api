# Spring Metric API

The Metric API is a RESTful web service for managing and retrieving metrics and statistics.

## Getting Started

### Prerequisites
- Java JDK 8 or higher
- Maven

### Installation
1. Clone the repository:
```bash
  git clone git@github.com:abhishekshah2905/spring-metric-api.git
```
2. Navigate to the project directory:
```bash
  cd spring-metric-api
```
3. Build the project:
```bash
  mvn clean install
```
4. Run the application:
```bash
  mvn spring-boot:run
```
5. Access the application at http://localhost:8083

### Usage
### Creating Metric Names
- POST request to /api/metrics/names with a JSON payload containing the metric name.
### Retrieving Metric Names
- GET request to /api/metrics/names to retrieve a list of metric names.
### Creating Metric Entries
- POST request to /api/metrics/entries with a JSON payload containing the metric entry details.
### Retrieving Metric Statistics
- GET request to /api/metrics/{id}/statistics to retrieve statistics for a specific metric.

### Configuration
- The application uses a MessageSourceConfig class for managing error messages.
- Swagger is configured using the SwaggerConfiguration class to generate API documentation.

### Customization
- Modify the controllers (MetricController and MetricEntryController) to add more functionality or customize existing endpoints.
- Update the error messages in the messages.properties file located in the src/main/resources directory.
