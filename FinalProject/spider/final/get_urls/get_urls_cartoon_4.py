# from selenium.webdriver.support import expected_conditions as EC

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import os
# import time
# import io
# import sys
# from collections import defaultdict, OrderedDict
import json

cartoon_urls = {}
i = 1


def single_page_spider(url):
    # sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')


    global i
    chromedriver = r"C:\Users\HP\AppData\Local\Programs\Python\Python38-32\chromedriver.exe"
    os.environ["webdriver.chrome.driver"] = chromedriver
    chrome_options = Options()
    chrome_options.add_argument('headless')
    driver = webdriver.Chrome(chromedriver, chrome_options=chrome_options)
    driver.get(url)
    videos = driver.find_elements_by_xpath('//*[@id="videolist_box"]/div[2]/ul/li/div/div[1]/div/a')
    for video in videos:
        if i <= 1000:
            cartoon_urls[video.get_attribute('href')] = i
            i = i + 1
    print("get already " + str(i - 1) + ' urls')


if __name__ == '__main__':
    urls = ['https://www.bilibili.com/v/douga/garage_kit/?spm_id_fr' \
            'om=333.6.b_7375626e6176.6#/all/click/0/{}/2020-07-16,2020-07-23'.format(number) for number in range(1, 52)]
    for url in urls:
        single_page_spider(url)
    file = open('../urls/urls_cartoon_4.json', 'w', encoding='utf-8')
    try:
        json.dump(cartoon_urls, file, ensure_ascii=False)
    except:
        print("write_json_wrong")
    finally:
        file.close()

