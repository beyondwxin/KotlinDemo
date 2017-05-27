package king.com.kotlindemo.bean

/**
 * Created by wuxin on 2017/5/27.
 */
/*
"error": false,
"results": [
{
    "_id": "590859ce421aa90c83a513b5",
    "createdAt": "2017-05-02T18:05:02.17Z",
    "desc": "Android \u591a\u72b6\u6001\u52a0\u8f7d\u5e03\u5c40\u7684\u5f00\u53d1 Tips",
    "images": [
    "http://img.gank.io/c1239688-bf22-46a7-ab46-b23bfb8d32da"
    ],
    "publishedAt": "2017-05-26T13:43:32.128Z",
    "source": "chrome",
    "type": "Android",
    "url": "http://gudong.name/2017/04/26/loading_layout_practice.html",
    "used": true,
    "who": "\u5495\u549a"
},
*/

data class UserResult(val error: Boolean, val list: List<User>)