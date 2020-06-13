package com.eduit.spring.model;

import java.util.List;

public interface DtoMapper<I, O> {

    O map(I object);

    List<O> map(List<I> objects);
}
