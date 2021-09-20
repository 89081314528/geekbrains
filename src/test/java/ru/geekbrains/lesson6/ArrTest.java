package ru.geekbrains.lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ArrTest {
    private Arr arr;

    @BeforeEach
    public void init() {
        arr = new Arr();
    }

    @Test
    public void shouldReturnArr() {
        final int[] newArr = arr.selectAfterLastFour(new int[]{1, 3, 4, 5, 6, 4, 7, 8, 4, 3, 2, 7});
        assertArrayEquals(new int[]{4, 3, 2, 7}, newArr);
    }

    @Test
    public void shouldReturnExeption() {
        assertThrows(RuntimeException.class, () -> {
            arr.selectAfterLastFour(new int[]{1, 3});
        });
    }

    @ParameterizedTest
    @MethodSource("dataForArray")
    public void testArray(int[] array, int[] result) {
        assertArrayEquals(result, arr.selectAfterLastFour(array));
    }

    public static Stream<Arguments> dataForArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 4}, new int[]{4}));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 4, 3}, new int[]{4, 3}));
        out.add(Arguments.arguments(new int[]{1, 3, 4, 5, 6, 4, 7, 8, 4, 3, 2, 7}, new int[]{4, 3, 2, 7}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForArray2")
    public void testArray2(int[] array, boolean result) {
        assertEquals(result, arr.consistOneTwo(array));
    }

    public static Stream<Arguments> dataForArray2() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 3}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        return out.stream();
    }
}