insert into resource(name, path, department, visible)
values ('втор. проф. инсульта.pptx', 'втор. проф. инсульта.pptx', 1, 1),
       ('Для родственников инсульт.pptx', 'Для родственников инсульт.pptx', 1, 1),
       ('занятие 1.ppt', 'занятие 1.ppt', 1, 1),
       ('занятие 2.ppt', 'занятие 2.ppt', 1, 1),
       ('занятие 3.ppt', 'занятие 3.ppt', 1, 1),
       ('занятие 4.ppt', 'занятие 4.ppt', 1, 1),
       ('занятие 5.ppt', 'занятие 5.ppt', 1, 1),
       ('Остеоартроз.pptx', 'Остеоартроз.pptx', 1, 1);

-- Реабилитация эндопротез
insert into resource(name, path, department)
values ('Энд_КС_1программа_А.docx', 'programs\Энд_КС_1программа_А.docx', 1);
insert into program(number, type, resource_id)
values (1, 1, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_1программа_Б.docx', 'programs\Энд_КС_1программа_Б.docx', 1);
insert into program(number, type, resource_id)
values (1, 2, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_1программа_В.docx', 'programs\Энд_КС_1программа_В.docx', 1);
insert into program(number, type, resource_id)
values (1, 3, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_2программа_А.docx', 'programs\Энд_КС_2программа_А.docx', 1);
insert into program(number, type, resource_id)
values (2, 1, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_2программа_Б.docx', 'programs\Энд_КС_2программа_Б.docx', 1);
insert into program(number, type, resource_id)
values (2, 2, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_2программа_В.docx', 'programs\Энд_КС_2программа_В.docx', 1);
insert into program(number, type, resource_id)
values (2, 3, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_3программа_А.docx', 'programs\Энд_КС_3программа_А.docx', 1);
insert into program(number, type, resource_id)
values (3, 1, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_3программа_Б.docx', 'programs\Энд_КС_3программа_Б.docx', 1);
insert into program(number, type, resource_id)
values (3, 2, (select ident_current('resource')));

insert into resource(name, path, department)
values ('Энд_КС_3программа_В.docx', 'programs\Энд_КС_3программа_В.docx', 1);
insert into program(number, type, resource_id)
values (3, 3, (select ident_current('resource')));

insert into test(name, department, test_process_type, visible)
values ('Реабилитация эндопротез', 1, 1, 1);

insert into question(name, ordinal, test_id)
values ('Определить наличие противопоказаний к проведению ' +
        'реабилитации после эндопротезирования коленного сустава', 1, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Тромбоз глубоких вен',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}',
        1, (select ident_current('question'))),
       ('Нестабильность протеза',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}',
        2, (select ident_current('question'))),
       ('Тромбоэмболия легочной артерии',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}',
        3, (select ident_current('question'))),
       ('Острая сердечно-сосудистая или дыхательная недостаточность',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}',
        4, (select ident_current('question'))),
       ('Инфекционное воспалительное заболевание с повышением температуры выше 38°С',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}',
        5, (select ident_current('question'))),
       ('Противопоказания отсутствуют',
        '{}',
        6, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Установить тип эндопротеза коленного сустава', 2, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Трехкомпонентый эндопротез (замена трех суставных поверхностей, включая надколенник)',
        '{"number":1}', 1, (select ident_current('question'))),
       ('Двухкомпонентный эндопротез', '{"number":1}', 2, (select ident_current('question'))),
       ('Одномыщелковый эндопротез', '{"number":2}', 3, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Способ фиксации эндопротеза коленного сустава', 3, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Цементный способ фиксации', '{"number":1}', 1, (select ident_current('question'))),
       ('Бесцементый способ фиксации', '{"number":3}', 2, (select ident_current('question'))),
       ('Гибридный способ фиксации', '{"number":3}', 3, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Уточнить наличие выраженной контрактуры до операции', 4, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Наличие выраженной контрактуры до операции',
        '{"recommendation":"В программу добавить использование аппаратов постоянного пассивного движения"}',
        1, (select ident_current('question'))),
       ('Отсутствие выраженной контрактуры до операции', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Сроки после операции', 5, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Меньше 4 недель', '{"type":1}', 1, (select ident_current('question'))),
       ('Более 4 недель', '{"type":2}', 2, (select ident_current('question'))),
       ('Более 8 недель', '{"type":3}', 3, (select ident_current('question')));


-- V. Показания к медицинской реабилитации: Шкала медицинской реабилитации
--    (выберите одну позицию по каждому пункту)

-- Если было выбрано ранее заболевания и травмы ЦНС

insert into test(name, department, test_process_type)
values ('Показания к медицинской реабилитации при ' +
        'заболеваниях и травмах центральной нервной системы', 0, 2);

insert into question(name, ordinal, test_id)
values ('Передвижение', 1, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Самостоятельно', '{"score":2}', 1, (select ident_current('question'))),
       ('Самостоятельно, возможно с помощью трости', '{"score":3}', 2, (select ident_current('question'))),
       ('С посторонней помощью, в т.ч. на кресле-коляске', '{"score":4}', 3, (select ident_current('question'))),
       ('Не передвигается, прикован к постели', '{"score":5}', 4, (select ident_current('question'))),
       ('Прикован к постели', '{"score":6}', 5, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Самообслуживание', 2, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Легкое ограничение (управление транспортом, чтение, письмо, танцы, работа и др)',
        '{"score":2}', 1, (select ident_current('question'))),
       ('Нуждается в помощи при осуществлении сложных видов деятельности' +
        '(приготовление пищи, уборка, поход в магазин и др.)', '{"score":3}', 2, (select ident_current('question'))),
       ('Нуждается в помощи при выполнении повседневных задач' +
        '(одевание, раздевание, туалет, прием пищи и др.)', '{"score":4}', 3, (select ident_current('question'))),
       ('Нуждается в помощи при выполнении всех повседневных задач',
        '{"score":5}', 4, (select ident_current('question'))),
       ('Полностью зависим от посторонней помощи', '{"score":6}', 5, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Нуждаемость в посторонней помощи', 3, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Не нуждается', '{"score":2}', 1, (select ident_current('question'))),
       ('Нуждается в помощи при ведении финансовых дел', '{"score":3}', 2, (select ident_current('question'))),
       ('В обычной жизни нуждается в ухаживающем', '{"score":4}', 3, (select ident_current('question'))),
       ('Нуждается в ухаживающем постоянно (и днем и ночью)', '{"score":5}', 4, (select ident_current('question'))),
       ('Специальный уход в условиях реанимационного отделения', '{"score":6}', 5, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Способность к самостоятельному проживанию', 4, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Может проживать один более недели', '{"score":2}', 1, (select ident_current('question'))),
       ('Может проживать один от 1 суток до недели', '{"score":3}', 2, (select ident_current('question'))),
       ('Может проживать один до 1 суток', '{"score":4}', 3, (select ident_current('question'))),
       ('Не может быть оставлен один', '{"score":5}', 4, (select ident_current('question')));

-- Если было выбрано ранее опорно-двигательный аппарат

insert into test(name, department, test_process_type)
values ('Показания к медицинской реабилитации при ' +
        'заболеваниях и травмах опорно-двигательного аппарата', 0, 2);

insert into question(name, ordinal, test_id)
values ('Передвижение', 1, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Самостоятельно', '{"score":2}', 1, (select ident_current('question'))),
       ('Самостоятельно, возможно с помощью трости', '{"score":3}', 2, (select ident_current('question'))),
       ('С дополнительными средствами опоры – костыли', '{"score":4}', 3, (select ident_current('question'))),
       ('С дополнительными средствами опоры – ходунки, ' +
        'или в кресле-коляске', '{"score":5}', 4, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Самообслуживание', 2, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Легкое ограничение (управление транспортом, чтение, письмо, танцы, работа и др)+',
        '{"score":2}', 1, (select ident_current('question'))),
       ('Нуждается в помощи при осуществлении сложных видов деятельности ' +
        '(приготовление пищи, уборка, поход в магазин и др.)', '{"score":3}', 2, (select ident_current('question'))),
       ('Умеренное ограничение: нуждается в помощи при выполнении повседневных задач ' +
        '(одевание, раздевание, туалет, прием пищи и др.)', '{"score":4}', 3, (select ident_current('question'))),
       ('Выраженное ограничение: нуждается в помощи при выполнении всех повседневных задач',
        '{"score":5}', 4, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Интенсивность болевого синдрома', 3, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('1-3', '{"score":3}', 1, (select ident_current('question'))),
       ('4-7', '{"score":4}', 2, (select ident_current('question'))),
       ('8-10', '{"score":5}', 3, (select ident_current('question')));

-- Если было выбрано периферическая нервная система

insert into test(name, department, test_process_type)
values ('Показания к медицинской реабилитации при ' +
        'заболеваниях и травмах периферической нервной системы', 0, 2);

insert into question(name, ordinal, test_id)
values ('Передвижение', 1, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Самостоятельно', '{"score":2}', 1, (select ident_current('question'))),
       ('Самостоятельно, возможно с помощью трости', '{"score":3}', 2, (select ident_current('question'))),
       ('С дополнительными средствами опоры – костыли', '{"score":4}', 3, (select ident_current('question'))),
       ('С дополнительными средствами опоры – ходунки, или в кресле-коляске',
        '{"score":5}', 4, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Самообслуживание', 2, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Легкое ограничение (управление транспортом, чтение, письмо, танцы, работа и др)+',
        '{"score":2}', 1, (select ident_current('question'))),
       ('Нуждается в помощи при осуществлении сложных видов деятельности ' +
        '(приготовление пищи, уборка, поход в магазин и др.)', '{"score":3}', 2, (select ident_current('question'))),
       ('Умеренное ограничение: нуждается в помощи при выполнении повседневных задач ' +
        '(одевание, раздевание, туалет, прием пищи и др.)', '{"score":4}', 3, (select ident_current('question'))),
       ('Выраженное ограничение: нуждается в помощи при выполнении всех повседневных задач',
        '{"score":5}', 4, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Интенсивность болевого синдрома', 3, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('1-3', '{"score":3}', 1, (select ident_current('question'))),
       ('4-7', '{"score":4}', 2, (select ident_current('question'))),
       ('8-10', '{"score":5}', 3, (select ident_current('question')));


-- VI. Определение наличия противопоказаний (я) для этапной медицинской реабилитации,
--     выберите подходящий ответ по каждому вопросу

insert into test(name, department, test_process_type)
values ('Определение наличия противопоказаний(я) для этапной медицинской реабилитации', 0, 3)

insert into question(name, ordinal, test_id)
values ('Прогрессирующий неврологический дефицит', 1, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Экстренная госпитализация в неврологическое/сосудистое отделение"]}',
        1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Декомпенсация соматических функций', 2, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Экстренная госпитализация в терапевтическое/кардиологическое отделение"]}',
        1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Наличие инфекционно-воспалительного процесса', 3, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Лечение у профильного специалиста (хирург, инфекционист и др.)"]}',
        1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Отсутствие продуктивного контакта с пациентом ' +
        '(сенсорная афазия, деменция, психоорганический синдром)', 4, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация в Центре патологии речи и нейрореабилитации ДЗМ", ' +
              '"Консультация психиатра", "Паллиативная помощь"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Сопутствующие заболевания в острой стадии, ' +
        'хронические заболевания в стадии обострения', 5, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Лечение у профильного специалиста"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Инфекционные заболевания в острой или заразной форме', 6, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Изоляция, лечение профильного специалиста"]}',
        1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Тяжелые психические заболевания: продуктивная симптоматика ' +
        '(бред, галлюцинации), дезориентация пациента, эпизоды спутанности ' +
        'сознания с психомоторным возбуждением, тяжелая депрессия, ' +
        'суицидальные высказывания и др.', 7, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация психиатра"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Эпилепсия с частыми (3 и более приступа в месяц) ' +
        'или органическими изменениями личности', 8, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация невролога-эпилептолога"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Все виды наркомании и алкоголизма ' +
        '(за исключением стойкой ремиссии – более года)', 9, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Курс лечения в условиях МНПЦ наркологии ДЗМ"]}',
        1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Кахексия', 10, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Лечение у профильного специалиста"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Анемия (Нв ниже 90 г/л)', 11, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация гематолога"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Тяжелые нарушения сердечного ритма и проводимости', 12, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация кардиолога"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Недостаточность кровообращения 2б-3ст', 13, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация кардиолога"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Высокий риск тромбоэмболических осложнений', 14, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация сосудистого хирурга", "УЗДГ вен нижних конечностей"]}',
        1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Сахарный диабет в стадии декомпенсации', 15, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация эндокринолога"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Пролежни 2 стадии и выше (с нарушением целостности кожных покровов)', 16, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация хирурга"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Наличие показаний к оперативному вмешательству или ' +
        'применению других специальных методов лечения', 17, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Лечение у профильного специалиста"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Злокачественные новообразования ' +
        '(за исключением III клинической группы диспансерного наблюдения)', 18, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Консультация онколога с заключением о принадлежности пациента ' +
              'к одной из групп диспансерного наблюдения"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));

insert into question(name, ordinal, test_id)
values ('Доброкачественные новообразования', 19, (select ident_current('test')));

insert into answer(name, data, ordinal, question_id)
values ('Да', '{"recommendations":["Заключение онколога об отсутствии необходимости радикального лечения, ' +
              'риска при проведении физических методов реабилитации"]}', 1, (select ident_current('question'))),
       ('Нет', '{}', 2, (select ident_current('question')));


-- VIII. Определения полноты комплекса обследований,
--       выберите подходящий ответ по каждому вопросу

-- Если была выбрана поликлиника

insert into test(name, department, test_process_type)
values ('Определения полноты комплекса обследований для поликлиники', 0, 3)

insert into question(name, ordinal, test_id)
values ('Документ, удостоверяющий личность физического лица (паспорт)', 1, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Документ, удостоверяющий личность физического лица (паспорт)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Полис обязательного медицинского страхования', 2, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Полис обязательного медицинского страхования"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Направление на госпитализацию (форма N 057/у-04)', 3, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Направление на госпитализацию (форма N 057/у-04)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Копия выписки из карты амбулаторного, стационарного больного (форма N 027/у), с указанием результатов проведенных лабораторных, инструментальных и других видов исследования по профилю заболевания пациента, сведений о перенесенных заболеваниях',
        4, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Копия выписки из карты амбулаторного, стационарного больного (форма N 027/у), с указанием результатов проведенных лабораторных, инструментальных и других видов исследования по профилю заболевания пациента, сведений о перенесенных заболеваниях"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Клинический анализ крови (сроком давности до 20 дней)', 5, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Клинический анализ крови (сроком давности до 20 дней)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Общий анализ мочи (сроком давности до 20 дней)', 6, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Общий анализ мочи (сроком давности до 20 дней)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Биохимический анализ крови: глюкоза, общий билирубин и его фракции, АСТ, АЛТ, мочевина, креатинин, щелочная фосфатаза, общий белок (сроком давности до 30 дней)',
        7, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Биохимический анализ крови: глюкоза, общий билирубин и его фракции, АСТ, АЛТ, мочевина, креатинин, щелочная фосфатаза, общий белок (сроком давности до 30 дней)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Рентгенограммы, данные КТ или МРТ (сроком давности до 6 месяцев)', 8, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Рентгенограммы, данные КТ или МРТ (сроком давности до 6 месяцев)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Коагулограмма, электрокардиография, ЭХО-КГ (для пациентов кардиологического профиля)', 9,
        (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Коагулограмма, электрокардиография, ЭХО-КГ (для пациентов кардиологического профиля)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Холтеровское мониторирование ЭКГ (для пациентов с нарушениями ритма) - сроком давности до 30 дней', 10,
        (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Холтеровское мониторирование ЭКГ (для пациентов с нарушениями ритма) - сроком давности до 30 дней"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Флюорография/рентгенография грудной клетки (сроком давности до 6 месяцев), при невозможности выполнения (маломобильные пациенты) - анализ мокроты на микобактерии туберкулеза методом микроскопии или молекулярно-генетическим методом (сроком давности до 3 месяцев)',
        11, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Флюорография/рентгенография грудной клетки (сроком давности до 6 месяцев), при невозможности выполнения (маломобильные пациенты) - анализ мокроты на микобактерии туберкулеза методом микроскопии или молекулярно-генетическим методом (сроком давности до 3 месяцев)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Заключение гинеколога (женщинам) - сроком давности до 30 дней', 12, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Заключение гинеколога (женщинам) - сроком давности до 30 дней"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Исследование крови на сифилис методом ИФА (суммарные антитела) (сроком давности до 3 месяцев)', 13,
        (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Исследование крови на сифилис методом ИФА (суммарные антитела) (сроком давности до 3 месяцев)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Исследование крови на маркеры гепатитов В и С (сроком давности до 3 месяцев)', 14,
        (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Исследование крови на маркеры гепатитов В и С (сроком давности до 3 месяцев)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Исследование крови на ВИЧ-инфекцию (сроком давности до 3 месяцев)', 15, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Исследование крови на ВИЧ-инфекцию (сроком давности до 3 месяцев)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Справка об иммунизации против кори (в соответствии с приказом Департамента здравоохранения города Москвы от 28.08.2017 N 599 "О проведении дополнительных санитарно-противоэпидемических (профилактических) мероприятий против кори',
        16, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Справка об иммунизации против кори (в соответствии с приказом Департамента здравоохранения города Москвы от 28.08.2017 N 599 \"О проведении дополнительных санитарно-противоэпидемических (профилактических) мероприятий против кори\""]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

-- для стационара

insert into test(name, department, test_process_type)
values ('Определения полноты комплекса обследований для стационара', 0, 3)

insert into question(name, ordinal, test_id)
values ('Диагноз клинический по рубрикам', 1, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Диагноз клинический по рубрикам"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Код МКБ-10 основного заболевания', 2, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Код МКБ-10 основного заболевания"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Анамнез', 3, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Анамнез"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Объективный статус, неврологический статус, местный статус на дату эпикриза', 4,
        (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Объективный статус, неврологический статус, местный статус на дату эпикриза"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Название операции', 5, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Название операции"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Проводимое лечение (антикоагулянтная терапия дата завершения)', 6, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Проводимое лечение (антикоагулянтная терапия дата завершения)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Обследования, актуальные в после операционном периоде', 7, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Обследования, актуальные в после операционном периоде"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Количество баллов по ШРМ, (Рэнкин. Ривермед)', 8, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Количество баллов по ШРМ, (Рэнкин. Ривермед)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Контакты ответственного лица за перевод (Ф.И.О., телефон, email)', 9, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Контакты ответственного лица за перевод (Ф.И.О., телефон, email)"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');

insert into question(name, ordinal, test_id)
values ('Планируемая дата выписки', 10, (select ident_current('test')));

insert into answer(name, ordinal, question_id, data)
values ('Да', 1, (select ident_current('question')), '{}'),
       ('Нет', 2, (select ident_current('question')),
        '{"recommendations":["Планируемая дата выписки"]}'),
       ('Не применимо', 3, (select ident_current('question')), '{}');