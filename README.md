# Ordering-App
﻿「嵌入式系統軟體設計」期末專題報告

撰寫重點 

**1月12日下午5點前繳交到wm.ntue.edu.tw**

**題目: 買我MaiWo 點餐系統**

**作者: 班級  資三甲    學號 110916042    姓名  楊宗翰**     

- 目的與優點

顧客可以在進入系統之後，商品條列式顯現，操作簡單，確認餐點後會到購物車頁面結算金額，確保沒有買錯商品，買錯的話可以重新下訂。

若商品確定之後則會把訂單送到店家，進入店家頁面需要先進行註冊和登入，就能看到條列式的訂內容。

- 操作說明

分成顧客和店家

顧客 : 

`	`可以進行點餐，商品數量可以使用按鈕(+1)(-1)進行調整，按下確認按鈕後會到購物車頁面，這裡會顯示出剛剛所購買的物品還有總結算金額，若有購買錯誤可以重新下訂，若無，即可把訂單傳送到店家。

店家 :

`	`首先，店家是不能隨便進入的，需要進行註冊和登入帳號，而後即可看到從顧客傳送來的訂單資訊。


- 使用元件、技術(如Text View、SQLite、Side Mweu、多國語言支援等等)

多國語言 : 英文、中文、日文

SQLiteDatabase、Cursor、TextView、ScrollView、ImageView、Intent、Bundle

- 程式列表(原始程式碼，自建圖案，多國語言等)

多國語言 :

英文

![](Aspose.Words.1bdb49a3-c41a-4381-91f3-c96f8480a5ce.001.png)

中文

![](Aspose.Words.1bdb49a3-c41a-4381-91f3-c96f8480a5ce.002.png)

日文

![](Aspose.Words.1bdb49a3-c41a-4381-91f3-c96f8480a5ce.003.png)

自建圖案：買我 logo

![](Aspose.Words.1bdb49a3-c41a-4381-91f3-c96f8480a5ce.004.png)

程式列表 : 

![](Aspose.Words.1bdb49a3-c41a-4381-91f3-c96f8480a5ce.005.png)

- 心得
![image](https://github.com/yanghenry0526/Ordering-App/blob/main/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202023-09-30%20211318.png)
![image](https://github.com/yanghenry0526/Ordering-App/blob/main/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202023-09-30%20211544.png)  
![image](https://github.com/yanghenry0526/Ordering-App/blob/main/%E8%9E%A2%E5%B9%95%E6%93%B7%E5%8F%96%E7%95%AB%E9%9D%A2%202023-09-30%20211747.png)
