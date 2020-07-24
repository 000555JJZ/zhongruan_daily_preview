import requests
from bs4 import BeautifulSoup
import json

if __name__ == '__main__':
    f = open("urls/cartoon_urls.json.json", encoding='utf-8')
    cartoon_urls = json.load(f)
