import requests
import pprint
import pandas as pd 
from pandas.io.json._table_schema import build_table_schema



url = "https://zillow56.p.rapidapi.com/search"

querystring = {"location":"chicago, il"}

headers = {
	"X-RapidAPI-Key": "9202cb6d35msh267f818513d4c85p1364fdjsn3cbef17f0867",
	"X-RapidAPI-Host": "zillow56.p.rapidapi.com"
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