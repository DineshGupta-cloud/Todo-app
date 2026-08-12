# Todo App

Production-oriented full-stack Todo application with a React/Vite frontend, Spring Boot REST API, MySQL, Docker, and GitHub Actions CI.

## Stack
- Frontend: React + Vite + Nginx
- Backend: Java 21 + Spring Boot + JPA
- Database: MySQL 8.4
- Delivery: Docker Compose + GitHub Actions

## Run locally
```bash
docker compose up --build
```
Open `http://localhost`.

## Database configuration
Docker Compose starts MySQL automatically. For production, set these environment variables through your deployment secret/configuration system:
- `MYSQL_ROOT_PASSWORD`
- `MYSQL_PASSWORD`
- `DATABASE_URL`
- `DATABASE_USERNAME`
- `DATABASE_PASSWORD`
- `CORS_ORIGIN`
- `VITE_API_URL`

Do not commit production credentials.

## API
- `GET /api/v1/todos`
- `POST /api/v1/todos` body `{ "title": "Ship it", "completed": false }`
- `PUT /api/v1/todos/{id}`
- `DELETE /api/v1/todos/{id}`
- `GET /actuator/health`

## Development
Backend: `cd backend && mvn spring-boot:run`
Frontend: `cd frontend && npm install && npm run dev`

## Production notes
The CI pipeline builds/tests both applications and verifies the container stack. Use a managed MySQL instance or a durable MySQL volume in production, rotate credentials, and configure backups before deploying production data.
