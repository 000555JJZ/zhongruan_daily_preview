import json
import random
import requests

url_list = []


def get_headers():
    ua_pool = [
        'User-Agent:Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50',
        'User-Agent:Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;',
        'User-Agent:Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1',
        'User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)'
        ]
    ua = random.choice(ua_pool)
    request_headers = {
        "User-Agent": ua
    }
    return request_headers


def get_up_url(line):
    file = open('../urls/pre_data.json', 'r', encoding='utf-8')
    for line in file.readlines():
        line = json.loads(line)
        url_list.append(line['up_url'])
    file.close()
    return url_list


def get_follower(url):
    id = url[21:]
    relation_url = 'https://api.bilibili.com/x/relation/stat?vmid=' + id
    wb_data = requests.get(relation_url, headers=get_headers()).json()
    try:
        all_data = wb_data['data']
    except:
        all_data = {'follower': -1}
    try:
        follower = all_data['follower']
    except:
        pass
    return follower


if __name__ == '__main__':
    file = open('../urls/pre_data.json', 'r', encoding='utf-8')
    data_file = open('../urls/data.json', 'w', encoding='utf-8')
    data_file.truncate()
    for line in file.readlines():
        line = json.loads(line)
        line['fans'] = get_follower(line['up_url'])
        try:
            json.dump(line, data_file, ensure_ascii=False)
            data_file.write('\n')
        except:
            print("write_json_wrong")
    file.close()
    data_file.close()


