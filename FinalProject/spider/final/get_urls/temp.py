import requests
from bs4 import BeautifulSoup

request_headers = {
    "User-Agent": 'Mozilla/5.0 (Window'
                  's NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36'
}

def get_rest(bvid):
    j = 0
    tag_string = ''
    bvid = 'BV1ga4y1e7Z1'
    url = 'https://www.bilibili.com/video/' + bvid
    wb_data = requests.get(url, headers=request_headers)
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
            tag_string = tag_string + tag.get_text() + ' '
        else:
            tag_string = tag_string + tag.get_text()
    data_add = {
        'name': name,
        'class_1': class_1,
        'class_2': class_2,
        'tags': tag_string,
        'up_url': up_url
    }
    print(data_add)

    request