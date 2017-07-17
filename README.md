# metmoji-server

## Files to add in src/main/resources
To make metmoji-server working you need to include 2 files into scr/main/resources.

**app.properties:**
This file contains the API key to access the openweathermap API.
```
openweathermapApiKey: XXXXXXXXXXXXX
```

**city.list.json:**
This file contains the list of all cities available in openweather map. This can be downloaded from openweathermap and is not included here, because I was not sure if it is allowed to publish this file on github. 
```json
[
  {
    "id": 2950158,
    "name": "Berlin",
    "country": "DE",
    "coord": {
      "lon": 10.45,
      "lat": 54.033329
    }
  },
  ...
]
```
