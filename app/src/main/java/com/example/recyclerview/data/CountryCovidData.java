package com.example.recyclerview.data;

import java.io.Serializable;

public class CountryCovidData implements Serializable {
    String ActiveCasesText;
    String CountryText;
    String NewCasesText;
    String NewDeathsText;
    String TotalCasesText;
    String TotalDeathsText;
    String TotalRecoveredText;

    public CountryCovidData(String ActiveCasesText,
                            String CountryText,
                            String NewCasesText,
                            String NewDeathsText,
                            String TotalCasesText,
                            String TotalDeathsText,
                            String TotalRecoveredText) {
        this.ActiveCasesText = ActiveCasesText;
        this.CountryText = CountryText;
        this.NewCasesText = NewCasesText;
        this.NewDeathsText = NewDeathsText;
        this.TotalCasesText = TotalCasesText;
        this.TotalDeathsText = TotalDeathsText;
        this.TotalRecoveredText = TotalRecoveredText;
    }

    @Override
    public String toString() {
        return CountryText;
    }

    public String getActiveCasesText() {
        return ActiveCasesText;
    }

    public String getCountryText() {
        return CountryText;
    }

    public String getNewCasesText() {
        return NewCasesText;
    }

    public String getNewDeathsText() {
        return NewDeathsText;
    }

    public String getTotalCasesText() {
        return TotalCasesText;
    }

    public String getTotalDeathsText() {
        return TotalDeathsText;
    }

    public String getTotalRecoveredText() {
        return TotalRecoveredText;
    }
}
