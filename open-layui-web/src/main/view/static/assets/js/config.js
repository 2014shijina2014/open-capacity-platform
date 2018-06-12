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
   	 var menu =  TAB_JSON.list ;
   	 $.each(data, function(i,item){
   		 
   		 	var obj ={} ;
   		 	obj.listName = item.name ;      
   		 	obj.listUuid = "uuid-home"+item.id ;
           
   		 	obj.listIcon = item.css ;
            
            var href = item.href;
            if(href != null && href != ""){
                obj.listUrl =  href;
                
                
                
            }
            obj.listRightIcon = '' ;
            obj.listNumber = '';
            obj.isHtml = true ;
            
            //二级菜单
            var child2 = item.child;
            if(child2 != null && child2.length > 0){
            	
            	 obj.subList= [] ;
           	 $.each(child2, function(j,item2){
           		obj.isHtml = false ;
           		var subObj ={} ;
           		subObj.listName = item2.name ;      
           		subObj.listUuid = "uuid-home"+ item2.id ;
               
           		subObj.listIcon = item2.css ;
                
                var href = item2.href;
                if(href != null && href != ""){
                	subObj.listUrl =  href;
                }
                subObj.listRightIcon = '' ;
                subObj.listNumber = '';
                subObj.isHtml = true ;
                  
                obj.subList.push(subObj);
                   
                  
           	 });
           }
           menu.push(obj);
       });
    }
});