# Описание.
-----------------------------------------------------------------------------------------
*Приложение Filmorate* - это площадка для общения и взаимодействия пользователей с возможность заводить друзей, оставлять отзывы и рекомендовать фильмы друг другу. Фукция *"Поиск"* позволяет легко находить фильмы по названию или режиссёру.    
Чтобы пользователи ориентировались в том, что происходит на платформе, в приложении есть *"Лента событий"*.      
Программа может принимать, обновлять и возвращать пользователей и фильмы.    
  
  
## Функции приложения:  
:heavy_check_mark: Функциональность *«Отзывы»*
 - Вывод всех фильмов режиссёра, отсортированных по количеству лайков.    
 - Вывод всех фильмов режиссёра, отсортированных по годам.
    
:heavy_check_mark: Функциональность *«Поиск»*
 - Алгоритм умеет искать по подстроке. Например, вы вводите *«крад»*, а в поиске возвращаются следующие фильмы: *«Крадущийся тигр, затаившийся дракон», «Крадущийся в ночи»* и другие. 
 - Кроме того, можно установить дополнительные параметры поиска: поиск по режиссёру, поиск по названию, либо оба значения через запятую при поиске одновременно и по режиссеру и по названию.
 - Полученный список фильмов отсортирован по популярности.

:heavy_check_mark: Функциональность *«Общие фильмы»*
 - Вывод общих с другом фильмов с сортировкой по их популярности.
 
:heavy_check_mark: Функциональность *«Рекомендации»*  

 Простая рекомендательная система для фильмов:    
 - Находится пользователь с максимальным количеством пересечения по лайкам.
 - Определяются фильмы, которые один пролайкал, а другой нет.
 - Рекомендуются фильмы, которым поставил лайк пользователь с похожими вкусами, а тот, для кого составляется рекомендация, ещё не поставил.
     Более подробно подобный алгоритм описан в этой [статье](https://www.baeldung.com/java-collaborative-filtering-recommendations).

:heavy_check_mark: Функциональность *«Лента событий»*
 - Отображаются последние события на платформе — добавление в друзья, удаление из друзей, лайки и отзывы, которые оставили друзья пользователя.

:heavy_check_mark: Функциональность *«Популярные фильмы»*
 - Вывод самых любимых у зрителей фильмов по жанрам и годам.

:heavy_check_mark: Функциональность *«Фильмы по режиссёрам»*
 - Добавление к фильму информации о его режиссёре.
   
:heavy_check_mark: Функциональность *«Удаление фильмов и пользователей»*
 - Удаление фильма или пользователя по идентификатору.
  
# Развертывание.
-----------------------------------------------------------------------------------------
Клонируйте репозиторий ( ссылка для клонирования: git@github.com:Dmitrii-Zz/java-filmorate.git ) и запустите приложение в IntelliJ IDEA. 
Так как у нашего API пока нет интерфейса, вы можете взаимодействовать с ним через веб-клиент Postman.

# Версии. 
-----------------------------------------------------------------------------------------
![Static Badge](https://img.shields.io/badge/11.0.18%20-%20green?label=java%20version)
![Static Badge](https://img.shields.io/badge/2.7.14%20-%20green?label=org.springframework.boot)
![Static Badge](https://img.shields.io/badge/1.18.20%20-%20green?label=lombok)


# Как работает приложение.
-----------------------------------------------------------------------------------------
После того, как приложение запущено в IntelliJ IDEA, откройте Postman или Insomnia.
Чтобы отправить запрос, сначала найдите HTTP-метод (например: GET) и введите путь для операции (например: http://localhost:8080/films/).

# API 
-----------------------------------------------------------------------------------------
|*Фильм*         | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Добавление фильма | POST | /films |
| Получение всех фильмов | GET | /films |
| Обновление фильма | PUT | /films |
| Список из первых count фильмов по количеству лайков. Если значение параметра count не задано, верните первые 10 | GET | /films/popular?count={count} |


|*Жанры*| *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список всех жанров | GET | /genres |
| Получение жанра по идентификатору | GET | /genres/{id} |

```
 // Пример возвращаемого значения
 {
   “id”: 1,
   “name”: “Комедия”
 }
```

|*Рейтинг*         | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список всех рейтингов | GET | /mpa |
| Получение рейтинга по идентификатору | GET | /mpa/{id} |

```
// Пример возвращаемого значения
 {
   “id”: 1,
   “name”: “G”
 }
```


|*Пользователь*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Cоздание пользователя | POST | /users |
| Обновление пользователя | PUT | /users |
| Получение списка всех пользователей | GET | /users |
| Добавление в друзья | PUT | /users/{id}/friends/{friendId} |
| Удаление из друзей | DELETE | /users/{id}/friends/{friendId} |
| Список пользователей, являющихся его друзьями | GET | /users/{id}/friends |
| Список друзей, общих с другим пользователем | GET | /users/{id}/friends/common/{otherId} |
| Пользователь ставит лайк фильму | PUT | /films/{id}/like/{userId} |
| Пользователь удаляет лайк | DELETE | /films/{id}/like/{userId} |


|*Функциональность «Отзывы»*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Добавление нового отзыва | POST | /reviews |
| Редактирование уже имеющегося отзыва | PUT | /reviews |
| Удаление уже имеющегося отзыва | DELETE | /reviews/{id} |
| Получение отзыва по идентификатору | GET | /reviews/{id} |
| Получение всех отзывов по идентификатору фильма, если фильм не указан то все. Если кол-во не указано то 10 | GET | /reviews?filmId={filmId}&count={count} |
| Пользователь ставит лайк отзыву | PUT | /reviews/{id}/like/{userId} |
| Пользователь ставит дизлайк отзыву | PUT | /reviews/{id}/dislike/{userId} |
| Пользователь удаляет лайк/дизлайк отзыву | DELETE | /reviews/{id}/like/{userId} |
| Пользователь удаляет дизлайк отзыву | DELETE | /reviews/{id}/dislike/{userId} |
 ```
Описание JSON-объекта с которым работают эндпоинты

{
    "reviewId": 123,
    "content": "This film is sooo baad.",
    "isPositive": false,
    "userId": 123, // Пользователь
    "filmId": 2, // Фильм
    "useful": 20 // рейтинг полезности 
}
```

|*Функциональность «Поиск»*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список фильмов, отсортированных по популярности | GET | /fimls/search |
| Параметры строки запроса | GET | /films/search?query=крад&by=director,title |
| **by** — может принимать значения **director** (поиск по режиссёру), **title** (поиск по названию), либо оба значения через запятую при поиске одновременно и по режиссеру и по названию| | |


|*Функциональность «Общие фильмы»*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список фильмов, отсортированных по популярности | GET | /films/common?userId={userId}&friendId={friendId} |
| Параметры строки запроса: | | |
| userId — идентификатор пользователя, запрашивающего информацию | | |
| friendId — идентификатор пользователя, с которым необходимо сравнить список фильмов | | |


|*Функциональность «Рекомендации»*          | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Рекомендации по фильмам для просмотра | GET | /users/{id}/recommendations |


|*Функциональность «Лента событий»*          | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Лента событий пользователя | GET | /users/{id}/feed |


|*Функциональность «Популярные фильмы»*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список самых популярных фильмов указанного жанра за нужный год | GET | /films/popular?count={limit}&genreId={genreId}&year={year} |

	
|*Функциональность «Фильмы по режиссёрам»*         | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Список фильмов режиссера отсортированных по количеству лайков или году выпуска | GET | /films/director/{directorId}?sortBy=[year,likes] |
| Список всех режиссёров | GET | /directors |
| Получение режиссёра по id | GET | /directors/{id} |
| Создание режиссёра | POST | /directors |
| Изменение режиссёра | PUT | /directors |
| Удаление режиссёра | DELETE | /directors/{id} |

```
POST /films

{
	"name": "New film",
	"releaseDate": "1999-04-30",
	"description": "New film about friends",
	"duration": 120,
	"mpa": { "id": 3},
	"genres": [{ "id": 1}],
	"director": [{ "id": 1}]
}
```

```
GET /directors
{
"id": 1,
"name": "New director"
}
```


|*Функциональность «Удаление фильмов и пользователей»*           | *HTTP-метод* | *Эндпоинт* |
|-|--------|---|
| Удаление пользователя по идентификатору | DELETE | /users/{userId} |
| Удаление фильма по идентификатору | DELETE | /films/{filmId} |


# Структура базы данных.
-----------------------------------------------------------------------------------------

![https://avatars1.githubusercontent.com/u/5384215?v=3&s=460](https://github.com/Ksenni888/CheckBrackets/blob/main/photo_2023-10-18_10-30-54.jpg)

Примеры запросов для работы с базой данных.

1. Отобразить всех пользователей:
```
SELECT (*)
FROM users;
```

2. Отобразить названия фильмов жанра "Ужас":
```
SELECT films.name
FROM films
WHERE films.film_id = (SELECT genre_film.film_id
                 FROM genre_film
                 WHERE genre_id = (SELECT genre_id
                                   FROM genres
                                   WHERE name = 'Ужас')) AS film_horror;               
```

3. Отобразить все фильмы:
```
SELECT (*)  
FROM films;
```

4. Отобразить существующие жанры фильмов:
```
SELECT name  
FROM genres
```

# Над приложением работали.
![Static Badge](https://img.shields.io/badge/%D0%94%D0%BC%D0%B8%D1%82%D1%80%D0%B8%D0%B9%20%D0%97%D0%BE%D0%BB%D0%BE%D1%82%D1%83%D1%85%D0%B8%D0%BD%20%20%F0%9F%90%B0%20-%20green)
![Static Badge](https://img.shields.io/badge/%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B9%20%D0%9F%D1%80%D0%B8%D1%81%D1%8F%D0%B6%D0%BD%D1%8E%D0%BA%20-%20green)
![Static Badge](https://img.shields.io/badge/%D0%94%D0%BC%D0%B8%D1%82%D1%80%D0%B8%D0%B9%20%D0%92%D0%B0%D1%80%D0%BD%D1%8F%D0%B3%D0%B0%20-%20green)
![Static Badge](https://img.shields.io/badge/%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B0%D0%BD%D0%B4%D1%80%20%D0%A4%D0%B8%D0%BB%D0%B0%D1%82%D0%BA%D0%BE%D0%B2%20-%20green)
![Static Badge](https://img.shields.io/badge/%D0%9A%D1%81%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%93%D0%B0%D0%BB%D0%B8%D1%87%D0%BA%D0%B8%D0%BD%D0%B0%20-%20green)


