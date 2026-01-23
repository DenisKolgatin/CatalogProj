Использование шаблонов проектирования:

DRY - расчет налога вынесен в константу

<img width="696" height="248" alt="image" src="https://github.com/user-attachments/assets/5cb95465-b3da-4c0e-9e92-921a74131069" />

Вместо того чтобы указывать магическое число, я использовал число элементов в корзине - List<CartItem> items = new ArrayList<>()

<img width="718" height="196" alt="image" src="https://github.com/user-attachments/assets/a74c4082-5591-4ee1-b901-3979d9018d96" />


Принципы Solid. Здесь использую единственную ответственность - класс отвечает только за управление содержимым корзины
<img width="888" height="512" alt="image" src="https://github.com/user-attachments/assets/b460d722-49d4-490b-a4f3-f6389136cfcf" />

Класс Main  - реализует инверсию зависимостей. Высокоуровневый модуль Main зависит от абстракции OrderProcessor, а не от деталей реализации классов. 

Принцип Лисков используется в SimpleOrderProcessor. Класс-наследник можно использовать вместо базового класса OrderProcessor

<img width="1042" height="193" alt="image" src="https://github.com/user-attachments/assets/82e7490e-259e-40ab-a3ae-b59aedf051c9" />

Метод process класса OrderProcessor закрыт для изменения, но открыт для расширения через переопределение protected-методов.
