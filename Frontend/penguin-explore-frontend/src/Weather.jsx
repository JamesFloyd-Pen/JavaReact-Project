import { useState } from 'react'
import './styles/Weather.css'

function Weather() {
    const [city, setCity] = useState('')
    const [weather, setWeather] = useState(null)
    const [loading, setLoading] = useState(false)
    const [error, setError] = useState(null)

    const fetchWeather = async () => {
        if (!city.trim()) {
            setError('Please enter a city name')
            return
        }

        setLoading(true)
        setError(null)
        
        try {
            const response = await fetch(`http://localhost:8080/api/weather/${city}`)
            
            if (!response.ok) {
                throw new Error('City not found or API error')
            }
            
            const data = await response.json()
            setWeather(data)
        } catch (err) {
            setError(err.message)
            setWeather(null)
        } finally {
            setLoading(false)
        }
    }

    const handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            fetchWeather()
        }
    }

    return (
        <div className="weather-container">
            <h2>Weather Display</h2>
            
            <div className="weather-input">
                <input
                    type="text"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    onKeyPress={handleKeyPress}
                    placeholder="Enter city name"
                    disabled={loading}
                />
                <button onClick={fetchWeather} disabled={loading}>
                    {loading ? 'Loading...' : 'Get Weather'}
                </button>
            </div>

            {error && <p className="error">{error}</p>}

            {weather && (
                <div className="weather-display">
                    <h3>{weather.name}, {weather.sys?.country}</h3>
                    <div className="weather-main">
                        <div className="temperature">
                            {Math.round(weather.main?.temp)}°C
                        </div>
                        <div className="weather-description">
                            {weather.weather?.[0]?.description}
                        </div>
                    </div>
                    <div className="weather-details">
                        <p><strong>Feels like:</strong> {Math.round(weather.main?.feels_like)}°C</p>
                        <p><strong>Humidity:</strong> {weather.main?.humidity}%</p>
                        <p><strong>Wind Speed:</strong> {weather.wind?.speed} m/s</p>
                        <p><strong>Pressure:</strong> {weather.main?.pressure} hPa</p>
                    </div>
                </div>
            )}
        </div>
    )
}

export default Weather
