import requests
from bs4 import BeautifulSoup
import pymongo

client = pymongo.MongoClient('192.168.0.108')
db = client['spider']
MONGO_TABLE = 'movie'


def save_to_mongo(result):
    try:
        if db[MONGO_TABLE].save(result):
            print('存储成功',result)
    except Exception:
        print('存储失败',result)


def spider():
    request_headers = {
        "User-Agent": 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36'
    }
    path = 'json/data_store.json'

    # url list
    urls = ['https://movie.douban.com/top250?start={}&filter='.format(number*25) for number in range(0, 10)]
    i = 0
    for single_url in urls:

        wb_data = requests.get(single_url, headers=request_headers)
        soup = BeautifulSoup(wb_data.text, 'lxml')
        htmls = soup.select('.hd > a')
        try:
            for html in htmls:
                i=i+1
                wb_data = requests.get(html.get('href'), headers=request_headers)
                soup = BeautifulSoup(wb_data.text, 'html.parser')
                rank = soup.select_one('.top250-no').get_text().strip()
                name = soup.select_one('#content > h1 > span:nth-child(1)').get_text().strip()
                temp_score = soup.select_one(
                    '#interest_sectl > div.rating_wrap.clearbox > div.rating_self.clearfix > strong').get_text().strip()
                score = float(temp_score)
                date = soup.select_one('''span[property='v:initialReleaseDate']''').get_text().strip()
                director = soup.select_one('#info > span:nth-child(1) > span.attrs > a').get_text().strip()
                actors = soup.select('#celebrities > ul > li')
                # data = rank + '  电影名：' + name + '    评分：' + score + '    上映日期：' + date + '    导演：' + director + '    演员：'
                actors_name = []
                for actor in actors:
                    # i = i + 1
                    actor_name = actor.a.get('title')
                    actors_name.append(actor_name)
                data = {
                    'id': i,
                    'rank': rank,
                    'name': name,
                    'score': score,
                    'date': date,
                    'director': director,
                    'actors': actors_name,
                }
                save_to_mongo(data)
        except:
            print("爬取失败")


if __name__ == '__main__':
    spider()







