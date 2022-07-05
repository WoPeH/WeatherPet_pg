package com.company;

import java.util.HashMap;

//as there is no endpoint to get all this, got to hardcode
//I'm actually not sure if I can hardcode it so that map is not filled with each function call, gotta think on it. r
public class WeatherDescriptionMapper {
    protected static String descriptionMapper(int idOfWeather) { //returns string description based on id
        HashMap<Integer, String> weatherDescription = new HashMap<>();
        weatherDescription.put(200, "Гроза с небольшим дождем");
        weatherDescription.put(201, "Гроза с дождем");
        weatherDescription.put(202, "Гроза с сильным дождем");
        weatherDescription.put(210, "Легкая гроза");
        weatherDescription.put(211, "Гроза");
        weatherDescription.put(212, "Сильная гроза");
        weatherDescription.put(221, "Прерывистая гроза");
        weatherDescription.put(230, "Гроза с легкой моросью");
        weatherDescription.put(231, "Гроза с моросью");
        weatherDescription.put(232, "Гроза с сильной моросью");
        //end of 2xx
        weatherDescription.put(300, "Мелкая морось");
        weatherDescription.put(301, "Морось");
        weatherDescription.put(302, "Интенсивная морось");
        weatherDescription.put(310, "Изморось (Легкий дождь с моросью)");
        weatherDescription.put(311, "Моросящий дождь");
        weatherDescription.put(312, "Сильный моросящий дождь");
        weatherDescription.put(313, "Моросящий ливень");
        weatherDescription.put(314, "Сильный моросящий ливень");
        weatherDescription.put(321, "Короткая морось?"); // I need a translator really
        //end of 3xx
        weatherDescription.put(500, "Легкий дождь");
        weatherDescription.put(501, "Умеренный дождь");
        weatherDescription.put(502, "Сильный интенсивный дождь");
        weatherDescription.put(503, "Очень сильный дождь");
        weatherDescription.put(504, "Окатный (купальный) дождь");
        weatherDescription.put(511, "Холодный дождь");
        weatherDescription.put(520, "Легкий спорый дождь");
        weatherDescription.put(521, "Спорый дождь");
        weatherDescription.put(522, "Сильный спорый дождь");
        weatherDescription.put(531, "Прерывистый спорый дождь");
        //end of 5xx
        weatherDescription.put(600, "Легкий снегопад");
        weatherDescription.put(601, "Снегопад");
        weatherDescription.put(602, "Сильный снегопад");
        weatherDescription.put(611, "Мокрый снег");
        weatherDescription.put(612, "Слабый дождь с мокрым снегом");
        weatherDescription.put(613, "Дождь с мокрым снегом");
        weatherDescription.put(615, "Легкий дождь со снегом");
        weatherDescription.put(616, "Дождь со снегом");
        weatherDescription.put(620, "Легкий спорый снегопад");
        weatherDescription.put(621, "Спорый снегопад");
        weatherDescription.put(622, "Сильный спорый снегопад");
        //end of 6xx
        weatherDescription.put(701, "Легкий туман");
        weatherDescription.put(711, "Мгла");
        weatherDescription.put(721, "Помоха");
        weatherDescription.put(731, "Песчаные/пылевые вихри");
        weatherDescription.put(741, "Туман");
        weatherDescription.put(751, "Ветер с песком");
        weatherDescription.put(761, "Ветер с пылью");
        weatherDescription.put(762, "Ветер с вулканической пылью"); //very likely happening in Minsk
        weatherDescription.put(771, "Шквалы ветра");
        weatherDescription.put(781, "Торнадо");
        //end of 8xx
        weatherDescription.put(800, "Ясно");
        weatherDescription.put(801, "Малооблачно");
        weatherDescription.put(802, "Рассеянные облака");
        weatherDescription.put(803, "Преимущественно облачно");
        weatherDescription.put(804, "Пасмурно");
        return weatherDescription.get(idOfWeather);
    }
}
