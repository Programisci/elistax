package com.dubilowicz.elista.utils.converters;

/**
 * Created by RaikPraca on 2016-03-23.
 */
public interface IConverter<T1,T2>
{
    T1 ConvertToOb(T2 obj);
    T2 ConvertToDto(T1 obj);
}
