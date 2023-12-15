# Процедура запуска автотестов

После клонирования репозитория необходимо выполнить следующее:

1. В терминале выполнить команду:
   `docker-compose up`
2. В новой вкладке терминала запустить приложение командой:

Для использования СУБД PostgreSQL:
`java -jar aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app`

Для использования СУБД MySQL:
`java -jar aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`

- приложение будет доступно по ссылке: http://localhost:8080/

3. В новой вкладке терминала запустить прогон тестов командой:

Для СУБД PostgreSQL:
`./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`

Для СУБД MySQL:
`./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`

4. Запустить сервис формирования отчетов Allure командой:
   `./gradlew allureServe `

- сформированный отчет откроется автоматически в браузере.

5. Для остановки Allure в терминале ввести комбинацию клавиш Ctrl+C, нажать клавишу y.
6. Для остановки контейнеров ввести в терминале команду:
   `docker-compose down`
