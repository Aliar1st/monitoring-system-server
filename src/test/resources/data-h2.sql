-- Реабилитация эндопротез

insert into resource(name, path, department, visible)
values ('втор. проф. инсульта.pptx', 'втор. проф. инсульта.pptx', 1, 1);
insert into resource(name, path, department, visible)
values ('Для родственников инсульт.pptx', 'Для родственников инсульт.pptx', 1, 1);
insert into resource(name, path, department, visible)
values ('занятие 1.ppt', 'занятие 1.ppt', 1, 1);
insert into resource(name, path, department, visible)
values ('занятие 2.ppt', 'занятие 2.ppt', 1, 1);
insert into resource(name, path, department, visible)
values ('занятие 3.ppt', 'занятие 3.ppt', 1, 1);
insert into resource(name, path, department, visible)
values ('занятие 4.ppt', 'занятие 4.ppt', 1, 1);
insert into resource(name, path, department, visible)
values ('занятие 5.ppt', 'занятие 5.ppt', 1, 1);
insert into resource(name, path, department, visible)
values ('Остеоартроз.pptx', 'Остеоартроз.pptx', 1, 1);

-- Реабилитация эндопротез
insert into resource(name, path, department)
values ('Энд_КС_1программа_А.docx', 'programs\Энд_КС_1программа_А.docx', 1);
insert into program(number, type, resource_id)
values (1, 1, 9);

insert into resource(name, path, department)
values ('Энд_КС_1программа_Б.docx', 'programs\Энд_КС_1программа_Б.docx', 1);
insert into program(number, type, resource_id)
values (1, 2, 10);

insert into resource(name, path, department)
values ('Энд_КС_1программа_В.docx', 'programs\Энд_КС_1программа_В.docx', 1);
insert into program(number, type, resource_id)
values (1, 3, 11);

insert into resource(name, path, department)
values ('Энд_КС_2программа_А.docx', 'programs\Энд_КС_2программа_А.docx', 1);
insert into program(number, type, resource_id)
values (2, 1, 12);

insert into resource(name, path, department)
values ('Энд_КС_2программа_Б.docx', 'programs\Энд_КС_2программа_Б.docx', 1);
insert into program(number, type, resource_id)
values (2, 2, 13);

insert into resource(name, path, department)
values ('Энд_КС_2программа_В.docx', 'programs\Энд_КС_2программа_В.docx', 1);
insert into program(number, type, resource_id)
values (2, 3, 14);

insert into resource(name, path, department)
values ('Энд_КС_3программа_А.docx', 'programs\Энд_КС_3программа_А.docx', 1);
insert into program(number, type, resource_id)
values (3, 1, 15);

insert into resource(name, path, department)
values ('Энд_КС_3программа_Б.docx', 'programs\Энд_КС_3программа_Б.docx', 1);
insert into program(number, type, resource_id)
values (3, 2, 16);

insert into resource(name, path, department)
values ('Энд_КС_3программа_В.docx', 'programs\Энд_КС_3программа_В.docx', 1);
insert into program(number, type, resource_id)
values (3, 3, 17);

insert into test(id, name, department, test_process_type)
values (1, 'Реабилитация эндопротез', 1, 1);

insert into question(id, name, ordinal, test_id)
values (1, 'Определить наличие противопоказаний к проведению реабилитации после эндопротезирования коленного сустава',
        1, 1);

insert into answer(id, name, data, ordinal, question_id)
values (1, 'Тромбоз глубоких вен',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}', 1, 1);
insert into answer(id, name, data, ordinal, question_id)
values (2, 'Нестабильность протеза',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}', 2, 1);
insert into answer(id, name, data, ordinal, question_id)
values (3, 'Тромбоэмболия легочной артерии',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}', 3, 1);
insert into answer(id, name, data, ordinal, question_id)
values (4, 'Острая сердечно-сосудистая или дыхательная недостаточность',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}', 4, 1);
insert into answer(id, name, data, ordinal, question_id)
values (5, 'Инфекционное воспалительное заболевание с повышением температуры выше 38°С',
        '{"recommendation":"Реабилитацию необходимо отложить. Начать после стабилизации состояния"}', 5, 1);
insert into answer(id, name, data, ordinal, question_id)
values (6, 'Противопоказания отсутствуют', '{}', 6, 1);

insert into question(id, name, ordinal, test_id)
values (2, 'Установить тип эндопротеза коленного сустава', 2, 1);

insert into answer(id, name, data, ordinal, question_id)
values (7, 'Трехкомпонентый эндопротез (замена трех суставных поверхностей, включая надколенник)',
        '{"number":1}', 1, 2);
insert into answer(id, name, data, ordinal, question_id)
values (8, 'Двухкомпонентный эндопротез', '{"number":1}', 2, 2);
insert into answer(id, name, data, ordinal, question_id)
values (9, 'Одномыщелковый эндопротез', '{"number":2}', 3, 2);

insert into question(id, name, ordinal, test_id)
values (3, 'Способ фиксации эндопротеза коленного сустава', 3, 1);

insert into answer(id, name, data, ordinal, question_id)
values (10, 'Цементный способ фиксации', '{"number":1}', 1, 3);
insert into answer(id, name, data, ordinal, question_id)
values (11, 'Бесцементый способ фиксации', '{"number":3}', 2, 3);
insert into answer(id, name, data, ordinal, question_id)
values (12, 'Гибридный способ фиксации', '{"number":3}', 3, 3);

insert into question(id, name, ordinal, test_id)
values (4, 'Уточнить наличие выраженной контрактуры до операции', 4, 1);

insert into answer(id, name, data, ordinal, question_id)
values (13, 'Наличие выраженной контрактуры до операции',
        '{"recommendation":"В программу добавить использование аппаратов постоянного пассивного движения"}', 1, 4);
insert into answer(id, name, data, ordinal, question_id)
values (14, 'Отсутствие выраженной контрактуры до операции', '{}', 2, 4);

insert into question(id, name, ordinal, test_id)
values (5, 'Сроки после операции', 5, 1);

insert into answer(id, name, data, ordinal, question_id)
values (15, 'Меньше 4 недель', '{"type":1}', 1, 5);
insert into answer(id, name, data, ordinal, question_id)
values (16, 'Более 4 недель', '{"type":2}', 2, 5);
insert into answer(id, name, data, ordinal, question_id)
values (17, 'Более 8 недель', '{"type":3}', 3, 5);


-- V. Показания к медицинской реабилитации: Шкала медицинской реабилитации
--    (выберите одну позицию по каждому пункту)

-- Если было выбрано ранее заболевания и травмы ЦНС

insert into test(id, name, department, test_process_type)
values (2, 'Показания к медицинской реабилитации при заболеваниях и травмах центральной нервной системы', 0, 2);

insert into question(id, name, ordinal, test_id)
values (6, 'Передвижение', 1, 2);

insert into answer(id, name, data, ordinal, question_id)
values (18, 'Самостоятельно', '{"score":2}', 1, 6);
insert into answer(id, name, data, ordinal, question_id)
values (19, 'Самостоятельно, возможно с помощью трости', '{"score":3}', 2, 6);
insert into answer(id, name, data, ordinal, question_id)
values (20, 'С посторонней помощью, в т.ч. на кресле-коляске', '{"score":4}', 3, 6);
insert into answer(id, name, data, ordinal, question_id)
values (21, 'Не передвигается, прикован к постели', '{"score":5}', 4, 6);
insert into answer(id, name, data, ordinal, question_id)
values (22, 'Прикован к постели', '{"score":6}', 5, 6);

insert into question(id, name, ordinal, test_id)
values (7, 'Самообслуживание', 2, 2);

insert into answer(id, name, data, ordinal, question_id)
values (23, 'Легкое ограничение (управление транспортом, чтение, письмо, танцы, работа и др)', '{"score":2}', 1, 7);
insert into answer(id, name, data, ordinal, question_id)
values (24,
        'Нуждается в помощи при осуществлении сложных видов деятельности(приготовление пищи, уборка, поход в магазин и др.)',
        '{"score":3}', 2, 7);
insert into answer(id, name, data, ordinal, question_id)
values (25, 'Нуждается в помощи при выполнении повседневных задач(одевание, раздевание, туалет, прием пищи и др.)',
        '{"score":4}', 3, 7);
insert into answer(id, name, data, ordinal, question_id)
values (26, 'Нуждается в помощи при выполнении всех повседневных задач', '{"score":5}', 4, 7);
insert into answer(id, name, data, ordinal, question_id)
values (27, 'Полностью зависим от посторонней помощи', '{"score":6}', 5, 7);

insert into question(id, name, ordinal, test_id)
values (8, 'Нуждаемость в посторонней помощи', 3, 2);

insert into answer(id, name, data, ordinal, question_id)
values (28, 'Не нуждается', '{"score":2}', 1, 8);
insert into answer(id, name, data, ordinal, question_id)
values (29, 'Нуждается в помощи при ведении финансовых дел', '{"score":3}', 2, 8);
insert into answer(id, name, data, ordinal, question_id)
values (30, 'В обычной жизни нуждается в ухаживающем', '{"score":4}', 3, 8);
insert into answer(id, name, data, ordinal, question_id)
values (31, 'Нуждается в ухаживающем постоянно (и днем и ночью)', '{"score":5}', 4, 8);
insert into answer(id, name, data, ordinal, question_id)
values (32, 'Специальный уход в условиях реанимационного отделения', '{"score":6}', 5, 8);

insert into question(id, name, ordinal, test_id)
values (9, 'Способность к самостоятельному проживанию', 4, 2);

insert into answer(id, name, data, ordinal, question_id)
values (33, 'Может проживать один более недели', '{"score":2}', 1, 9);
insert into answer(id, name, data, ordinal, question_id)
values (34, 'Может проживать один от 1 суток до недели', '{"score":3}', 2, 9);
insert into answer(id, name, data, ordinal, question_id)
values (35, 'Может проживать один до 1 суток', '{"score":4}', 3, 9);
insert into answer(id, name, data, ordinal, question_id)
values (36, 'Не может быть оставлен один', '{"score":5}', 4, 9);

-- Если было выбрано ранее опорно-двигательный аппарат

insert into test(id, name, department, test_process_type)
values (3, 'Показания к медицинской реабилитации при заболеваниях и травмах опорно-двигательного аппарата', 0, 2);

insert into question(id, name, ordinal, test_id)
values (10, 'Передвижение', 1, 3);

insert into answer(id, name, data, ordinal, question_id)
values (37, 'Самостоятельно', '{"score":2}', 1, 10);
insert into answer(id, name, data, ordinal, question_id)
values (38, 'Самостоятельно, возможно с помощью трости', '{"score":3}', 2, 10);
insert into answer(id, name, data, ordinal, question_id)
values (39, 'С дополнительными средствами опоры – костыли', '{"score":4}', 3, 10);
insert into answer(id, name, data, ordinal, question_id)
values (40, 'С дополнительными средствами опоры – ходунки, или в кресле-коляске', '{"score":5}', 4, 10);

insert into question(id, name, ordinal, test_id)
values (11, 'Самообслуживание', 2, 3);

insert into answer(id, name, data, ordinal, question_id)
values (41, 'Легкое ограничение (управление транспортом, чтение, письмо, танцы, работа и др)+', '{"score":2}', 1, 11);
insert into answer(id, name, data, ordinal, question_id)
values (42,
        'Нуждается в помощи при осуществлении сложных видов деятельности (приготовление пищи, уборка, поход в магазин и др.)',
        '{"score":3}', 2, 11);
insert into answer(id, name, data, ordinal, question_id)
values (43,
        'Умеренное ограничение: нуждается в помощи при выполнении повседневных задач (одевание, раздевание, туалет, прием пищи и др.)',
        '{"score":4}', 3, 11);
insert into answer(id, name, data, ordinal, question_id)
values (44, 'Выраженное ограничение: нуждается в помощи при выполнении всех повседневных задач', '{"score":5}', 4, 11);

insert into question(id, name, ordinal, test_id)
values (12, 'Интенсивность болевого синдрома', 3, 3);

insert into answer(id, name, data, ordinal, question_id)
values (45, '1-3', '{"score":3}', 1, 12);
insert into answer(id, name, data, ordinal, question_id)
values (46, '4-7', '{"score":4}', 2, 12);
insert into answer(id, name, data, ordinal, question_id)
values (47, '8-10', '{"score":5}', 3, 12);

-- Если было выбрано периферическая нервная система

insert into test(id, name, department, test_process_type)
values (4, 'Показания к медицинской реабилитации при заболеваниях и травмах периферической нервной системы', 0, 2);

insert into question(id, name, ordinal, test_id)
values (13, 'Передвижение', 1, 4);

insert into answer(id, name, data, ordinal, question_id)
values (48, 'Самостоятельно', '{"score":2}', 1, 13);
insert into answer(id, name, data, ordinal, question_id)
values (49, 'Самостоятельно, возможно с помощью трости', '{"score":3}', 2, 13);
insert into answer(id, name, data, ordinal, question_id)
values (50, 'С дополнительными средствами опоры – костыли', '{"score":4}', 3, 13);
insert into answer(id, name, data, ordinal, question_id)
values (51, 'С дополнительными средствами опоры – ходунки, или в кресле-коляске', '{"score":5}', 4, 13);

insert into question(id, name, ordinal, test_id)
values (14, 'Самообслуживание', 2, 4);

insert into answer(id, name, data, ordinal, question_id)
values (52, 'Легкое ограничение (управление транспортом, чтение, письмо, танцы, работа и др)+', '{"score":2}', 1, 14);
insert into answer(id, name, data, ordinal, question_id)
values (53,
        'Нуждается в помощи при осуществлении сложных видов деятельности (приготовление пищи, уборка, поход в магазин и др.)',
        '{"score":3}', 2, 14);
insert into answer(id, name, data, ordinal, question_id)
values (54,
        'Умеренное ограничение: нуждается в помощи при выполнении повседневных задач (одевание, раздевание, туалет, прием пищи и др.)',
        '{"score":4}', 3, 14);
insert into answer(id, name, data, ordinal, question_id)
values (55, 'Выраженное ограничение: нуждается в помощи при выполнении всех повседневных задач', '{"score":5}', 4, 14);

insert into question(id, name, ordinal, test_id)
values (15, 'Интенсивность болевого синдрома', 3, 4);

insert into answer(id, name, data, ordinal, question_id)
values (56, '1-3', '{"score":3}', 1, 15);
insert into answer(id, name, data, ordinal, question_id)
values (57, '4-7', '{"score":4}', 2, 15);
insert into answer(id, name, data, ordinal, question_id)
values (58, '8-10', '{"score":5}', 3, 15);


-- VI. Определение наличия противопоказаний (я) для этапной медицинской реабилитации,
--     выберите подходящий ответ по каждому вопросу

insert into test(id, name, department, test_process_type)
values (5, 'Определение наличия противопоказаний(я) для этапной медицинской реабилитации', 0, 3);

insert into question(id, name, ordinal, test_id)
values (16, 'Прогрессирующий неврологический дефицит', 1, 5);

insert into answer(id, name, data, ordinal, question_id)
values (59, 'Да', '{"recommendations":["Экстренная госпитализация в неврологическое/сосудистое отделение"]}', 1, 16);
insert into answer(id, name, data, ordinal, question_id)
values (60, 'Нет', '{}', 2, 16);

insert into question(id, name, ordinal, test_id)
values (17, 'Декомпенсация соматических функций', 2, 5);

insert into answer(id, name, data, ordinal, question_id)
values (61, 'Да', '{"recommendations":["Экстренная госпитализация в терапевтическое/кардиологическое отделение"]}', 1,
        17);
insert into answer(id, name, data, ordinal, question_id)
values (62, 'Нет', '{}', 2, 17);

insert into question(id, name, ordinal, test_id)
values (18, 'Наличие инфекционно-воспалительного процесса', 3, 5);

insert into answer(id, name, data, ordinal, question_id)
values (63, 'Да', '{"recommendations":["Лечение у профильного специалиста (хирург, инфекционист и др.)"]}', 1, 18);
insert into answer(id, name, data, ordinal, question_id)
values (64, 'Нет', '{}', 2, 18);

insert into question(id, name, ordinal, test_id)
values (19, 'Отсутствие продуктивного контакта с пациентом (сенсорная афазия, деменция, психоорганический синдром)', 4,
        5);

insert into answer(id, name, data, ordinal, question_id)
values (65, 'Да',
        '{"recommendations":["Консультация в Центре патологии речи и нейрореабилитации ДЗМ", "Консультация психиатра", "Паллиативная помощь"]}',
        1, 19);
insert into answer(id, name, data, ordinal, question_id)
values (66, 'Нет', '{}', 2, 19);

insert into question(id, name, ordinal, test_id)
values (20, 'Сопутствующие заболевания в острой стадии, хронические заболевания в стадии обострения', 5, 5);

insert into answer(id, name, data, ordinal, question_id)
values (67, 'Да', '{"recommendations":["Лечение у профильного специалиста"]}', 1, 20);
insert into answer(id, name, data, ordinal, question_id)
values (68, 'Нет', '{}', 2, 20);

insert into question(id, name, ordinal, test_id)
values (21, 'Инфекционные заболевания в острой или заразной форме', 6, 5);

insert into answer(id, name, data, ordinal, question_id)
values (69, 'Да', '{"recommendations":["Изоляция, лечение профильного специалиста"]}', 1, 21);
insert into answer(id, name, data, ordinal, question_id)
values (70, 'Нет', '{}', 2, 21);

insert into question(id, name, ordinal, test_id)
values (22,
        'Тяжелые психические заболевания: продуктивная симптоматика (бред, галлюцинации), дезориентация пациента, эпизоды спутанности сознания с психомоторным возбуждением, тяжелая депрессия, суицидальные высказывания и др.',
        7, 5);

insert into answer(id, name, data, ordinal, question_id)
values (71, 'Да', '{"recommendations":["Консультация психиатра"]}', 1, 22);
insert into answer(id, name, data, ordinal, question_id)
values (72, 'Нет', '{}', 2, 22);

insert into question(id, name, ordinal, test_id)
values (23, 'Эпилепсия с частыми (3 и более приступа в месяц) или органическими изменениями личности', 8, 5);

insert into answer(id, name, data, ordinal, question_id)
values (73, 'Да', '{"recommendations":["Консультация невролога-эпилептолога"]}', 1, 23);
insert into answer(id, name, data, ordinal, question_id)
values (74, 'Нет', '{}', 2, 23);

insert into question(id, name, ordinal, test_id)
values (24, 'Все виды наркомании и алкоголизма (за исключением стойкой ремиссии – более года)', 9, 5);

insert into answer(id, name, data, ordinal, question_id)
values (75, 'Да', '{"recommendations":["Курс лечения в условиях МНПЦ наркологии ДЗМ"]}', 1, 24);
insert into answer(id, name, data, ordinal, question_id)
values (76, 'Нет', '{}', 2, 24);

insert into question(id, name, ordinal, test_id)
values (25, 'Кахексия', 10, 5);

insert into answer(id, name, data, ordinal, question_id)
values (77, 'Да', '{"recommendations":["Лечение у профильного специалиста"]}', 1, 25);
insert into answer(id, name, data, ordinal, question_id)
values (78, 'Нет', '{}', 2, 25);

insert into question(id, name, ordinal, test_id)
values (26, 'Анемия (Нв ниже 90 г/л)', 11, 5);

insert into answer(id, name, data, ordinal, question_id)
values (79, 'Да', '{"recommendations":["Консультация гематолога"]}', 1, 26);
insert into answer(id, name, data, ordinal, question_id)
values (80, 'Нет', '{}', 2, 26);

insert into question(id, name, ordinal, test_id)
values (27, 'Тяжелые нарушения сердечного ритма и проводимости', 12, 5);

insert into answer(id, name, data, ordinal, question_id)
values (81, 'Да', '{"recommendations":["Консультация кардиолога"]}', 1, 27);
insert into answer(id, name, data, ordinal, question_id)
values (82, 'Нет', '{}', 2, 27);

insert into question(id, name, ordinal, test_id)
values (28, 'Недостаточность кровообращения 2б-3ст', 13, 5);

insert into answer(id, name, data, ordinal, question_id)
values (83, 'Да', '{"recommendations":["Консультация кардиолога"]}', 1, 28);
insert into answer(id, name, data, ordinal, question_id)
values (84, 'Нет', '{}', 2, 28);

insert into question(id, name, ordinal, test_id)
values (29, 'Высокий риск тромбоэмболических осложнений', 14, 5);

insert into answer(id, name, data, ordinal, question_id)
values (85, 'Да', '{"recommendations":["Консультация сосудистого хирурга", "УЗДГ вен нижних конечностей"]}', 1, 29);
insert into answer(id, name, data, ordinal, question_id)
values (86, 'Нет', '{}', 2, 29);

insert into question(id, name, ordinal, test_id)
values (30, 'Сахарный диабет в стадии декомпенсации', 15, 5);

insert into answer(id, name, data, ordinal, question_id)
values (87, 'Да', '{"recommendations":["Консультация эндокринолога"]}', 1, 30);
insert into answer(id, name, data, ordinal, question_id)
values (88, 'Нет', '{}', 2, 30);

insert into question(id, name, ordinal, test_id)
values (31, 'Пролежни 2 стадии и выше (с нарушением целостности кожных покровов)', 16, 5);

insert into answer(id, name, data, ordinal, question_id)
values (89, 'Да', '{"recommendations":["Консультация хирурга"]}', 1, 31);
insert into answer(id, name, data, ordinal, question_id)
values (90, 'Нет', '{}', 2, 31);

insert into question(id, name, ordinal, test_id)
values (32, 'Наличие показаний к оперативному вмешательству или применению других специальных методов лечения', 17, 5);

insert into answer(id, name, data, ordinal, question_id)
values (91, 'Да', '{"recommendations":["Лечение у профильного специалиста"]}', 1, 32);
insert into answer(id, name, data, ordinal, question_id)
values (92, 'Нет', '{}', 2, 32);

insert into question(id, name, ordinal, test_id)
values (33, 'Злокачественные новообразования (за исключением III клинической группы диспансерного наблюдения)', 18, 5);

insert into answer(id, name, data, ordinal, question_id)
values (93, 'Да',
        '{"recommendations":["Консультация онколога с заключением о принадлежности пациента к одной из групп диспансерного наблюдения"]}',
        1, 33);
insert into answer(id, name, data, ordinal, question_id)
values (94, 'Нет', '{}', 2, 33);

insert into question(id, name, ordinal, test_id)
values (34, 'Доброкачественные новообразования', 19, 5);

insert into answer(id, name, data, ordinal, question_id)
values (95, 'Да',
        '{"recommendations":["Заключение онколога об отсутствии необходимости радикального лечения, риска при проведении физических методов реабилитации"]}',
        1, 34);
insert into answer(id, name, data, ordinal, question_id)
values (96, 'Нет', '{}', 2, 34);


-- VIII. Определения полноты комплекса обследований,
--       выберите подходящий ответ по каждому вопросу

-- Если была выбрана поликлиника

insert into test(id, name, department, test_process_type)
values (6, 'Определения полноты комплекса обследований для поликлиники', 0, 0);

insert into question(id, name, ordinal, test_id)
values (35, 'Документ, удостоверяющий личность физического лица (паспорт)', 1, 6);

insert into answer(id, name, ordinal, question_id)
values (97, 'Да', 1, 35);
insert into answer(id, name, ordinal, question_id)
values (98, 'Нет', 2, 35);
insert into answer(id, name, ordinal, question_id)
values (99, 'Не применимо', 2, 35);

insert into question(id, name, ordinal, test_id)
values (36, 'Полис обязательного медицинского страхования', 2, 6);

insert into answer(id, name, ordinal, question_id)
values (100, 'Да', 1, 36);
insert into answer(id, name, ordinal, question_id)
values (101, 'Нет', 2, 36);
insert into answer(id, name, ordinal, question_id)
values (102, 'Не применимо', 2, 36);

insert into question(id, name, ordinal, test_id)
values (37, 'Направление на госпитализацию (форма N 057/у-04)', 3, 6);

insert into answer(id, name, ordinal, question_id)
values (103, 'Да', 1, 37);
insert into answer(id, name, ordinal, question_id)
values (104, 'Нет', 2, 37);
insert into answer(id, name, ordinal, question_id)
values (105, 'Не применимо', 2, 37);

insert into question(id, name, ordinal, test_id)
values (38,
        'Копия выписки из карты амбулаторного, стационарного больного (форма N 027/у), с указанием результатов проведенных лабораторных, инструментальных и других видов исследования по профилю заболевания пациента, сведений о перенесенных заболеваниях',
        4, 6);

insert into answer(id, name, ordinal, question_id)
values (106, 'Да', 1, 38);
insert into answer(id, name, ordinal, question_id)
values (107, 'Нет', 2, 38);
insert into answer(id, name, ordinal, question_id)
values (108, 'Не применимо', 2, 38);

insert into question(id, name, ordinal, test_id)
values (39, 'Клинический анализ крови (сроком давности до 20 дней)', 5, 6);

insert into answer(id, name, ordinal, question_id)
values (109, 'Да', 1, 39);
insert into answer(id, name, ordinal, question_id)
values (110, 'Нет', 2, 39);
insert into answer(id, name, ordinal, question_id)
values (111, 'Не применимо', 2, 39);

insert into question(id, name, ordinal, test_id)
values (40, 'Общий анализ мочи (сроком давности до 20 дней)', 6, 6);

insert into answer(id, name, ordinal, question_id)
values (112, 'Да', 1, 40);
insert into answer(id, name, ordinal, question_id)
values (113, 'Нет', 2, 40);
insert into answer(id, name, ordinal, question_id)
values (114, 'Не применимо', 2, 40);

insert into question(id, name, ordinal, test_id)
values (41,
        'Биохимический анализ крови: глюкоза, общий билирубин и его фракции, АСТ, АЛТ, мочевина, креатинин, щелочная фосфатаза, общий белок (сроком давности до 30 дней)',
        7, 6);

insert into answer(id, name, ordinal, question_id)
values (115, 'Да', 1, 41);
insert into answer(id, name, ordinal, question_id)
values (116, 'Нет', 2, 41);
insert into answer(id, name, ordinal, question_id)
values (117, 'Не применимо', 2, 41);

insert into question(id, name, ordinal, test_id)
values (42, 'Рентгенограммы, данные КТ или МРТ (сроком давности до 6 месяцев)', 8, 6);

insert into answer(id, name, ordinal, question_id)
values (118, 'Да', 1, 42);
insert into answer(id, name, ordinal, question_id)
values (119, 'Нет', 2, 42);
insert into answer(id, name, ordinal, question_id)
values (120, 'Не применимо', 2, 42);

insert into question(id, name, ordinal, test_id)
values (43, 'Коагулограмма, электрокардиография, ЭХО-КГ (для пациентов кардиологического профиля)', 9, 6);

insert into answer(id, name, ordinal, question_id)
values (121, 'Да', 1, 43);
insert into answer(id, name, ordinal, question_id)
values (122, 'Нет', 2, 43);
insert into answer(id, name, ordinal, question_id)
values (123, 'Не применимо', 2, 43);

insert into question(id, name, ordinal, test_id)
values (44, 'Холтеровское мониторирование ЭКГ (для пациентов с нарушениями ритма) - сроком давности до 30 дней', 10, 6);

insert into answer(id, name, ordinal, question_id)
values (124, 'Да', 1, 44);
insert into answer(id, name, ordinal, question_id)
values (125, 'Нет', 2, 44);
insert into answer(id, name, ordinal, question_id)
values (126, 'Не применимо', 2, 44);

insert into question(id, name, ordinal, test_id)
values (45,
        'Флюорография/рентгенография грудной клетки (сроком давности до 6 месяцев), при невозможности выполнения (маломобильные пациенты) - анализ мокроты на микобактерии туберкулеза методом микроскопии или молекулярно-генетическим методом (сроком давности до 3 месяцев)',
        11, 6);

insert into answer(id, name, ordinal, question_id)
values (127, 'Да', 1, 45);
insert into answer(id, name, ordinal, question_id)
values (128, 'Нет', 2, 45);
insert into answer(id, name, ordinal, question_id)
values (129, 'Не применимо', 2, 45);

insert into question(id, name, ordinal, test_id)
values (46, 'Заключение гинеколога (женщинам) - сроком давности до 30 дней', 12, 6);

insert into answer(id, name, ordinal, question_id)
values (130, 'Да', 1, 46);
insert into answer(id, name, ordinal, question_id)
values (131, 'Нет', 2, 46);
insert into answer(id, name, ordinal, question_id)
values (132, 'Не применимо', 2, 46);

insert into question(id, name, ordinal, test_id)
values (47, 'Исследование крови на сифилис методом ИФА (суммарные антитела) (сроком давности до 3 месяцев)', 13, 6);

insert into answer(id, name, ordinal, question_id)
values (133, 'Да', 1, 47);
insert into answer(id, name, ordinal, question_id)
values (134, 'Нет', 2, 47);
insert into answer(id, name, ordinal, question_id)
values (135, 'Не применимо', 2, 47);

insert into question(id, name, ordinal, test_id)
values (48, 'Исследование крови на маркеры гепатитов В и С (сроком давности до 3 месяцев)', 14, 6);

insert into answer(id, name, ordinal, question_id)
values (136, 'Да', 1, 48);
insert into answer(id, name, ordinal, question_id)
values (137, 'Нет', 2, 48);
insert into answer(id, name, ordinal, question_id)
values (138, 'Не применимо', 2, 48);

insert into question(id, name, ordinal, test_id)
values (49, 'Исследование крови на ВИЧ-инфекцию (сроком давности до 3 месяцев)', 15, 6);

insert into answer(id, name, ordinal, question_id)
values (139, 'Да', 1, 49);
insert into answer(id, name, ordinal, question_id)
values (140, 'Нет', 2, 49);
insert into answer(id, name, ordinal, question_id)
values (141, 'Не применимо', 2, 49);

insert into question(id, name, ordinal, test_id)
values (50,
        'Справка об иммунизации против кори (в соответствии с приказом Департамента здравоохранения города Москвы от 28.08.2017 N 599 "О проведении дополнительных санитарно-противоэпидемических (профилактических) мероприятий против кори"',
        16,
        6);

insert into answer(id, name, ordinal, question_id)
values (142, 'Да', 1, 50);
insert into answer(id, name, ordinal, question_id)
values (143, 'Нет', 2, 50);
insert into answer(id, name, ordinal, question_id)
values (144, 'Не применимо', 2, 50);

-- для стационара

insert into test(id, name, department, test_process_type)
values (7, 'Определения полноты комплекса обследований для стационара', 0, 0);

insert into question(id, name, ordinal, test_id)
values (51, 'Диагноз клинический по рубрикам', 1, 7);

insert into answer(id, name, ordinal, question_id)
values (145, 'Да', 1, 51);
insert into answer(id, name, ordinal, question_id)
values (146, 'Нет', 2, 51);
insert into answer(id, name, ordinal, question_id)
values (147, 'Не применимо', 2, 51);

insert into question(id, name, ordinal, test_id)
values (52, 'Код МКБ-10 основного заболевания', 2, 7);

insert into answer(id, name, ordinal, question_id)
values (148, 'Да', 1, 52);
insert into answer(id, name, ordinal, question_id)
values (149, 'Нет', 2, 52);
insert into answer(id, name, ordinal, question_id)
values (150, 'Не применимо', 2, 52);

insert into question(id, name, ordinal, test_id)
values (53, 'Анамнез', 3, 7);

insert into answer(id, name, ordinal, question_id)
values (151, 'Да', 1, 53);
insert into answer(id, name, ordinal, question_id)
values (152, 'Нет', 2, 53);
insert into answer(id, name, ordinal, question_id)
values (153, 'Не применимо', 2, 53);

insert into question(id, name, ordinal, test_id)
values (54, 'Объективный статус, неврологический статус, местный статус на дату эпикриза', 4,
        7);

insert into answer(id, name, ordinal, question_id)
values (154, 'Да', 1, 54);
insert into answer(id, name, ordinal, question_id)
values (155, 'Нет', 2, 54);
insert into answer(id, name, ordinal, question_id)
values (156, 'Не применимо', 2, 54);

insert into question(id, name, ordinal, test_id)
values (55, 'Название операции', 5, 7);

insert into answer(id, name, ordinal, question_id)
values (157, 'Да', 1, 55);
insert into answer(id, name, ordinal, question_id)
values (158, 'Нет', 2, 55);
insert into answer(id, name, ordinal, question_id)
values (159, 'Не применимо', 2, 55);

insert into question(id, name, ordinal, test_id)
values (56, 'Проводимое лечение (антикоагулянтная терапия дата завершения)', 6, 7);

insert into answer(id, name, ordinal, question_id)
values (160, 'Да', 1, 56);
insert into answer(id, name, ordinal, question_id)
values (161, 'Нет', 2, 56);
insert into answer(id, name, ordinal, question_id)
values (162, 'Не применимо', 2, 56);

insert into question(id, name, ordinal, test_id)
values (57, 'Обследования, актуальные в после операционном периоде', 7, 7);

insert into answer(id, name, ordinal, question_id)
values (163, 'Да', 1, 57);
insert into answer(id, name, ordinal, question_id)
values (164, 'Нет', 2, 57);
insert into answer(id, name, ordinal, question_id)
values (165, 'Не применимо', 2, 57);

insert into question(id, name, ordinal, test_id)
values (58, 'Количество баллов по ШРМ, (Рэнкин. Ривермед)', 8, 7);

insert into answer(id, name, ordinal, question_id)
values (166, 'Да', 1, 58);
insert into answer(id, name, ordinal, question_id)
values (167, 'Нет', 2, 58);
insert into answer(id, name, ordinal, question_id)
values (168, 'Не применимо', 2, 58);

insert into question(id, name, ordinal, test_id)
values (59, 'Контакты ответственного лица за перевод (Ф.И.О., телефон, email)', 9, 7);

insert into answer(id, name, ordinal, question_id)
values (169, 'Да', 1, 59);
insert into answer(id, name, ordinal, question_id)
values (170, 'Нет', 2, 59);
insert into answer(id, name, ordinal, question_id)
values (171, 'Не применимо', 2, 59);

insert into question(id, name, ordinal, test_id)
values (60, 'Планируемая дата выписки', 10, 7);

insert into answer(id, name, ordinal, question_id)
values (172, 'Да', 1, 60);
insert into answer(id, name, ordinal, question_id)
values (173, 'Нет', 2, 60);
insert into answer(id, name, ordinal, question_id)
values (174, 'Не применимо', 2, 60);


-- <===--- MKB 10 ---===>

-- insert into mkb10 (id, code, name)
-- -- центральная нервная система
-- values (', A81.1', 'Подострый склерозирующий панэнцефалит'),
--        ('A83.0', 'Японский энцефалит'),
--        ('A83.1', 'Западный лошадиный энцефалит'),
--        ('A83.2', 'Восточный лошадиный энцефалит'),
--        ('A83.3', 'Энцефалит Сент-Луис'),
--        ('A83.4', 'Австралийский энцефалит'),
--        ('A83.5', 'Калифорнийский энцефалит'),
--        ('A83.6', 'Болезнь, вызванная вирусом Роцио'),
--        ('A83.8', 'Другие комариные вирусные энцефалиты'),
--        ('A84.0', 'Дальневосточный клещевой энцефалит [русский весенне-летний энцефалит]'),
--        ('A84.1', 'Центральноевропейский клещевой энцефалит'),
--        ('A84.8', 'Другие клещевые вирусные энцефалиты'),
--        ('A85.0+', 'Энтеровирусный энцефалит (G05.1*)'),
--        ('A85.1+', 'Аденовирусный энцефалит (G05.1*)'),
--        ('A85.2', 'Вирусный энцефалит, передаваемый членистоногими, неуточненный'),
--        ('A85.8', 'Другие уточненные вирусные энцефалиты'),
--        ('A87.0+', 'Энтеровирусный менингит (G02.0*)'),
--        ('A87.1+', 'Аденовирусный менингит (G02.0*)'),
--        ('A87.2', 'Лимфоцитарный хориоменингит'),
--        ('A87.8', 'Другой вирусный менингит'),
--        ('B91', 'Последствия полиомиелита'),
--        ('B94.1', 'Отдаленные последствия вирусного энцефалита'),
--        ('D32.0', 'Оболочек головного мозга'),
--        ('D32.1', 'Оболочек спинного мозга'),
--        ('D33.0', 'Головного мозга над мозговым наметом'),
--        ('D33.1', 'Головного мозга под мозговым наметом'),
--        ('D33.2', 'Головного мозга неуточненное'),
--        ('D33.3', 'Черепных нервов'),
--        ('D33.4', 'Спинного мозга'),
--        ('D33.7', 'Других уточненных частей центральной нервной системы'),
--        ('G03.0', 'Непиогенный менингит'),
--        ('G03.1', 'Хронический менингит'),
--        ('G03.2', 'Доброкачественный рецидивирующий менингит [Молларе]'),
--        ('G03.8', 'Менингит, вызванный другими уточненными возбудителями'),
--        ('G04.0', 'Острый диссеминированный энцефалит'),
--        ('G06.0', 'Внутричерепной абсцесс и гранулема'),
--        ('G06.1', 'Внутрипозвоночный абсцесс и гранулема'),
--        ('G08', 'Внутричерепной и внутрипозвоночный флебит и тромбофлебит'),
--        ('G09', 'Последствия воспалительных болезней центральной нервной системы'),
--        ('G11.0', 'Врожденная непрогрессирующая атаксия'),
--        ('G11.1', 'Ранняя мозжечковая атаксия'),
--        ('G11.2', 'Поздняя мозжечковая атаксия'),
--        ('G11.3', 'Мозжечковая атаксия с нарушением репарации ДНК'),
--        ('G11.4', 'Наследственная спастическая параплегия'),
--        ('G11.8', 'Другая наследственная атаксия'),
--        ('G20', 'Болезнь Паркинсона'),
--        ('G21.8', 'Другие формы вторичного паркинсонизма'),
--        ('G24.0', 'Дистония, вызванная лекарственными средствами'),
--        ('G24.1', 'Идиопатическая семейная дистония'),
--        ('G24.2', 'Идиопатическая несемейная дистония'),
--        ('G24.3', 'Спастическая кривошея'),
--        ('G24.4', 'Идиопатическая рото-лицевая дистония'),
--        ('G24.5', 'Блефароспазм'),
--        ('G24.8', 'Прочие дистонии'),
--        ('G35', 'Рассеянный склероз'),
--        ('G37.0', 'Диффузный склероз'),
--        ('G37.1', 'Центральная демиелинизация мозолистого тела'),
--        ('G37.2', 'Центральный понтинный миелинолиз'),
--        ('G37.3', 'Острый поперечный миелит при демиелинизирующей болезни центральной нервной системы'),
--        ('G37.4', 'Подострый некротизирующий миелит'),
--        ('G37.5', 'Концентрический склероз [Бало]'),
--        ('G37.8', 'Другие уточненные демиелинизирующие болезни центральной нервной системы'),
--        ('G45.0', 'Синдром вертебробазилярной артериальной системы'),
--        ('G45.1', 'Синдром сонной артерии (полушарный)'),
--        ('G45.2', 'Множественные и двусторонние синдромы церебральных артерий'),
--        ('G45.3', 'Преходящая слепота'),
--        ('G45.4', 'Транзиторная глобальная амнезия'),
--        ('G45.8', 'Другие транзиторные церебральные ишемические атаки и связанные с ними синдромы'),
--        ('G46.0*', 'Синдром средней мозговой артерии (I66.0+)'),
--        ('G46.1*', 'Синдром передней мозговой артерии (I66.1+)'),
--        ('G46.2*', 'Синдром задней мозговой артерии (I66.2+)'),
--        ('G46.3*', 'Синдром инсульта в стволе головного мозга (I60-I67+)'),
--        ('G46.4*', 'Синдром мозжечкового инсульта (I60-I67+)'),
--        ('G46.5*', 'Чисто двигательный лакунарный синдром (I60-I67+)'),
--        ('G46.6*', 'Чисто чувствительный лакунарный синдром (I60-I67+)'),
--        ('G46.7*', 'Другие лакунарные синдромы (I60-I67+)'),
--        ('G46.8*', 'Другие сосудистые синдромы головного мозга при цереброваскулярных болезнях (I60-I67+)'),
--        ('G80.0', 'Спастический церебральный паралич'),
--        ('G80.1', 'Спастическая диплегия'),
--        ('G80.2', 'Детская гемиплегия'),
--        ('G80.3', 'Дискинетический церебральный паралич'),
--        ('G80.4', 'Атаксический церебральный паралич'),
--        ('G80.8', 'Другой вид детского церебрального паралича'),
--        ('G95.0', 'Сирингомиелия и сирингобульбия'),
--        ('G95.1', 'Сосудистые миелопатии'),
--        ('G95.2', 'Сдавление спинного мозга неуточненное'),
--        ('G95.8', 'Другие уточненные болезни спинного мозга'),
--        ('G96.0', 'Истечение цереброспинальной жидкости [ликворея]'),
--        ('G96.1', 'Поражения оболочек головного мозга, не классифицированные в других рубриках'),
--        ('G96.8', 'Другие уточненные поражения центральной нервной системы'),
--        ('I60.0', 'Субарахноидальное кровоизлияние из каротидного синуса и бифуркации'),
--        ('I60.1', 'Субарахноидальное кровоизлияние из средней мозговой артерии'),
--        ('I60.2', 'Субарахноидальное кровоизлияние из передней соединительной артерии'),
--        ('I60.3', 'Субарахноидальное кровоизлияние из задней соединительной артерии'),
--        ('I60.4', 'Субарахноидальное кровоизлияние из базилярной артерии'),
--        ('I60.5', 'Субарахноидальное кровоизлияние из позвоночной артерии'),
--        ('I60.6', 'Субарахноидальное кровоизлияние из других внутричерепных артерий'),
--        ('I60.7', 'Субарахноидальное кровоизлияние из внутричерепной артерии неуточненной'),
--        ('I60.8', 'Другое субарахноидальное кровоизлияние'),
--        ('I61.0', 'Внутримозговое кровоизлияние в полушарие субкортикальное'),
--        ('I61.1', 'Внутримозговое кровоизлияние в полушарие кортикальное'),
--        ('I61.2', 'Внутримозговое кровоизлияние в полушарие неуточненное'),
--        ('I61.3', 'Внутримозговое кровоизлияние в ствол мозга'),
--        ('I61.4', 'Внутримозговое кровоизлияние в мозжечок'),
--        ('I61.5', 'Внутримозговое кровоизлияние внутрижелудочковое'),
--        ('I61.6', 'Внутримозговое кровоизлияние множественной локализации'),
--        ('I61.8', 'Другое внутримозговое кровоизлияние'),
--        ('I62.0', 'Субдуральное кровоизлияние (острое) (нетравматическое)'),
--        ('I62.1', 'Нетравматическое экстрадуральное кровоизлияние'),
--        ('I63.0', 'Инфаркт мозга, вызванный тромбозом прецеребральных артерий'),
--        ('I63.1', 'Инфаркт мозга, вызванный эмболией прецеребральных артерий'),
--        ('I63.2', 'Инфаркт мозга, вызванный неуточненной закупоркой или стенозом прецеребральных артерий'),
--        ('I63.3', 'Инфаркт мозга, вызванный тромбозом мозговых артерий'),
--        ('I63.4', 'Инфаркт мозга, вызванный эмболией мозговых артерий'),
--        ('I63.5', 'Инфаркт мозга, вызванный неуточненной закупоркой или стенозом мозговых артерий'),
--        ('I63.6', 'Инфаркт мозга, вызванный тромбозом вен мозга, непиогенный'),
--        ('I63.8', 'Другой инфаркт мозга'),
--        ('I64', 'Инсульт, не уточненный как кровоизлияние или инфаркт'),
--        ('I67.0', 'Расслоение мозговых артерий без разрыва'),
--        ('I67.1', 'Аневризма мозга без разрыва'),
--        ('I67.2', 'Церебральный атеросклероз'),
--        ('I67.3', 'Прогрессирующая сосудистая лейкоэнцефалопатия'),
--        ('I67.4', 'Гипертензивная энцефалопатия'),
--        ('I67.5', 'Болезнь Мойамойа'),
--        ('I67.6', 'Негнойный тромбоз внутричерепной венозной системы'),
--        ('I67.7', 'Церебральный артериит, не классифицированный в других рубриках'),
--        ('I67.8', 'Другие уточненные поражения сосудов мозга'),
--        ('I69.0', 'Последствия субарахноидального кровоизлияния'),
--        ('I69.1', 'Последствия внутричерепного кровоизлияния'),
--        ('I69.2', 'Последствия другого нетравматического внутричерепного кровоизлияния'),
--        ('I69.3', 'Последствия инфаркта мозга'),
--        ('I69.4', 'Последствия инсульта, не уточненные как кровоизлияние или инфаркт мозга'),
--        ('S02.0', 'Перелом свода черепа'),
--        ('S02.1', 'Перелом основания черепа'),
--        ('S06.0', 'Сотрясение головного мозга'),
--        ('S06.1', 'Травматический отек головного мозга'),
--        ('S06.2', 'Диффузная травма головного мозга'),
--        ('S06.3', 'Очаговая травма головного мозга'),
--        ('S06.4', 'Эпидуральное кровоизлияние'),
--        ('S06.5', 'Травматическое субдуральное кровоизлияние'),
--        ('S06.6', 'Травматическое субарахноидальное кровоизлияние'),
--        ('S06.7', 'Внутричерепная травма с продолжительным коматозным состоянием'),
--        ('S06.8', 'Другие внутричерепные травмы'),
--        ('S12.0', 'Перелом первого шейного позвонка'),
--        ('S12.1', 'Перелом второго шейного позвонка'),
--        ('S12.2', 'Перелом других уточненных шейных позвонков'),
--        ('S12.7', 'Множественные переломы шейных позвонков'),
--        ('S12.8', 'Перелом других частей шеи'),
--        ('S14.0', 'Контузия и отек шейного отдела спинного мозга'),
--        ('S22.1', 'Множественные переломы грудного отдела позвоночника'),
--        ('S24.0', 'Ушиб и отек грудного отдела спинного мозга'),
--        ('S24.1', 'Другие и неуточненные травмы грудного отдела спинного мозга'),
--        ('S34.0', 'Сотрясение и отек поясничного отдела спинного мозга'),
--        ('S34.1', 'Другая травма поясничного отдела спинного мозга'),
--        ('T90.0', 'Последствия поверхностной травмы головы'),
--        ('T90.1', 'Последствия открытого ранения головы'),
--        ('T90.2', 'Последствия перелома черепа и костей лица'),
--        ('T90.3', 'Последствия травмы черепных нервов'),
--        ('T90.4', 'Последствия травмы глаза окологлазничной области'),
--        ('T90.5', 'Последствия внутричерепной травмы'),
--        ('T90.8', 'Последствия других уточненных травм головы'),
--        ('T91.1', 'Последствия перелома позвоночника'),
--        ('T91.3', 'Последствия травмы спинного мозга'),
-- -- периферичесская нервная система
--        ('G25.0', 'Эссенциальный тремор'),
--        ('G25.1', 'Тремор, вызванный лекарственным средством'),
--        ('G25.2', 'Другие уточненные формы тремора'),
--        ('G25.3', 'Миоклонус'),
--        ('G25.4', 'Хорея, вызванная лекарственным средством'),
--        ('G25.5', 'Другие виды хореи'),
--        ('G25.6', 'Тики, вызванные лекарственными средствами, и другие тики органического происхождения'),
--        ('G25.8', 'Другие уточненные экстрапирамидные и двигательные нарушения'),
--        ('G26*', 'Экстрапирамидные и двигательные нарушения при болезнях, классифицированных в других рубриках'),
--        ('G50.0', 'Невралгия тройничного нерва'),
--        ('G50.1', 'Атипичная лицевая боль'),
--        ('G50.8', 'Другие поражения тройничного нерва'),
--        ('G51.0', 'Паралич Белла'),
--        ('G51.1', 'Воспаление узла коленца'),
--        ('G51.2', 'Синдром Россолимо-Мелькерссона'),
--        ('G51.3', 'Клонический гемифациальный спазм'),
--        ('G51.4', 'Лицевая миокимия'),
--        ('G51.8', 'Другие поражения лицевого нерва'),
--        ('G52.0', 'Поражения обонятельного нерва'),
--        ('G52.1', 'Поражения языкоглоточного нерва'),
--        ('G52.2', 'Поражения блуждающего нерва'),
--        ('G52.3', 'Поражения подъязычного нерва'),
--        ('G52.7', 'Множественные поражения черепных нервов'),
--        ('G52.8', 'Поражения других уточненных черепных нервов'),
--        ('G54.0', 'Поражения плечевого сплетения'),
--        ('G54.1', 'Поражения пояснично-крестцового сплетения'),
--        ('G54.2', 'Поражения шейных корешков, не классифицированные в других рубриках'),
--        ('G54.3', 'Поражения грудных корешков, не классифицированные в другихрубриках'),
--        ('G54.4', 'Поражения пояснично-крестцовых корешков, не классифицированные в других рубриках'),
--        ('G54.5', 'Невралгическая амиотрофия'),
--        ('G54.6', 'Синдром фантома конечности с болью'),
--        ('G54.7', 'Синдром фантома конечности без боли'),
--        ('G54.8', 'Другие поражения нервных корешков и сплетений'),
--        ('G56.0', 'Синдром запястного канала'),
--        ('G56.1', 'Другие поражения срединного нерва'),
--        ('G56.2', 'Поражение локтевого нерва'),
--        ('G56.3', 'Поражение лучевого нерва'),
--        ('G56.4', 'Каузалгия'),
--        ('G56.8', 'Другие мононевропатии верхней конечности'),
--        ('G57.0', 'Поражение седалищного нерва'),
--        ('G57.1', 'Мералгия парестетическая'),
--        ('G57.2', 'Поражение бедренного нерва'),
--        ('G57.3', 'Поражение бокового подколенного нерва'),
--        ('G57.4', 'Поражение срединного подколенного нерва'),
--        ('G57.5', 'Синдром предплюсневого канала'),
--        ('G57.6', 'Поражение подошвенного нерва'),
--        ('G57.8', 'Другие мононевралгии нижней конечности'),
--        ('G58.0', 'Межреберная невропатия'),
--        ('G58.7', 'Множественный мононеврит'),
--        ('G58.8', 'Другие уточненные виды мононевропатии'),
--        ('G59.0*', 'Диабетическая мононевропатия (E10-E14+ с общим четвертым знаком .4)'),
--        ('G59.8*', 'Другие мононевропатии при болезнях, классифицированных в других рубриках'),
--        ('G60.0', 'Наследственная моторная и сенсорная невропатия'),
--        ('G60.1', 'Болезнь Рефсума'),
--        ('G60.2', 'Невропатия в сочетании с наследственной атаксией'),
--        ('G60.3', 'Идиопатическая прогрессирующая невропатия'),
--        ('G60.8', 'Другие наследственные и идиопатические невропатии'),
--        ('G61.0', 'Синдром Гийена-Барре'),
--        ('G61.1', 'Сывороточная невропатия'),
--        ('G61.8', 'Другие воспалительные полиневропатии'),
--        ('G62.0', 'Лекарственная полиневропатия'),
--        ('G62.1', 'Алкогольная полиневропатия'),
--        ('G62.2', 'Полиневропатия, вызванная другими токсичными веществами'),
--        ('G62.8', 'Другие уточненные полиневропатии'),
--        ('G63.0*', 'Полиневропатия при инфекционных и паразитарных болезнях, классифицированных в других рубриках'),
--        ('G63.1*', 'Полиневропатия при новообразованиях (C00-D48+)'),
--        ('G63.2*', 'Диабетическая полиневропатия (E10-E14+ с общим четвертым знаком .4)'),
--        ('G63.3*',
--         'Полиневропатия при других эндокринных болезнях и нарушениях обмена веществ (E00-E07+, E15-E16+, E20-E34+, E70-E89+)'),
--        ('G63.4*', 'Полиневропатия при недостаточности питания (E40-E64+)'),
--        ('G63.5*', 'Полиневропатия при системных поражениях соединительной ткани (M30-M35+)'),
--        ('G63.6*', 'Полиневропатия при других костно-мышечных поражениях (M00-M25+, M40-M96+)'),
--        ('G63.8*', 'Полиневропатия при других болезнях, классифицированных в других рубриках'),
--        ('G64', 'Другие расстройства периферической нервной системы'),
--        ('G71.0', 'Мышечная дистрофия'),
--        ('G71.1', 'Миотонические расстройства'),
--        ('G71.2', 'Врожденные миопатии'),
--        ('G71.3', 'Митохондриальная миопатия, не классифицированная в других рубриках'),
--        ('G71.8', 'Другие первичные поражения мышц'),
--        ('G72.0', 'Лекарственная миопатия'),
--        ('G72.1', 'Алкогольная миопатия'),
--        ('G72.2', 'Миопатия, вызванная другим токсичным веществом'),
--        ('G72.3', 'Периодический паралич'),
--        ('G72.4', 'Воспалительная миопатия, не классифицированная в других рубриках'),
--        ('G72.8', 'Другие уточненные миопатии'),
--        ('G73.0*', 'Миастенические синдромы при эндокринных болезнях'),
--        ('G73.1*', 'Синдром Итона-Ламберта (C80+)'),
--        ('G73.2*', 'Другие миастенические синдромы при опухолевом поражении (C00-D48+)'),
--        ('G73.3*', 'Миастенические синдромы при других болезнях, классифицированных в других рубриках'),
--        ('G73.4*', 'Миопатия при инфекционных и паразитарных болезнях, классифицированных в других рубриках'),
--        ('G73.5*', 'Миопатия при эндокринных болезнях'),
--        ('G73.6*', 'Миопатия при нарушениях обмена веществ'),
--        ('G73.7*', 'Миопатия при других болезнях, классифицированных в других рубриках'),
--        ('G90.0', 'Идиопатическая периферическая вегетативная невропатия'),
--        ('G90.1', 'Семейная дизавтономия [Райли-Дея]'),
--        ('G90.2', 'Синдром Горнера'),
--        ('G90.3', 'Полисистемная дегенерация'),
--        ('G90.8', 'Другие расстройства вегетативной [автономной] нервной системы'),
-- -- опорнодвигательный аппарат
--        ('D16.0', 'Лопатки и длинных костей верхней конечности'),
--        ('D16.1', 'Коротких костей верхней конечности'),
--        ('D16.2', 'Длинных костей нижней конечности'),
--        ('D16.3', 'Коротких костей нижней конечности'),
--        ('D16.6', 'Позвоночного столба'),
--        ('D16.7', 'Ребер, грудины и ключицы'),
--        ('D16.8', 'Тазовых костей, крестца и копчика'),
--        ('M03.0*', 'Артрит после перенесенной менингококковой инфекции (A39.8+)'),
--        ('M03.1*', 'Постинфекционная артропатия при сифилисе'),
--        ('M03.2*', 'Другие постинфекционные артропатии при болезнях, классифицированных в других рубриках'),
--        ('M03.6*', 'Реактивная артропатия при других болезнях, классифицированных в других рубриках'),
--        ('M05.0', 'Синдром Фелти'),
--        ('M05.1+', 'Ревматоидная болезнь легкого (J99.0*)'),
--        ('M05.2', 'Ревматоидный васкулит'),
--        ('M05.3+', 'Ревматоидный артрит с вовлечением других органов и систем'),
--        ('M05.8', 'Другие серопозитивные ревматоидные артриты'),
--        ('M06.0', 'Серонегативный ревматоидный артрит'),
--        ('M06.1', 'Болезнь Стилла, развившаяся у взрослых'),
--        ('M06.2', 'Ревматоидный бурсит'),
--        ('M06.3', 'Ревматоидный узелок'),
--        ('M06.4', 'Воспалительная полиартропатия'),
--        ('M06.8', 'Другие уточненные ревматоидные артриты'),
--        ('M07.0*', 'Дистальная межфаланговая псориатическая артропатия(L40.5+)'),
--        ('M07.1*', 'Мутилирующий артрит (L40.5+)'),
--        ('M07.2*', 'Псориатический спондилит (L40.5+)'),
--        ('M07.3*', 'Другие псориатические артропатии (L40.5+)'),
--        ('M07.4*', 'Артропатия при болезни Крона [регионарном энтерите](K50.-+)'),
--        ('M07.5*', 'Артропатия при язвенном колите (K51.-+)'),
--        ('M07.6*', 'Другие энтеропатические артропатии'),
--        ('M08.0', 'Юношеский ревматоидный артрит'),
--        ('M08.1', 'Юношеский анкилозирующий спондилит'),
--        ('M08.2', 'Юношеский артрит с системным началом'),
--        ('M08.3', 'Юношеский полиартрит (серонегативный)'),
--        ('M08.4', 'Пауциартикулярный юношеский артрит'),
--        ('M08.8', 'Другие юношеские артриты'),
--        ('M09.0*', 'Юношеский артрит при псориазе (L40.5+)'),
--        ('M09.1*', 'Юношеский артрит при болезни Крона регионарном энтерите (K50.-+)'),
--        ('M09.2*', 'Юношеский артрит при язвенном колите (K51.-+)'),
--        ('M09.8*', 'Юношеский артрит при других болезнях, классифицированных в других рубриках'),
--        ('M10.0', 'Идиопатическая подагра'),
--        ('M10.1', 'Свинцовая подагра'),
--        ('M10.2', 'Лекарственная подагра'),
--        ('M10.3', 'Подагра, обусловленная нарушением почечной функции'),
--        ('M10.4', 'Другая вторичная подагра'),
--        ('M11.0', 'Отложение гидроксиапатита'),
--        ('M11.1', 'Наследственный хондрокальциноз'),
--        ('M11.2', 'Другой хондрокальциноз'),
--        ('M11.8', 'Другие уточненные кристаллические артропатии'),
--        ('M12.0', 'Хроническая постревматическая артропатия [Жакку]'),
--        ('M12.1', 'Болезнь Кашина-Бека'),
--        ('M12.2', 'Ворсинчато-узелковый [виллонодуряный] синовит (пигментный)'),
--        ('M12.3', 'Палиндромный ревматизм'),
--        ('M12.4', 'Интермиттирующий гидрартроз'),
--        ('M12.5', 'Травматическая артропатия'),
--        ('M12.8', 'Другие уточненные артропатии, не классифицированные в других рубриках'),
--        ('M13.0', 'Полиартрит неуточненный'),
--        ('M13.1', 'Моноартрит, не классифицированный в других рубриках'),
--        ('M13.8', 'Другие уточненные артриты'),
--        ('M14.0*', 'Подагрическая артропатия вследствие ферментных дефектов и других наследственных нарушений'),
--        ('M14.1*', 'Кристаллическая артропатия при других обменных болезнях'),
--        ('M14.2*', 'Диабетическая артропатия (E10-E14+ с общим четвертым знаком .6)'),
--        ('M14.3*', 'Липоидный дерматоартрит (E78.8+)'),
--        ('M14.4*', 'Артропатия при амилоидозе (E85.-+)'),
--        ('M14.5*',
--         'Артропатия при других болезнях эндокринной системы, расстройствах питания и нарушениях обмена веществ'),
--        ('M14.6*', 'Невропатическая артропатия'),
--        ('M14.8*', 'Артропатия при других уточненных болезнях, классифицированных в других рубриках'),
--        ('M15.0', 'Первичный генерализованный (остео)артроз'),
--        ('M15.1', 'Узлы Гебердена (с артропатией)'),
--        ('M15.2', 'Узлы Бушара (с артропатией)'),
--        ('M15.3', 'Вторичный множественный артроз'),
--        ('M15.4', 'Эрозивный (остео)артроз'),
--        ('M15.8', 'Другой полиартроз'),
--        ('M16.0', 'Первичный коксартроз двусторонний'),
--        ('M16.1', 'Другой первичный коксартроз'),
--        ('M16.2', 'Коксартроз в результате дисплазии двусторонний'),
--        ('M16.3', 'Другие диспластические коксартрозы'),
--        ('M16.4', 'Посттравматический коксартроз двусторонний'),
--        ('M16.5', 'Другие посттравматические коксартрозы'),
--        ('M16.6', 'Другие вторичные коксартрозы двусторонние'),
--        ('M16.7', 'Другие вторичные коксартрозы'),
--        ('M17.0', 'Первичный гонартроз двусторонний'),
--        ('M17.1', 'Другой первичный гонартроз'),
--        ('M17.2', 'Посттравматический гонартроз двусторонний'),
--        ('M17.3', 'Другие посттравматические гонартрозы'),
--        ('M17.4', 'Другие вторичные гонартрозы двусторонние'),
--        ('M17.5', 'Другие вторичные гонартрозы'),
--        ('M18.0', 'Первичный артроз первого запястно-пястного сустава двусторонний'),
--        ('M18.1', 'Другие первичные артрозы первого запястно-пястного сустава'),
--        ('M18.2', 'Посттравматический артроз первого запястно-пястного сустава двусторонний'),
--        ('M18.3', 'Другие посттравматические артрозы первого запястно-пястного сустава'),
--        ('M18.4', 'Другие вторичные артрозы первого запястно-пястного сустава двусторонние'),
--        ('M18.5', 'Другие вторичные артрозы первого запястно-пястного сустава'),
--        ('M19.0', 'Первичный артроз других суставов'),
--        ('M19.1', 'Посттравматический артроз других суставов'),
--        ('M19.2', 'Вторичный артроз других суставов'),
--        ('M19.8', 'Другой уточненный артроз'),
--        ('M20.0', 'Деформация пальца(цев)'),
--        ('M20.1', 'Наружное искривление большого пальца (hallus valgus)(приобретенное)'),
--        ('M20.2', 'Ригидный большой палец стопы'),
--        ('M20.3', 'Другие деформации большого пальца стопы (приобретенные)'),
--        ('M20.4', 'Другие молоткообразные деформации стопы (приобретенные)'),
--        ('M20.5', 'Другие деформации пальца(цев) стопы (приобретенные)'),
--        ('M21.0', 'Вальгусная деформация, не классифицированная в других рубриках'),
--        ('M21.1', 'Варусная деформация, не классифицированная в других рубриках'),
--        ('M21.2', 'Сгибательная деформация'),
--        ('M21.3', 'Свисание стопы или кисти (приобретенное)'),
--        ('M21.4', 'Плоская стопа [pes planus] (приобретенная)'),
--        ('M21.5',
--         'Приобретенные когтеобразная кисть, косорукость, полая стопа (с высоким сводом) и искривленная стопа (косолапость)'),
--        ('M21.6', 'Другие приобретенные деформации лодыжки и стопы'),
--        ('M21.7', 'Разная длина конечностей (приобретенная)'),
--        ('M21.8', 'Другие уточненные приобретенные деформации конечностей'),
--        ('M22.0', 'Привычный вывих надколенника'),
--        ('M22.1', 'Привычный подвывих надколенника'),
--        ('M22.2', 'Нарушения между надколенником и бедренной костью'),
--        ('M22.3', 'Другие поражения надколенника'),
--        ('M22.4', 'Хондромаляция надколенника'),
--        ('M22.8', 'Другие поражения надколенника'),
--        ('M23.0', 'Кистозный мениск'),
--        ('M23.1', 'Дисковидный мениск (врожденный)'),
--        ('M23.2', 'Поражение мениска в результате старого разрыва или травмы'),
--        ('M23.3', 'Другие поражения мениска'),
--        ('M23.4', 'Свободное тело в коленном суставе'),
--        ('M23.5', 'Хроническая нестабильность коленного сустава'),
--        ('M23.6', 'Другие спонтанные разрывы связки(ок) колена'),
--        ('M23.8', 'Другие внутренние поражения колена'),
--        ('M24.0', 'Свободное тело в суставе'),
--        ('M24.1', 'Другие нарушения суставного хряща'),
--        ('M24.2', 'Поражение связок'),
--        ('M24.3', 'Патологическое смещение и подвывих сустава, не классифицированное в других рубриках'),
--        ('M24.4', 'Повторяющиеся вывихи и подвывихи сустава'),
--        ('M24.5', 'Контрактура сустава'),
--        ('M24.6', 'Анкилоз сустава'),
--        ('M24.7', 'Протрузия вертлужной впадины'),
--        ('M24.8', 'Другие уточненные поражения суставов, не классифицированные в других рубриках'),
--        ('M25.0', 'Гемартроз'),
--        ('M25.1', 'Фистула сустава'),
--        ('M25.2', 'Болтающийся сустав'),
--        ('M25.3', 'Другая нестабильность сустава'),
--        ('M25.4', 'Выпот в суставе'),
--        ('M25.5', 'Боль в суставе'),
--        ('M25.6', 'Тугоподвижность в суставе, не классифицированная в других рубриках'),
--        ('M25.7', 'Остеофит'),
--        ('M25.8', 'Другие уточненные болезни суставов'),
--        ('M30.0', 'Узелковый полиартериит'),
--        ('M30.1', 'Полиартериит с поражением легких [Черджа-Стросса]'),
--        ('M30.2', 'Ювенильный полиартериит'),
--        ('M30.3', 'Слизисто-кожный лимфонодулярный синдром [Кавасаки]'),
--        ('M30.8', 'Другие состояния, связанные с узелковым полиартериитом'),
--        ('M31.0', 'Гиперчувствительный ангиит'),
--        ('M31.1', 'Тромботическая микроангиопатия'),
--        ('M31.2', 'Смертельная срединная гранулема'),
--        ('M31.3', 'Гранулематоз Вегенера'),
--        ('M31.4', 'Синдром дуги аорты [Такаясу]'),
--        ('M31.5', 'Гигантоклеточный артериит с ревматической полимиалгией'),
--        ('M31.6', 'Другие гигантоклеточные артерииты'),
--        ('M31.8', 'Другие уточненные некротизирующие васкулопатии'),
--        ('M32.0', 'Лекарственная системная красная волчанка'),
--        ('M32.1+', 'Системная красная волчанка с поражением других органов или систем'),
--        ('M32.8', 'Другие формы системной красной волчанки'),
--        ('M40.1', 'Другие вторичные кифозы'),
--        ('M40.2', 'Другие и неуточненные кифозы'),
--        ('M40.3', 'Синдром прямой спины'),
--        ('M40.4', 'Другие лордозы'),
--        ('M41.0', 'Инфантильный идиопатический сколиоз'),
--        ('M41.1', 'Юношеский идиопатический сколиоз'),
--        ('M41.2', 'Другие идиопатические сколиозы'),
--        ('M41.3', 'Торакогенный сколиоз'),
--        ('M41.4', 'Нервно-мышечный сколиоз'),
--        ('M41.5', 'Прочие вторичные сколиозы'),
--        ('M41.8', 'Другие формы сколиоза'),
--        ('M42.0', 'Юношеский остеохондроз позвоночника'),
--        ('M42.1', 'Остеохондроз позвоночника у взрослых'),
--        ('M43.0', 'Спондилолиз'),
--        ('M43.1', 'Спондилолистез'),
--        ('M43.2', 'Другие сращения позвоночного столба'),
--        ('M43.3', 'Привычный атланто-аксиальный подвывих с миелопатией'),
--        ('M43.4', 'Другие привычные антланто-аксиальные подвывихи'),
--        ('M43.5', 'Другие привычные подвывихи позвонков'),
--        ('M43.6', 'Кривошея'),
--        ('M43.8', 'Другие уточненные деформирующие дорсопатии'),
--        ('M45', 'Анкилозирующий спондилит'),
--        ('M46.0', 'Энтезопатия позвоночника'),
--        ('M46.1', 'Сакроилеит, не классифицированный в других рубриках'),
--        ('M46.2', 'Остеомиелит позвонков'),
--        ('M46.3', 'Инфекция межпозвоночных дисков (пиогенная)'),
--        ('M46.4', 'Дисцит неуточненный'),
--        ('M46.5', 'Другие инфекционные спондилопатии'),
--        ('M46.8', 'Другие уточненные воспалительные спондилопатии'),
--        ('M47.0+', 'Синдром сдавления передней спинальной или позвоночной артерии (G99.2*)'),
--        ('M47.1', 'Другие спондилезы с миелопатией'),
--        ('M47.2', 'Другие спондилезы с радикулопатией'),
--        ('M47.8', 'Другие спондилезы'),
--        ('M48.0', 'Спинальный стеноз'),
--        ('M48.1', 'Анкилозирующий гиперостоз Форестье'),
--        ('M48.2', '"Целующиеся" позвонки'),
--        ('M48.3', 'Травматическая спондилопатия'),
--        ('M48.4', 'Перелом позвоночника, связанный с перенапряжением'),
--        ('M48.5', 'Разрушение позвонка, не классифицированное в других рубриках'),
--        ('M48.8', 'Другие уточненные спондилопатии'),
--        ('M50.0+', 'Поражение межпозвоночного диска шейного отдела с миелопатией (G99.2*)'),
--        ('M50.1', 'Поражение  межпозвоночного диска шейного отдела с радикулопатией'),
--        ('M50.2', 'Смещение межпозвоночного диска шейного отдела другого типа'),
--        ('M50.3', 'Другая дегенерация межпозвоночного диска шейного отдела'),
--        ('M50.8', 'Другие поражения межпозвоночного диска шейного отдела'),
--        ('M51.0+', 'Поражения межпозвоночных дисков поясничного и других отделов с миелопатией (G99.2*)'),
--        ('M51.1', 'Поражения межпозвоночных дисков поясничного и других отделов с радикулопатией'),
--        ('M51.2', 'Другое уточненное смещение межпозвоночного диска'),
--        ('M51.3', 'Другая уточненная дегенерации межпозвоночного диска'),
--        ('M51.4', 'Узлы [грыжи] Шморля'),
--        ('M51.8', 'Другое уточненное поражение межпозвоночного диска'),
--        ('M53.0', 'Шейно-черепной синдром'),
--        ('M53.1', 'Шейно-плечевой синдром'),
--        ('M53.2', 'Спинальная нестабильность'),
--        ('M53.3', 'Крестцово-копчиковые нарушения, не классифицированные в других рубриках'),
--        ('M53.8', 'Другие уточненные дорсопатии'),
--        ('M54.0', 'Панникулит, поражающий шейный отдел и позвоночник'),
--        ('M54.1', 'Радикулопатия'),
--        ('M54.2', 'Цервикалгия'),
--        ('M54.3', 'Ишиас'),
--        ('M54.4', 'Люмбаго с ишиасом'),
--        ('M54.5', 'Боль внизу спины'),
--        ('M54.6', 'Боль в грудном отделе позвоночника'),
--        ('M54.8', 'Другая дорсалгия'),
--        ('M60.0', 'Инфекционный миозит'),
--        ('M60.1', 'Интерстициальный миозит'),
--        ('M60.2',
--         'Гранулема мягких тканей, вызванная попаданием инородного тела, не классифицированная в других рубриках'),
--        ('M60.8', 'Другие миозиты'),
--        ('M61.0', 'Миозит оссифицирующий травматический'),
--        ('M61.1', 'Миозит оссифицирующий прогрессирующий'),
--        ('M61.2', 'Паралитическая кальцификация и оссификация мышц'),
--        ('M61.3', 'Кальцификация и оссификация  мышц, связанные с ожогами'),
--        ('M61.4', 'Другая кальцификация мышцы'),
--        ('M61.5', 'Другая оссификация мышцы'),
--        ('M62.0', 'Расхождение мышцы'),
--        ('M62.1', 'Другой разрыв мышцы (нетравматический)'),
--        ('M62.2', 'Ишемический инфаркт мышцы'),
--        ('M62.3', 'Синдром иммобилизации (параплегический)'),
--        ('M62.4', 'Контрактура мышцы'),
--        ('M62.5', 'Истощение и атрофия мышц, не классифицированные в других рубриках'),
--        ('M62.6', 'Мышечная деформация'),
--        ('M62.8', 'Другие уточненные поражения мышц'),
--        ('M65.0', 'Абсцесс оболочки сухожилия'),
--        ('M65.1', 'Другие инфекционные (тено)синовиты'),
--        ('M65.2', 'Кальцифицирующий тендинит'),
--        ('M65.3', 'Щелкающий палец'),
--        ('M65.4', 'Теносиновит шиловидного отростка лучевой кости [синдром де Кервена]'),
--        ('M65.8', 'Другие синовиты и теносиновиты'),
--        ('M66.0', 'Разрыв подколенной кисты'),
--        ('M66.1', 'Разрыв синовиальной оболочки'),
--        ('M66.2', 'Спонтанный разрыв сухожилий разгибателей'),
--        ('M66.3', 'Спонтанный разрыв сухожилий сгибателей'),
--        ('M66.4', 'Спонтанный разрыв других сухожилий'),
--        ('M67.0', 'Короткое пяточное [ахиллово] сухожилие (приобретенное)'),
--        ('M67.1', 'Другая контрактура сухожилия (влагалища)'),
--        ('M67.2', 'Синовиальная гипертрофия, не классифицированная в других рубриках'),
--        ('M67.3', 'Мигрирующий синовит'),
--        ('M67.4', 'Ганглион'),
--        ('M67.8', 'Другие уточненные поражения синовиальной оболочки и сухожилия'),
--        ('M68.0*', 'Синовит и теносиновит при бактериальных болезнях, классифицированных в других рубриках'),
--        ('M68.8*',
--         'Другие поражения синовиальной оболочки и сухожилий при болезнях, классифицированных в других рубриках'),
--        ('M70.0', 'Хронический крепитирующий синовит кисти и запястья'),
--        ('M70.1', 'Бурсит кисти'),
--        ('M70.2', 'Бурсит локтевого отростка'),
--        ('M70.3', 'Другие бурситы локтевого сустава'),
--        ('M70.4', 'Препателлярный бурсит'),
--        ('M70.5', 'Другие бурситы коленного сустава'),
--        ('M70.6', 'Бурсит большого вертела (бедренной кости)'),
--        ('M70.7', 'Другие бурситы бедра'),
--        ('M70.8', 'Другие болезни мягких тканей, связанные с нагрузкой, перегрузкой и давлением'),
--        ('M72.0', 'Ладонный фасциальный фиброматоз [Дюпюитрена]'),
--        ('M72.1', 'Соединительнотканные узелки на тыльной поверхности пальцев'),
--        ('M72.2', 'Подошвенный фасциальный фиброматоз'),
--        ('M72.3', 'Узелковый фасциит'),
--        ('M72.4', 'Псевдосаркоматозный фиброматоз'),
--        ('M72.5', 'Фасциит, не классифицированный в других рубриках'),
--        ('M72.8', 'Другие фибробластические нарушения'),
--        ('M75.0', 'Адгезивный капсулит плеча'),
--        ('M75.1', 'Синдром сдавления ротатора плеча'),
--        ('M75.2', 'Тендинит двуглавой мышцы'),
--        ('M75.3', 'Кальцифицирующий тендинит плеча'),
--        ('M75.4', 'Синдром удара плеча'),
--        ('M75.5', 'Бурсит плеча'),
--        ('M75.8', 'Другие поражения плеча'),
--        ('M76.0', 'Тендинит ягодичных мышц'),
--        ('M76.1', 'Тендинит поясничных мышц'),
--        ('M76.2', 'Шпора подвздошного гребешка'),
--        ('M76.3', 'Подвздошный большеберцовый связочный синдром'),
--        ('M76.4', 'Большеберцовый коллатеральный бурсит [Пеллегрини-Штиды]'),
--        ('M76.5', 'Тендинит области надколенника'),
--        ('M76.6', 'Тендинит пяточного [ахиллова] сухожилия'),
--        ('M76.7', 'Тендинит малоберцовой кости'),
--        ('M76.8', 'Другие энтезопатии нижней конечности, исключая стопу'),
--        ('M77.0', 'Медиальный эпикондилит'),
--        ('M77.1', 'Латеральный эпикондилит'),
--        ('M77.2', 'Периартериит запястья'),
--        ('M77.3', 'Пяточная шпора'),
--        ('M77.4', 'Метатарзалгия'),
--        ('M77.5', 'Другие энтезопатии стопы'),
--        ('M77.8', 'Другие энтезопатии, не классифицированные в других рубриках'),
--        ('M80.0', 'Постменопаузный остеопороз с патологическим переломом'),
--        ('M80.1', 'Остеопороз с патологическим переломом после удаления яичников'),
--        ('M80.2', 'Остеопороз с патологическим переломом, вызванный обездвиженностью'),
--        ('M80.3', 'Постхирургический остеопороз с патологическим переломом,вызванный нарушением всасывания в кишечнике'),
--        ('M80.4', 'Лекарственный остеопороз с патологическим переломом'),
--        ('M80.5', 'Идиопатический остеопороз с патологическим переломом'),
--        ('M80.8', 'Другой остеопороз с патологическим переломом'),
--        ('M81.0', 'Постменопаузный остеопороз'),
--        ('M81.1', 'Остеопороз после удаления яичников'),
--        ('M81.2', 'Остеопороз, вызванный обездвиженностью'),
--        ('M81.3', 'Постхирургический остеопороз, вызванный нарушением всасывания'),
--        ('M81.4', 'Лекарственный остеопороз'),
--        ('M81.5', 'Идиопатический остеопороз'),
--        ('M81.6', 'Локализованный остеопороз [Лекена]'),
--        ('M81.8', 'Другие остеопорозы'),
--        ('M82.0*', 'Остеопороз при множественном миеломатозе (C90.0+)'),
--        ('M82.1*', 'Остеопороз при эндокринных нарушениях (E00-E34+)'),
--        ('M82.8*', 'Остеопороз при других болезнях, классифицированных в других рубриках'),
--        ('M84.0', 'Плохое срастание перелома'),
--        ('M84.1', 'Несрастание перелома [псевдартроз]'),
--        ('M84.2', 'Замедленное сращение перелома'),
--        ('M84.3', 'Стрессовые переломы, не классифицированные в других рубриках'),
--        ('M84.4', 'Патологические переломы, не классифицированные в других рубриках'),
--        ('M84.8', 'Другие нарушения целостности кости'),
--        ('M86.0', 'Острый гематогенный остеомиелит'),
--        ('M86.1', 'Другие формы острого остеомиелита'),
--        ('M86.2', 'Подострый остеомиелит'),
--        ('M86.3', 'Хронический многоочаговый остеомиелит'),
--        ('M86.4', 'Хронический остеомиелит с дренированным синусом'),
--        ('M86.5', 'Другие хронические гематогенные остеомиелиты'),
--        ('M86.6', 'Другой хронический остеомиелит'),
--        ('M86.8', 'Другой остеомиелит'),
--        ('M93.0', 'Соскальзывание верхнего эпифиза бедренной кости (нетравматическое)'),
--        ('M93.1', 'Болезнь Кинбека у взрослых'),
--        ('M93.2', 'Рассекающий остеохондрит'),
--        ('M93.8', 'Другие уточненные остеохондропатии'),
--        ('S04.0', 'Травма зрительного нерва и зрительных проводящих путей'),
--        ('S04.1', 'Травма глазодвигательного нерва'),
--        ('S04.2', 'Травма блокового нерва'),
--        ('S04.3', 'Травма тройничного нерва'),
--        ('S04.4', 'Травма отводящего нерва'),
--        ('S04.5', 'Травма лицевого нерва'),
--        ('S04.6', 'Травма слухового нерва'),
--        ('S04.7', 'Травма добавочного нерва'),
--        ('S04.8', 'Травма других черепных нервов'),
--        ('S13.0', 'Травматический разрыв межпозвоночного диска на уровне шеи'),
--        ('S13.1', 'Вывих шейного позвонка'),
--        ('S13.2', 'Вывих другой и неуточненной части шеи'),
--        ('S13.3', 'Множественные вывихи на уровне шеи'),
--        ('S13.4', 'Растяжение и перенапряжение связочного аппарата шейного отдела позвоночника'),
--        ('S13.5', 'Растяжение и перенапряжение связочного аппарата в области щитовидной железы'),
--        ('S13.6', 'Растяжение и перенапряжение суставов и связок других и неуточненных частей шеи'),
--        ('S14.0', 'Контузия и отек шейного отдела спинного мозга'),
--        ('S14.1', 'Другие и неуточненные повреждения шейного отдела спинного мозга'),
--        ('S14.2', 'Травма нервного корешка шейного отдела позвоночника'),
--        ('S14.3', 'Травма плечевого сплетения'),
--        ('S14.4', 'Травма периферических нервов шеи'),
--        ('S14.5', 'Травма симпатических нервов шейного отдела'),
--        ('S14.6', 'Травма других и неуточненных нервов шеи'),
--        ('S16', 'Травма мышц и сухожилий на уровне шеи'),
--        ('S23.0', 'Травматический разрыв межпозвоночного диска в грудном отделе'),
--        ('S23.1', 'Вывих грудного позвонка'),
--        ('S23.2', 'Вывих другого и неуточненного отдела грудной клетки'),
--        ('S23.3', 'Растяжение и перенапряжение связочного аппарата грудного отдела позвоночника'),
--        ('S23.4', 'Растяжение и перенапряжение связочного аппарата ребер и грудины'),
--        ('S23.5', 'Растяжение и перенапряжение связочного аппарата другого и неуточненного отдела грудной клетки'),
--        ('S24.0', 'Ушиб и отек грудного отдела спинного мозга'),
--        ('S24.1', 'Другие и неуточненные травмы грудного отдела спинного мозга'),
--        ('S24.2', 'Травма нервного корешка грудного отдела позвоночника'),
--        ('S24.3', 'Травма периферических нервов грудной клетки'),
--        ('S24.4', 'Травма симпатических нервов грудного отдела'),
--        ('S24.5', 'Травма других нервов грудного отдела'),
--        ('S24.6', 'Травма уточненного нерва грудного отдела'),
--        ('S32.0', 'Перелом поясничного позвонка'),
--        ('S32.1', 'Перелом крестца'),
--        ('S32.2', 'Перелом копчика'),
--        ('S32.3', 'Перелом подвздошной кости'),
--        ('S32.4', 'Перелом вертлужной впадины'),
--        ('S32.5', 'Перелом лобковой кости'),
--        ('S32.7', 'Множественные переломы пояснично-крестцового отдела позвоночника и костей таза'),
--        ('S32.8', 'Переломы других и неуточненных частей пояснично-крестцового отдела позвоночника и костей таза'),
--        ('S33.0', 'Травматический разрыв межпозвоночного диска в пояснично-крестцовом отделе'),
--        ('S33.1', 'Вывих поясничного позвонка'),
--        ('S33.2', 'Вывих крестцово-подвздошного сустава и крестцово-копчикового соединения'),
--        ('S33.3', 'Вывих другой и неуточненной части пояснично-крестцового отдела позвоночника и таза'),
--        ('S33.4', 'Травматический разрыв лобкового симфиза [лонного сочленения]'),
--        ('S33.5', 'Растяжение и перенапряжение капсульно-связочного аппарата поясничного отдела позвоночника'),
--        ('S33.6', 'Растяжение и перенапряжение капсульно-связочного аппарата крестцово-подвздошного сустава'),
--        ('S33.7',
--         'Растяжение и перенапряжение капсульно-связочного аппарата другой и неуточненной части пояснично-крестцового отдела позвоночника и таза'),
--        ('S34.0', 'Сотрясение и отек поясничного отдела спинного мозга'),
--        ('S34.1', 'Другая травма поясничного отдела спинного мозга'),
--        ('S34.2', 'Травма нервного корешка пояснично-крестцового отдела позвоночника'),
--        ('S34.3', 'Травма конского хвоста'),
--        ('S34.4', 'Травма пояснично-крестцового нервного сплетения'),
--        ('S34.5', 'Травма поясничных, крестцовых и тазовых симпатических нервов'),
--        ('S34.6', 'Травма периферического(их) нерва(ов) живота, нижней части спины и таза'),
--        ('S34.8', 'Травма других и неуточненных нервов на уровне живота, нижней части спины и таза'),
--        ('S42.0', 'Перелом ключицы'),
--        ('S42.1', 'Перелом лопатки'),
--        ('S42.2', 'Перелом верхнего конца плечевой кости'),
--        ('S42.3', 'Перелом тела [диафиза] плечевой кости'),
--        ('S42.4', 'Перелом нижнего конца плечевой кости'),
--        ('S42.7', 'Множественные переломы ключицы, лопатки и плечевой кости'),
--        ('S42.8', 'Перелом других частей плечевого пояса и плеча'),
--        ('S43.0', 'Вывих плечевого сустава'),
--        ('S43.1', 'Вывих акромиально-ключичного сустава'),
--        ('S43.2', 'Вывих грудино-ключичного сустава'),
--        ('S43.3', 'Вывих другой и неуточненной части плечевого пояса'),
--        ('S43.4', 'Растяжение и перенапряжение капсульно-связочного аппарата плечевого сустава'),
--        ('S43.5', 'Растяжение и перенапряжение капсульно-связочного аппарата акромиально-ключичного сустава'),
--        ('S43.6', 'Растяжение и перенапряжение капсульно-связочного аппарата грудиноключичного сустава'),
--        ('S43.7',
--         'Растяжение и перенапряжение капсульно-связочного аппарата другой и неуточненной части плечевого пояса'),
--        ('S44.0', 'Травма локтевого нерва на уровне плеча'),
--        ('S44.1', 'Травма срединного нерва на уровне плеча'),
--        ('S44.2', 'Травма лучевого нерва на уровне плеча'),
--        ('S44.3', 'Травма подмышечного нерва'),
--        ('S44.4', 'Травма мышечно-кожного нерва'),
--        ('S44.5', 'Травма кожного чувствительного нерва на уровне плечевого пояса и плеча'),
--        ('S44.7', 'Травма нескольких нервов на уровне плечевого пояса и плеча'),
--        ('S44.8', 'Травма других нервов на уровне плечевого пояса и плеча'),
--        ('S46.0', 'Травма сухожилия вращательной манжеты плеча'),
--        ('S46.1', 'Травма мышцы и сухожилия длинной головки двуглавой мышцы'),
--        ('S46.2', 'Травма мышцы и сухожилия других частей двуглавой мышцы'),
--        ('S46.3', 'Травма мышцы и сухожилия трехглавой мышцы'),
--        ('S46.7', 'Травма нескольких мышц и сухожилий на уровне плечевого пояса и плеча'),
--        ('S46.8', 'Травма других мышц и сухожилий на уровне плечевого пояса и плеча'),
--        ('S52.0', 'Перелом верхнего конца локтевой кости'),
--        ('S52.1', 'Перелом верхнего конца лучевой кости'),
--        ('S52.2', 'Перелом тела [диафиза] локтевой кости'),
--        ('S52.3', 'Перелом тела [диафиза] лучевой кости'),
--        ('S52.4', 'Сочетанный перелом диафизов локтевой и лучевой костей'),
--        ('S52.5', 'Перелом нижнего конца лучевой кости'),
--        ('S52.6', 'Сочетанный перелом нижних концов локтевой и лучевой костей'),
--        ('S52.7', 'Множественные переломы костей предплечья'),
--        ('S52.8', 'Перелом других частей костей предплечья'),
--        ('S53.0', 'Вывих головки лучевой кости'),
--        ('S53.1', 'Вывих в локтевом суставе неуточненный'),
--        ('S53.2', 'Травматический разрыв лучевой коллатеральной связки'),
--        ('S53.3', 'Травматический разрыв локтевой коллатеральной связки'),
--        ('S53.4', 'Растяжение и перенапряжение капсульно-связочного'),
--        ('S56.0', 'Травма сгибателя большого пальца и его сухожилия на уровне предплечья'),
--        ('S56.1', 'Травма сгибателя другого(их) пальца(ев) и его сухожилия на уровне предплечья'),
--        ('S56.2', 'Травма другого сгибателя и его сухожилия на уровне предплечья'),
--        ('S56.3', 'Травма разгибателя или отводящей мышцы большого пальца и их сухожилий на уровне предплечья'),
--        ('S56.4', 'Травма разгибателя другого(их) пальца(ев) и его сухожилия на уровне предплечья'),
--        ('S56.5', 'Травма другого разгибателя и сухожилия на уровне предплечья'),
--        ('S56.7', 'Травма нескольких мышц и сухожилий на уровне предплечья'),
--        ('S56.8', 'Травма других и неуточненных мышц и сухожилий на уровне предплечья'),
--        ('S62.0', 'Перелом ладьевидной кости кисти'),
--        ('S62.1', 'Перелом другой(их) кости(ей) запястья'),
--        ('S62.2', 'Перелом первой пястной кости'),
--        ('S62.3', 'Перелом другой пястной кости'),
--        ('S62.4', 'Множественные переломы пястных костей'),
--        ('S62.5', 'Перелом большого пальца кисти'),
--        ('S62.6', 'Перелом другого пальца кисти'),
--        ('S62.7', 'Множественные переломы пальцев'),
--        ('S64.0', 'Травма локтевого нерва на уровне запястья и кисти'),
--        ('S64.1', 'Травма срединного нерва на уровне запястья и кисти'),
--        ('S64.2', 'Травма лучевого нерва на уровне запястья и кисти'),
--        ('S64.3', 'Травма нерва большого пальца'),
--        ('S64.4', 'Травма нерва другого пальца'),
--        ('S64.7', 'Травма нескольких нервов на уровне запястья и кисти'),
--        ('S64.8', 'Травма других нервов на уровне запястья и кисти'),
--        ('S66.0', 'Травма длинного сгибателя большого пальца и его сухожилия на уровне запястья и кисти'),
--        ('S66.1', 'Травма сгибателя другого пальца и его сухожилия на уровне запястья и кисти'),
--        ('S66.2', 'Травма разгибателя большого пальца и его сухожилия на уровне запястья и кисти'),
--        ('S66.3', 'Травма разгибателя другого пальца и его сухожилия на уровне запястья и кисти'),
--        ('S66.4', 'Травма собственной мышцы и сухожилия большого пальца на уровне запястья и кисти'),
--        ('S66.5', 'Травма собственной мышцы и сухожилия другого пальца  на уровне запястья и кисти'),
--        ('S66.6', 'Травма нескольких мышц-сгибателей и сухожилий на уровне запястья и кисти'),
--        ('S66.7', 'Травма нескольких мышц-разгибателей и сухожилий на уровне запястья и кисти'),
--        ('S66.8', 'Травма других мышц и сухожилий на уровне запястья и кисти'),
--        ('S72.0', 'Перелом шейки бедра'),
--        ('S72.1', 'Чрезвертельный перелом'),
--        ('S72.2', 'Подвертельный перелом'),
--        ('S72.3', 'Перелом тела [диафиза] бедренной кости'),
--        ('S72.4', 'Перелом нижнего конца бедренной кости'),
--        ('S72.7', 'Множественные переломы бедренной кости'),
--        ('S72.8', 'Переломы других частей бедренной кости'),
--        ('S73.0', 'Вывих бедра'),
--        ('S73.1', 'Растяжение и перенапряжение капсульно-связочного аппарата тазобедренного сустава'),
--        ('S74.0', 'Травма седалищного нерва на уровне тазобедренного сустава и бедра'),
--        ('S74.1', 'Травма бедренного нерва на уровне тазобедренного сустава и бедра'),
--        ('S74.2', 'Травма кожного чувчтвительного нерва на уровне тазобед ренного сустава и бедра'),
--        ('S74.7', 'Травма нескольких нервов на уровне тазобедренного сустава и бедра'),
--        ('S74.8', 'Травма других нервов на уровне тазобедренного сустава и бедра'),
--        ('S76.0', 'Травма мышцы и сухожилия области тазобедренного сустава'),
--        ('S76.1', 'Травма четырехглавой мышцы и ее сухожилия'),
--        ('S76.2', 'Травма приводящей мышцы бедра и ее сухожилия'),
--        ('S76.3', 'Травма мышцы и сухожилия из задней группы мышц на уровне бедра'),
--        ('S76.4', 'Травма других и неуточненных мышц и сухожилий на уровне бедра'),
--        ('S76.7', 'Травма нескольких мышц и сухожилий на уровне тазобедренного сустава и бедра'),
--        ('S82.0', 'Перелом надколенника'),
--        ('S82.1', 'Перелом проксимального отдела большеберцовой кости'),
--        ('S82.2', 'Перелом тела [диафиза] большеберцовой кости'),
--        ('S82.3', 'Перелом дистального отдела большеберцовой кости'),
--        ('S82.4', 'Перелом только малоберцовой кости'),
--        ('S82.5', 'Перелом внутренней [медиальной] лодыжки'),
--        ('S82.6', 'Перелом наружной [латеральной] лодыжки'),
--        ('S82.7', 'Множественные переломы голени'),
--        ('S82.8', 'Переломы других отделов голени'),
--        ('S83.0', 'Вывих надколенника'),
--        ('S83.1', 'Вывих коленного сустава'),
--        ('S83.2', 'Разрыв мениска свежий'),
--        ('S83.3', 'Разрыв суставного хряща коленного сустава свежий'),
--        ('S83.4', 'Растяжение, разрыв и перенапряжение (наружной)(внутренней) боковой связки'),
--        ('S83.5', 'Растяжение, разрыв и перенапряжение (передней) (задней) крестообразной связки коленного сустава'),
--        ('S83.6', 'Растяжение, разрыв и перенапряжение других и неуточненных элементов коленного сустава'),
--        ('S83.7', 'Травма нескольких структур коленного сустава'),
--        ('S84.0', 'Травма большеберцового нерва на уровне голени'),
--        ('S84.1', 'Травма малоберцового нерва на уровне голени'),
--        ('S84.2', 'Травма кожного чувствительного нерва на уровне голени'),
--        ('S84.7', 'Травма нескольких нервов на уровне голени'),
--        ('S84.8', 'Травма других нервов на уровне голени'),
--        ('S86.0', 'Травма пяточного [ахиллова] сухожилия'),
--        ('S86.1', 'Травма другой(их) мышцы(мышц) и сухожилия(ий) задней мышечной группы на уровне голени'),
--        ('S86.2', 'Травма мышцы(мышц) и сухожилия(ий) передней мышечной группы на уровне голени'),
--        ('S86.3', 'Травма мышцы(мышц) и сухожилия(ий) малоберцовой мышечной группы на уровне голени'),
--        ('S86.7', 'Травма нескольких мышц и сухожилий на уровне голени'),
--        ('S86.8', 'Травма других мышц и сухожилий на уровне голени'),
--        ('S92.0', 'Перелом пяточной кости'),
--        ('S92.1', 'Перелом таранной кости'),
--        ('S92.2', 'Перелом других костей предплюсны'),
--        ('S92.3', 'Перелом костей плюсны'),
--        ('S92.4', 'Перелом большого пальца стопы'),
--        ('S92.5', 'Перелом другого пальца стопы'),
--        ('S92.7', 'Множественные переломы стопы'),
--        ('S94.0', 'Травма наружного [латерального] подошвенного нерва'),
--        ('S94.1', 'Травма внутреннего [медиального] подошвенного нерва'),
--        ('S94.2', 'Травма глубокого малоберцового нерва на уровне голено стопного сустава и стопы'),
--        ('S94.3', 'Травма кожного чувствительного нерва на уровне голено стопного сустава и стопы'),
--        ('S94.7', 'Травма нескольких нервов на уровне голеностопного сустава и стопы'),
--        ('S94.8', 'Травма других нервов на уровне голеностопного сустава и стопы'),
--        ('S96.0', 'Травма длинного сгибателя пальца и его сухожилия на уровне голеностопного сустава и стопы'),
--        ('S96.1', 'Травма длинного разгибателя пальца и его сухожилия на уровне голеностопного сустава и стопы'),
--        ('S96.2', 'Травма собственной мышцы и сухожилия на уровне голеностопного сустава и стопы'),
--        ('S96.7', 'Травма нескольких мышц и сухожилий на уровне голеностопного сустава и стопы'),
--        ('S96.8', 'Травма другой мышцы и сухожилия на уровне голеностопного сустава и стопы'),
--        ('T02.1', 'Переломы в области грудной клетки, нижней части спины и таза'),
--        ('T02.2', 'Переломы, захватывающие несколько областей одной верхней конечности'),
--        ('T02.3', 'Переломы, захватывающие несколько областей одной нижней конечности'),
--        ('T02.4', 'Переломы, захватывающие несколько областей обеих верхних конечностей'),
--        ('T02.5', 'Переломы, захватывающие несколько областей обеих нижних конечностей'),
--        ('T02.6', 'Переломы, захватывающие несколько областей верхней(их) и нижней(их) конечностей'),
--        ('T02.7', 'Переломы, захватывающие грудную клетку, нижнюю часть спины, таз и конечность(ти)'),
--        ('T02.8', 'Другие сочетания переломов, захватывающих несколько областей тела'),
--        ('T84.0', 'Осложнение механического происхождения, связанное с внутренним суставным протезом'),
--        ('T84.1',
--         'Осложнение механического происхождения, связанное с внутренним устройством, фиксирующим кости конечности'),
--        ('T84.2',
--         'Осложнение механического происхождения, связанное с внутренним устройством, фиксирующим другие кости'),
--        ('T84.3',
--         'Осложнение механического происхождения, связанное с другими костными устройствами, имплантатами и трансплантатами'),
--        ('T84.4',
--         'Осложнение механического происхождения, связанное с другими внутренними ортопедическими устройствами, имплантатами и трансплантатами'),
--        ('T84.5', 'Инфекция и воспалительная реакция, обусловленные эндопротезированием'),
--        ('T84.6',
--         'Инфекция и воспалительная реакция, обусловленные внутренним фиксирующим устройством (любой локализации)'),
--        ('T84.7',
--         'Инфекция и воспалительная реакция, обусловленные другими внутренними ортопедическими протезными устройствами, имплантатами и трансплантатами'),
--        ('T84.8',
--         'Другие осложнения, связанные с внутренними ортопедическими протезными устройствами, имплантатами и трансплантатами'),
--        ('T92.0', 'Последствия открытого ранения верхней конечности'),
--        ('T92.1', 'Последствия перелома верхней конечности, исключая запястье и кисть'),
--        ('T92.2', 'Последствия перелома на уровне запястья и кисти'),
--        ('T92.3', 'Последствия вывиха, растяжения и деформации верхней конечности'),
--        ('T92.4', 'Последствия травмы нерва верхней конечности'),
--        ('T92.5', 'Последствия травмы мышцы и сухожилия верхней конечности'),
--        ('T92.6', 'Последствия размозжения и травматической ампутации верхней конечности'),
--        ('T92.8', 'Последствия других уточненных травм верхней конечности'),
--        ('T93.1', 'Последствия перелома бедра'),
--        ('T93.2', 'Последствия других переломов нижней конечности'),
--        ('T93.3', 'Последствия вывиха, растяжения и деформации нижней конечности'),
--        ('T93.4', 'Последствия травмы нерва нижней конечности'),
--        ('T93.5', 'Последствия травмы мышцы и сухожилия нижней конечности'),
--        ('T93.6', 'Последствия размозжения и травматической ампутации нижней конечности'),
--        ('T93.8', 'Последствия других уточненных травм нижней конечности'),
--        ('T95.2', 'Последствия термического и химического ожога и отморожения верхней конечности'),
--        ('T95.3', 'Последствия термического и химического ожога и отморожения нижней конечности');


-- <===--- DB FILLING ---===>

-- password: 1111
insert into usr (id, password, username, role, first_name, last_name)
values (1, '$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'sadmin', 0, 'sadmin_f', 'sadmin_l');
insert into admin (user_id)
values (1);

insert into user_departments(user_id, departments)
values (1, 0);

insert into usr (id, password, username, role, first_name, last_name, middle_name)
values (2, '$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'doctor', 2, 'doctor_f', 'doctor_l',
        'doctor_m');
insert into doctor (user_id, medical_institution)
values (2, 'Institution of Perdaevo');

insert into user_departments(user_id, departments)
values (2, 1);
insert into user_departments(user_id, departments)
values (2, 2);

insert into usr (id, password, username, role, first_name, last_name)
values (3, '$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'patient', 3, 'patient_f', 'patient_l');
-- insert into patient (id, user_id, doctor_id) values ((, select ident_current('usr')), (select ident_current('doctor')));

insert into user_departments(user_id, departments)
values (3, 1);
insert into user_departments(user_id, departments)
values (3, 2);

