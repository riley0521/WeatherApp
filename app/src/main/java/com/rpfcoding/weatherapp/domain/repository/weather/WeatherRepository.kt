package com.rpfcoding.weatherapp.domain.repository.weather

import com.rpfcoding.weatherapp.domain.util.Resource
import com.rpfcoding.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}