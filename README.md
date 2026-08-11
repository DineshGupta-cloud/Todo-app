# Todo App

Production-oriented full-stack Todo application with a React/Vite frontend, Spring Boot REST API, PostgreSQL, Docker, and GitHub Actions CI.

## Stack
- Frontend: React + Vite + Nginx
- Backend: Java 21 + Spring Boot + JPA
- Database: PostgreSQL
- Delivery: Docker Compose + GitHub Actions

## Run locally
```bash
docker compose up --build
```
Open `http://localhost`.

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
Configure `DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`, `CORS_ORIGIN`, and `VITE_API_URL` through your deployment secret/configuration system. Do not commit credentials. The CI pipeline builds/tests both applications and verifies the container stack.
