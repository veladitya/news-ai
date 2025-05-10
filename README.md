# news-ai
## Overview

The News AI System ingests news articles from the New York Times Technology RSS feed, processes the data, stores it in a Redis database, and exposes the articles through a REST API. The system also provides a React-based UI for browsing the news articles.

### Architecture Diagram

![Architecture](./path_to_diagram)

### Key Components

1. **Rss-Producer (Spring Boot)**

    * Periodically polls the NY Times Technology RSS feed (every 5 minutes by default).
    * Parses each RSS <item> to JSON format.
    * Publishes messages to the Kafka topic `nyt.rss.articles` using the article ID as the record key.

2. **News-Consumer (Spring Boot)**

    * Subscribes to the Kafka topic `nyt.rss.articles`.
    * Filters out old articles (published more than 24 hours ago) and duplicates (already present in Redis).
    * Saves new articles to Redis with a TTL of 24 hours.

3. **News-API (Spring Boot REST)**

    * Provides a REST endpoint: `GET /api/v1/news` with pagination and sorting.
    * Supports optional language translation (English/Spanish) - `Not implemented`
    * Runs on port 8080.

4. **News-UI (React)**

    * Displays news articles from the API.
    * Sticky header during scrolling.
    * Opens the main article on clicking the title, short description, or image in a new tab.
    * Supports language toggle (English/Spanish).
    * Runs on port 8998.

## Docker Setup

### Prerequisites

* Docker
* Docker Compose

### Running the System

1. Clone the repository:

   ```bash
   git clone https://github.com/veladitya/news-ai.git
   cd news-ai
   ```

2. Start the containers:

   ```bash
   docker-compose up -d
   ```

3. Verify the containers are running:

   ```bash
   docker ps
   ```

### Access Points

* API: [Swagger API](http://localhost:8080/swagger-ui/index.html)
* UI: [React on Vite](http://localhost:8998)

### Stopping the System

```bash
docker-compose down
```

## Troubleshooting

* To check logs for a specific service:

  ```bash
  docker-compose logs -f <service_name>
  ```

## Environment Variables

| Variable      | Description                                   |
| ------------- | --------------------------------------------- |
| REDIS\_HOST   | Redis server hostname (default: redis-server) |
| REDIS\_PORT   | Redis server port (default: 6379)             |
| KAFKA\_BROKER | Kafka broker addresses                        |
| NODE\_ENV     | Node environment (production)                 |

## Demo Video
[Download Video](demo.mp4)

## Demo Video
[Click here](demo.html)
## License

MIT License
