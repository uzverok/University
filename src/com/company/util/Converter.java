package Students.util;

import Students.model.Teacher;

@FunctionalInterface
public interface Converter<T,N> {
    N convert(T t);
}
