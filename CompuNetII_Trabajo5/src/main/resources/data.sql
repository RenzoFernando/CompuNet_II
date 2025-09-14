INSERT INTO accounts (owner, balance) VALUES ('Renzo Fernando', 1000.0);
INSERT INTO accounts (owner, balance) VALUES ('Sabrina Annlynn ', 5000.0);

-- Insertar 5 Profesores
INSERT INTO professors (name) VALUES ('Juan Perez'), ('Maria Rodriguez'), ('Carlos Gomez'), ('Ana Martinez'), ('Luis Hernandez');

-- Insertar 8 Cursos (algunos profesores tienen más de un curso)
INSERT INTO courses (name, credits, professor_id) VALUES ('Introduccion a la Programacion', 4, 1);
INSERT INTO courses (name, credits, professor_id) VALUES ('Estructuras de Datos', 4, 1);
INSERT INTO courses (name, credits, professor_id) VALUES ('Anatomia Humana', 5, 2);
INSERT INTO courses (name, credits, professor_id) VALUES ('Fisiologia', 5, 2);
INSERT INTO courses (name, credits, professor_id) VALUES ('Derecho Penal', 3, 3);
INSERT INTO courses (name, credits, professor_id) VALUES ('Derecho Civil', 3, 3);
INSERT INTO courses (name, credits, professor_id) VALUES ('Dibujo Tecnico', 2, 4);
INSERT INTO courses (name, credits, professor_id) VALUES ('Historia del Arte', 3, 5);

-- Insertar 7 Estudiantes
INSERT INTO students (name, code, program) VALUES ('Laura Garcia', '2021102001', 'Ingenieria de Sistemas');
INSERT INTO students (name, code, program) VALUES ('Pedro Pascal', '2021102006', 'Ingenieria de Sistemas');
INSERT INTO students (name, code, program) VALUES ('Andres Lopez', '2021102002', 'Medicina');
INSERT INTO students (name, code, program) VALUES ('Sofia Torres', '2021102003', 'Derecho');
INSERT INTO students (name, code, program) VALUES ('David Ramirez', '2021102004', 'Arquitectura');
INSERT INTO students (name, code, program) VALUES ('Valentina Diaz', '2021102005', 'Diseno Grafico');
INSERT INTO students (name, code, program) VALUES ('Camila Velez', '2022102007', 'Medicina');

-- Insertar relaciones Estudiante-Curso complejas
INSERT INTO students_courses (student_id, course_id) VALUES (1, 1), (1, 2); -- Laura (Sistemas) en 2 cursos de Sistemas
INSERT INTO students_courses (student_id, course_id) VALUES (2, 1); -- Pedro (Sistemas) en 1 curso de Sistemas
INSERT INTO students_courses (student_id, course_id) VALUES (3, 3), (3, 4); -- Andres (Medicina) en 2 cursos de Medicina
INSERT INTO students_courses (student_id, course_id) VALUES (4, 5), (4, 8); -- Sofia (Derecho) en Derecho Penal e Historia del Arte
INSERT INTO students_courses (student_id, course_id) VALUES (5, 7); -- David (Arquitectura) en Dibujo Tecnico
INSERT INTO students_courses (student_id, course_id) VALUES (6, 8); -- Valentina (Diseño) en Historia del Arte
INSERT INTO students_courses (student_id, course_id) VALUES (7, 3); -- Camila (Medicina) en Anatomia

---
INSERT INTO tasks (task_code, execution_time, creation_date, description) VALUES
    ('TASK-001', '2025-10-20 09:00:00', '2025-09-10', 'Realizar backup diario de la base de datos.');

INSERT INTO tasks (task_code, execution_time, creation_date, description) VALUES
    ('TASK-002', '2025-10-21 18:30:00', '2025-09-10', 'Enviar reporte de ventas semanal.');

INSERT INTO tasks (task_code, execution_time, creation_date, description) VALUES
    ('TASK-003', '2025-09-15 12:00:00', '2025-09-11', NULL);