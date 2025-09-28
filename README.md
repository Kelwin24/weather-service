# 🌦️ Weather Project

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green?logo=spring)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9-red?logo=apache-maven)](https://maven.apache.org/)
[![Redis](https://img.shields.io/badge/Redis-7-orange?logo=redis)](https://redis.io/)
[![OpenWeather](https://img.shields.io/badge/OpenWeather-API-blueviolet)](https://openweathermap.org/api)

---

## Overview

The **Weather Project** is a Spring Boot application that provides **real-time weather data** and a short **forecast** for any city.
It integrates with the **OpenWeather API** and uses **Redis caching** to reduce repeated API calls and improve performance.

---

## 🚀 Features

* Search weather by city name.
* Displays:

  * 🌍 Location
  * 🌤 Current weather condition
  * 🌡 Current temperature (°C)
  * 📅 Multi-day forecast (description & temperature)
* Redis caching for efficiency.
* Clean UI built with Thymeleaf.
* Error handling for invalid or non-existent cities.

---

## 🛠 Tech Stack

* **Backend:** Java 17, Spring Boot 3.2
* **Frontend:** Thymeleaf, HTML, CSS
* **Cache:** Redis 7
* **API:** OpenWeather API
* **Build Tool:** Maven 3.9

---

## ⚙️ Installation & Setup

1. **Clone the repository**

```bash
git clone <your-repo-link>
cd weather-project
```

2. **Set up Redis**
   Ensure Redis is installed and running (default port `6379`).

Linux/Mac:

```bash
sudo service redis-server start
```

Windows (Chocolatey):

```bash
choco install redis-64
redis-server
```

3. **Configure API Key**
   In `src/main/resources/application.properties`:

```properties
weather.api.key=<YOUR_API_KEY>
weather.api.url=http://api.openweathermap.org/data/2.5/weather
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
```

4. **Run the project with Maven**

```bash
mvn spring-boot:run
```

5. **Access the app**
   Open:

```
http://localhost:8080
```

---

## 📖 Usage

1. Enter a **city name** in the home page form.
2. Click **Get Weather**.
3. Results page displays:

```
Weather in <City Name>

Current Weather
Condition: <description>
Temperature: <temperature> °C

Forecast
- <day1 description> - <day1 temperature> °C
- <day2 description> - <day2 temperature> °C
- <day3 description> - <day3 temperature> °C

[Check another city]
```

---

## 🔮 Future Enhancements

* Include weather icons (☀️ 🌧 ☁️).
* Improve mobile responsiveness.
* Add map integration.

---

## 👨‍💻 Author

**Kelwin Kishore**
