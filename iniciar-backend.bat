@echo off
echo Iniciando o servidor Spring Boot...
cd /d "%~dp0controle-estoque"
mvnw.cmd spring-boot:run
pause