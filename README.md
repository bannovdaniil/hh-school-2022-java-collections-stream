# hh-school-2022-java-collections-stream

Работа с Stream API,

_**Задания с 1 по 7** реализовать функционал классов, согласно заданиям._

1. Метод на входе принимает List<Integer> id людей, ходит за ними в сервис
   (он выдает несортированный Set<Person>, внутренняя работа сервиса неизвестна)
   нужно их отсортировать в том же порядке, что и переданные id.
   Оценить асимпотику работы
2. На вход принимаются две коллекции объектов Person и величина limit
   Необходимо объеденить обе коллекции
   отсортировать персоны по дате создания и выдать первые limit штук.
3. Отсортировать коллекцию сначала по фамилии, по имени (при равной фамилии), и по дате создания (при равных фамилии и
   имени)
4. Список персон класса Person необходимо сконвертировать в список ApiPersonDto
   (предположим, что это некоторый внешний формат)
   Конвертер для одной персоны - personConverter.convert()
5. Есть список персон, и словарь сопоставляющий id каждой персоны и id региона
   Необходимо выдать список персон ApiPersonDto, с правильно проставленными areaId
   Конвертер одной персоны дополнен!
6. Имеются:

- коллекция персон Collection<Person>
- словарь Map<Integer, Set<Integer>>, сопоставляющий каждой персоне множество id регионов
- коллекция всех регионов Collection<Area>
  На выходе хочется получить множество строк вида "Имя - регион".
  Если у персон регионов несколько, таких строк так же будет несколько

7. Из коллекции компаний необходимо получить всевозможные различные названия вакансий

_**Задание №8** Дан класс с неким функционалом, необходимо произвести рефакторинг.
По возможности переписать методы, на Stream API._

**Предисловие к заданию:**
А теперь о горьком
Всем придется читать код
А некоторым придется читать код, написанный мною.
Сочувствую им.
Спасите будущих жертв, и исправьте здесь все, что вам не по душе!
P.S. функции тут разные и рабочие (наверное), но вот их понятность и эффективность страдает (аж пришлось писать
комменты)
P.P.S Здесь ваши правки желательно прокомментировать (можно на гитхабе в пулл реквесте)

1. Не хотим выдывать апи нашу фальшивую персону, поэтому конвертим начиная со второй
2. ну и различные имена тоже хочется
3. Для фронтов выдадим полное имя, а то сами не могут
4. словарь id персоны -> ее имя
5. есть ли совпадающие в двух коллекциях персоны?
6. ...
