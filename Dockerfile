# Устанавливаем базовый образб содержащий JDK
FROM openjdk:latest
# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /usr/src/app/
# Копируем исходный код приложения внутрь контейнера
COPY /src/main/ /usr/src/app/
# Компилируем Java исходный код
RUN javac -encoding utf8 -d docker_out @sourceFilesList
# Теперь рабочая директория - директория с компилированными файлами
WORKDIR /usr/src/app/docker_out
# Запускаем
ENTRYPOINT [ "java","main.java.lesson1.App" ]

# второй способ копирование и запуск уже имеющегося байт кода программы
# Устанавливаем базовый образб содержащий JDK
# FROM openjdk:latest
# Устанавливаем рабочую директорию внутри контейнера
# WORKDIR /usr/src/app/out
# Копируем директорию с готовым байт кодом внутрь контейнера
# COPY /src/main/out /usr/src/app/out
# Устанавливаем рабочую директорию внутри контейнера
# WORKDIR /usr/src/app/out
# Запускаем
# ENTRYPOINT [ "java","main.java.lesson1.App" ]