import json
import random
import time
import requests
from bs4 import BeautifulSoup

data = []
i = 1


def get_headers():
    ua_pool = ['User-Agent:Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11',
               'User-Agent:Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1',
               'User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X '
               'MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)',
               'User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)']
    ua = random.choice(ua_pool)
    request_headers = {
        "User-Agent": ua
    }
    return request_headers


def get_single_data(url):
    global i
    wb_data = requests.get(url, headers=get_headers()).json()
    all_data = wb_data['data']
    try:
        single_data = {
            'aid': all_data['aid'],  # 视频编号
            'bvid': all_data['bvid'],
            'view': all_data['view'],  # 播放量
            'like': all_data['like'],  # 点赞数
            'danmaku': all_data['danmaku'],  # 弹幕数
            'reply': all_data['reply'],  # 评论数
            'favorite': all_data['favorite'],  # 收藏数
            'coin': all_data['coin'],  # 硬币数
            'share': all_data['share'],  # 分享数
            'not_used': 1
        }
        single_data.update(get_more(all_data['bvid']))
        try:
            json.dump(single_data, file, ensure_ascii=False)
            file.write('\n')
        except:
            print("write_json_wrong")
        if i % 10 == 0:
            print(single_data)
        i = i + 1
    except:
        pass


def get_more(bvid):
    j = 0
    tag_string = ''
    url = 'https://www.bilibili.com/video/' + bvid
    wb_data = requests.get(url, headers=get_headers())
    soup = BeautifulSoup(wb_data.text, 'html.parser')
    name = soup.select_one('#viewbox_report > h1 > span').get_text()
    up_url = ''
    try:
        up_url = soup.select_one('.username').get('href')
    except:
        pass
    try:
        up_url = soup.select_one('#member-container > div:nth-child(2) > div.panel > div > a').get('href')
    except:
        pass
    class_1 = soup.select_one('#viewbox_report > div:nth-child(2) > span.a-crumbs > a:nth-child(1)').get_text()
    class_2 = soup.select_one('#viewbox_report > div:nth-child(2) > span.a-crumbs > a:nth-child(3)').get_text()
    tags = soup.select('.tag-link')
    for tag in tags:
        j = j + 1
        if j < tags.__len__():
            tag_string = tag_string + tag.get_text() + ':::'
        else:
            tag_string = tag_string + tag.get_text()
    data_add = {
        'name': name,
        'class_1': class_1,
        'class_2': class_2,
        'tags': tag_string,
        'up_url': up_url
    }
    return data_add


if __name__ == '__main__':
    file = open('../urls/data1.json', 'a', encoding='utf-8')
    # file.truncate()
    urls = ['https://api.bilibili.com/x/web-interface/archive/stat?aid={}'.format(num) for num in range(171392, 187190)]
    for url in urls:
        get_single_data(url)
    file.close()


