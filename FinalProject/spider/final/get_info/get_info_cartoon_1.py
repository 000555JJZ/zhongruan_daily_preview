import time

import requests
from bs4 import BeautifulSoup

request_headers = {
    "User-Agent": 'Mozilla/5.0 (Window'
                  's NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36',
    # 'Cookie' : '''_uuid=D1092E3F-C5DE-83A8-4730-AB89416E20CD13109infoc;
    # buvid3=4D2AFC79-8B28-4100-9683-37C4A47B834753919infoc; CURRENT_FNVAL=16; rpdid=|(JJmYR|)k)R0J'ulmJkYlYk~;
    # DedeUserID=165570715; DedeUserID__ckMd5=bbf2bb9233545394; SESSDATA=8ada38e5%2C1608817696%2C2fc5d*61;
    # bili_jct=cc26eba1bcfa8c9fe7b4c532cc58cf98; CURRENT_QUALITY=80; LIVE_BUVID=AUTO4315954020413759;
    # bp_t_offset_165570715=414720117962409386; PVID=10; finger=-166317360 '''

    'Referer': "https://www.bilibili.com/v/douga/?spm_id_from=333.851.b_7072696d6172794368616e6e656c4d656e75.1"
}

url='https://www.bilibili.com/video/BV1ez411v7H7'
wb_data = requests.get(url, headers=request_headers)

soup = BeautifulSoup(wb_data.text, 'html.parser')
time.sleep(20)

title = soup.select_one('#viewbox_report > h1').get_text()
block = soup.select_one('#viewbox_report > div:nth-child(2) > span.a-crumbs > a:nth-child(1)').get_text()
type = soup.select_one('#viewbox_report > div:nth-child(2) > span.a-crumbs > a:nth-child(3)').get_text()
# view = soup.select_one('#viewbox_report > div:nth-child(3) > span.view').get_text()


view = soup.select_one('#arc_toolbar_report > div.ops > span.like').get_text()
print(view)
