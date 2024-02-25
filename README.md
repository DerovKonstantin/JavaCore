## Дёров Константин Павлович 
## Семинар 1. Компиляция и интерпретация кода
### Задание.   
Создать проект из трёх классов (основной с точкой входа и два класса в другом пакете), которые вместе должны составлять одну программу, позволяющуюпроизводить четыре основных математических действия и осуществлять форматированныйвывод результатов пользователю (ИЛИ ЛЮБОЕ ДРУГОЕ ПРИЛОЖЕНИЕ НА ВАШ ВЫБОР, которое просто демонстрирует работу некоторого механизма).   
Создать Dockerfile, позволяющий откопировать исходный код вашего приложения в образ для демонстрации работы вашего приложения при создании соответствующего контейнера.

Подобную процедуру мы с вами проделали на уроке, теперь необходимо проделать данную процедуру самостоятельно.

### Решение.
В качестве приложения возмем приложение итоговой контройлной работы - Final-work-Animal-Nursery (Сиситема учета животных в питомнике) https://github.com/DerovKonstantin/-Final-work-Animal-Nursery   
**Всю работу будем производить в командной строке Windows**. 

--- 
Для начала проверим работоспособность приложения и основных команд. Перейдем в рабочую директорию с готовым приложение на компьютере, произведем компиляцию всех задействованных в работе приложения классов с помощю команды **javac**, запуустим скомпилированный код программы при помощи команды **java**, создадим файлы документацию разъяссняюще работу приложения при помощи команды **javadoc**.
* Microsoft Windows [Version 10.0.19044.1620]
(c) Корпорация Майкрософт (Microsoft Corporation). Все права защищены.   
* Меняем директорию.   
C:\Users\DiorO>cd /D F:\ProbaPera\ProbaPera_1\AnimalNursery\src\main 
* Производим компиляцию файлов.   
F:\ProbaPera\ProbaPera_1\AnimalNursery\src\main>javac -encoding utf8 -d out @sourceFilesList  
* Производим запуск программы.   
F:\ProbaPera\ProbaPera_1\AnimalNursery\src\main>java -classpath ./out main.java.lesson1.App  
* Создаем файлы с документацыей   
F:\ProbaPera\ProbaPera_1\AnimalNursery\src\main>javadoc -encoding utf8 -d docs @sourceFilesList  
---
Теперь можно создать Dockerfile, позволяющий откопировать исходный код вашего приложения в образ для демонстрации работы вашего приложения при создании соответствующего контейнера.
* Создаем Dockerfile.  
  * Устанавливаем базовый образб содержащий JDK   
FROM openjdk:latest   
  * Устанавливаем рабочую директорию внутри контейнера   
WORKDIR /usr/src/app/   
  * Копируем исходный код приложения внутрь контейнера   
COPY /src/main/ /usr/src/app/   
  * Компилируем Java исходный код   
RUN javac -encoding utf8 -d docker_out @sourceFilesList   
  * Теперь рабочая директория - директория с компилированными файлами   
WORKDIR /usr/src/app/docker_out   
  * Запускаем   
ENTRYPOINT [ "java","main.java.lesson1.App" ]   
* Билдим образ.   
F:\ProbaPera\ProbaPera_1\AnimalNursery>docker build -t animal_nursery_started .   
[+] Building 2.8s (10/10) FINISHED                                                       docker:default   
 => [internal] load build definition from Dockerfile                                               0.0s   
 => => transferring dockerfile: 1.16kB                                                             0.0s   
 => [internal] load metadata for docker.io/library/openjdk:latest                                  0.0s   
 => [internal] load .dockerignore                                                                  0.0s   
 => => transferring context: 2B                                                                    0.0s   
 => [1/5] FROM docker.io/library/openjdk:latest                                                    0.0s   
 => [internal] load build context                                                                  0.1s   
 => => transferring context: 679.65kB                                                              0.1s   
 => CACHED [2/5] WORKDIR /usr/src/app/                                                             0.0s   
 => CACHED [3/5] COPY /src/main/ /usr/src/app/                                                     0.0s   
 => [4/5] RUN javac -encoding utf8 -d docker_out @sourceFilesList                                  2.0s   
 => [5/5] WORKDIR /usr/src/app/docker_out                                                          0.2s   
 => exporting to image                                                                             0.2s   
 => => exporting layers                                                                            0.2s   
 => => writing image sha256:9944c20dc3e8f5b0fd4360ee9c506c3380c421e7850e5034f71eee4e56ad9713       0.0s   
 => => naming to docker.io/library/animal_nursery_started                                          0.0s   
View build details: docker-desktop://dashboard/build/default/default/vqtgxcs9s4cgbx8b8qf7gmux2    
What's Next?   
  ~1. Sign in to your Docker account → docker login    
  ~2. View a summary of image vulnerabilities and recommendations → docker scout quickview    

* Запускаем созданный контейнер интерактивно и проверяем работу приложения.   
F:\ProbaPera\ProbaPera_1\AnimalNursery>docker run -it animal_nursery_started   
Select language group(Выберите языковую группу)...   
   R - Russian(Русский)   
   E - English(Английский)   
...e   
You have chosen English...   
...   
Enter the command (one letter)...   
   E - EXIT   
   L - LIST   
   A - ADD   
   D - DELETE   
...l   
list of animals.................   
Cat [name = Sеrgеy, age = 21, id = 101, status = домашний]   
Dog [name = Andrеy, age = 22, id = 111, status = домашний]   
Donkey [name = Ivan, age = 22, id = 121, status = вьючный]   
Mull [name = Igorь, age = 23, id = 301, status = вьючный]   
Cat [name = Daшa, age = 25, id = 171, status = домашний]   
Dog [name = Lеna, age = 23, id = 104, status = домашний]   
...............................   
Enter the command (one letter)...   
   E - EXIT   
   L - LIST   
   A - ADD   
   D - DELETE   
...e   
Exit the program, the data has been saved!   
F:\ProbaPera\ProbaPera_1\AnimalNursery>   
# УРА ВСЕ РАБОТАЕТ !!!
![Это мой Wordpress!](DiorOFF_Wordpress$$$.bmp)
