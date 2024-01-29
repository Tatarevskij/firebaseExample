
    Подключить Firebase к проекту.
    Настроить проект для получения отчётов о сбоях и ошибках, происходящих в приложении.
    Настроить проект для получения пуш-уведомлений от сервиса Firebase.


Подготовка к работе

Убедитесь, что девайс или эмулятор поддерживают google-services: без этого не будет возможности протестировать работу пуш-уведомлений. Для выполнения практической работы вы можете установить на эмулятор образ Android, включающий в себя google-services.


Что нужно сделать


    Создайте проект в консоли Firebase.
    Добавьте к созданному проекту Android-приложение:
        зарегистрируйте приложение в Firebase;
        скачайте полученный файл google-services.json и добавьте его в проект, в папку app (или аналогичную; ориентиром может служить файл build.gradle уровня приложения, а не проекта);
        если ранее вы уже регистрировали приложение, то повторно найти и скачать файл google-services.json можно в разделе Project Settings.

    Подключите необходимые библиотеки и плагины в файлах build.gradle уровня приложения и уровня проекта в соответствии с инструкцией (найдите её в консоли разработчика при создании проекта).
    Если у вас возникает ошибка, связанная с репозиторием Google, попробуйте удалить этот репозиторий из секции allProjects в файле build.gradle уровня проекта. Если это не поможет — обратитесь за помощью в конфигурации к проверяющему куратору.
    Подключите сервис Crashlytics к приложению в соответствии с инструкцией.
    Убедитесь, что всё подключено верно: спровоцируйте краш в приложении. Отчёт об ошибке должен появиться в консоли Firebase в разделе Crashlytics.
    Добавьте в приложение уведомление для пользователя при совершении какого-то действия. Для этого:
        создайте channel для уведомления;
        создайте сам UI-компонент Notification;
        наполните его необходимыми данными;
        отобразите Notification с помощью NotificationManagerCompat в нужный момент.
    Подключите сервис Messaging к приложению в соответствии с инструкцией.
    Убедитесь, что всё подключено верно: отправьте себе тестовое сообщение с помощью утилиты Notification Composer в консоли Firebase. Если сообщение не приходит: 
        Убедитесь, что приложение в background. Notification-сообщения обрабатываются автоматически, только когда приложение в background. Помните, что для обработки сообщения любого типа в foreground нужен отдельный сервис.
        Подождите какое-то время. У сервиса FCM могут быть задержки при обработке сообщений.
    Выполните по желанию:
        Добавьте сервис для обработки пуш-сообщений. Создайте класс, который наследуется от FirebaseMessagingService.
        Зарегистрируйте его в AndroidManifest. 
        Переопределите функцию onMessageReceived, напишите необходимый код для обработки сообщения и отображения его в виде уведомления.
        С помощью Firebase Messaging API и сервиса Postman отправьте себе несколько сообщений и убедитесь, что они приходят, а также отображаются в виде уведомлений и когда приложение в foreground, и когда приложение в background. Пошаговую инструкцию по работе с Firebase Messaging API и сервисом Postman можно найти в презентации к занятию.


Рекомендации по выполнению

    Создание проекта в Firebase и добавление приложения https://firebase.google.com/docs/android/setup?hl=ru
    Подключение Crashlytics https://firebase.google.com/docs/crashlytics/get-started?platform=android
    Подключение Messaging Service https://firebase.google.com/docs/cloud-messaging/android/first-message
    Обработка получаемых сообщений от FCM  https://firebase.google.com/docs/cloud-messaging/android/receive
    Создание channel для уведомлений https://developer.android.com/develop/ui/views/notifications/channels
    Создание уведомления https://developer.android.com/develop/ui/views/notifications/build-notification


Что оценивается

    Выполнены все обязательные пункты задания. 
    При краше приложения отчёт об ошибке приходит в сервис Crashlytics.



