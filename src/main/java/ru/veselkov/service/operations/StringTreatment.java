package ru.veselkov.service.operations;

public class StringTreatment {
    public String refactorString(String string) {
        if (string == null) return null;
        String stringWithOutUnnecessaryCharacters = string
                .replaceAll("\\s+", "")
                .toLowerCase();
        if (stringWithOutUnnecessaryCharacters.isEmpty()) {
            return null;
        } else {
            return stringWithOutUnnecessaryCharacters;
        }
    }
}
