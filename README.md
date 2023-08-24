## MyBatisでReadの実装
### 概要
#### やったこと：4名のid、name(氏名)、age(年齢)、address(住所)の実装
#### 仕様：id, name, ageのみレスポンスとして返す 
#### Postman URL：```http://localhost:8080/guests```, ```http://localhost:8080/guests/(id番号)```

### 動作確認
* データベース名：guest_db
* テーブル名：guests
* guestsのカラムとレコード

| id | name | age | address |
| ---- | ---- | ---- | ---- |
| 1 | yamada | 30 | 東京都千代田区 |
| 2 | tanaka | 40 | 大阪府大阪市 |
| 3 | okamoto | 50 | 北海道札幌市 |
| 4 | murakami | 60 | 沖縄県那覇市 |

![mysql-guest_db](https://github.com/Haruka2306/task9/assets/137120436/c751f9d0-639a-4ecf-b169-26cd0180d8a9)

#### Postman URL：```http://localhost:8080/guests```
![task9_postman_guests](https://github.com/Haruka2306/task9/assets/137120436/a5b96267-79a4-40a2-8ccc-c857fdc9968d)

#### Postman URL：```http://localhost:8080/guests/1```
![task9_postman_guests1](https://github.com/Haruka2306/task9/assets/137120436/70f84f53-cab7-47bb-9c38-f0e4988fdfe5)
