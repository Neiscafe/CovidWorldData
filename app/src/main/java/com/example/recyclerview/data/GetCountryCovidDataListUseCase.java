package com.example.recyclerview.data;

import android.content.Context;

import java.util.List;

public interface GetCountryCovidDataListUseCase {
    List<CountryCovidData> execute(Context appContext);
}
