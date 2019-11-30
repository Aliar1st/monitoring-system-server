package loc.aliar.monitoringsystemserver.domain;

public interface FieldParameters {
    int USERNAME_MIN = 4;
    int USERNAME_MAX = 50;

    int PASSWORD_MIN = 4;
    int PASSWORD_MAX = 50;
    int PASSWORD_HASH_MAX = 100;

    int FIRST_NAME_MIN = 2;
    int FIRST_NAME_MAX = 50;

    int LAST_NAME_MIN = 2;
    int LAST_NAME_MAX = 50;

    int MIDDLE_NAME_MIN = 2;
    int MIDDLE_NAME_MAX = 50;

    int EMAIL_MIN = 3;
    int EMAIL_MAX = 130;

    int PHONE_MIN = 11;
    int PHONE_MAX = 12;
    String PHONE_PATTERN = "(\\+7|7|8)[0-9]{10}";

    int MEDICAL_INSTITUTION_MIN = 4;
    int MEDICAL_INSTITUTION_MAX = 255;

    int EDUCATION_NAME_MIN = 4;
    int EDUCATION_NAME_MAX = 30;

    int POSITION_NAME_MIN = 4;
    int POSITION_NAME_MAX = 70;

    int SPECIALIZATION_NAME_MIN = 4;
    int SPECIALIZATION_NAME_MAX = 50;

    int DEGREE_NAME_MIN = 4;
    int DEGREE_NAME_MAX = 30;

    int TEST_NAME_MAX = 255;
    int QUESTION_NAME_MAX = 350;
    int ANSWER_NAME_MAX = 255;
    int ANSWER_DATA_MAX = 500;

    int MKB_10_CODE_MAX = 10;
    int MKB_10_NAME_MAX = 255;
}
