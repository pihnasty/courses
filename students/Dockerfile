FROM postgres:15

ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin123
ENV POSTGRES_DB=studentsdb

COPY students_db.sql /docker-entrypoint-initdb.d/
