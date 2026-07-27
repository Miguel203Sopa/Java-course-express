docker run -d --name mi_postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=1234 \
-e POSTGRES_DB=midb -p 5432:5432 -v postgres_data:/var/lib/postgresql/data  postgres:16
