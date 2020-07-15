import requests
from bs4 import BeautifulSoup


def spider():
    request_headers = {
        "User-Agent": 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36'
    }
    path = 'json/data_store.json'

    # url list
    urls = ['https://movie.douban.com/top250?start={}&filter='.format(number*25) for number in range(0, 10)]
    for single_url in urls:
        wb_data = requests.get(single_url, headers=request_headers)
        soup = BeautifulSoup(wb_data.text, 'lxml')
        htmls = soup.select('.hd > a')
        for html in htmls:
            i = 0
            wb_data = requests.get(html.get('href'), headers=request_headers)
            soup = BeautifulSoup(wb_data.text, 'html.parser')
            rank = soup.select_one('.top250-no').get_text().strip()
            name = soup.select_one('#content > h1 > span:nth-child(1)').get_text().strip()
            score = soup.select_one(
                '#interest_sectl > div.rating_wrap.clearbox > div.rating_self.clearfix > strong').get_text().strip()
            date = soup.select_one('''span[property='v:initialReleaseDate']''').get_text().strip()
            director = soup.select_one('#info > span:nth-child(1) > span.attrs > a').get_text().strip()
            actors = soup.select('#celebrities > ul > li')
            data = rank + '  电影名：' + name + '    评分：' + score + '    上映日期：' + date + '    导演：' + director + '    演员：'
            # review_links = soup.select('.main-bd > h2 > a')
            for actor in actors:
                i = i + 1
                actor_name = actor.a.get('title')
                if i < 6:
                    data = data + actor_name + '，'
                else:
                    data = data + actor_name
            # for review_link in review_links:
            #     wb_data = requests.get(review_link.get('href'), headers=request_headers)
            #     soup = BeautifulSoup(wb_data.text, 'lxml')
            #     str = soup.select_one('#content > div > div.article > h1 > span').get_text()
            #     str = str + soup.find('div', class_='review-content clearfix').get_text()
            #     data = data + str
            print(data)

spider()







