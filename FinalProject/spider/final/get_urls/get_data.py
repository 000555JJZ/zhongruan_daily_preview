import json
import random
import time
import requests
from bs4 import BeautifulSoup

data = []
i = 1
time_start = time.time()


def get_ips():
    ip_list = []

    request_headers = {
        "User-Agent": 'Mozilla/5.0 (Window'
                      's NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36'
    }
    urls = ['https://www.kuaidaili.com/free/inha/{}/'.format(num) for num in range(1, 5)]
    for url in urls:
        wb_data = requests.get(url, headers=get_headers())
        soup = BeautifulSoup(wb_data.text, 'html.parser')
        trs = soup.select('#list > table > tbody > tr')
        for tr in trs:
            proxy = {tr.select('td')[3].get_text(): tr.select_one('td').get_text()}
            ip_list.append(proxy)
        time.sleep(2)
    return ip_list


def get_headers():
    # ua_pool = ['Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131
    # Safari/537.36', 'Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0', 'Mozilla/5.0 (X11; U;
    # Linux x86_64; zh-CN; rv:1.9.2.10) Gecko/20100922 Ubuntu/10.10 (maverick) Firefox/3.6.10', 'Mozilla/5.0 (X11;
    # Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36 OPR/60.0.3255.83' ]

    ua_pool = [
        'User-Agent:Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) '
        'Version/5.1 Safari/534.50',
        'User-Agent:Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;',
        'User-Agent:Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1',
        'User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)'
        ]

    ua = random.choice(ua_pool)
    request_headers = {
        "User-Agent": ua
    }
    return request_headers


def get_follower(url):
    id = url[21:]
    relation_url = 'https://api.bilibili.com/x/relation/stat?vmid=' + id
    wb_data = requests.get(relation_url, headers=get_headers(), proxies=random.choice(ips)).json()
    try:
        all_data = wb_data['data']
    except:
        all_data = {'follower': -1}
    try:
        follower = all_data['follower']
    except:
        pass
    return follower


def get_single_data(url):
    global i
    global time_start
    wb_data = requests.get(url, headers=get_headers(), proxies=random.choice(ips)).json()
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
        single_data['fans'] = get_follower(single_data['up_url'])
        try:
            json.dump(single_data, file, ensure_ascii=False)
            file.write('\n')
        except:
            print("write_json_wrong")
        if i % 10 == 0:
            time_end = time.time()
            print(single_data)
            print((time_end - time_start) / 60)
            if ((time_end - time_start)) / 60 > 1:
                time.sleep(30)
                time_start = time.time()
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
    ips = get_ips()
    file = open('../urls/pre_data.json', 'a', encoding='utf-8')
    # file.truncate()
    urls = ['https://api.bilibili.com/x/web-interface/archive/stat?aid={}'.format(num) for num in range(130954, 150001)]
    for url in urls:
        get_single_data(url)
    file.close()
