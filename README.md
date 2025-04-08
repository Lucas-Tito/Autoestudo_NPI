<h2 align="center"> Criando Banco de Dados </h2>

+ sudo apt install postgresql postgresql-contrib
+ sudo -u postgres psql
+ CREATE USER admin WITH PASSWORD 'admin';
+ CREATE DATABASE usuariosdb;
+ GRANT ALL PRIVILEGES ON DATABASE admin TO meuusuario;
+ \c usuariosdb
+ GRANT ALL PRIVILEGES ON SCHEMA public TO admin;

<h2 align="center"> Instalando Frontend </h2>

+ npm install -g @vue/cli
+ vue create vue-crud-usuarios
+ cd vue-crud-usuarios
+ npm run serve
