#language: ru
  Функционал:  Развлечение

    Сценарий: Выбор фильма с рейтингом >=8

      Когда выбран пункт меню "Афиша"
      И выбран раздел "Кино"

      Тогда заголовок страницы - "Кино в Москве"

      Когда выбрана дата - "Завтра"
      И  найден фильм с рейтингом >= "8"

      Тогда проверены название фильма и количество кинотеатров