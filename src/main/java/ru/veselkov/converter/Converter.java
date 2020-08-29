package ru.veselkov.converter;

public interface Converter<S, T> {
    T convert(S source);
}
