Craindo o Banco de dados.

+ sudo apt install postgresql postgresql-contrib
+ sudo -u postgres psql
+ CREATE USER admin WITH PASSWORD 'admin';
+ CREATE DATABASE usuariosdb;
+ GRANT ALL PRIVILEGES ON DATABASE admin TO meuusuario;
+ \c usuariosdb
+ GRANT ALL PRIVILEGES ON SCHEMA public TO admin;

