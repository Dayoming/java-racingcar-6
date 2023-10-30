package racingcar;

public class Validator {

    public static boolean validateNames(String names) {
        String CarNames[] = names.split(",");

        if (names.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_NAME);
        }

        if (CarNames.length < 2) {
            throw new IllegalArgumentException(Messages.ERROR_SHORTAGE_PEOPLE);
        }

        for (String name : CarNames) {
            validateName(name);
        }
        return true;
    }

    public static void validateName(String name) {
        if (name.length() > GameRuleNumbers.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Messages.ERROR_NAME_LIMIT_EXCESS);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_NAME);
        }
    }

    public static boolean validateNumber(String number) {
        final String REGEX = "[0-9]+";
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(Messages.ERROR_INCLUSION_NUMBER);
        }
        if (Integer.parseInt(number) < 1) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_SMALL);
        }
        return true;
    }
}
