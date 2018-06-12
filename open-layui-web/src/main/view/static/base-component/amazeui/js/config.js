/**
 * Created by huzhihui on 2016/9/30.
 */

/**
 * 全局列表json
 * @type {{}}
 */
var TAB_JSON = {
    list: [
        {
            listName: '首页',/*tab名称*/
            listUrl: 'pages/dashboard.html',/*页面路径*/
            listUuid: 'uuid-main',/*tab唯一标识*/
            listIcon: 'am-icon-home',/*左侧显示图标*/
            listRightIcon: '',/*右侧显示图标*/
            listNumber: '',/*右侧显示数字数据*/
            listNumberColor: 'am-badge am-badge-secondary',/*右侧显示数字数据样式*/
            isHtml: true/*是否是页面，false为折叠tab*/
        },
        {
            listName: '页面模版',
            listUrl: '',
            listUuid: 'uuid-moban',
            listIcon: 'am-icon-file',
            listRightIcon: 'am-icon-angle-right',
            listNumber: '',
            listNumberColor: '',
            isHtml: false,
            subList: [
                {
                    listName: '个人资料',
                    listUrl: 'html/personal-data.html',
                    listUuid: 'uuid-personal-data',
                    listIcon: 'am-icon-check',
                    listRightIcon: 'am-icon-star',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '帮助页',
                    listUrl: 'html/main.html',
                    listUuid: 'uuid-help',
                    listIcon: 'am-icon-puzzle-piece',
                    listRightIcon: '',
                    listNumber: '20',
                    listNumberColor: 'am-badge am-badge-secondary',
                    isHtml: true
                }
            ]
        }
    ]     
};


$.ajax({  
    url:"/permissions/current",  
    type:"get",  
    async:false,
    success:function(data){
	   	 if(!$.isArray(data)){
	   		 location.href='/login.html';
	   		 return;
	   	 }
	   	  
    }
});
