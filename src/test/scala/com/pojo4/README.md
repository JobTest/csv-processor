
Важно отметить что POJO-класы используются разными фреймворками для создания сущности объекта:
1. (В программном коде иннициализия полей для сущности объекта POJO-класа выполняется серез конструктор с параметрами...)
2. Фреймворки иннициализируют поля для сущности объекта POJO-класа (бина) через get-set-методы.
   Такие бины - сериализрованные... 
   например: 
   - инициализация полей Entity-объекта и связей между таблицами через orm-фреймворк (hibernate, spring-jpa) 
   - биндинг DTO-объекта полученного в параметрах для spring-mvc
А еще от правильности создания/описания POJO-класа зависит продуктивность поведения объекта-ключа в хеш-таблицах...

Решение применять 'case-класы' или 'object' зависит от условия и слоя приложения где будет использоваться объект...
Например:
- сервисный слой должен держать единственный экземпляр класа-сервиса (синглтон), который потом можно будет автовайрить в web-слой (api)
- web-слой (api) используют конкретный протокол для обмена даными: ftp (файлы), http (клиент - приложение), soap (сервисы приложения), tcp/udp (стримы), jms...
  (использует request-скоуп)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Микросервисная архитектура позволяет держать web-приложение в рабочем состоянии в случае если один из микросервисов останавливается - а остальные компоненты приложения продолжают работать.
Чем больше микросервисов в приложении тем лучше для работы такого приложения.
Микросервисы одного приложения являются компонентами этого приложения, поэтому каждый компонент может договориться между собой на программном уровне как обмениваться данными (soap-протокол...)

Для стороних приложений существует общедоступное API (например: клиент-сервер...)
