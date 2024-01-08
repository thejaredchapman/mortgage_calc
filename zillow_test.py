import requests
import pprint
import pandas as pd 
from pandas.io.json._table_schema import build_table_schema

#TODO(Update api_key with usable rest_api)
api_key = []
api_host = []
location = []

url = "https://zillow56.p.rapidapi.com/search"

querystring = {"location":"{location}"}

headers = {
	"X-RapidAPI-Key": api_key,
	"X-RapidAPI-Host": api_host
}

response = requests.get(url, headers=headers, params=querystring)

data = response.json()


df = pd.DataFrame(data)
print(build_table_schema(df))
df.to_json('results.json', orient='table', lines=True)
df.to_csv('data.txt', sep='\t', index=False)
df.to_excel("output.xlsx")
print(df.to_markdown(tablefmt="grid"))

pprint.pprint(data)
