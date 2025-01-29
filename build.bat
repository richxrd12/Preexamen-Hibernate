@echo off
if "%1"=="-f" (

    echo Levantando la base de datos por primera vez...

    docker build -t mysql-granja .

    echo Creada la imagen, ahora el contenedor...

    docker run -d --name granja -p 3306:3306 mysql-granja

    echo Creado el contenedor, listo para usar :D

) else if "%1"=="-d" (

    echo Borrando el contenedor y la imagen...

    docker stop granja

    docker rm granja

    docker rmi mysql-granja

    echo Se ha borrado el contenedor y la imagen :D

) else (
    echo Levantando el contenedor...

    docker start granja

    echo Listo para usar :D
)