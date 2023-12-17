package com.kaanduzbastilar.kotlincountries.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kaanduzbastilar.kotlincountries.model.Country

@Dao
interface CountryDao {

    //data access object
    @Insert
    suspend fun insertAll(vararg countries: Country) : List<Long>

    //Insert -> INSERT INTO
    //suspend coroutineler içerisinde çağırılıyor, durdurulup devam ettirilmeye olanak veren
    //vararg -> SQLite'ta objeleri tek tek giriyoruz bununla birlikte istediğimiz kadarı istediğimiz zaman vermemiz lazım, kaçtane vericeğimi bilmiyorum internetten kaç tane gelicek ,listede olmaz tek tek vermem gerkeiyor, bir tekil objeyi farklı sayılarla verebilmemiz için gerekli olan keyword, bir liste verdiğimi 10 tane 15 tane country olduğunu düşün ama hepsini tek tek veriyoruz, bu long listeside uuidleri döndürücek
    //list long -> primary key

    @Query("SELECT * FROM country")
    suspend fun getAllCountries() : List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()
}