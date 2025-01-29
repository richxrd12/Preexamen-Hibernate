USE granja;

CREATE TABLE parcela(
    id INT AUTO_INCREMENT PRIMARY KEY,
    area FLOAT,
    ubicacion VARCHAR(255)
);

CREATE TABLE granjeros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreApellidos varchar(255),
    email varchar(255),
    nombreUsuario varchar(255) unique,
    password varchar(255),
    saldo float
);

CREATE TABLE animales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreComun VARCHAR(255),
    genero VARCHAR(255),
    peso FLOAT,
    tamaño FLOAT,
    dieta VARCHAR(255),
    precio FLOAT,
    estado ENUM("VIVO", "MUERTO"),
    idParcela INT,
    enfermedades VARCHAR(255),
    cuidados VARCHAR(255),
    horasTrabajo INT,
    temperamento ENUM("DÓCIL", "INDEPENDIENTE", "TÍMIDO", "AGRESIVO", "ACTIVO"),
    FOREIGN KEY (idParcela) REFERENCES parcela(id)
);

CREATE TABLE granjeros_animales (
    idAnimal INT,
    idGranjero INT,
    PRIMARY KEY(idAnimal, idGranjero),
    FOREIGN KEY (idGranjero) REFERENCES granjeros(id),
    FOREIGN KEY (idAnimal) REFERENCES animales(id)
);


INSERT INTO granjeros (nombreApellidos, email, nombreUsuario, password, saldo)
VALUES
('Juan Pérez', 'juan.perez@example.com', 'juanito123', 'password123', 1000.50),
('María García', 'maria.garcia@example.com', 'mariaG', 'securepass', 750.00),
('Carlos López', 'carlos.lopez@example.com', 'carlitos', 'mypass123', 1200.75),
('richa', 'richa', 'richa', '1234', 1200.75);

INSERT INTO parcela (area, ubicacion)
VALUES
(100.0, 'Campo Norte'),
(150.0, 'Campo Sur'),
(50.0, 'Campo Este');

INSERT INTO animales (nombreComun, genero, peso, tamaño, dieta, precio, estado, idParcela)
VALUES
('Vaca', 'Hembra', 500.0, 1.8, 'Herbívoro', 1200.00, 'VIVO', 1),
('Caballo', 'Macho', 600.0, 1.9, 'Herbívoro', 1500.00, 'VIVO', 2),
('Gallo', 'Hembra', 1.5, 0.3, 'Omnívoro', 20.00, 'VIVO', 1),
('León', 'Hembra', 1.5, 0.3, 'Carnívoro', 20.00, 'VIVO', 2),
('Gallina', 'Hembra', 1.5, 0.3, 'Omnívoro', 20.00, 'VIVO', 3);

INSERT INTO granjeros_animales (idAnimal, idGranjero)
VALUES
(1, 4),
(2, 4),
(3, 3);