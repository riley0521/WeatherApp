package com.rpfcoding.weatherapp.data.repository.weather

import com.rpfcoding.weatherapp.data.mappers.toWeatherInfo
import com.rpfcoding.weatherapp.data.remote.WeatherApi
import com.rpfcoding.weatherapp.domain.repository.weather.WeatherRepository
import com.rpfcoding.weatherapp.domain.util.Resource
import com.rpfcoding.weatherapp.domain.weather.WeatherInfo
import java.lang.Exception

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}