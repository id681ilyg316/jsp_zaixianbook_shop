## 本项目实现的最终作用是基于JSP在线图书销售商城网站项目
## 分为3个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 会员用户管理
 - 图书分类管理
 - 图书管理
 - 新闻管理
 - 管理员登录
 - 管理员账号管理
 - 订单管理
 - 评价管理
### 第2个角色为设计文稿，实现了如下功能：
 - 设计文稿截图
### 第3个角色为用户角色，实现了如下功能：
 - 会员登录注册
 - 商城公告新闻查看
 - 最新图书查看
 - 查看图书详情
 - 查看我的订单
 - 查看评论以及发表评论
 - 查看购物车
 - 用户首页
## 数据库设计如下：
# 数据库设计文档

**数据库名：** zaixianbook_shop

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [bookclassification](#bookclassification) |  |
| [bookcomment](#bookcomment) |  |
| [bookinformation](#bookinformation) |  |
| [bookorderform](#bookorderform) |  |
| [commonmember](#commonmember) |  |
| [dtproperties](#dtproperties) |  |
| [ordersendingform](#ordersendingform) |  |
| [shoppingcar](#shoppingcar) |  |
| [systemadministrator](#systemadministrator) |  |
| [webnews](#webnews) |  |

**表名：** <a id="bookclassification">bookclassification</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | bookclass_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | bookclass_classification |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | bookclass_addtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="bookcomment">bookcomment</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | bookcomment_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | bookcomment_content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | bookcomment_sender |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | bookcomment_sendtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | bookcomment_bookid |   int   | 10 |   0    |    Y     |  N   |   0    |   |

**表名：** <a id="bookinformation">bookinformation</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | book_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | book_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图书名称  |
|  3   | book_picturepath |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | book_author |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图书作者  |
|  5   | book_publisher |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | book_price |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | book_classification |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | book_discountok |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | book_discount |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | book_recommendlevel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | book_storeamount |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  12   | book_type |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  13   | book_addtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="bookorderform">bookorderform</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | bookorderform_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | bookorderform_formnumber |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | bookorderform_bookid |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  4   | bookorderform_amount |   int   | 10 |   0    |    Y     |  N   |   0    |   |

**表名：** <a id="commonmember">commonmember</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | member_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | member_loginname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | member_password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | member_truename |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | member_sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | member_email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | member_tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | member_level |   double   | 23 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="dtproperties">dtproperties</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | objectid |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  3   | property |   varchar   | 64 |   0    |    N     |  N   |       |   |
|  4   | value |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 值  |
|  5   | uvalue |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | lvalue |   mediumblob   | 16777215 |   0    |    Y     |  N   |   NULL    |   |
|  7   | version |   int   | 10 |   0    |    N     |  N   |   0    |   |

**表名：** <a id="ordersendingform">ordersendingform</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | ordersendingform_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | ordersendingform_formnumber |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | ordersendingform_userid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | ordersendingform_sendok |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | fangshi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | zhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="shoppingcar">shoppingcar</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | shoppingcar_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | shoppingcar_bookid |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  3   | shoppingcar_amount |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  4   | shoppingcar_addtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | shoppingcar_userid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="systemadministrator">systemadministrator</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | admin_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | admin_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | admin_password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | admin_addtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="webnews">webnews</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | webnews_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | webnews_title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | webnews_content |   varchar   | 5000 |   0    |    Y     |  N   |   NULL    |   |
|  4   | webnews_sendtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | webnews_sender |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**运行不出来可以微信 javape 我的公众号：源码码头**
